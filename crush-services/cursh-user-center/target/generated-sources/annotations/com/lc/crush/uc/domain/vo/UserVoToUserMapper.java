package com.lc.crush.uc.domain.vo;

import com.lc.crush.uc.domain.User;
import io.github.linpeilie.AutoMapperConfig;
import io.github.linpeilie.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(
    config = AutoMapperConfig.class,
    uses = {}
)
public interface UserVoToUserMapper extends BaseMapper<UserVo, User> {
}
