package projeto.labmedicalbackend.models;

import jakarta.persistence.*;
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
    @Column(length=256)
    private String nomeCompleto;
    @Column(length=64)
    private String genero;
    @Column(nullable = false)
    private Date dataNascimento;
    //verificar data
    @Column(length=14)
    //@CPF
    private String cpf;
    //123.456.789-10
    @Column(length=64)
    private String rg;
    @Column(nullable = false)
    //checar como fazer o length de number
    private Number estadoCivil;
    /*
    * Solteiro
    * Casado
    * Separado
    * Divorciado
    * Viúvo
    * */
    //verificar tipo String ou number
    @Column(length=32)
    private String telefone;
    @Column(length=64)
    private String email;
    @Column(length=64)
    private String naturalidade;
}
