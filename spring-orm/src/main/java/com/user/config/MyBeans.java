package com.user.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import com.user.pojo.User;

@Configuration
@ComponentScan(basePackages={"com.user.dao"})
public class MyBeans {
	private DataSource dataSource;
	@Bean
public DataSource dataSource(
		@Value("${db.driverClassName}") String driverClassName,
		@Value("${db.url}") String url,
		@Value("${db.username}") String user,
		@Value("${db.password}") String password){
	DriverManagerDataSource dataSource=new DriverManagerDataSource();
	dataSource.setDriverClassName(driverClassName);
	dataSource.setUrl(url);
	dataSource.setUsername(user);
	dataSource.setPassword(password);
	this.dataSource=dataSource;
	return dataSource;
	
}   @Bean(autowire=Autowire.BY_TYPE)
	public HibernateTemplate hibernateTemplate(){
		return new HibernateTemplate();
	}
@Bean(autowire=Autowire.BY_TYPE)
public LocalSessionFactoryBean localSessionFactoryBean(){
	LocalSessionFactoryBean factorybean=new LocalSessionFactoryBean();
	Properties prop=new Properties();
	prop.setProperty("hibernate.show_sql", "true");
	prop.setProperty("hibernate.hbm2ddl.auto", "create");
	factorybean.setAnnotatedClasses(User.class);
	factorybean.setHibernateProperties(prop);
	factorybean.setDataSource(dataSource);
	
	return factorybean;
	
}
@Bean
public static PropertyPlaceholderConfigurer placeholder(){
	PropertyPlaceholderConfigurer placeholder=new PropertyPlaceholderConfigurer();
	placeholder.setLocation(new ClassPathResource("com/user/properties/database.properties"));
	return placeholder;
}



}
