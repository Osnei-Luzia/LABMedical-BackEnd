package projeto.labmedicalbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto.labmedicalbackend.models.Exame;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Long> {
}
