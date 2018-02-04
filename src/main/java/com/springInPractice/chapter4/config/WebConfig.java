package com.springInPractice.chapter4.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration @ComponentScan(
        value = {"com.springInPractice.chapter4.controller"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.REGEX,pattern = ".*Config$")})
public class WebConfig extends WebMvcConfigurationSupport{


    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/chapter4/users/registration_ok").setViewName("users/registration_ok");
    }

    @Bean
    MessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:/messages");
        return messageSource;
    }

}
