package nirdosh.web.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=CustomerValidator.class)
@Documented
public @interface CustomerValidation {
	String message() default "{constraint.MyConstraint.message}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default { };
}
