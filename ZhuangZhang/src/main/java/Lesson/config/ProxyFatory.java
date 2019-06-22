package Lesson.config;

import Lesson.service.AccountService;
import Lesson.service.serviceImpl.AccountServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFatory {
    private static AccountService accountService = new AccountServiceImpl();
    public static AccountService getProxyInstance() {
        final Class clazz = accountService.getClass();
        AccountService proxyInstance = (AccountService) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new InvocationHandler() {

            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object o = null;
                try {
                    //前置窗口
                    TransactionManager.beginConnection();
                    o = method.invoke(accountService, args);
                    //后置窗口
                    TransactionManager.commitConnection();
                } catch (Exception e) {
                    e.printStackTrace();
                    //回滚窗口
                    TransactionManager.rollBackConnection();
                } finally {
                    //最终窗口
                    TransactionManager.closeConnection();
                }

                return o;
            }
        });


        return proxyInstance;
    }
}
