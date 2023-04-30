package projeto.labmedicalbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import projeto.labmedicalbackend.models.Paciente;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    boolean existsPacienteByCpf(@Param("cpf") String cpf);

    List<Paciente> findAllByNomeCompleto(@Param("nome") String nome);
}
