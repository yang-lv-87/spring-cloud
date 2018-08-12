package com.example.demo;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
public class MysqlConfig {
	@Bean
	public DataSource dataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mysql://192.168.1.111:3306/solr");
			dataSource.setUser("root");
			dataSource.setPassword("root");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		return dataSource;
	}
}
