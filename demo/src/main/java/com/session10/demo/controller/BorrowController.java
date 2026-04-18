package com.session10.demo.controller;

import com.session10.demo.model.BorrowForm;
import com.session10.demo.validation.DateValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BorrowController {
    @Autowired
    private DateValidator dateValidator;

    @GetMapping("/borrow")
    public String showForm(BorrowForm form) {
        return "borrow-form";
    }

    @PostMapping("/borrow")
    public String submit(@Valid @ModelAttribute("borrowForm") BorrowForm form, BindingResult result, RedirectAttributes redirect) {
        dateValidator.validate(form, result);
        if (result.hasErrors()) {
            return "borrow-form";
        }

        redirect.addFlashAttribute("success", "Đăng ký thành công!");
        return "redirect:/";
    }
}