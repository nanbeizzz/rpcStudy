package register;

import framework.URL;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.*;

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
        saveFile();
    }

    public static List<URL> get(String interfaceName){
        return getFile().get(interfaceName);
    }

    public static URL getRandom(String interfaceName){
        List<URL> urls = RemoteRegister.get(interfaceName);
        int i = new Random().nextInt(urls.size());
        return urls.get(i);
    }

    private static void saveFile(){
        try {
            FileOutputStream fos = new FileOutputStream("/temp.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(REGISTER);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, List<URL>> getFile(){
        try {
            FileInputStream fis = new FileInputStream("/temp.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Map<String, List<URL>> map = (Map<String, List<URL>>) ois.readObject();
            ois.close();
            fis.close();
            return map;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
