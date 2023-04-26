package projeto.labmedicalbackend.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DataNascimentoValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataNascimentoConstraint {
    String message() default "data de nascimento inválida";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

