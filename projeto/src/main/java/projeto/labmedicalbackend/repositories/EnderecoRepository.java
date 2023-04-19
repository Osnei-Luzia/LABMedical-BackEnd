package projeto.labmedicalbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto.labmedicalbackend.models.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
