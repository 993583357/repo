package Lesson.enhancer;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyEnhancer1{
    private static Enhancer eh = new Enhancer();
    private static MyMethodInterceptor m = new MyMethodInterceptor();
    public static Object getProxyObj(Class clazz) {
        eh.setSuperclass(clazz);
        eh.setCallback(m);
        Object o = eh.create();
        return o;
    }

    public static void main(String[] args) {
        UserService proxyObj = (UserService) getProxyObj(UserService.class);
        proxyObj.selectUses();
        proxyObj.deleteUses();
    }

}
