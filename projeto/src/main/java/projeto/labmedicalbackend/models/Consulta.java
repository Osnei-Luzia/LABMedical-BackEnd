package projeto.labmedicalbackend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "consultas")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 512, nullable = false)
    @NotBlank
    private String motivo;
    @Column(nullable = false)
    @NotNull
    private Date dataHora;
    @Column(length = 512, nullable = false)
    @NotBlank
    private String descricao;
    @Column(length = 512, nullable = false)
    @NotBlank
    private String medicacao;
    @Column(length = 512, nullable = false)
    @NotBlank
    private String dosagens;
    @NotNull
    @ManyToOne
    private Paciente paciente_id;
    @NotNull
    @ManyToOne
    private Usuario usuario_id;
}
