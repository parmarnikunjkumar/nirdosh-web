package nirdosh.web.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD,ElementType.METHOD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=TelephoneValidator.class)
public @interface TelephoneValidation {
	String message() default " ";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default { };
}
