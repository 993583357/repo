package Lesson.proxy;

import Lesson.domain.User;
import Lesson.service.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

public class MyHandler implements InvocationHandler{
    private Service service;
    public MyHandler(Service service){
        this.service = service;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().contains("add") || method.getName().contains("update")) {
            String s = String.format("%tF %<tT", new Date());
            User user = (User) args[0];
            System.out.println(user.getName()+"\n"+ s);
        }

        return method.invoke(service,args);
    }
}
