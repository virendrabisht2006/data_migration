package com.itc.bank.migration.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
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
@EnableJpaRepositories(basePackages = {"com.itc.bank.migration.repository.command"},
        entityManagerFactoryRef = "mySqlEntityManager",
        transactionManagerRef = "mySqlTransactionManager")
public class MySqlConfiguration {

    @Bean(name = "mySqlDataSource")
    @ConfigurationProperties(prefix = "data.mySqlDataSource")
    public DataSource mySqlDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "mySqlEntityManager")
    public LocalContainerEntityManagerFactoryBean oraclesqlEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(mySqlDataSource())
                .packages("com.itc.bank.migration.entity.destination")
                .build();
    }


    @Bean(name = "mySqlTransactionManager")
    public PlatformTransactionManager oraclesqlTransactionManager(@Qualifier("mySqlEntityManager") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
