package provider;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tanghf
 * @className provider.LocalRegister.java
 * @createTime 2019/8/21 11:14
 */
public class LocalRegister {

    private static Map<String, Class> LOCALREGISTER = new HashMap<>();

    public static void register(String interfaceName, Class interfaceImpl){
        LOCALREGISTER.put(interfaceName, interfaceImpl);
    }

    public static Class get(String interfaceName){
        return LOCALREGISTER.get(interfaceName);
    }
}
