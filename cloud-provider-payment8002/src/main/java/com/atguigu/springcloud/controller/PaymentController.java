package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping(value = "payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        System.out.println("hhe");
        if (result > 0) {
            return new CommonResult(200,"插入数据成功",result);
        }else {
            return new CommonResult(444,"插入数据失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        System.out.println("查询成功:" + id);
        Payment result = paymentService.getPaymentById(id);
        System.out.println("*******查询成功" + result.toString());
        if (result != null) {
            return new CommonResult(200,"查询成功,端口号：" + port,result);
        }else {
            return new CommonResult(444,"查询失败",null);
        }
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB() {
        return port;
    }
}
