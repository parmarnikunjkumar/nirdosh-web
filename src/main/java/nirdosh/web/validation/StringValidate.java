package nirdosh.web.validation;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy=StringValidator.class)
public @interface StringValidate {
	String message() default "constraint.MyConstraint.message";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
