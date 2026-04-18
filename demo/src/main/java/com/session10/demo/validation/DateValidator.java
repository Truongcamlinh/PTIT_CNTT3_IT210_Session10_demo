package com.session10.demo.validation;

import com.session10.demo.model.BorrowForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class DateValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return BorrowForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        BorrowForm form = (BorrowForm) target;
        if (form.getEndDate() != null && form.getStartDate() != null) {
            if (form.getEndDate().isBefore(form.getStartDate())) {
                errors.rejectValue("endDate", "", "Ngày trả phải sau ngày nhận");
            }
        }
    }
}