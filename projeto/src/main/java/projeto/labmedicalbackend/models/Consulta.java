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
    @Column(length = 512)
    @NotBlank
    private String motivo;

    @NotNull
    private Date dataHora;
    //fazer pelo timestamp da inserção
    //validar data

    @Column(length = 512)
    @NotNull
    private String descricao;
    @Column(length = 512)
    @NotNull
    private String medicacao;
    @Column(length = 512)
    @NotNull
    private String dosagens;
    @NotNull
    @OneToOne()//resolver deleçao de OneToOne
    private Paciente paciente_id;
    @NotNull
    @ManyToOne
    private Usuario usuario_id;
}
