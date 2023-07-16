package com.lc.crush.gateway.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.core.Ordered;
import com.lc.crush.gateway.filter.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 拦截器排序：序号越低优先级越高
 * @author abing
 * @date 2023/6/15 15:34
 */
@Getter
@AllArgsConstructor
public enum FilterOrder {

    /**
     * 跨域配置：MIN_VALUE
     */
    GlobalCorsFilter(GlobalCorsFilter.class, Ordered.HIGHEST_PRECEDENCE),

    /**
     * 国际化处理：MIN_VALUE
     */
    GlobalI18nFilter(GlobalI18nFilter.class, Ordered.HIGHEST_PRECEDENCE),

    /**
     * 跨站脚本过滤器：MIN_VALUE
     */
    XssFilter(XssFilter.class, Ordered.HIGHEST_PRECEDENCE),

    /**
     * 全局缓存获取body请求数据（解决流不能重复读取问题）:MIN_VALUE + 1
     */
    GlobalCacheRequestFilter(GlobalCacheRequestFilter.class, Ordered.HIGHEST_PRECEDENCE + 1),

    /**
     * 转发认证过滤器(内部服务外网隔离)
     **/
    ForwardAuthFilter(ForwardAuthFilter.class, -100),

    /**
     * 全局日志过滤器
     * <p>
     * 用于打印请求执行参数与响应时间等等 ：MAX_VALUE
     **/
    GlobalLogFilter(GlobalLogFilter.class, Ordered.LOWEST_PRECEDENCE),

    ;

    private final Class clazz;
    private final Integer order;

    private static Map<Class, Integer> cache;

    static {
        cache = Arrays.stream(FilterOrder.values())
                .collect(Collectors.toMap(FilterOrder::getClazz, FilterOrder::getOrder));
    }

    /**
     * 根据类获取序号
     * @param clazz
     * @return
     */
    public static Integer of(Class clazz) {
        return Optional.of(cache.get(clazz)).orElse(-1);
    }
}
