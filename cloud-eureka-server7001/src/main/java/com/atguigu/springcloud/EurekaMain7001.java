package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @EnableEurekaServer表示这是 eureka 服务端程序
 * @EnableEurekaClient 表示这是 eureka 客户端程序
 * 在 eureka 内就两个组件，即客户端和服务端
 *      客户端: 想要在eureka内注册的服务
 *             1.连接服务端
 *             2.向服务端注册服务和保持连接
 *             3.向服务端获取服务
 *      服务端:
 *              1.接收客户端的请求
 *              2.管理注册的服务
 * 配置好eureka后,即可在浏览器通过配置端口访问eureka服务器的主页
 */

@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class,args);
    }
}
