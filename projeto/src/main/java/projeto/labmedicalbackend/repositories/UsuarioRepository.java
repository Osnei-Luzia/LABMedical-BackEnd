package projeto.labmedicalbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto.labmedicalbackend.models.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
