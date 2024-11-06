package NuestraSenoraDeLaSabiduria.LoginBack.Modelo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "usuarios")
public class Bibliotecario extends Usuario {

  // Constructor
  public Bibliotecario(
    String id,
    String nombreUsuario,
    String contrasena,
    String nombreCompleto
  ) {
    super(id, nombreUsuario, contrasena, nombreCompleto); // El rol siempre es "bibliotecario"
  }

  // Si en el futuro se necesitan más atributos específicos, se pueden agregar aquí

  @Override
  public String obtenerDetallesUsuario() {
    return super.obtenerDetallesUsuario() + " - Bibliotecario";
  }
}
