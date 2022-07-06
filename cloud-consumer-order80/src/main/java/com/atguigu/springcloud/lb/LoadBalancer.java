package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalancer {

    ServiceInstance instance(List<ServiceInstance> serviceInstances);

}

/**
 * 自定义负载均衡的实现思路
 *      自定义负载均衡算法的核心就是通过服务发现获取
 *  服务名下的所有服务，然后通过负载均衡算法来选择具
 *  体的服务。
 *     其主要流程如下：
 *        1.通过服务发现获得对应服务名下的所有服务，这个可以使用 DiscoveryClient
 *        2.对所有的服务用负载均衡算法进行选择
 *        3.通过 2 选择的服务进行具体任务的执行
 */
