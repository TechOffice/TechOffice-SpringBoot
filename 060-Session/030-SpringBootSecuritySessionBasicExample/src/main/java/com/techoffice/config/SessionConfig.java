package com.techoffice.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJdbcHttpSession
public class SessionConfig {

	@Bean
	public EmbeddedDatabase dataSource(){
		EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
		embeddedDatabaseBuilder.setType(EmbeddedDatabaseType.H2);
		embeddedDatabaseBuilder.addScript("org/springframework/session/jdbc/schema-h2.sql");
		return embeddedDatabaseBuilder.build();
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

}
