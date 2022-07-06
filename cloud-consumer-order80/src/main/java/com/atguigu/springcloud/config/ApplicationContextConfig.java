package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    @Bean
    // @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}

/**
 * @LoadBalanced 是负载均衡的组件
 *    # 一般的负载均衡可分为两种，一种是本地负载均衡，一种是集中负载均衡
 *    # 本地负载均衡： 即在本服务内完成负载均衡的操作
 *          流程：
 *              1. 本地负载均衡的组件在注册中心里进行注册
 *              2. 当本地程序向客户端申请服务时，实际是由负载均衡的组件向注册中心申请服务
 *              3. 负载均衡的组件会将申请到的服务保存下来，然后根据负载均衡算法选择一个服务
 *              4. 本地程序就访问 3 中选择出来的程序
 *    # 集中负载均衡 ： 由服务器完成的负载均衡，比如 nginx,服务器会对所有访问注册中心的请求进
 *                   行负载均衡，然后再根据结果让请求访问对应的服务
 *    # @LoadBalanced用在本地，显然是本地的负载均衡
 *          那我们为什么可以使用 @LoadBalanced 标签对服务请求进行负载均衡呢？
 *              * 现在比较流行的负载均衡是 ribbon，这是netflix提出的负载均衡控制，已经被集成到springcloud
 *              * 未来的趋势可能是spring自己提出的 LoadBalanced 来完成负载均衡
 *              * 要使用负载均衡的话，我们必须在项目引入相关的依赖，即 robbin的相关依赖
 *                 但是本项目的服务注册是使用eureka的，eureka的客户端已经自己集成了Robbin
 *                 所以不需要我们手动引入。要是使用consul、zookeeper进行服务注册的话，我们
 *                 就要自己引入robbin的依赖
 *
 */
