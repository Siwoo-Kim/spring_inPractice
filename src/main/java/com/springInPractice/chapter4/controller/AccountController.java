package com.springInPractice.chapter4.controller;

import com.springInPractice.chapter4.domain.Account;
import com.springInPractice.chapter4.domain.AccountForm;
import com.springInPractice.chapter4.service.AccountService;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.function.Predicate;

@Log
@Controller
@RequestMapping("/chapter4/users")
public class AccountController {

    // Define logical view name by class variable
    private static final String VN_REG_FORM = "users/registrationForm";
    private static final String VN_REG_OK = "redirect:/chapter4/users/registration_ok";
    @Inject AccountService accountService;
    // Allow only specified white list for data binding with domain object
    @InitBinder
    public void initBinder(WebDataBinder binder){
        //Whitelist
        binder.setAllowedFields(new String[]{
                "username","password","confirmPassword",
                "firstName","lastName","email",
                "marketingOk","acceptTerms"
        });
    }

    @GetMapping("/new")
    public String getRegistrationForm(Model model){
        model.addAttribute("account", AccountForm.builder().build());
        return VN_REG_FORM;
    }

    @PostMapping
    public String postRegistrationForm(
            @ModelAttribute("account") @Valid AccountForm form,
            BindingResult result){
        log.warning("Created registration: "+ form);
        convertPasswordError(result);

        accountService.registerAccount(toAccount(form),form.getPassword(),result);

        return (result.hasErrors() ? VN_REG_FORM : VN_REG_OK );
    }

    private static Account toAccount(AccountForm form) {
        return Account.builder()
                .username(form.getUsername())
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .email(form.getEmail())
                .marketingOk(form.isMarketingOk())
                .acceptTerms(form.isAcceptTerms())
                .activate(true)
                .build();
    }

    private void convertPasswordError(BindingResult result) {
        Predicate<String> equalsPasswordMismatch = message -> "account.password.mismatch.message".equals(message);
        Predicate<BindingResult> passwordErrors = bindingResult -> bindingResult.hasFieldErrors("password");

        if(!passwordErrors.test(result) && result.getGlobalErrors().stream().map(error -> error.getDefaultMessage()).anyMatch(equalsPasswordMismatch)){
            result.rejectValue("password","error.mismatch");
        }

    }

}
