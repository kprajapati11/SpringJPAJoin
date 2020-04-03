package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Address;
import dmacc.beans.Book;
import dmacc.beans.Borrower;

@Configuration
public class BeanConfiguration {
	@Bean 
	public Borrower borrower() {
		Borrower bean = new Borrower("Test Name");
		bean.setName("Hello");
		bean.setPhone("515-111-1234");
		return bean;
	}
	
	@Bean
	public Address address() {
		Address bean = new Address("123 Main street", "Des Moines", "IA");
		return bean;
	}
	
	
	@Bean
	public Book book() {
		Book bean = new Book(new Long(122332323),"Intro to Java","Thomas T");
		return bean;
	}

}


