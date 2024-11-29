package NuestraSenoraDeLaSabiduria.LoginBack.Modelo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "usuarios")
@TypeAlias("Bibliotecario")
public class Bibliotecario extends Usuario {

  public Bibliotecario(
    String nombreUsuario,
    String contrasena,
    String nombreCompleto
  ) {
    super(nombreUsuario, contrasena, nombreCompleto);
  }

  // Si en el futuro se necesitan más atributos específicos, se pueden agregar aquí

  @Override
  public String obtenerDetallesUsuario() {
    return super.obtenerDetallesUsuario() + " - Bibliotecario";
  }
}
