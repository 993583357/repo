package Lesson.config;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy {

    private static Enhancer eh = new Enhancer();
    private static Demo d = new Demo();
    public static Object getProxy() {
        eh.setSuperclass(d.getClass());
        eh.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                try {
                    TransactionManager.beginConnection();
                    Object o1 = method.invoke(d, objects);
                    TransactionManager.commitConnection();
                    return o1;

                }catch (Exception e) {
                    e.printStackTrace();
                    TransactionManager.rollBackConnection();
                }finally {
                    TransactionManager.closeConnection();
                }
                return null;
            }
        });
        return eh.create();
    }
}
