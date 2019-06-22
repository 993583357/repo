package Lesson.proxy;

import Lesson.domain.User;
import Lesson.service.Service;
import Lesson.service.impl.ServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Proxy;

public class MyProxy {
    private Service proxy = new ServiceImpl();
    @Before
    public void test0(){
        Service service = new ServiceImpl();
        ClassLoader c = MyProxy.class.getClassLoader();
        Class[] interfaces = service.getClass().getInterfaces();
        MyHandler myHandler = new MyHandler(service);
        proxy = (Service) Proxy.newProxyInstance(c, interfaces, myHandler);
    }
    @Test
    public void test1(){
        User user = new User();
        user.setName("张三");
        proxy.addUser(user);
    }
    @Test
    public void test2(){
        User user = new User();
        proxy.updateUser(user);
    }
    @Test
    public void test3(){

    }


}
