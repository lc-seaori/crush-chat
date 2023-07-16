package com.lc.crush.uc.domain;

import com.lc.crush.uc.domain.vo.UserVo;
import io.github.linpeilie.AutoMapperConfig;
import io.github.linpeilie.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(
    config = AutoMapperConfig.class,
    uses = {}
)
public interface UserToUserVoMapper extends BaseMapper<User, UserVo> {
}
