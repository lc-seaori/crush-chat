package com.lc.crush.uc.mapper;

import com.lc.crush.common.mybatis.core.mapper.BaseMapperPlus;
import com.lc.crush.uc.domain.User;
import com.lc.crush.uc.domain.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lc
 * @date 2023/7/15 16:49
 */
@Mapper
public interface UserMapper extends BaseMapperPlus<User, UserVo> {
}
