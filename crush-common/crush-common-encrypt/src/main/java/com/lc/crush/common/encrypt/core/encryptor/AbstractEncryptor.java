package com.lc.crush.common.encrypt.core.encryptor;

import com.lc.crush.common.encrypt.core.EncryptContext;
import com.lc.crush.common.encrypt.core.IEncryptor;

/**
 * 所有加密执行者的基类
 *
 * @author lc
 * @version 4.6.0
 */
public abstract class AbstractEncryptor implements IEncryptor {

    public AbstractEncryptor(EncryptContext context) {
        // 用户配置校验与配置注入
    }

}
