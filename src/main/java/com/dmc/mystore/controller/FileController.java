package com.dmc.mystore.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmc.mystore.common.Result;
import com.dmc.mystore.entity.Files;
import com.dmc.mystore.mapper.FileMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * 文件上传相关接口
 */
@RestController
@RequestMapping("/file")
public class FileController {
    @Value("${files.upload.path}")
    private String fileUploadPath;
    @Resource
    private FileMapper fileMapper;
    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile file) throws IOException {
        String originalFilename=file.getOriginalFilename();
        String type= FileUtil.extName(originalFilename);
        long size= file.getSize();

        //定义一个文件唯一的标识码
        String uuid= IdUtil.fastSimpleUUID();
        String fileUUID=uuid + StrUtil.DOT + type;
        File uploadFile=new File(fileUploadPath + fileUUID);
        //判断配置的文件目录是否存在，若不存在则创建一个新的文件目录
        File parentFile=uploadFile.getParentFile();
        if(!parentFile.exists()){
            parentFile.mkdirs();
        }

        String url;
        //上传文件到磁盘
        file.transferTo(uploadFile);
        //获取文件的md5
        String md5=SecureUtil.md5(uploadFile);
        //从数据库查询是否存在相同的记录
        Files dbFiles= getFileByMd5(md5);
            if (dbFiles != null){
                url=dbFiles.getUrl();
                //由于文件已存在，所以删除刚才上传的重复文件
                uploadFile.delete();
            }else {
                //数据库若不存在重复文件，则不删除刚才上传的文件
                url="http://localhost:9090/file/" + fileUUID;
            }

        //存储数据库
        Files saveFile = new Files();
        saveFile.setName(originalFilename);
        saveFile.setType(type);
        saveFile.setSize(size/1024);
        saveFile.setUrl(url);
        saveFile.setMd5(md5);
        fileMapper.insert(saveFile);
        return url;
    }

    /**
     * 文件下载接口  http://localhost:9090/file/{fileUUID};
     * @param fileUUID
     * @param response
     * @throws IOException
     */
    @GetMapping("/{fileUUID}")
    public void download(@PathVariable String fileUUID,HttpServletResponse response) throws IOException {
        //根据文件的唯一标识码获取文件
        File uploadFile=new File(fileUploadPath + fileUUID);
        //设置输出流的格式
        ServletOutputStream os=response.getOutputStream();
        response.addHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(fileUUID,"UTF-8"));
        response.setContentType("application/octet-stream");

        //读取文件的字节流
        os.write(FileUtil.readBytes(uploadFile));
        os.flush();
        os.close();

    }

    /**
     * 通过文件的md5查询文件
     * @param md5
     * @return
     */
    private Files getFileByMd5(String md5){
        //查询文件的md5是否存在
        QueryWrapper<Files> queryWrapper= new QueryWrapper<>();
        queryWrapper.eq("md5",md5);
        List<Files> filesList=fileMapper.selectList(queryWrapper);
        return filesList.size() == 0 ? null : filesList.get(0);

    }

    //新增和修改
    @PostMapping("/update")
    public Result update(@RequestBody Files files){
        //新增或者更新
        return Result.success(fileMapper.updateById(files));

    }
    //删除数据
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        Files files=fileMapper.selectById(id);
        files.setIsDelete(true);
        fileMapper.updateById(files);
        return Result.success();
    }

    //批量删除
    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids){
        //select * from sys_file where id in (id,id,id...)
        QueryWrapper<Files> queryWrapper=new QueryWrapper<>();
        queryWrapper.in("id",ids);
        List<Files> files=fileMapper.selectList(queryWrapper);
        for (Files file : files){
            file.setIsDelete(true);
            fileMapper.updateById(file);
        }
        return Result.success();
    }
    //分页查询——mybatis-plus的方式查询
    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize,
                           @RequestParam(defaultValue = "") String name


    ) {
        QueryWrapper<Files> queryWrapper=new QueryWrapper<>();
        //查询未删除的记录
        queryWrapper.eq("is_delete",false);
        queryWrapper.orderByDesc("id");

        if (!"".equals(name)){
            queryWrapper.like("name",name);
        }
        return Result.success(fileMapper.selectPage(new Page<>(pageNum,pageSize),queryWrapper));
    }

}
