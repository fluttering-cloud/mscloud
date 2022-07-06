package com.atguigu.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 本类是用于完成指定负载均衡算法
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myIRule() {
        return new RandomRule();
    }
}

/**
 * robbin负载均衡算法实现
 *      在SpringCloud内集成了robbin，而robbin的核心就是负载均衡算法。
 *   在robbin内，负载均衡算法都继承了IRule接口。所以我们也可以通过这个
 *   接口来实现自定义的负载均衡算法
 *
 * 注意
 *    若我们想给应用内的其他的负载均衡算法，而这些请求之外的请求还是使用robbin
 * 默认的负载均衡算法的话，定制化的负载均衡算法就不能被@ComponentScan标签扫描到，否则的
 * 话，我们自定义的负载均衡算法就会成为全局的负载均衡算法
 *    @SpringBootApplication 内有多个注解，其中包含了 @ComponentScan ，我们知道，@ComponentScan
 * 会自动扫描本包和本包下的所有子包中的类。所有要是我们想定制化负载均衡算法，那么我们的算法至少都要在
 * @SpringBootApplication 所在的包的同级包内。
 *
 *    当我们写好自定义的负载均衡算法后，就需要将其应用了，这时候就要用到 @RibbonClient 标签了。
 * @RibbonClient标签用于指定 Ribbon 的负载均衡算法。该标签的使用位置是启动类，即标注了@SpringBootApplication
 * 的类。
 *    @RibbonClient 标签有两个主要的属性，@RibbonClient(name = "服务名",configuration = 实现自定义负载均衡的类.class)
 * 其中 name 是注册中心内的服务的名字，configuration 是我们指定的负载均衡算法的类。当我们给这两个属性赋值后，以后每次访问
 * name所指的服务，就会用configuration内的负载均衡算法
 */
