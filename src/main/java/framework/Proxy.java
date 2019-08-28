package framework;

import protocal.dubbo.NettyClient;
import protocal.http.HttpClient;
import register.RemoteRegister;

/**
 * @author tanghf
 * @className framework.Proxy.java
 * @createTime 2019/8/22 15:28
 */
public class Proxy {

    public static <T> T getProxy(Class<T> interfaceClass){
        return (T) java.lang.reflect.Proxy.newProxyInstance(interfaceClass.getClassLoader(),
                new Class[]{interfaceClass},
                (proxy, method, args) -> {
//                    HttpClient httpClient = new HttpClient();
                    NettyClient httpClient = new NettyClient<>();
                    Invocation invocation = new Invocation(interfaceClass.getName(),
                            method.getName(),
                            method.getParameterTypes(),
                            args);
                    URL url = RemoteRegister.getRandom(interfaceClass.getName());
                    String result = httpClient.send(url.getHostname(), url.getPort(), invocation);
                    return result;
                });
    }
}
