package com.zhanyou.provider;

import com.zhanyou.framework.Protocol;
import com.zhanyou.framework.ProtocolFactory;
import com.zhanyou.framework.URL;
import com.zhanyou.provider.api.HelloService;
import com.zhanyou.provider.impl.HelloServiceImpl;
import com.zhanyou.register.RemoteMapRegister;

public class Provider {

    private static boolean isRun = true;

    public static void main(String[] args) {
        // 注册服务
        URL url = new URL("localhost", Integer.valueOf(System.getProperty("port")));
        RemoteMapRegister.regist(HelloService.class.getName(), url);
//        ZookeeperRegister.regist(HelloService.class.getName(), url);
        LocalRegister.regist(HelloService.class.getName(), HelloServiceImpl.class);

        // 启动Tomcat
        Protocol protocol = ProtocolFactory.getProtocol();
        protocol.start(url);



    }
}
