package NuestraSenoraDeLaSabiduria.LoginBack.Modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BibliotecarioDTO extends UsuarioDTO {

  // Puedes agregar propiedades específicas de un Bibliotecario si lo deseas.

  // Constructor
  public BibliotecarioDTO(
    String nombreUsuario,
    String contrasena,
    String nombreCompleto
  ) {
    super(nombreUsuario, contrasena, nombreCompleto);
  }
}
