DROP DATABASE IF EXISTS `crush-cloud`;

CREATE DATABASE  `crush-cloud` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

-- 全局设置字符集
SET NAMES utf8mb4;
-- 取消外键约束
SET FOREIGN_KEY_CHECKS = 0;

USE `crush-cloud`;

/******************************************/
/*   用户表 = user   */
/******************************************/
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `nick_name` varchar(20) NOT NULL COMMENT '用户昵称',
    `phone` varchar(20) NOT NULL COMMENT '手机号',
    `open_id` varchar(32) DEFAULT NULL COMMENT '微信用户标识openid',
    `avatar` varchar(255) DEFAULT NULL COMMENT '头像路径',
    `sex` tinyint(1) NOT NULL COMMENT '性别：0-男性，1-女性',
    `birthday` date DEFAULT NULL COMMENT '生日',
    `status` tinyint(2) NOT NULL DEFAULT 0 COMMENT '用户状态：0-正常，1-冻结，2-注销',
    `delete_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除：0-正常，1-删除)',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`),
    UNIQUE INDEX `udx_open_id`(`open_id`),
    INDEX `idx_phone`(`phone`),
    INDEX `idx_create_time`(`create_time`),
    INDEX `idx_update_time`(`update_time`)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表';

/******************************************/
/*   用户个人资料表 = user_profile   */
/******************************************/
DROP TABLE IF EXISTS `user_profile`;
CREATE TABLE `user_profile` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `user_id` bigint(20) NOT NULL COMMENT '关联用户id',
    `height` tinyint(5) DEFAULT NULL COMMENT '身高，单位：cm',
    `weight` tinyint(5) DEFAULT NULL COMMENT '体重，单位：kg',
    `location` varchar(255) DEFAULT NULL COMMENT '现居地',
    `hometown` varchar(255) DEFAULT NULL COMMENT '家乡',
    `marital_status` tinyint(2) DEFAULT 1 COMMENT '婚姻状况：1-未婚，2-离异无孩，3-离异带孩，4-离异不带孩，5-丧偶',
    `education` tinyint(2) DEFAULT NULL COMMENT '最高学历：1-小学；2-初中；3-中专；4-高中；5-大专；6-本科；7-硕士；8-博士',
    `graduated_from` varchar(255) DEFAULT NULL COMMENT '毕业院校',
    `occupation` tinyint(4) DEFAULT NULL COMMENT '职业：详情看枚举',
    `company` varchar(100) DEFAULT NULL COMMENT '公司：这里应该是公司代码',
    `annual_income` tinyint(2) DEFAULT NULL COMMENT '年收入：1：5~15W；2：15~30W；3：30~50W；4：50~100W；5-100W以上',
    `wechat_number` varchar(100) DEFAULT NULL COMMENT '微信号',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`),
    UNIQUE INDEX `idx_uid`(`user_id`)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户个人资料表';

/******************************************/
/*   用户其他头像图片表 = user_avatar   */
/******************************************/
DROP TABLE IF EXISTS `user_avatar`;
CREATE TABLE `user_avatar` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `user_id` bigint(20) NOT NULL COMMENT '关联用户id',
    `nick_name` varchar(20) NOT NULL COMMENT '用户昵称',
    `phone` varchar(20) NOT NULL COMMENT '手机号',
    `open_id` varchar(32) DEFAULT NULL COMMENT '微信用户标识openid',
    `avatar` varchar(255) DEFAULT NULL COMMENT '头像路径',
    `sex` tinyint(1) NOT NULL COMMENT '性别：1-男性，2-女性',
    `birthday` date DEFAULT NULL COMMENT '生日',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`),
    INDEX `idx_uid`(`user_id`)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户其他头像图片表';

/******************************************/
/*   用户交友信息 = user_social_info   */
/******************************************/
DROP TABLE IF EXISTS `user_social_info`;
CREATE TABLE `user_social_info` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `user_id` bigint(20) NOT NULL COMMENT '关联用户id',
    `about_me` varchar(2000) DEFAULT NULL COMMENT '关于我(自我描述)',
    `about_family` varchar(2000) DEFAULT NULL COMMENT '家庭背景',
    `about_hobbies` varchar(2000) DEFAULT NULL COMMENT '兴趣爱好',
    `about_emotional_view` varchar(2000) DEFAULT NULL COMMENT '感情观',
    `about_ideal_partner` varchar(2000) DEFAULT NULL COMMENT '理想的另一半',
    `about_ideal_life` varchar(2000) DEFAULT NULL COMMENT '理想生活',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`),
    UNIQUE INDEX `idx_uid`(`user_id`)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户交友信息';

/******************************************/
/*   身份认证（实名、学历、工作） =    */
/******************************************/


