package com.in28minutes.learnspringframework.examples.g1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.inject.Inject;
import jakarta.inject.Named;

//@Component
@Named
class BusinessService{
	private DataService dataService;
 
	
	public DataService getDataService() {
		
		return dataService;
	}
	//@Autowired
	@Inject
	public void setDataService(DataService dataService) {
		this.dataService = dataService;
		System.out.println("Setter Injection");
	}
}
//@Component 
@Named
class DataService{
	
}

@Configuration
@ComponentScan 
public class CdiContextLauncherApplication {
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stubss

		try(var context = new AnnotationConfigApplicationContext(CdiContextLauncherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			System.out.println(context.getBean(BusinessService.class).getDataService());
	 
		}
		
		
	}

}


 