package NuestraSenoraDeLaSabiduria.LoginBack.Modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {

  private String id;
  private String nombreUsuario;
  private String contrasena;
  private String nombreCompleto;

  // Constructor
  public UsuarioDTO(
    String nombreUsuario,
    String contrasena,
    String nombreCompleto
  ) {
    this.nombreUsuario = nombreUsuario;
    this.contrasena = contrasena;
    this.nombreCompleto = nombreCompleto;
  }
}
