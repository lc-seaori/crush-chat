package com.lc.crush.common.encrypt.properties;

import lombok.Data;
import com.lc.crush.common.encrypt.enumd.AlgorithmType;
import com.lc.crush.common.encrypt.enumd.EncodeType;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 加解密属性配置类
 *
 * @author lc
 * @version 4.6.0
 */
@Data
@ConfigurationProperties(prefix = "mybatis-encryptor")
public class EncryptorProperties {

    /**
     * 过滤开关
     */
    private Boolean enable;

    /**
     * 默认算法
     */
    private AlgorithmType algorithm;

    /**
     * 安全秘钥
     */
    private String password;

    /**
     * 公钥
     */
    private String publicKey;

    /**
     * 私钥
     */
    private String privateKey;

    /**
     * 编码方式，base64/hex
     */
    private EncodeType encode;

}
