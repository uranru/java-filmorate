package ru.yandex.practicum.filmorate.validator;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.time.LocalDate;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = LoginValidator.class)
@Target({FIELD})
@Retention(RUNTIME)
@Documented
public @interface Login {
    String message() default "login is not correct";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
class LoginValidator implements ConstraintValidator<Login, String> {
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean valid = true;
        if (value != null) {
            if (value.contains(" ")) {
                valid = false;
            }
        }
        return valid;
    }
}