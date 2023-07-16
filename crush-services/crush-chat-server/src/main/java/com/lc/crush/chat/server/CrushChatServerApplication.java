package com.lc.crush.chat.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;

/**
 * @author lc
 * @date 2023/6/15 16:23
 */
@SpringBootApplication
public class CrushChatServerApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(CrushChatServerApplication.class);
        application.setApplicationStartup(new BufferingApplicationStartup(2048));
        application.run(args);
        System.out.println("(♥◠‿◠)ﾉﾞ  系统模块启动成功   ლ(´ڡ`ლ)ﾞ  ");
    }
}
