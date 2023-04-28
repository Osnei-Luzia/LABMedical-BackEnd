package projeto.labmedicalbackend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import projeto.labmedicalbackend.models.enums.Especializacao;
import projeto.labmedicalbackend.validators.EnumConstraint;

@Entity
@Table(name = "usuarios")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario extends Pessoa {
    @Column(length = 32, nullable = false)
    @NotBlank
    private String crm;
    @Column(nullable = false)
    @NotNull
    @Enumerated(EnumType.ORDINAL)
    @EnumConstraint(targetClassType = Especializacao.class, message = "Especialização inválida")
    private Especializacao especializacao;
    /*
     * 0- Clínico Geral
     * 1- Anestesista
     * 2- Dermatologia
     * 3- Ginecologia
     * 4- Neurologia
     * 5- Pediatria
     * 6- Psiquiatria
     * 7- Ortopedia
     */
    @Size(min = 8)
    @Column(nullable = false)
    private String senha;
}
