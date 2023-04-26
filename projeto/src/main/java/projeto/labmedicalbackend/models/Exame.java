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
    @Column(nullable = false)
    @NotBlank
    private String nome;
    @Column(nullable = false)
    @NotNull
    private Date dataHora;
    @Column(nullable = false)
    @NotBlank
    private String tipo;
    @Column(nullable = false)
    @NotBlank
    private String laboratorio;
    private String arquivo;
    @Column(length = 512, nullable = false)
    @NotBlank
    private String resultado;
    @ManyToOne
    private Paciente paciente_id;
    @ManyToOne
    private Usuario usuario_id;
}
