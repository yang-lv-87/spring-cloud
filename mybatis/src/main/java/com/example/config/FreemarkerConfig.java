package com.example.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
public class FreemarkerConfig {
	
	@Autowired
    protected freemarker.template.Configuration configuration;
	
    @Autowired  
    protected FreeMarkerViewResolver resolver;
    
    @Autowired  
    protected InternalResourceViewResolver springResolver;
    
    @PostConstruct
    public void  setSharedVariable(){  
        resolver.setSuffix(".ftl");   
        resolver.setCache(false); 
        resolver.setRequestContextAttribute("request"); //为模板调用时，调用request对象的变量名</span>  
        resolver.setOrder(0);  
        resolver.setExposeRequestAttributes(true);
        resolver.setExposeSessionAttributes(true);
    }  

}
