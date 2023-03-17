package com.example.traning.Common.Constraints.Validator;

import com.example.traning.Common.Constraints.AnnotationValidate.BirthDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Calendar;
import java.util.Date;

public class BirthDateValidator implements ConstraintValidator<BirthDate, Date> {
    @Override
    public boolean isValid(Date date, ConstraintValidatorContext constraintValidatorContext) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return Calendar.getInstance().get(Calendar.YEAR) - calendar.get(Calendar.YEAR) >= 18;
    }
}
