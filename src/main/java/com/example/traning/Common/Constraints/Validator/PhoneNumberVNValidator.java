package com.example.traning.Common.Constraints.Validator;

import com.example.traning.Common.Constraints.AnnotationValidate.PhoneNumberVN;
import com.example.traning.Common.Constraints.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberVNValidator implements ConstraintValidator<PhoneNumberVN, String> {
    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext constraintValidatorContext) {
        return Validation.isPhoneVN(phoneNumber);
    }
}
