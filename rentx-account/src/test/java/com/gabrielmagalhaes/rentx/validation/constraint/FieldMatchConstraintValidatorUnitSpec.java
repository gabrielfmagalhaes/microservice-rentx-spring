package com.gabrielmagalhaes.rentx.validation.constraint;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class FieldMatchConstraintValidatorUnitSpec {

    private static Validator validator;

    @BeforeAll
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    PasswordStub makeValidPassword() {
        return new PasswordStub("valid_password", "valid_password");
    }

    @Test
    @DisplayName("should validate constraint for matching fields")
    void shouldValidateEqualFields() {
        Set<ConstraintViolation<PasswordStub>> constraintViolations = validator.validate(makeValidPassword());

        assertEquals(constraintViolations.size(), 0);
    }

    private class PasswordStub {
        private final String password;
        private final String passwordConfirmation;

        PasswordStub(String password, String passwordConfirmation) {
            this.password = password;
            this.passwordConfirmation = passwordConfirmation;
        }
    }
}
