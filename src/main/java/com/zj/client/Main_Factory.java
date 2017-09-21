package com.zj.client;

import com.caucho.hessian.client.HessianProxyFactory;
import com.zj.bean.User;
import com.zj.client.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.MalformedURLException;

public class Main_Factory {
    public static void main(String[] args) throws MalformedURLException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:client-context.xml");
        String url = "http://localhost:8080/service/userService";
        HessianProxyFactory factory = new HessianProxyFactory();
        UserService service = (UserService)factory.create(UserService.class,url);
        User user = service.getUserbyName("Alvis");
        System.out.println(user.getName());
    }
}