package com.hellojava.spring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

//表示当前类是一个Spring配置类
@Configuration
//定义扫描的基础包
@ComponentScan(basePackages= {"com.hellojava"})
//导入properties文件
@PropertySource("classpath:db.properties")
public class SpringConfiguration {
	@Autowired
	private Environment env;
	
	@Bean(name="dataSource")
	public DataSource initDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("driver"));
		dataSource.setUrl(env.getProperty("url"));
		dataSource.setUsername(env.getProperty("user"));
		dataSource.setPassword(env.getProperty("password"));
		return dataSource;
	}
}
