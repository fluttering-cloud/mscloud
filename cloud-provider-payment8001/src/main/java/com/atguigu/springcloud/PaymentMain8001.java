package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient    // 表示这是一个eureka客户端
// @EnableDiscoveryClient // 填加这个类，表示可以实现服务发现
public class PaymentMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class,args);
    }
}
/**
 * @EnableEurekaClient
 *    # 该注解表示这个应用程序是 eureka 的客户端
 *    # eureka的客户端，即在eureka内进行注册过的服务
 *
 * @EnableDiscoveryClient
 *    # 该注解用于完成服务发现功能，常常搭配 DiscoveryClient 类一起使用
 *    # 什么是服务发现：
 *        当一个服务在注册中心（如eureka、zookeeper）内注册后，可以获得其他服务的ip、主机等等信息
 *    这就是服务发现
 *        当开启服务发现后，我们可以通过 DiscoveryClient 类来获取注册中心内的所有服务
 *              使用步骤：
 *                  1. 在需要使用服务发现的地方注入DiscoveryClient
 *                  2. 调用 getInstances("服务名") 方法获得对应的服务
 *                  3. 获取服务内的对象，即可查看ip、主机等信息
 */