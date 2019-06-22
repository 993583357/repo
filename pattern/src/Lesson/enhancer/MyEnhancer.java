package Lesson.enhancer;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyEnhancer {
    private static Enhancer eh = new Enhancer();

    public void test() {
        System.out.println("helloWord");
    }

    public static void main(String[] args) {
        eh.setSuperclass(MyEnhancer.class);
        eh.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

                System.out.println("前置增强");
                Object o1 = methodProxy.invokeSuper(o, args);
                System.out.println("后置增强");
                return o1;
            }
        });
        MyEnhancer o = (MyEnhancer) eh.create();
        o.test();
    }
}
