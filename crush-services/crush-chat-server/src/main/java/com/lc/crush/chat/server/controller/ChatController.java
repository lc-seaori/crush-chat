package com.lc.crush.chat.server.controller;

import com.lc.crush.chat.server.domain.vo.SysConfigVo;
import com.lc.crush.chat.server.service.ISysConfigService;
import com.lc.crush.common.core.domain.R;
import com.lc.crush.common.redis.utils.RedisUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lc
 * @date 2023/6/15 17:39
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/chat")
public class ChatController {
    private final ISysConfigService configService;

    @GetMapping("test")
    @Trace
    public R<String> testChat(){
        log.info("hello world!");
        log.warn("hello world!");
        log.debug("hello world!");
        log.error("hello world!");
        return R.ok(TraceContext.traceId());
    }

    @GetMapping(value = "/{configId}")
    public R<SysConfigVo> getInfo(@PathVariable Long configId) {
        return R.ok(configService.selectConfigById(configId));
    }

    /**
     * 根据参数键名查询参数值
     * @param configKey 参数Key
     */
    @GetMapping(value = "/configKey/{configKey}")
    public R<Void> getConfigKey(@PathVariable String configKey) {
        return R.ok(configService.selectConfigByKey(configKey));
    }

    /**
     * 根据参数键名查询参数值【手动查Redis】
     * @param configKey
     * @return com.lc.crush.common.core.domain.R<java.lang.Void>
     * @throws
     * @author lc
     * @date 2023/6/20 21:30
     */
    @GetMapping(value = "/configKeyFromRedis/{configKey}")
    public R<Void> configKeyFromRedis(@PathVariable String configKey) {
        return R.ok(RedisUtils.delCacheMapValue("sys_config", configKey));
    }
}
