package josh.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import josh.beans.Games;

@Configuration
public class BeanConfiguration 
{
	@Bean
	public Games games()
	{
		Games bean = new Games();
		bean.setName("WIP");
		bean.setType("NA");
		bean.setPrice(12.99);
		return bean;
	}
	
	
	
}
