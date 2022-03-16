package com.zhanyou.framework;

import com.zhanyou.protocol.dubbo.DubboProtocol;
import com.zhanyou.protocol.http.HttpProtocol;

public class ProtocolFactory {

    public static Protocol getProtocol() {
        // 工厂模式
//        String name = System.getProperty("protocolName");
        String name = "http";
        if (name == null || name.equals("")) name = "http";
        switch (name) {
            case "http":
                return new HttpProtocol();
            case "dubbo":
                return new DubboProtocol();
            default:
                break;
        }
        return new HttpProtocol();
    }
}
