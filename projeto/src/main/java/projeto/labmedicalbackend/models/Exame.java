package projeto.labmedicalbackend.models;

import jakarta.persistence.*;
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
    private String nome;

    @Column(nullable = false)
    private Date dataHora;
    //fazer pelo timestamp da inserção
    //validar data

    @Column(nullable = false)
    private String tipo;
    private String arquivo;
    //fazer tipo para midia

    @Column(length = 512, nullable = false)
    private String resultado;
}
