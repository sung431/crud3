package com.ese.crud3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.ese.crud3", excludeFilters=@ComponentScan.Filter(Configuration.class))
public class ServletConfig extends WebMvcConfigurerAdapter{
	
	@Bean 
	public ViewResolver viewResolver() { 
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp"); 
		return resolver; 
	}  
	
	/*** welcome page ***/
/*	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home.do");
	}*/
	  
	/*** 인터셉터 추가 ***/
/*	@Override 
	public void addInterceptors(InterceptorRegistry registry) { 
		registry.addInterceptor(new CorsInterceptor());
	}*/
	
	

}
