package com.springInPractice.chapter3.config;

import com.springInPractice.chapter3.controller.NomineeController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration @ComponentScan("com.springInPractice.chapter3.controller")
public class WebConfig extends WebMvcConfigurationSupport {


    @Bean
    NomineeController nomineeController(){
        NomineeController nomineeController = new NomineeController();
        nomineeController.setThanksViewName("nominee/thanks");
        return nomineeController;
    }

}
