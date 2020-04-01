package com.newer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.newer.util.Person;

@SpringBootTest
class DemoApplicationTests {
	
	//自动注入spring的ioc容器
	@Autowired
	private ApplicationContext ctxt;
	
	@Autowired
	private Person person;

	@Test
	public void test() {
		for(String name:ctxt.getBeanDefinitionNames()) {
			System.out.println(name);
		}
	}
	
	@Test
	public void test2() {
		 System.out.println(person);
	}

}
