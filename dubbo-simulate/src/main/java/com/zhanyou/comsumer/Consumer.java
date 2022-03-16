package com.zhanyou.comsumer;

import com.zhanyou.framework.ProxyFactory;
import com.zhanyou.provider.api.HelloService;

public class Consumer {

    public static void main(String[] args) {
        HelloService helloService = ProxyFactory.getProxy(HelloService.class);
        for (;;) {
            try {
                String result = helloService.sayHello("占友");
                System.out.println(result);
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }

    }
}
