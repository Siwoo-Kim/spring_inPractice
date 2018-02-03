package com.springInPractice.chapter4.controller;

import com.springInPractice.chapter4.domain.AccountForm;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log
@Controller
@RequestMapping("/chapter4/users")
public class AccountController {

    @GetMapping("/new")
    public String getRegistrationForm(Model model){
        model.addAttribute("account", AccountForm.builder().build());
        return "users/registrationForm";
    }

    @PostMapping
    public String postRegistrationForm(@ModelAttribute AccountForm accountForm){
        log.warning("Created registration: "+accountForm);
        return "redirect:/chapter4/users/registration_ok";
    }

}
