package com.lc.crush.uc.service;

import com.lc.crush.uc.domain.vo.UserVo;

/**
 * @author lc
 * @date 2023/7/15 16:39
 */
public interface IUserService {

    /**
     * 根据id查询数据
     * @param id
     * @return com.lc.crush.uc.domain.vo.UserVo
     * @throws
     * @author lc
     * @date 2023/7/15 16:48
     */
    UserVo getUserById(Long id);
}
