package com.dmc.mystore.exception;

import com.dmc.mystore.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler  {

/*
  如果抛出的是ServiceException,则调用该方法
  GlobalExceptionHandler 全局异常处理器
  @param se 业务异常
  @return Result
*/
@ExceptionHandler(ServiceException.class)
@ResponseBody
    public Result handle(ServiceException se){
        return Result.error(se.getCode(),se.getMessage());

}
}
