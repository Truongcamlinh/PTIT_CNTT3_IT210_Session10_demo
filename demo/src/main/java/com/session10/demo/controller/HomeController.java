package com.session10.demo.controller;

import com.session10.demo.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private DeviceService service;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("devices", service.getAll());
        return "home";
    }
}