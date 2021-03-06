package com.demo.configuration;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.demo.mapper")
public class MyBatisConfiguration {

    @Autowired
    private DataSource dataSource;
    /*@Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() {
        SqlSessionFactoryBean sqlsession = new SqlSessionFactoryBean();
        sqlsession.setDataSource(dataSource);
//        sqlsession.setTypeAliasesPackage("com.demo.mapper");//扫描entity包 使用别名
        org.apache.ibatis.session.Configuration configuration=new org.apache.ibatis.session.Configuration();
        configuration.setUseGeneratedKeys(true);//使用jdbc的getGeneratedKeys获取数据库自增主键值
        configuration.setUseColumnLabel(true);//使用列别名替换列名 select user as User
        configuration.setMapUnderscoreToCamelCase(true);//-自动使用驼峰命名属性映射字段   userId    user_id
        sqlsession.setConfiguration(configuration);
        sqlsession.setFailFast(true);
        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
//            sqlsession.setMapperLocations(resolver.getResources("classpath:mybatis-mapper/*.xml"));
            return sqlsession.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }*/


    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }
}
