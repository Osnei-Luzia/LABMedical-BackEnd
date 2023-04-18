package projeto.labmedicalbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import projeto.labmedicalbackend.models.Usuario;

import java.util.Optional;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    @Query("SELECT u FROM Usuario u WHERE u.cpf = :cpf")
    Optional<Usuario> findUsuarioByCpf (@Param("cpf")String cpf);
    boolean existsUsuarioByCpf(@Param("cpf")String cpf);
}
