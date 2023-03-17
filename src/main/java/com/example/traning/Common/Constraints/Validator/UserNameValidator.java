package com.example.traning.Common.Constraints.Validator;

import com.example.traning.Common.Constraints.AnnotationValidate.UserName;
import com.example.traning.Common.Constraints.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserNameValidator implements ConstraintValidator<UserName, String> {
    @Override
    public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
        return !Validation.isCharVN(code);
    }
}
