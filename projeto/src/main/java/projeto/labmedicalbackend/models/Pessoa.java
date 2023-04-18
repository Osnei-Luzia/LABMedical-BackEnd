package projeto.labmedicalbackend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
//fazer constrains

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
    @Column(length = 256)
    @NotBlank
    private String nomeCompleto;
    @Column(length = 64)
    @NotBlank
    private String genero;
    @Column(nullable = false)
    @NotNull
    private Date dataNascimento;
    //validar data
    @Column(length = 14)
    @CPF
    @NotBlank
    private String cpf;
    @Column(length = 64)
    @NotBlank
    private String rg;
    @Column(nullable = false)
    @Min(value = 1)
    @Max(value = 5)
    @NotNull
    private Integer estadoCivil;
    /*
     * 1- Solteiro
     * 2- Casado
     * 3- Separado
     * 4- Divorciado
     * 5- Viúvo
     * */
    @Column(length = 32)
    @NotBlank
    private String telefone;
    @Column(length = 128)
    @Email
    @NotBlank
    private String email;
    @Column(length = 64)
    @NotBlank
    private String naturalidade;
}
