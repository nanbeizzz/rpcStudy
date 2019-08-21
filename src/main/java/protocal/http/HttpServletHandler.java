package protocal.http;

import org.apache.commons.io.IOUtils;
import provider.LocalRegister;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author tanghf
 * @className protocal.http.HttpServletHandler.java
 * @createTime 2019/8/21 10:40
 */
public class HttpServletHandler {

    public void handle(HttpServletRequest req, HttpServletResponse resp){
        //处理请求，返回结果
        try {
            ServletInputStream inputStream = req.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(inputStream);

            Invocation invocation = (Invocation) ois.readObject();
            Class implClass = LocalRegister.get(invocation.getInterfaceName());
            Method method = implClass.getMethod(invocation.getMethodName(), invocation.getParamTypes());
            String result = (String) method.invoke(implClass.newInstance(), invocation.getParams());
            IOUtils.write(result, resp.getOutputStream(), "utf-8");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
