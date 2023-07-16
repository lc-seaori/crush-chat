package com.lc.crush.uc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;

/**
 * @author lc
 * @date 2023/7/15 16:35
 */
@SpringBootApplication
public class CrushUserCenterApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(CrushUserCenterApplication.class);
        application.setApplicationStartup(new BufferingApplicationStartup(2048));
        application.run(args);
        System.out.println("(♥◠‿◠)ﾉﾞ  用户中心模块启动成功   ლ(´ڡ`ლ)ﾞ  ");
    }
}
