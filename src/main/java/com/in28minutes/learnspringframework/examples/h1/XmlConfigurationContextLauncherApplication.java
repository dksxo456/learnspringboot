package com.in28minutes.learnspringframework.examples.h1;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.in28minutes.learnspringframework.game.GameRunner;

import jakarta.inject.Inject;
import jakarta.inject.Named;


@Configuration
@ComponentScan 
public class XmlConfigurationContextLauncherApplication {
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stubss

		try(var context = new ClassPathXmlApplicationContext("contextConfiguration.xml")){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			 System.out.println(context.getBean("name"));
			 System.out.println(context.getBean("age"));
			 System.out.println(context.getBean("GameRunner"));
			 context.getBean(GameRunner.class).run();  //반환 타입이 GameRunner
			 ((GameRunner)context.getBean("GameRunner")).run(); // ""은 Object 형태로 반환하므로 형변환 필요.
		}
		
		
	}

}


 