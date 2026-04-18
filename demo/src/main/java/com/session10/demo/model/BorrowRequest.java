package com.session10.demo.model;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class BorrowRequest {
    @NotBlank(message = "Không được để trống")
    private String name;

    @Pattern(regexp = "^[A-Za-z]{2}\\d+$", message = "Mã sinh viên phải có định dạng: 2 chữ cái theo sau là 4 chữ số")
    private String studentId;

    @Email(message = "Email không hợp lệ")
    private String email;

    @Min(value =1, message = "Số lượng phải lớn hơn 0")
    private int quantity;

    @Future(message = "Ngày mượn phải là ngày trong tương lai")
    private LocalDate startDate;

    @Future(message = "Ngày trả phải là ngày trong tương lai")
    private LocalDate endDate;

    @NotBlank(message = "Không được để trống")
    private String reason;

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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

    public void setReason(String reason) {
        this.reason = reason;
    }
}
