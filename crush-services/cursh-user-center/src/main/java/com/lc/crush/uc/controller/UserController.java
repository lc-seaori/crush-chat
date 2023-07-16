package com.lc.crush.uc.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import com.lc.crush.common.core.domain.R;
import com.lc.crush.uc.domain.vo.UserVo;
import com.lc.crush.uc.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户信息相关接口
 * @author lc
 * @date 2023/7/15 16:37
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final IUserService userService;

    private final WxMaService maService;

    /**
     * 根据id查询用户信息
     * @param id 用户id
     * @throws
     * @author lc
     * @date 2023/7/15 17:26
     */
    @GetMapping("/{id}")
    public R<UserVo> getUserById(@PathVariable Long id) {
        log.info("根据id查询用户信息");
        return R.ok(userService.getUserById(id));
    }

    /**
     * 获取小程序accessToken
     * @param
     * @return com.lc.crush.common.core.domain.R<java.lang.String>
     * @author lc
     * @date 2023/7/15 22:01
     */
    @GetMapping("/getAccessToken")
    public R<String> getAccessToken() throws WxErrorException {
        log.info("show appid：{}", maService.getWxMaConfig().getAppid());
        return R.ok(maService.getAccessToken());
    }
}
