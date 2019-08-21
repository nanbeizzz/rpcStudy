package provider.impl;

import provider.api.HelloService;

/**
 * @author tanghf
 * @className provider.impl.HelloServiceImpl.java
 * @createTime 2019/8/21 10:52
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String username) {
        return "hello, " + username;
    }
}
