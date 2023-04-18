package projeto.labmedicalbackend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

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
    @Min(value = 1)
    @Max(value = 8)
    @NotNull
    private Integer especializacao;
    /*
     * 1- Clínico Geral
     * 2- Anestesista
     * 3- Dermatologia
     * 4- Ginecologia
     * 5- Neurologia
     * 6- Pediatria
     * 7- Psiquiatria
     * 8- Ortopedia
     * */
    @Size(min = 8)
    @NotBlank
    private String senha;
}
