package com.gabrielmagalhaes.rentx.validation.constraint.impl;

import com.gabrielmagalhaes.rentx.validation.constraint.FieldMatch;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

    private String firstFieldName;
    private String secondFieldName;
    private String message;

    @Override
    public void initialize(final FieldMatch constraintAnnotation) {
        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        final Object firstObj = PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(firstFieldName);
        final Object secondObj = PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(secondFieldName);

        boolean valid =  firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);

        if (!valid){
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(firstFieldName)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }

        return valid;
    }
}