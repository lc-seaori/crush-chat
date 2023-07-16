package com.lc.crush.common.sentinel.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * sentinel自定义配置类
 * @author lc
 */
@Data
@ConfigurationProperties(prefix = "spring.cloud.sentinel.transport")
public class SentinelCustomProperties {

    private String serverName;

}
