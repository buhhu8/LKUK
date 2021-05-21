package org.lk.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationVersion;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "org.lk.repository.jpa")
public class DataSourceConfiguration {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driver-class-name}")
    private String driverClass;
    @Value("${migration.version:}")
    private String migrationVersion;

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

//    @Bean
//    @DependsOn("flyway")
//    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
//        LocalSessionFactoryBean sessionFactory =
//                new LocalSessionFactoryBean();
//
//        sessionFactory.setDataSource(dataSource); // sessionFactory.setDataSource(dataSource())
//        sessionFactory.setPackagesToScan("org.lk.model.domain");
//        // sessionFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//
//        return sessionFactory;
//    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            DataSource dataSource
    ) {
        return builder
                .dataSource(dataSource)
                .packages("org.lk.model.domain")
                .build();
    }

    @Bean(initMethod = "migrate") // flyway.migrate();
    public Flyway flyway(DataSource dataSource) {
        return Flyway.configure() // Flyway flyway = Flyway.configure()...
                .dataSource(dataSource)
                .baselineOnMigrate(true)
                .target(getMigrationVersion())
                .load();
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
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

    private MigrationVersion getMigrationVersion() {
        return migrationVersion == null || migrationVersion.trim().isEmpty() ?
                MigrationVersion.LATEST :
                MigrationVersion.fromVersion(migrationVersion);
    }

}
