package com.gabrielmagalhaes.rentx.validation.constraint;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class FieldMatchConstraintValidatorUnitTest {

    private static Validator validator;

    @BeforeAll
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    PasswordStub makeValidPassword() {
        return new PasswordStub("any_password", "any_password");
    }

    PasswordStub makeInvalidPassword() {
        return new PasswordStub("any_password", "wrong_password");
    }

    @Test
    @DisplayName("should validate constraint for matching fields")
    void shouldValidateEqualFields() {
        Set<ConstraintViolation<PasswordStub>> constraintViolations = validator.validate(makeValidPassword());

        assertEquals(constraintViolations.size(), 0);
    }

    @Test
    @DisplayName("should violate constraint when no matching fields")
    void shouldViolateConstraintWhenNoEqualFields() {
        Set<ConstraintViolation<PasswordStub>> constraintViolations = validator.validate(makeInvalidPassword());

        assertEquals(constraintViolations.size(), 1);
    }

    @FieldMatch(first = "password", second = "passwordConfirmation", message = "password fields must match")
    private class PasswordStub {
        private final String password;
        private final String passwordConfirmation;

        PasswordStub(String password, String passwordConfirmation) {
            this.password = password;
            this.passwordConfirmation = passwordConfirmation;
        }

        public String getPassword() {
            return password;
        }

        public String getPasswordConfirmation() {
            return passwordConfirmation;
        }
    }
}
