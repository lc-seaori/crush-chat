package com.lc.crush.chat.server.domain.vo;

import com.lc.crush.chat.server.domain.SysConfig;
import io.github.linpeilie.AutoMapperConfig;
import io.github.linpeilie.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(
    config = AutoMapperConfig.class,
    uses = {}
)
public interface SysConfigVoToSysConfigMapper extends BaseMapper<SysConfigVo, SysConfig> {
}
