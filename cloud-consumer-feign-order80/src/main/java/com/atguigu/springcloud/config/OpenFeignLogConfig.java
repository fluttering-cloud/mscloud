package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenFeignLogConfig {

    @Bean
    public Logger.Level getOpenFeignLog() {
        return Logger.Level.FULL;
    }

}

/**
 *      在Openfeign内提供了对每个调用打印日志的功能，我们可以通过该接口对调用者的调用情况进行监督
 *      在 feign 内有一个 Logger 类，我们只需要把这个类注入容器，并且在yml文件内指定对哪个服务
 * 的底调用进行监控，即可开启 feign 的日志监控功能
 *      yml文件的配置如下：
 *          logging:
 *              level:
 *                 被监控接口的全路径: 日志级别（error、debug、info等等）
 *  注意，在OpenFeign内的日志输出信息有以下几种
 *          Logger.Level.NONE : 默认级别，不显示任何日志
 *          Logger.Level.BASIC : 仅记录请求方法、url、响应状态码、执行时间
 *          Logger.Level.HEADERS: 除了BASIC的信息外，还有请求和响应头的信息
 *          Logger.Level.FULL: 除了HEADERS的信息外,还有请求和响应的正文及元数据
 */