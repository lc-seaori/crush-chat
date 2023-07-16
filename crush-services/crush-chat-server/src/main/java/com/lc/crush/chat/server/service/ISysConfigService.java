package com.lc.crush.chat.server.service;

import com.lc.crush.chat.server.domain.vo.SysConfigVo;

/**
 * 参数配置 服务层
 *
 * @author Lion Li
 */
public interface ISysConfigService {
    /**
     * 查询参数配置信息
     * @param configId 参数配置ID
     * @return 参数配置信息
     */
    SysConfigVo selectConfigById(Long configId);

    /**
     * 根据键名查询参数配置信息
     *
     * @param configKey 参数键名
     * @return 参数键值
     */
    String selectConfigByKey(String configKey);
}
