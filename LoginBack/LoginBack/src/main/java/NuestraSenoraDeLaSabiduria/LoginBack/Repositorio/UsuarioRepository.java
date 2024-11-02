package NuestraSenoraDeLaSabiduria.LoginBack.Repositorio;

import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.Usuario;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repositorio de la entidad Usuario
 */
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
  Optional<Usuario> findByNombreUsuario(String nombreUsuario);
  boolean existsByNombreUsuario(String nombreUsuario);
}
