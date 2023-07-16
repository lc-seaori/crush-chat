package com.lc.crush.uc.domain.vo;

import com.lc.crush.uc.domain.User;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 用户信息实体
 * @author lc
 * @date 2023/7/15 16:44
 */
@Data
@AutoMapper(target = User.class)
public class UserVo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户昵称
     */
    private String nickName;
}
