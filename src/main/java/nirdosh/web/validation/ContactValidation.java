package nirdosh.web.validation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@Target({TYPE,ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy=ContactValidator.class)
public @interface ContactValidation {
	String message() default " ";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default { };
}
