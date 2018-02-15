package com.sushant.bean;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.sushant.dao.SmartQuizDAO;
import com.sushant.dao.SmartQuizDAOImpl;
import com.sushant.service.SmartQuizService;
import com.sushant.service.SmartQuizServiceImpl;

@Configuration
@ComponentScan(basePackages={"com.sushant.dao","com.sushant.service"})
public class MyBeans {
	@Bean
public PropertyPlaceholderConfigurer placeholder(){
PropertyPlaceholderConfigurer placeholder=new PropertyPlaceholderConfigurer();
placeholder.setLocation(new ClassPathResource("com/sushant/properties/database.properties"));
return placeholder;
	}
	@Bean("dataSource")
	public DataSource dataSource( ){
	DriverManagerDataSource dataSource=new DriverManagerDataSource();
	dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
	dataSource.setUsername("hr");
    dataSource.setPassword("hr");
    return dataSource;
	}
	@Bean("smartQuizDAOImpl")
	public SmartQuizDAO smartQuizDAOImpl(){
		return new SmartQuizDAOImpl();
	}
	@Bean("smartQuizServiceImpl")
	public SmartQuizService smartQuizServiceImpl(){
		return new SmartQuizServiceImpl();
	}
	}

