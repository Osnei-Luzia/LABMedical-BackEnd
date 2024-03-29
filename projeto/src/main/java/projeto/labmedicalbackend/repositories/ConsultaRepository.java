package projeto.labmedicalbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto.labmedicalbackend.models.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
