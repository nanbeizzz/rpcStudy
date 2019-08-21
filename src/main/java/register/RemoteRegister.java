package register;

import framework.URL;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tanghf
 * @className register.RemoteRegister.java
 * @createTime 2019/8/21 11:37
 */
public class RemoteRegister {

    private static Map<String, List<URL>> REGISTER = new HashMap<>();

    public static void register(String interfaceName, URL url) {
        List<URL> urls = Collections.singletonList(url);
        REGISTER.put(interfaceName, urls);
    }

    public static List<URL> get(String interfaceName){
        return REGISTER.get(interfaceName);
    }
}
