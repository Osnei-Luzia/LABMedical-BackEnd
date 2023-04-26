package projeto.labmedicalbackend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import projeto.labmedicalbackend.models.enums.Especializacao;

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
    private Especializacao especializacao;
    @Size(min = 8)
    @Column(nullable = false)
    private String senha;
}
