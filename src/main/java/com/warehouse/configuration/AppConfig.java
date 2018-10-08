package com.warehouse.configuration;




import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.mysql.jdbc.log.Log;
import com.mysql.jdbc.log.LogFactory;


 

 
 
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "com.warehouse")
public class AppConfig extends WebMvcConfigurerAdapter{
	
	
	  Logger logger = Logger.getLogger(AppConfig.class.getName());
	 /**
     * Configure ViewResolvers to deliver preferred views.
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
 
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        registry.viewResolver(viewResolver);
    }
	
    
    /**
     * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
    }
    
    
    
    
        @Override
        public void configurePathMatch(PathMatchConfigurer matcher) {
            matcher.setUseRegisteredSuffixPatternMatch(true);
        }
    
        
      
        /*@Bean
        public CommonsMultipartResolver multipartResolver() {
            CommonsMultipartResolver resolver=new CommonsMultipartResolver();
            resolver.setDefaultEncoding("utf-8");
            return resolver;
        }*/
         
        
        
        
        @Bean
        public CorsFilter corsFilter() {
            final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource= new UrlBasedCorsConfigurationSource();
            final CorsConfiguration corsConfig = new CorsConfiguration();
            corsConfig.setAllowCredentials(true);
            corsConfig.addAllowedOrigin("*");
            corsConfig.addAllowedHeader("*");
            corsConfig.addAllowedMethod("OPTIONS");
            corsConfig.addAllowedMethod("HEAD");
            corsConfig.addAllowedMethod("GET");
            corsConfig.addAllowedMethod("PUT");
            corsConfig.addAllowedMethod("POST");
            corsConfig.addAllowedMethod("DELETE");
            corsConfig.addAllowedMethod("PATCH");
            urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfig);
            return new CorsFilter(urlBasedCorsConfigurationSource);
        }
        
        

        /*s*/
        
        
        
        
}