package projeto.labmedicalbackend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projeto.labmedicalbackend.models.enums.EstadoCivil;
import projeto.labmedicalbackend.validators.EnumConstraint;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoas")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 256, nullable = false)
    @NotBlank
    private String nomeCompleto;
    @Column(length = 64, nullable = false)
    @NotBlank
    private String genero;
    @Column(nullable = false)
    @NotBlank
    private String dataNascimento;
    @Column(length = 14, nullable = false)
    @CPF
    @NotBlank
    private String cpf;
    @Column(length = 64, nullable = false)
    @NotBlank
    private String rg;
    @Column(nullable = false)
    @NotNull
    @Enumerated(EnumType.ORDINAL)
    @EnumConstraint(targetClassType = EstadoCivil.class, message = "estado civil inválido")
    private EstadoCivil estadoCivil;
    /*
     * 0- Solteiro
     * 1- Casado
     * 2- Separado
     * 3- Divorciado
     * 4- Viúvo
     */
    @Column(length = 32, nullable = false)
    @NotBlank
    private String telefone;
    @Column(length = 128, nullable = false)
    @Email
    @NotBlank
    private String email;
    @Column(length = 64, nullable = false)
    @NotBlank
    private String naturalidade;
}
