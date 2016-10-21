package com.jht.mq.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by ${huipei.x} on 2016/8/12.
 */

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.jht" })
@PropertySource(value = {"classpath:datasource.properties"})
@EnableConfigurationProperties(MybatisProperties.class)
public class MybatisConfiguration  {


   @Autowired
    private Environment environment;
    @Autowired
    MybatisProperties mybatisProperties;

   @Bean
    public DataSource dataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(mybatisProperties.getUrl());
        dataSource.setUsername(mybatisProperties.getUsername());
        dataSource.setPassword(mybatisProperties.getPassword());
       System.out.println("111"+mybatisProperties.getPassword());
    dataSource.setInitialSize(Integer.valueOf(environment.getRequiredProperty("druid.initialSize")));
        dataSource.setMinIdle(Integer.valueOf(environment.getRequiredProperty("druid.minIdle")));
        dataSource.setMaxActive(Integer.valueOf(environment.getRequiredProperty("druid.maxActive")));
        dataSource.setMaxWait(Long.valueOf(environment.getRequiredProperty("druid.maxWait")));
        dataSource.setTimeBetweenEvictionRunsMillis(Integer.valueOf(environment.getRequiredProperty("druid.timeBetweenEvictionRunsMillis")));
        dataSource.setMinEvictableIdleTimeMillis(Integer.valueOf(environment.getRequiredProperty("druid.minEvictableIdleTimeMillis")));
        dataSource.setValidationQuery(environment.getRequiredProperty("druid.validationQuery"));
        dataSource.setTestWhileIdle(Boolean.valueOf(environment.getRequiredProperty("druid.testWhileIdle")));
        dataSource.setTestOnBorrow(Boolean.valueOf(environment.getRequiredProperty("druid.testOnBorrow")));
        dataSource.setTestOnReturn(Boolean.valueOf(environment.getRequiredProperty("druid.testOnReturn")));
        dataSource.setPoolPreparedStatements(Boolean.valueOf(environment.getRequiredProperty("druid.poolPreparedStatements")));
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(Integer.valueOf(environment.getRequiredProperty("druid.maxPoolPreparedStatementPerConnectionSize")));
        dataSource.setFilters(environment.getRequiredProperty("druid.filters"));
        return dataSource;
    }

   @Bean(name="sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws SQLException {
        SqlSessionFactoryBean bean =new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage(String.valueOf(new String[]{"com.jht.mq.model,com.jht.openapi.dto"}));
        return bean;
    }

  @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }



    @Bean
    @Autowired
    public PlatformTransactionManager transactionManager(DataSource dataSource) throws SQLException {
        DataSourceTransactionManager dataSourceTransactionManager=new  DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

}
