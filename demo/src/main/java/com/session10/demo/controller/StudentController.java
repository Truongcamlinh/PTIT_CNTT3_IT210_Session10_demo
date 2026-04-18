package com.session10.demo.controller;

import com.session10.demo.model.BorrowRequest;
import com.session10.demo.service.BorrowService;
import com.session10.demo.service.DeviceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StudentController {
    @Autowired
    private DeviceService deviceService;

    @Autowired
    private BorrowService borrowService;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("devices", deviceService.getAllDevices());
        return "home";
    };

    @GetMapping("/borrow/{id}")
    public String form(@PathVariable("id") int id, Model model){
        model.addAttribute("borrow", new BorrowRequest());
        model.addAttribute("deviceId", id);
        return "borrow-form";
    }

    @PostMapping("/borrow")
    public String submit(@Valid @ModelAttribute("borrow") BorrowRequest request, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "borrow-form";
        }

        if(request.getEndDate().isBefore(request.getStartDate())){
            result.rejectValue("endDate", "", "Ngày kết thúc phải sau ngày bắt đầu");
            return "borrow-form";
        }

        borrowService.save(request);
        redirectAttributes.addFlashAttribute("message", "Thành công! Yêu cầu mượn đã được gửi.");
        return "redirect:/";
    }
}
