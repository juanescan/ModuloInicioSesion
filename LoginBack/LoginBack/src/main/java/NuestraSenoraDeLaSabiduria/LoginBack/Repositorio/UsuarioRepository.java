package NuestraSenoraDeLaSabiduria.LoginBack.Repositorio;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;
import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    boolean existsByNombreUsuario(String nombreUsuario);
}
