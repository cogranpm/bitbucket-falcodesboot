package com.faobruzen.spring.config;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@ComponentScan("com.faubruzen.ui.controller")
public class AppJavaConfig {

	
    @Bean(name = "stringPrintWriter") @Scope("prototype")
    public PrintWriter printWriter(){
        // useful when dumping stack trace to file
        return new PrintWriter(new StringWriter());
    }	
    
    private DataSource getEmbeddedDataSource()
    {
    	DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:derby:C:\\Projects\\Database\\Falcode;create=true");
        dataSourceBuilder.username("paulm");
        dataSourceBuilder.password("reddingo");
        dataSourceBuilder.driverClassName("org.apache.derby.jdbc.EmbeddedDriver");
        DataSource ds = dataSourceBuilder.build(); 
        return ds;
    }
    
    private DataSource getServerDataSource()
    {
    	DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:derby://localhost:1527//home/paulm/Documents/Projects/Database/Woosterizer/Woosterizer_DEV;create=true");
        dataSourceBuilder.username("paulm");
        dataSourceBuilder.password("reddingo");
        dataSourceBuilder.driverClassName("org.apache.derby.jdbc.ClientDriver");
        DataSource ds = dataSourceBuilder.build(); 
        return ds;
    }
    

    @Bean
    public DataSource dataSource() {
    	return getServerDataSource();
        //return getEmbeddedDataSource();
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
      LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
      em.setDataSource(dataSource);
      em.setPackagesToScan(new String[] { "com.faobruzen.entity" });

      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
      em.setJpaVendorAdapter(vendorAdapter);

      Properties properties = new Properties();
      properties.setProperty("spring.jpa.hibernate.ddl-auto", "none");
      properties.setProperty("spring.jpa.database-platform", "org.hibernate.dialect.DerbyTenSevenDialect");
      properties.setProperty("spring.jpa.show-sql", "false");
      properties.setProperty("spring.datasource.continue-on-error", "false");
      em.setJpaProperties(properties);

      return em;
    }    
    
    
	
}
