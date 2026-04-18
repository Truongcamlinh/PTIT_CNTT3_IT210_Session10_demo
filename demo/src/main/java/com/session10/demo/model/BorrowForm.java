package com.session10.demo.model;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class BorrowForm {
    @NotBlank(message = "Không được để trống")
    private String fullName;

    @Pattern(regexp = "^[A-Z]{2}\\d+$", message = "Mã SV không hợp lệ")
    private String studentCode;

    @Email(message = "Email không hợp lệ")
    private String email;

    @Min(value = 1, message = "Phải >=1")
    private int quantity;

    @Future(message = "Ngày phải trong tương lai")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @NotBlank(message = "Không được để trống")
    private String reason;

    public String getFullName() {
        return fullName;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public String getEmail() {
        return email;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}