package projeto.labmedicalbackend.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario extends Pessoa {
    @Column(length = 32, nullable = false)
    private String crm;
    @Column(nullable = false)
    //checar como fazer o length de number
    private Number especializacao;
    @Column(nullable = false)
    private String senha;
}
