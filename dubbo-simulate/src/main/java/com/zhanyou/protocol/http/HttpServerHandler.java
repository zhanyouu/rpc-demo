package com.zhanyou.protocol.http;

import com.zhanyou.framework.Invocation;
import org.apache.commons.io.IOUtils;
import com.zhanyou.provider.LocalRegister;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;

public class HttpServerHandler {

    public void handler(HttpServletRequest req, HttpServletResponse resp) {

        try {
            InputStream inputStream = req.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(inputStream);
            Invocation invocation = (Invocation)ois.readObject();
//            Invocation invocation = JSONObject.parseObject(req.getInputStream(), Invocation.class);
            String interfaceName = invocation.getInterfaceName();
            Class implClass = LocalRegister.get(interfaceName);
            Method method = implClass.getMethod(invocation.getMethodName(), invocation.getParamType());
            String result = (String) method.invoke(implClass.newInstance(), invocation.getParams());

            System.out.println("tomcat:" + result);
            IOUtils.write(result, resp.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
