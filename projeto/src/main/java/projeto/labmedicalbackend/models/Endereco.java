package projeto.labmedicalbackend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "enderecos")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @NotBlank
    private String cep;
    @Column(nullable = false)
    @NotBlank
    private String cidade;
    @Column(nullable = false)
    @NotBlank
    private String estado;
    @Column(nullable = false)
    @NotBlank
    private String logradouro;
    @Column(nullable = false)
    @NotNull
    private Integer numero;
    private String complemento;
    @Column(nullable = false)
    @NotBlank
    private String bairro;
    private String pontoReferencia;
}
