package com.devfun.settingweb_boot.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
// basePackages로 com.devfun.settingweb_boot.dao 안에 있는 mapper를 스캔한다고 명시
@MapperScan(basePackages = "com.devfun.settingweb_boot.dao")
public class MybatisConfig {
    //mybatis를 사용하기 위한 설정 - java를 이용한 bean 등록
    @Bean
    public SqlSessionFactory sqlSessionFactory (DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();

        sqlSessionFactory.setDataSource(dataSource);
        // typeAliase로 dto를 사용한다고 정의
        sqlSessionFactory.setTypeAliasesPackage("com.devfun.settingweb_boot.dto");

        return sqlSessionFactory.getObject();
    }
    @Bean
    public SqlSessionTemplate sqlSession (SqlSessionFactory sqlSessionFactory) {

        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
