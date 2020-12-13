package org.lk.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DataSourceConfiguration {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driver-class-name}")
    private String driverClass;

    @Bean
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(url);
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);
        hikariConfig.setDriverClassName(driverClass);

        hikariConfig.setMaximumPoolSize(15);
        hikariConfig.setPoolName("lk-uk-connection-pool");

        return new HikariDataSource(hikariConfig);
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean sessionFactory =
                new LocalSessionFactoryBean();

        sessionFactory.setDataSource(dataSource); // sessionFactory.setDataSource(dataSource())
        sessionFactory.setPackagesToScan("org.lk.model.domain");
        // sessionFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        return sessionFactory;
    }

    //   @Bean
    //    @DependsOn("flyway")
    //    public LocalContainerEntityManagerFactoryBean configureEntityManagerFactory() {
    //        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
    //        entityManagerFactoryBean.setDataSource(configureDataSource());
    //        entityManagerFactoryBean.setPackagesToScan("package to scan");
    //        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    //
    //        Properties jpaProperties = new Properties();
    //        jpaProperties.put(org.hibernate.cfg.Environment.DIALECT, dialect);
    //        jpaProperties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, hbm2ddlAuto);
    //        entityManagerFactoryBean.setJpaProperties(jpaProperties);
    //
    //        return entityManagerFactoryBean;
    //    }

    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new JpaTransactionManager();
    }

}
