package projeto.labmedicalbackend.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.text.SimpleDateFormat;
import java.util.Objects;

public class DataNascimentoValidator implements ConstraintValidator<DataNascimentoConstraint, String> {
    @Override
    public void initialize(DataNascimentoConstraint dataNascimento) {
    }

    @Override
    public boolean isValid(String field, ConstraintValidatorContext context) {
        if(Objects.isNull(field)){
            return true;
        }
        try {
            SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
            date.setLenient(false);
            date.parse(field);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}