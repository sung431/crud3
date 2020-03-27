package com.ese.crud3.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class RootConfig {

	@Bean(destroyMethod="close")
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/first");
		dataSource.setUsername("postgres");
		dataSource.setPassword("root");
		dataSource.setDefaultAutoCommit(false);
		
		return dataSource;
	}

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource());
        
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath:/mapper/**/*_SQL.xml");
        sqlSessionFactory.setMapperLocations(resources);
        
        return sqlSessionFactory;
    }
    
    @Bean(destroyMethod = "clearCache")
    public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
