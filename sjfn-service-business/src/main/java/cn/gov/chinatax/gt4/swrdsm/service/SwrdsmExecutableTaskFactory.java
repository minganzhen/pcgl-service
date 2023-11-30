package cn.gov.chinatax.gt4.swrdsm.service;

import com.tencent.cloud.task.sdk.client.DefaultTaskFactory;
import com.tencent.cloud.task.sdk.client.exception.InstancingException;
import com.tencent.cloud.task.sdk.client.model.ExecutableTaskData;
import com.tencent.cloud.task.sdk.client.spi.ExecutableTask;
import com.tencent.cloud.task.sdk.client.spi.ExecutableTaskFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.invoke.MethodHandles;

/**
 * @project 总局税务人端
 * @package cn.gov.chinatax.gt4.swrdsm.service
 * @file SkzsExecutableTaskFactory.java 创建时间:2023/11/1011:09
 * @title 标题（要求能简洁地表达出类的功能和职责）
 * @description 描述（简要描述类的职责、实现方式、使用注意事项等）
 * @copyright Copyright (c) 2023 中国软件与技术服务股份有限公司
 * @company 中国软件与技术服务股份有限公司
 * @module 模块: 
 * @author 范良才
 * @reviewer 审核人
 *
 * @version 1.0.0
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 *
 */
public class SwrdsmExecutableTaskFactory implements ExecutableTaskFactory, ApplicationContextAware {

    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private ApplicationContext applicationContext;

    private final ExecutableTaskFactory defaultFactory =
            new DefaultTaskFactory(Thread.currentThread().getContextClassLoader());


    @Override
    public ExecutableTask newExecutableTask(ExecutableTaskData executableTaskData) throws InstancingException {
        try {
            ExecutableTask executableTask =
                    (ExecutableTask) applicationContext.getBean(Class.forName(executableTaskData.getTaskContent()));
            LOG.info("generate executableTask bean SpringExecutableTaskFactory. taskName: {}",
                    executableTaskData.getTaskContent());
            return executableTask;
        } catch (Throwable t) {
            LOG.info("FpysValidExecutableTask is terminated... ");
            return defaultFactory.newExecutableTask(executableTaskData);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}
