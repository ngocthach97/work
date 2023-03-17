package com.example.traning.Common.Constraints.AnnotationValidate;

import com.example.traning.Common.Constraints.Validator.BirthDateValidator;

import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Constraint(validatedBy = BirthDateValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Documented
public @interface BirthDate {
}
