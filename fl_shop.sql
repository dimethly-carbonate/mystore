/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : fl_shop

Target Server Type    : MYSQL
Target Server Version : 80027
File Encoding         : 65001

Date: 2022-06-29 18:18:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for fl_admin
-- ----------------------------
DROP TABLE IF EXISTS `fl_admin`;
CREATE TABLE `fl_admin` (
  `adid` int NOT NULL AUTO_INCREMENT,
  `adname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nikename` varchar(20) DEFAULT NULL,
  `phone` varchar(20) NOT NULL,
  `adpwd` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role` varchar(50) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `avatar_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `is_delete` tinyint(1) DEFAULT '0',
  `enable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`adid`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of fl_admin
-- ----------------------------
INSERT INTO `fl_admin` VALUES ('10', 'admin', '管理员', '13955676789', '123321', 'ROLE_ADMIN', '2022-02-26 22:10:14', 'http://localhost:9090/file/dabe2182328841f39c74760430014b8a.png', '0', '1');
INSERT INTO `fl_admin` VALUES ('13', '左灯', '采购员', '13955676789', '33333', 'ROLE_BUYER', '2022-03-25 09:22:15', 'http://localhost:9090/file/dabe2182328841f39c74760430014b8a.png', '0', '1');
INSERT INTO `fl_admin` VALUES ('16', '右行', '销售员', '13955676789', '123456', 'ROLE_SALER', '2022-04-13 10:12:10', 'http://localhost:9090/file/9562f11e04324af69f0607b8d23415da.png', '0', '1');

-- ----------------------------
-- Table structure for fl_buy
-- ----------------------------
DROP TABLE IF EXISTS `fl_buy`;
CREATE TABLE `fl_buy` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '编号',
  `buyid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '采购单号',
  `buy_date` date NOT NULL COMMENT '采购日期',
  `buy_apply` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '申请人',
  `buyer` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '采购人',
  `buy_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '采购商品',
  `buy_supplier` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '供应商',
  `buy_count` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '采购数量',
  `buy_unit` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '数量单位',
  `buy_price` double NOT NULL DEFAULT '0' COMMENT '单价',
  `buy_status` varchar(5) NOT NULL,
  `reviewer` varchar(20) DEFAULT NULL,
  `reviewdate` date DEFAULT NULL,
  `remarks` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of fl_buy
-- ----------------------------
INSERT INTO `fl_buy` VALUES ('36', 'CG202507080036', '2025-07-08', '左灯', '左灯', '6', '红牛官方商城', '6', '个', '16', '已通过', '哈哈', '2022-05-27', '');
INSERT INTO `fl_buy` VALUES ('37', 'CG202507080037', '2025-07-08', '左灯', '左灯', '8', '迈凯伦官方商城', '34', '箱/个', '12', '未审核', null, null, null);
INSERT INTO `fl_buy` VALUES ('38', 'CG202507080038', '2025-07-08', '左灯', '左灯', '14', '红牛官方商城', '2', '个', '300', '未审核', null, null, null);
INSERT INTO `fl_buy` VALUES ('39', 'CG202507080039', '2025-07-08', '左灯', '左灯', '11', '威廉姆斯官方商城', '2', '个', '80', '未审核', null, null, null);
INSERT INTO `fl_buy` VALUES ('40', 'CG202507080040', '2025-07-08', '左灯', '左灯', '15', '迈凯伦官方商城', '8', '件/24个', '130', '已通过', '哈哈', '2022-05-28', '');
INSERT INTO `fl_buy` VALUES ('41', 'CG202507090041', '2025-07-09', '左灯', '左灯', '36', '红牛官方商城', '6', '个', '23', '已通过', '哈哈', '2022-05-28', '');

-- ----------------------------
-- Table structure for fl_customer
-- ----------------------------
DROP TABLE IF EXISTS `fl_customer`;
CREATE TABLE `fl_customer` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '顾客编号',
  `cus_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `cus_sort` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类别',
  `cus_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系方式',
  `cus_address` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地址',
  `cus_cost` int NOT NULL COMMENT '总花费',
  `cus_pay` int NOT NULL COMMENT '总支付',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of fl_customer
-- ----------------------------

-- ----------------------------
-- Table structure for fl_foster
-- ----------------------------
DROP TABLE IF EXISTS `fl_after_sales`;
CREATE TABLE `fl_after_sales` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '编号',
  `sender` varchar(10) NOT NULL COMMENT '申请人',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系方式',
  `fos_Name` varchar(20) NOT NULL COMMENT '物品名称',
  `fos_Variety` varchar(10) NOT NULL COMMENT '种类',
  `fos_Url` varchar(225) NOT NULL COMMENT '图片',
  `fos_Note` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `fos_Starttime` date NOT NULL COMMENT '货物接收日期',
  `fos_Endtime` date DEFAULT NULL COMMENT '维修结束日期',
  `fos_Price` double NOT NULL COMMENT '配件价格',
  `fos_Total` double DEFAULT NULL COMMENT '总价',
  `fos_Status` varchar(3) NOT NULL COMMENT '支付状态',
  `fos_Oper` varchar(10) NOT NULL COMMENT '操作人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of fl_foster
-- ----------------------------

-- ----------------------------
-- Table structure for fl_login
-- ----------------------------
DROP TABLE IF EXISTS `fl_login`;
CREATE TABLE `fl_login` (
  `id` int NOT NULL AUTO_INCREMENT,
  `adname` varchar(50) NOT NULL,
  `create_Time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=145 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of fl_login
-- ----------------------------
INSERT INTO `fl_login` VALUES ('6', '左灯', '2025-04-21 08:55:39');
INSERT INTO `fl_login` VALUES ('7', '左灯', '2025-04-21 09:06:45');
INSERT INTO `fl_login` VALUES ('73', '右行', '2025-05-02 09:57:58');

-- ----------------------------
-- Table structure for fl_out
-- ----------------------------
DROP TABLE IF EXISTS `fl_out`;
CREATE TABLE `fl_out` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '编号',
  `out_Id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '出库单编号',
  `out_Oper` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作人',
  `out_Date` date NOT NULL COMMENT '出库日期',
  `out_Name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '出库产品名称',
  `out_Customer` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '客户',
  `out_Supplier` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '供应商',
  `out_Num` int DEFAULT NULL COMMENT '出库数量',
  `out_Unit` varchar(20) NOT NULL COMMENT '数量单位',
  `out_Price` double(20,0) DEFAULT NULL COMMENT '单价',
  `out_Total` double(20,0) DEFAULT NULL COMMENT '总价',
  `out_Profit` double(5,0) DEFAULT NULL COMMENT '利润',
  `out_Paid` double(255,0) DEFAULT NULL COMMENT '已付款',
  `status` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of fl_out
-- ----------------------------
INSERT INTO `fl_out` VALUES ('19', '202507100019', '右行', '2022-05-11', '31', '3', '阿尔派官方商城', '2', '盆', '25', '50', '10', '50', '已出库');
INSERT INTO `fl_out` VALUES ('20', '202507100020', '右行', '2022-05-26', '7', '3', '红牛官方商城', '16', '盆', '45', '720', '352', '91', '已出库');
INSERT INTO `fl_out` VALUES ('21', '202507100021', '右行', '2022-05-12', '6', '3', '红牛官方商城', '4', '盆', '17', '68', '20', '17', '已出库');
INSERT INTO `fl_out` VALUES ('22', '202507100022', '右行', '2022-05-27', '10', '3', '威廉姆斯官方商城', '5', '盆', '200', '1000', '400', '1000', '已出库');
INSERT INTO `fl_out` VALUES ('23', '202507100023', '右行', '2022-05-26', '14', '1', '红牛官方商城', '7', '盆', '300', '2100', '700', '2100', '已出库');
INSERT INTO `fl_out` VALUES ('24', '202507100024', '右行', '2022-05-19', '9', '3', '迈凯伦官方商城', '7', '盆', '56', '392', '147', '392', '已出库');
INSERT INTO `fl_out` VALUES ('25', '202507100025', '右行', '2022-05-20', '10', '3', '威廉姆斯官方商城', '3', '盆', '200', '600', '240', '600', '已出库');
INSERT INTO `fl_out` VALUES ('26', '202507100026', '右行', '2022-05-26', '10', '3', '威廉姆斯官方商城', '4', '盆', '200', '800', '320', '800', '已出库');
INSERT INTO `fl_out` VALUES ('27', '202507100027', '右行', '2022-05-27', '9', '12', '迈凯伦官方商城', '4', '盆', '56', '224', '84', '224', '已出库');
INSERT INTO `fl_out` VALUES ('28', '202507100028', '右行', '2022-05-20', '9', '3', '迈凯伦官方商城', '4', '盆', '56', '224', '84', '224', '已出库');
INSERT INTO `fl_out` VALUES ('29', '202507100029', '右行', '2022-05-28', '36', '1', '红牛官方商城', '6', '盆', '45', '270', '132', '270', '已出库');

-- ----------------------------
-- Table structure for fl_product
-- ----------------------------
DROP TABLE IF EXISTS `fl_product`;
CREATE TABLE `fl_product` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '商品编号',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `psort` int NOT NULL COMMENT '所属类别',
  `pro_cost` double NOT NULL COMMENT '进价',
  `pro_price` double NOT NULL COMMENT '售价',
  `pro_stock` int DEFAULT '0' COMMENT '库存',
  `pro_from` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '供应商',
  `pro_sales` int DEFAULT '0' COMMENT '销量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of fl_product
-- ----------------------------
INSERT INTO `fl_product` VALUES ('6', '维斯塔潘帽子', '4', '300', '348', '32', '红牛官方商城', '24');
INSERT INTO `fl_product` VALUES ('7', '维斯塔潘车模', '4', '200', '249', '12', '红牛官方商城', '27');
INSERT INTO `fl_product` VALUES ('8', '诺里斯帽子', '4', '300', '348', '20', '迈凯伦官方商城', '11');
INSERT INTO `fl_product` VALUES ('9', '诺里斯车模', '2', '200', '249', '19', '迈凯伦官方商城', '38');
INSERT INTO `fl_product` VALUES ('10', '赛恩斯帽子', '4', '300', '348', '29', '威廉姆斯官方商城', '23');
INSERT INTO `fl_product` VALUES ('11', '赛恩斯车模', '4', '200', '249', '20', '威廉姆斯官方商城', '11');
INSERT INTO `fl_product` VALUES ('12', '勒克莱尔帽子', '13', '300', '348', '30', '法拉利官方商城', '10');
INSERT INTO `fl_product` VALUES ('13', '勒克莱尔车模', '13', '200', '249', '20', '法拉利官方商城', '11');
INSERT INTO `fl_product` VALUES ('14', 'RedBull队服', '13', '400', '468', '1', '红牛官方商城', '22');
INSERT INTO `fl_product` VALUES ('15', 'McLaren队服', '13', '400', '468', '4', '迈凯伦官方商城', '21');
INSERT INTO `fl_product` VALUES ('16', 'Mercedes队服', '2', '400', '468', '63', '梅赛德斯奔驰官方商城', '20');
INSERT INTO `fl_product` VALUES ('17', 'Williams队服', '2', '400', '468', '55', '威廉姆斯官方商城', '15');
INSERT INTO `fl_product` VALUES ('31', 'Alpine队服', '13', '400', '468', '10', '阿尔派官方商城', '2');
INSERT INTO `fl_product` VALUES ('32', 'Ferrari队服', '4', '400', '468', '44', '法拉利官方商城', '24');
INSERT INTO `fl_product` VALUES ('33', 'Haas队服', '4', '400', '468', '31', '哈斯官方商城', '2');
INSERT INTO `fl_product` VALUES ('34', 'Aston Martin队服', '2', '400', '468', '14', '阿斯顿马丁官方商城', '7');
INSERT INTO `fl_product` VALUES ('35', 'Sauber队服', '4', '400', '468', '27', '索伯官方商城', '4');
INSERT INTO `fl_product` VALUES ('36', 'VCARB队服', '4', '400', '468', '30', '红牛官方商城', '9');

-- ----------------------------
-- Table structure for fl_put
-- ----------------------------
DROP TABLE IF EXISTS `fl_put`;
CREATE TABLE `fl_put` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '编号',
  `put_Id` varchar(225) NOT NULL COMMENT '入库单号',
  `put_Name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '入库商品',
  `put_Date` date NOT NULL COMMENT '入库日期',
  `put_Supplier` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '供应商',
  `put_Oper` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作人',
  `put_Num` int NOT NULL COMMENT '入库数量',
  `put_Unit` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '数量单位',
  `put_Price` double NOT NULL COMMENT '单价',
  `put_Total` double NOT NULL COMMENT '总价',
  `status` varchar(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of fl_put
-- ----------------------------
INSERT INTO `fl_put` VALUES ('23', 'RK202507080023', '17', '2025-07-08', '威廉姆斯官方商城', '左灯', '11', '个', '400', '4400', '已入库');
INSERT INTO `fl_put` VALUES ('24', 'RK202507080024', '15', '2025-07-08', '迈凯伦官方商城', '左灯', '8', '个', '400', '3200', '已入库');
INSERT INTO `fl_put` VALUES ('25', 'RK202507080025', '36', '2025-07-08', '红牛官方商城', '左灯', '6', '个', '400', '2400', '已入库');

-- ----------------------------
-- Table structure for fl_sale
-- ----------------------------
DROP TABLE IF EXISTS `fl_sale`;
CREATE TABLE `fl_sale` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '编号',
  `sale_Id` varchar(255) NOT NULL COMMENT '出库通知单编号',
  `saler` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '申请人',
  `sale_date` date NOT NULL COMMENT '出库申请日期',
  `sale_Name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '出库产品名称',
  `sale_Supplier` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '供应商',
  `sale_Num` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '出库数量',
  `sale_Unit` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '数量单位',
  `sale_price` double NOT NULL COMMENT '单价',
  `sale_Total` double NOT NULL COMMENT '总价',
  `sale_Paid` double(20,0) DEFAULT NULL COMMENT '已付款',
  `reviewer` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '审核人',
  `results` varchar(5) NOT NULL,
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '审核人备注',
  `reviewdate` date DEFAULT NULL COMMENT '审核日期',
  `applynote` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '申请人备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of fl_sale
-- ----------------------------
INSERT INTO `fl_sale` VALUES ('9', 'CK202507090009', '右行', '2025-07-09', '13', '法拉利官方商城', '18', '盆', '80', '1440', '1440', '哈哈', '未审核', '同意出库', '2022-04-29', null);
INSERT INTO `fl_sale` VALUES ('11', 'CK202507090011', '右行', '2025-07-09', '31', '威廉姆斯官方商城', '18', '盆', '30', '540', '540', '哈哈', '已通过', '', '2022-05-27', null);
INSERT INTO `fl_sale` VALUES ('13', 'CK202507090013', '右行', '2025-07-09', '7', '法拉利官方商城', '16', '盆', '23', '368', '20', '哈哈', '未审核', '', '2022-05-26', null);
INSERT INTO `fl_sale` VALUES ('17', 'CK202507090017', '右行', '2025-07-09', '15', '威廉姆斯官方商城', '6', '盆', '200', '1200', '200', null, '未审核', null, null, null);

-- ----------------------------
-- Table structure for fl_sort
-- ----------------------------
DROP TABLE IF EXISTS `fl_sort`;
CREATE TABLE `fl_sort` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '编号',
  `sortname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品类别名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of fl_sort
-- ----------------------------
INSERT INTO `fl_sort` VALUES ('2', '帽子');
INSERT INTO `fl_sort` VALUES ('4', '车模');
INSERT INTO `fl_sort` VALUES ('13', '队服');

-- ----------------------------
-- Table structure for fl_supplier
-- ----------------------------
DROP TABLE IF EXISTS `fl_supplier`;
CREATE TABLE `fl_supplier` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '供应商编号',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '供应商名称',
  `smanager` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '负责人',
  `sup_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系方式',
  `sup_address` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地址',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of fl_supplier
-- ----------------------------

-- ----------------------------
-- Table structure for fl_unit
-- ----------------------------
DROP TABLE IF EXISTS `fl_unit`;
CREATE TABLE `fl_unit` (
  `unitsid` int NOT NULL AUTO_INCREMENT,
  `unitname` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `unitpid` int DEFAULT NULL,
  PRIMARY KEY (`unitsid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of fl_unit
-- ----------------------------
INSERT INTO `fl_unit` VALUES ('1', '个', null);
INSERT INTO `fl_unit` VALUES ('2', '箱', null);
INSERT INTO `fl_unit` VALUES ('7', '辆', null);
INSERT INTO `fl_unit` VALUES ('8', '个', '2');
INSERT INTO `fl_unit` VALUES ('9', '件', null);
INSERT INTO `fl_unit` VALUES ('10', '24个', '9');

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `value` varchar(255) DEFAULT NULL COMMENT '内容',
  `type` varchar(255) DEFAULT NULL COMMENT '类型'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('user', 'el-icon-user-solid', 'icon');
INSERT INTO `sys_dict` VALUES ('house', 'el-icon-house', 'icon');
INSERT INTO `sys_dict` VALUES ('menu', 'el-icon-menu', 'icon');
INSERT INTO `sys_dict` VALUES ('custom', 'el-icon-s-custom', 'icon');
INSERT INTO `sys_dict` VALUES ('document', 'el-icon-document', 'icon');
INSERT INTO `sys_dict` VALUES ('buy', 'el-icon-shopping-cart-full', 'icon');
INSERT INTO `sys_dict` VALUES ('sale', 'el-icon-sell', 'icon');
INSERT INTO `sys_dict` VALUES ('sort', 'el-icon-notebook-1', 'icon');
INSERT INTO `sys_dict` VALUES ('supplier', 'el-icon-coordinate', 'icon');
INSERT INTO `sys_dict` VALUES ('customer', 'el-icon-truck', 'icon');
INSERT INTO `sys_dict` VALUES ('role', 'el-icon-star-on', 'icon');
INSERT INTO `sys_dict` VALUES ('system', 'el-icon-s-tools', 'icon');
INSERT INTO `sys_dict` VALUES ('good', 'el-icon-s-shop', 'icon');
INSERT INTO `sys_dict` VALUES ('business', 'el-icon-mobile', 'icon');
INSERT INTO `sys_dict` VALUES ('product', 'el-icon-goods', 'icon');
INSERT INTO `sys_dict` VALUES ('totaldata', 'el-icon-s-data', 'icon');
INSERT INTO `sys_dict` VALUES ('out', 'el-icon-shopping-cart-2', 'icon');
INSERT INTO `sys_dict` VALUES ('put', 'el-icon-sold-out', 'icon');
INSERT INTO `sys_dict` VALUES ('forest', 'el-icon-box', 'icon');
INSERT INTO `sys_dict` VALUES ('unit', '\r\nel-icon-collection', 'icon');
INSERT INTO `sys_dict` VALUES ('inventory', 'el-icon-receiving', 'icon');
INSERT INTO `sys_dict` VALUES ('logindata', 'el-icon-date', 'icon');

-- ----------------------------
-- Table structure for sys_file
-- ----------------------------
DROP TABLE IF EXISTS `sys_file`;
CREATE TABLE `sys_file` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '文件名称\r\n',
  `type` varchar(255) DEFAULT NULL COMMENT '文件类型',
  `size` bigint DEFAULT NULL COMMENT '文件大小（KB）',
  `url` varchar(255) DEFAULT NULL COMMENT '下载连接',
  `md5` varchar(255) DEFAULT NULL COMMENT '文件md5',
  `is_delete` tinyint(1) DEFAULT '0' COMMENT '是否删除',
  `enable` tinyint(1) DEFAULT '1' COMMENT '是否禁用链接',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of sys_file
-- ----------------------------
INSERT INTO `sys_file` VALUES ('61', 'dabe2182328841f39c74760430014b8a.png', 'png', '14', 'http://localhost:9090/file/dabe2182328841f39c74760430014b8a.png', 'cea02d67a5082d121e9c821aeaae0394', '1', '1');
INSERT INTO `sys_file` VALUES ('62', 'dabe2182328841f39c74760430014b8a.png', 'png', '14', 'http://localhost:9090/file/dabe2182328841f39c74760430014b8a.png', 'cea02d67a5082d121e9c821aeaae0394', '1', '1');
INSERT INTO `sys_file` VALUES ('79', '24gf-portraitMalePlus.png', 'png', '5', 'http://localhost:9090/file/a2f54569128c4da99b05ccfaecbcc060.png', '6b45bd0f0677403725cf6e9ed1c5f5dd', '0', '0');
INSERT INTO `sys_file` VALUES ('80', '花1.jpg', 'jpg', '99', 'http://localhost:9090/file/1a096b72ca384adcb904fee73af09def.jpg', '269cdf2703bb85f1e7e7467fa0f7147b', '0', '1');
INSERT INTO `sys_file` VALUES ('81', '花1.jpg', 'jpg', '99', 'http://localhost:9090/file/1a096b72ca384adcb904fee73af09def.jpg', '269cdf2703bb85f1e7e7467fa0f7147b', '0', '1');
INSERT INTO `sys_file` VALUES ('82', 'mmexport1652267892448.jpg', 'jpg', '136', 'http://localhost:9090/file/808ff821fd014b9fa5b7c6f4924ddbe5.jpg', '1c7ef5192f3fa74a00496c843238b29b', '0', '1');
INSERT INTO `sys_file` VALUES ('83', '头像 女孩 (1).png', 'png', '11', 'http://localhost:9090/file/9562f11e04324af69f0607b8d23415da.png', 'b4a9aa2cce6bf90dd438196e8eafa9b7', '0', '1');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '名称',
  `path` varchar(255) DEFAULT NULL COMMENT '路径',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `pid` int DEFAULT NULL COMMENT '父级id',
  `page_path` varchar(255) DEFAULT NULL COMMENT '页面路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=230 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '主页', '/home', 'el-icon-house', null, null, 'Home');
INSERT INTO `sys_menu` VALUES ('2', '系统管理', '', 'el-icon-s-tools', '', null, null);
INSERT INTO `sys_menu` VALUES ('3', '用户管理', '/manager', 'el-icon-user-solid', '', '2', 'User');
INSERT INTO `sys_menu` VALUES ('4', '角色管理', '/role', 'el-icon-star-on', null, '2', 'Role');
INSERT INTO `sys_menu` VALUES ('5', '菜单管理', '/menu', 'el-icon-menu', null, '2', 'Menu');
INSERT INTO `sys_menu` VALUES ('7', '业务管理', null, 'el-icon-mobile', null, null, null);
INSERT INTO `sys_menu` VALUES ('8', '客户管理', '/customer', 'el-icon-truck', null, '7', 'Customer');
INSERT INTO `sys_menu` VALUES ('9', '供应商管理', '/supplier', 'el-icon-coordinate', null, '7', 'Supplier');
INSERT INTO `sys_menu` VALUES ('10', '采购管理', '/buy', 'el-icon-shopping-cart-full', null, '7', 'Buy');
INSERT INTO `sys_menu` VALUES ('11', '销售管理', '/sale', 'el-icon-shopping-cart-2', null, '7', 'Sale');
INSERT INTO `sys_menu` VALUES ('12', '入库管理', '/putstorage', 'el-icon-sold-out', null, '7', 'Putstorage');
INSERT INTO `sys_menu` VALUES ('13', '入库统计', '/puttotal', 'el-icon-s-data', null, '7', 'Puttotal');
INSERT INTO `sys_menu` VALUES ('14', '出库管理', '/outstorage', 'el-icon-sell', null, '7', 'Outstorage');
INSERT INTO `sys_menu` VALUES ('15', '出库统计', '/outtotal', 'el-icon-s-data', null, '7', 'Outtotal');
INSERT INTO `sys_menu` VALUES ('16', '售后服务管理', '/foster', 'el-icon-box', null, '7', 'Foster');
INSERT INTO `sys_menu` VALUES ('17', '商品管理', null, 'el-icon-s-shop', null, null, null);
INSERT INTO `sys_menu` VALUES ('18', '花材管理', '/flower', 'el-icon-goods', null, '17', 'Flower');
INSERT INTO `sys_menu` VALUES ('19', '花材类别管理', '/sort', 'el-icon-notebook-1', null, '17', 'Sort');
INSERT INTO `sys_menu` VALUES ('20', '单位管理', '/unit', 'el-icon-notebook-1', null, '17', 'Unit');
INSERT INTO `sys_menu` VALUES ('21', '库存盘点', '/inventory', 'el-icon-receiving', null, '17', 'Inventory');
INSERT INTO `sys_menu` VALUES ('22', '登录日志', '/loginlog', 'el-icon-date', null, null, 'Loginlog');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `flag` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '唯一标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '管理员', '主管理员', 'ROLE_ADMIN');
INSERT INTO `sys_role` VALUES ('2', '采购员', '采购员', 'ROLE_BUYER');
INSERT INTO `sys_role` VALUES ('3', '销售员', '销售员', 'ROLE_SALER');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` int NOT NULL COMMENT '角色id',
  `menu_id` int NOT NULL COMMENT '菜单id',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('1', '1');
INSERT INTO `sys_role_menu` VALUES ('1', '2');
INSERT INTO `sys_role_menu` VALUES ('1', '3');
INSERT INTO `sys_role_menu` VALUES ('1', '4');
INSERT INTO `sys_role_menu` VALUES ('1', '5');
INSERT INTO `sys_role_menu` VALUES ('1', '7');
INSERT INTO `sys_role_menu` VALUES ('1', '8');
INSERT INTO `sys_role_menu` VALUES ('1', '9');
INSERT INTO `sys_role_menu` VALUES ('1', '10');
INSERT INTO `sys_role_menu` VALUES ('1', '11');
INSERT INTO `sys_role_menu` VALUES ('1', '12');
INSERT INTO `sys_role_menu` VALUES ('1', '13');
INSERT INTO `sys_role_menu` VALUES ('1', '14');
INSERT INTO `sys_role_menu` VALUES ('1', '15');
INSERT INTO `sys_role_menu` VALUES ('1', '16');
INSERT INTO `sys_role_menu` VALUES ('1', '17');
INSERT INTO `sys_role_menu` VALUES ('1', '18');
INSERT INTO `sys_role_menu` VALUES ('1', '19');
INSERT INTO `sys_role_menu` VALUES ('1', '20');
INSERT INTO `sys_role_menu` VALUES ('1', '21');
INSERT INTO `sys_role_menu` VALUES ('1', '22');
INSERT INTO `sys_role_menu` VALUES ('2', '1');
INSERT INTO `sys_role_menu` VALUES ('2', '7');
INSERT INTO `sys_role_menu` VALUES ('2', '8');
INSERT INTO `sys_role_menu` VALUES ('2', '10');
INSERT INTO `sys_role_menu` VALUES ('2', '12');
INSERT INTO `sys_role_menu` VALUES ('2', '13');
INSERT INTO `sys_role_menu` VALUES ('2', '17');
INSERT INTO `sys_role_menu` VALUES ('2', '18');
INSERT INTO `sys_role_menu` VALUES ('2', '19');
INSERT INTO `sys_role_menu` VALUES ('2', '20');
INSERT INTO `sys_role_menu` VALUES ('2', '21');
INSERT INTO `sys_role_menu` VALUES ('2', '22');
INSERT INTO `sys_role_menu` VALUES ('3', '1');
INSERT INTO `sys_role_menu` VALUES ('3', '7');
INSERT INTO `sys_role_menu` VALUES ('3', '8');
INSERT INTO `sys_role_menu` VALUES ('3', '11');
INSERT INTO `sys_role_menu` VALUES ('3', '14');
INSERT INTO `sys_role_menu` VALUES ('3', '15');
INSERT INTO `sys_role_menu` VALUES ('3', '16');
INSERT INTO `sys_role_menu` VALUES ('3', '17');
INSERT INTO `sys_role_menu` VALUES ('3', '21');
