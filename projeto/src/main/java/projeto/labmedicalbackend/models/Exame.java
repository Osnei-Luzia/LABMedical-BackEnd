package projeto.labmedicalbackend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "exames")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;

    @NotNull
    private Date dataHora;
    //fazer pelo timestamp da inserção
    //validar data

    @NotBlank
    private String tipo;
    @NotBlank
    private String laboratorio;
    private String arquivo;
    //conferir arquivo
    @Column(length = 512)
    @NotBlank
    private String resultado;
    @ManyToOne
    private Paciente paciente_id;
    @ManyToOne//checar cardinalidade
    private Usuario usuario_id;
}
