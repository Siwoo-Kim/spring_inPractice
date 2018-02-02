package com.springInPractice.chapter3.controller;

import com.springInPractice.chapter3.domain.Member;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Log
@Controller
@RequestMapping("/nominee")
public class NomineeController {

    private String thanksViewName;

    public void setThanksViewName(String thanksViewName){
        this.thanksViewName = thanksViewName;
    }

    @GetMapping("/form")
    public void form(Model model) {
        model.addAttribute("nominee",Member.builder().build());
    }

    @PostMapping("/form")
    public String processFormData(
            @ModelAttribute("nominee") Member member,Model model){
        log.warning("Processing nomine: "+member);
        Map map = model.asMap();
        log.warning("model[member]= "+ map.get("member"));
        log.warning("model[nominee]= "+ map.get("nominee"));
        return thanksViewName;
    }

}
