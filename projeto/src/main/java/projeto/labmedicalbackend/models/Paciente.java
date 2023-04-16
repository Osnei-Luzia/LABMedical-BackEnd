package projeto.labmedicalbackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String contatoEmergencia;
    private String convenio;
    private String numeroCarteira;
    private Date validade;
    //@ManyToOne
    private String endereco;
}
