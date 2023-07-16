package com.lc.crush.chat.server.mapper;

import com.lc.crush.chat.server.domain.SysConfig;
import com.lc.crush.chat.server.domain.vo.SysConfigVo;
import com.lc.crush.common.mybatis.core.mapper.BaseMapperPlus;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lc
 * @date 2023/6/20 20:29
 */
@Mapper
public interface SysConfigMapper extends BaseMapperPlus<SysConfig, SysConfigVo> {

}
