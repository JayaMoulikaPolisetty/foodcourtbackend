package com.niit.foodcourtbackend.configuration;

import java.util.Properties;


import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.niit.foodcourtbackend")
public class HibernateConfiguration {
 
	//DataSource bean is created
	@Bean
	public DataSource getdataSource()
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
	public SessionFactory sessionFactory(DataSource datasource)
	{	
		LocalSessionFactoryBuilder localSessionFactoryBuilder = new LocalSessionFactoryBuilder(datasource);
		localSessionFactoryBuilder.scanPackages("com.niit.foodcourtbackend");
		localSessionFactoryBuilder.getProperties();
		return localSessionFactoryBuilder.buildSessionFactory();
	}
	
	//adding hibernate properties to session factory
	public void getProperties()
	{
		Properties properties = new Properties();
		properties.put("hibernate_dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate_format_sql", "true");
		properties.put("hibernate_show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
	}
	
	@Bean
	public HibernateTransactionManager TransactionalManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager(sessionFactory);
		return hibernateTransactionManager;
		
	}
	
}
