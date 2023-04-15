package projeto.labmedicalbackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "teste")
public class Teste {
    @Id
    Long id;
}
