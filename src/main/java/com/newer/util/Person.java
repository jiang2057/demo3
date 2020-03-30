package com.newer.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("person")
@PropertySource("classpath:account.properties")
public class Person {
	private String name;
	private double salary;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	
	@Value("${account.accountNo}")
	private String accountNo;
	@Value("${account.pwd}")
	private String pwd;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", salary=" + salary + ", birthday=" + birthday + ", accountNo=" + accountNo
				+ ", pwd=" + pwd + "]";
	}
	
	
	
	

	 
	
}
