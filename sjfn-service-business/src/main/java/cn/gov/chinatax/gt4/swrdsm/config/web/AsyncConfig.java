package cn.gov.chinatax.gt4.swrdsm.config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.core.task.support.TaskExecutorAdapter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Copyright：Copyright (c) 2002-2023 Digitalchina CO.,LTD.  All rights reserved.
 * @Company：神州数码信息系统集成服务有限公司
 * @Department：税务地方大客户.CA
 * @Author：huax
 * @CreationTime：2023-03-01 11:10:00
 * @Version：1.0
 * @Compiler：1.8
 * @Description：ScheculeConfig 开启异步线程 https://blog.csdn.net/sinat_15946141/article/details/107951917
 */
@Configuration
public class AsyncConfig {
    @Bean
    public TaskExecutor taskExecutor() {
        return new TaskExecutorAdapter(ForkJoinPool.commonPool());
    }

    @Bean(name = "zdycx-mxcx-async-executor")
    public Executor ZdycxMxcxAsync() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        //设置核心线程数
        taskExecutor.setCorePoolSize(24);
        // 线程池维护线程的最大数量，只有在缓冲队列满了以后才会申请超过核心线程数的线程
        taskExecutor.setMaxPoolSize(64);
        //缓存队列
        taskExecutor.setQueueCapacity(100);
        //允许的空闲时间，当超过了核心线程数之外的线程在空闲时间到达之后会被销毁
        taskExecutor.setKeepAliveSeconds(30 * 2);
        //异步方法内部线程名称
        taskExecutor.setThreadNamePrefix("zdycx-mxcx-async-executor");
        //拒绝策略
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        taskExecutor.initialize();
        return taskExecutor;
    }
    @Bean(name = "zdycx-tjfx-async-executor")
    public Executor ZdycxTjfxAsync() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        //设置核心线程数
        taskExecutor.setCorePoolSize(16);
        // 线程池维护线程的最大数量，只有在缓冲队列满了以后才会申请超过核心线程数的线程
        taskExecutor.setMaxPoolSize(64);
        //缓存队列
        taskExecutor.setQueueCapacity(100);
        //允许的空闲时间，当超过了核心线程数之外的线程在空闲时间到达之后会被销毁
        taskExecutor.setKeepAliveSeconds(30 * 2);
        //异步方法内部线程名称
        taskExecutor.setThreadNamePrefix("zdycx-tjfx-async-executor");
        //拒绝策略
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        taskExecutor.initialize();
        return taskExecutor;
    }
}
