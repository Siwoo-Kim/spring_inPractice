package com.springInPractice.chapter3.controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Log
@Controller
@RequestMapping({"/","/home","/index"})
public class HomeController {

    @GetMapping
    public String home(Locale locale){
        log.warning(locale::toString);
        return "home";
    }
}
