package com.lc.crush.common.core.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 程序注解配置
 * @EnableAspectJAutoProxy 表示通过aop框架暴露该代理对象,AopContext能够访问
 * @author lc
 * @date 2023/6/2 18:10
 */
@AutoConfiguration
@EnableAspectJAutoProxy(exposeProxy = true)
public class ApplicationConfig {

}
