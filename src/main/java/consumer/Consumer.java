package consumer;

import protocal.http.HttpClient;
import protocal.http.Invocation;
import provider.api.HelloService;

import java.lang.reflect.Method;

/**
 * @author tanghf
 * @className consumer.Consumer.java
 * @createTime 2019/8/21 13:27
 */
public class Consumer {

    public static void main(String[] args) throws NoSuchMethodException {

        HttpClient httpClient = new HttpClient();
        Invocation invocation = new Invocation(HelloService.class.getName(), "sayHello", new Class[]{String.class}, new Object[]{"world"});
        String result = httpClient.send("localhost", 8080, invocation);
        System.out.println(result);

    }
}
