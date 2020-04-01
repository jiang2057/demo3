package com.newer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.newer.util.HelloService;

@ImportResource(locations = "classpath:spring-bean.xml")
@Configuration
public class AppConfig {
	/*
	 * @Bean定义bean，
	 *      bean对象为方法的返回值
	 *      bean的名称为方法名
	 */
	@Bean
	public HelloService helloService() {
		return new HelloService();
	}

}
