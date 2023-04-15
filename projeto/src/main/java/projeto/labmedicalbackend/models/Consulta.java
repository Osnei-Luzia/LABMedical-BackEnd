package projeto.labmedicalbackend.models;

import jakarta.persistence.*;
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
    private String motivo;

    @Column(nullable = false)
    private Date dataHora;
    //fazer pelo timestamp da inserção

    @Column(length = 512, nullable = false)
    private String descricao;
    @Column(length = 512, nullable = false)
    private String medicacao;
    @Column(length = 512, nullable = false)
    private String dosagens;
}
