package com.niit.foodcourtbackend.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

@Configuration
public class HibernateConfiguration {
 
	//DataSource bean is created
	@Bean
	public DataSource datasource()
	{
		BasicDataSource datasource = new BasicDataSource();
		datasource.setDriverClassName("org.h2.driver");
		datasource.setUsername("sa");
		datasource.setPassword("");
		datasource.setUrl("jdbc:h2:~/foodcourt");
		return datasource;
	}
	//localSessionFactoryBuilder is created
	@Bean
	public LocalSessionFactoryBuilder sessionFactory(DataSource datasource)
	{	
		LocalSessionFactoryBuilder sessionFactory = new LocalSessionFactoryBuilder(datasource);
		sessionFactory.scanPackages("com.niit.foodcourtbackend");
		sessionFactory.getProperties();
		return sessionFactory;
	}
	
	public void getProperties()
	{
		Properties properties = new Properties();
		properties.put("hibernate_dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate_format_sql", "true");
		properties.put("hibernate_show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
	}
	
}
