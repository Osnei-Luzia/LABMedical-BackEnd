package projeto.labmedicalbackend.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import projeto.labmedicalbackend.exceptions.EnumNullPointerException;
import projeto.labmedicalbackend.models.enums.Especializacao;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnumValidator implements ConstraintValidator<EnumConstraint, Enum> {
    private Set<String> valoresValidos;
    private Set<Integer> keysValidas;
    private String campoVerificado;

    @Override
    public void initialize(EnumConstraint targetEnum) {
        valoresValidos = Stream.of(targetEnum.targetClassType().getEnumConstants()).map(Enum::name).collect(Collectors.toSet());
        //keysValidas = Stream.of(targetEnum.targetClassType().getEnumConstants()).map(Enum::ordinal).collect(Collectors.toSet());
        campoVerificado = targetEnum.targetClassType().getName();
        //manipular String
    }

    @Override
    public boolean isValid(Enum field, ConstraintValidatorContext context) {
        try {
            if (valoresValidos.contains(field.name())) {
                return true;
            }
        } catch (NullPointerException e){
            throw new EnumNullPointerException(campoVerificado+" não deve ser nulo");
        }
        return false;
    }
}
