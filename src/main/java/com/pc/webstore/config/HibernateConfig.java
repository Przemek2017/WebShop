package com.pc.webstore.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Przemek
 */
@Configuration
@ComponentScan(basePackages = {"com.pc.webstore.dto"})
@EnableTransactionManagement
public class HibernateConfig {
    
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/onlineshop?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_DIALECT = "org.hibernate.dialect.MySQLDialect";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "toor";
    
    @Bean
    public DataSource getDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(DATABASE_DRIVER);
        dataSource.setUrl(DATABASE_URL);
        dataSource.setUsername(DATABASE_USERNAME);
        dataSource.setPassword(DATABASE_PASSWORD);
        dataSource.setMaxTotal(2);
        dataSource.setInitialSize(1);
        dataSource.setTestOnBorrow(true);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setDefaultAutoCommit(true);
        return dataSource;
    }
    
    @Bean
    public SessionFactory getSessionFactory(DataSource dataSource){
        LocalSessionFactoryBuilder sessionFactoryBuilder = new LocalSessionFactoryBuilder(dataSource);
        sessionFactoryBuilder.addProperties(getHibernateProperties());
        sessionFactoryBuilder.scanPackages("com.pc.webstore.dto");
        return sessionFactoryBuilder.buildSessionFactory();
    }
    
    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", DATABASE_DIALECT);
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.format_sql", "true");
        return properties;
    }
    
    @Bean
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
        return transactionManager;
    }
}
