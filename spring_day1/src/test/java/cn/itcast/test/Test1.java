package cn.itcast.test;

import cn.itcast.domain.User;
import cn.itcast.service.Service;
import cn.itcast.service.impl.ServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

    @Test
    public void equls(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        Service service = (ServiceImpl)ac.getBean("service");
        User user1 = (User) ac.getBean("user1");
        System.out.println(user1);
        service.checkUserPassWord(user1);

    }
}
