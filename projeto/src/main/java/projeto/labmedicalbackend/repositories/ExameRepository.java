package projeto.labmedicalbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import projeto.labmedicalbackend.models.Exame;
import projeto.labmedicalbackend.models.Usuario;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Long> {
    @Query("SELECT e.id FROM Exame e WHERE e.paciente_id.id = :id")
    List<Long> findAllByPaciente_id(@Param("id") Long id);
}
