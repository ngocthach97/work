package com.example.traning.Common.Validation.Validator;

import com.example.traning.Common.Validation.AnnotationValidate.PhoneNumberVN;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberVNValidator implements ConstraintValidator<PhoneNumberVN, String> {
    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext constraintValidatorContext) {
        Pattern pattern = Pattern.compile("^(03|05|07|08|09[0-9])+([0-9]{7})$");
        Matcher matcher = pattern.matcher(phoneNumber);
        if (matcher.find()) {
            return true;
        }
        return false;
    }
}
