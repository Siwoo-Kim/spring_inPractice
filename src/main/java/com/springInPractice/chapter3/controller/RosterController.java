package com.springInPractice.chapter3.controller;

import com.springInPractice.chapter3.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/roster")
public class RosterController {

    private List<Member> memberList = new ArrayList<>();

    public RosterController(){
        memberList.add(Member.builder().firstName("John").lastName("Lennon").build());
        memberList.add(Member.builder().firstName("Paul").lastName("McCartney").build());
        memberList.add(Member.builder().firstName("George").lastName("Harrison").build());
        memberList.add(Member.builder().firstName("Ringo").lastName("Starr").build());
    }

    @GetMapping("/list")
    public void list(Model model){
        model.addAttribute(memberList);
    }

    @GetMapping("/member")
    public void member(@RequestParam("id") Integer id,Model model){
        model.addAttribute(memberList.get(id));
    }

}
