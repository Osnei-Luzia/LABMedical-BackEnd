package projeto.labmedicalbackend.models;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pacientes")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente extends Pessoa{
    @ElementCollection
    private List<String> listaAlergias;
    @ElementCollection
    private List<String> listaCuidados;
    @Column(length = 64,nullable = false)
    @NotBlank
    private String contatoEmergencia;
    private String convenio;
    private String numeroCarteira;

    private Date validade;
    @ManyToOne
    private Endereco endereco;
    @NotNull
    private Integer exames;
    @NotNull
    private Integer consultas;
}
