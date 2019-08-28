package provider;

import framework.URL;
import protocal.dubbo.NettyServer;
import protocal.http.HttpServer;
import provider.api.HelloService;
import provider.impl.HelloServiceImpl;
import register.RemoteRegister;

/**
 * @author tanghf
 * @className provider.Provider.java
 * @createTime 2019/8/20 09:10
 */
public class Provider {

    public static void main(String[] args) {
        //1.本地注册
        //{服务名：实现类}
        System.out.println(HelloService.class.getName()+"========"+HelloServiceImpl.class);
        LocalRegister.register(HelloService.class.getName(), HelloServiceImpl.class);

        //2.远程注册
        //{服务名：List(url)}
        URL url = new URL("localhost", 8080);
        RemoteRegister.register(HelloService.class.getName(), url);

        //3.启动tomcat
        NettyServer httpServer = new NettyServer();
        httpServer.start("localhost", 8080);

    }
}
