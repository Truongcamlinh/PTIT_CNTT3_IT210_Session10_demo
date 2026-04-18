package com.session10.demo.controller;

import com.session10.demo.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private BorrowService borrowService;

    @GetMapping
    public String view(Model model){
        model.addAttribute("requests", borrowService.getAll());
        return "admin";
    }
}
