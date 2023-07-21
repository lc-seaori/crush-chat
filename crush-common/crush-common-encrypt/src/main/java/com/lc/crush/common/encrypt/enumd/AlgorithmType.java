package com.lc.crush.common.encrypt.enumd;

import lombok.AllArgsConstructor;
import lombok.Getter;
import com.lc.crush.common.encrypt.core.encryptor.*;

/**
 * 算法枚举
 * @author lc
 * @date 2023/7/21 20:53
 */
@Getter
@AllArgsConstructor
public enum AlgorithmType {

    /**
     * 默认走yml配置
     */
    DEFAULT(null),

    /**
     * base64
     */
    BASE64(Base64Encryptor.class),

    /**
     * aes
     */
    AES(AesEncryptor.class),

    /**
     * rsa
     */
    RSA(RsaEncryptor.class),

    /**
     * sm2
     */
    SM2(Sm2Encryptor.class),

    /**
     * sm4
     */
    SM4(Sm4Encryptor.class);

    private final Class<? extends AbstractEncryptor> clazz;
}
