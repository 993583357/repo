package cn.itcast.test;

import cn.itcast.config.AnnotationConfig;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.ServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class Test1 {

    @Test
    public void checkTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        UserService service = (ServiceImpl)ac.getBean("serviceImpl");
        //User user = (User) ac.getBean("user1");
        //service.checkUserPassWord(user);
        service.selectAll();
    }

}
