package Lesson.config;

import Lesson.service.AccountService;
import Lesson.service.serviceImpl.AccountServiceImpl;

public class Test {
    public static void main(String[] args) {
        //模拟转账的人和金额
        int id1 = 1;
        int id2 = 2;
        int money = 8000;
        //获取增强对象
        //1.通过jdk动态代理
        AccountService proxyInstance = ProxyFatory.getProxyInstance();
        //2.通过cglib动态代理
        //Demo proxyInstance = (Demo) CglibProxy.getProxy();
        //执行转出的增强方法
        proxyInstance.setAccount(id1,id2,money);
        //制造系统异常
        //int a = 1/0;




    }
}
