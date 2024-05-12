package com.example.demo;

//import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan({"com.example.controller","com.example.service"})
@EntityScan("com.example.entity")
@EnableJpaRepositories("com.example.repository")
public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);

//        //Annotation!
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//
//        ctx.register(JavaConfig.class);
//        ctx.refresh();
//
//        Car car = ctx.getBean(Car.class);

        //Context
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("setting.xml");
//        Car car = (Car)ctx.getBean("car");

//        Frame frame = (Frame) ctx.getBean("frame");
//
//        Wheel bmw = (Wheel)ctx.getBean("bmw");
//        Wheel hm = (Wheel)ctx.getBean("hm");


//		frame.setWheel(hm);
//       car.setFrame(frame);

    }

}
