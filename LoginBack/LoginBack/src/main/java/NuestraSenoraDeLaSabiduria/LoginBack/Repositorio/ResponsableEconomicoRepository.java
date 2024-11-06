package NuestraSenoraDeLaSabiduria.LoginBack.Repositorio;

import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.ResponsableEconomico;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repositorio de la entidad ResponsableEconomico
 *
 * @see ResponsableEconomico
 * @see MongoRepository
 * @version 1.0
 * @Autor Diego Chicuazuque
 */
public interface ResponsableEconomicoRepository
  extends MongoRepository<ResponsableEconomico, String> {
  boolean exiexistsByCorreoElectronico(String correoElectronico);
}
