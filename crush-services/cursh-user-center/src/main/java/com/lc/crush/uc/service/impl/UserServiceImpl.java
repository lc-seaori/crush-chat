package com.lc.crush.uc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lc.crush.uc.domain.User;
import com.lc.crush.uc.domain.vo.UserVo;
import com.lc.crush.uc.mapper.UserMapper;
import com.lc.crush.uc.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author lc
 * @date 2023/7/15 16:48
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private final UserMapper userMapper;

    @Override
    public UserVo getUserById(Long id) {
        return userMapper.selectVoById(id);
    }
}
