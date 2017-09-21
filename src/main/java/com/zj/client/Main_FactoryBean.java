package com.zj.client;

import com.caucho.hessian.client.HessianProxyFactory;
import com.zj.bean.User;
import com.zj.client.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

import java.net.MalformedURLException;

public class Main_FactoryBean {
    public static void main(String[] args) throws MalformedURLException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:client-context.xml");
        String url = "http://localhost:8080/service/userService";

        HessianProxyFactoryBean hessianProxyFactoryBean=new HessianProxyFactoryBean();
        hessianProxyFactoryBean.setServiceUrl(url);
        hessianProxyFactoryBean.setServiceInterface(UserService.class);
        hessianProxyFactoryBean.afterPropertiesSet();
        UserService userService=(UserService)hessianProxyFactoryBean.getObject();
        User user=userService.getUserbyName("Alvis");
        System.out.println(user.getName());
    }
}