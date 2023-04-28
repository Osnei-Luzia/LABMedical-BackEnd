package projeto.labmedicalbackend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "pacientes")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente extends Pessoa {
    @ElementCollection
    private List<String> listaAlergias;
    @ElementCollection
    private List<String> listaCuidados;
    @Column(length = 64, nullable = false)
    @NotBlank
    private String contatoEmergencia;
    private String convenio;
    private String numeroCarteira;
    private String validade;
    @ManyToOne
    private Endereco endereco;
}
