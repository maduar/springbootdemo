package com.maduar.springbootdemo.form.validator;

import com.maduar.springbootdemo.form.KmailPostForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/*
 *
 * @author maduar
 * @date 22/07/2018 11:14 AM
 * @email maduar@163.com
 *
 * */
@Component
public class KmailPostFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return KmailPostForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "kid", "kid.empty");
        KmailPostForm kmailPostForm = (KmailPostForm) target;
        if (kmailPostForm.getKid() == null) {
            errors.rejectValue("kid", "kid is null");
        } else if (kmailPostForm.getKid().intValue() < 0) {
            errors.rejectValue("kid", "kid < 0");
        }
    }
}
