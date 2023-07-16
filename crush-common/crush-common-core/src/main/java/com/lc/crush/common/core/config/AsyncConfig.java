package com.lc.crush.common.core.config;

import cn.hutool.core.util.ArrayUtil;
import com.lc.crush.common.core.exception.ServiceException;
import com.lc.crush.common.core.utils.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Arrays;
import java.util.concurrent.*;

/**
 * 异步配置：自定义异步线程池
 * @author lc
 */
@Slf4j
@EnableAsync(proxyTargetClass = true)
@AutoConfiguration
public class AsyncConfig implements AsyncConfigurer {

    private static final int CORE_POOL_SIZE = 10;

    /**
     * 执行周期性或定时任务
     * 可以通过ThreadPoolTaskExecutor创建
     */
    @Bean(name = "scheduledExecutorService")
    public ScheduledExecutorService scheduledExecutorService() {
        return new ScheduledThreadPoolExecutor(CORE_POOL_SIZE,
            new BasicThreadFactory.Builder().namingPattern("schedule-pool-%d").daemon(true).build(),
            new ThreadPoolExecutor.CallerRunsPolicy()) {
            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                super.afterExecute(r, t);
                printException(r, t);
            }
        };
    }

    /**
     * 自定义 @Async 注解使用系统线程池
     */
    @Override
    public Executor getAsyncExecutor() {
        return SpringUtils.getBean("scheduledExecutorService");
    }

    /**
     * 异步执行异常处理
     */
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (throwable, method, objects) -> {
            throwable.printStackTrace();
            StringBuilder sb = new StringBuilder();
            sb.append("Exception message - ").append(throwable.getMessage())
                .append(", Method name - ").append(method.getName());
            if (ArrayUtil.isNotEmpty(objects)) {
                sb.append(", Parameter value - ").append(Arrays.toString(objects));
            }
            throw new ServiceException(sb.toString());
        };
    }

    /**
     * 打印线程异常信息
     */
    public void printException(Runnable r, Throwable t) {
        if (t == null && r instanceof Future<?>) {
            try {
                Future<?> future = (Future<?>) r;
                if (future.isDone()) {
                    future.get();
                }
            } catch (CancellationException ce) {
                t = ce;
            } catch (ExecutionException ee) {
                t = ee.getCause();
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
        if (t != null) {
            log.error(t.getMessage(), t);
        }
    }

    /**
     *@Override
     *     public Executor getAsyncExecutor() {
     *         return customExecutor();
     *     }
     *
     *     @Bean(MALLCHAT_EXECUTOR)
     *     @Primary
     *     public ThreadPoolTaskExecutor customExecutor() {
     *         ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
     *         executor.setCorePoolSize(10);
     *         executor.setMaxPoolSize(10);
     *         executor.setQueueCapacity(200);
     *         executor.setThreadNamePrefix("custom-executor-");
     *         executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());//满了调用线程执行，认为重要任务
     *         executor.setThreadFactory(new MyThreadFactory(executor));
     *         executor.initialize();
     *         return executor;
     *     }
     *
     *     @Bean
     *     public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
     *         // 获得运行机器 逻辑处理器核数（其实就是线程数）
     *         int availableNum = Runtime.getRuntime().availableProcessors();
     *         ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
     *         // 核心线程数 cpu * 2
     *         executor.setCorePoolSize(availableNum * 2);
     *         // 配置最大线程数 50
     *         executor.setMaxPoolSize(50);
     *         // 配置队列容量
     *         executor.setQueueCapacity(500);
     *         // 配置非核心线程超时释放时间（核心线程默认不允许回收）
     *         executor.setKeepAliveSeconds(60);
     *         // 配置线程名称前缀
     *         executor.setThreadNamePrefix("vol-thread-pool");
     *         // 增加 TaskDecorator 属性的配置
     *         executor.setTaskDecorator(new ContextDecorator());
     *         // 配置拒绝策略，CallerRunsPolicy：当拒绝时由调用线程处理该任务
     *         executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
     *         return executor;
     *     }
     */

}
