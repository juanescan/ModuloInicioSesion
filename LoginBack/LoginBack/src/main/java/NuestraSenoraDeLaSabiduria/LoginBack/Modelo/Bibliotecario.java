package NuestraSenoraDeLaSabiduria.LoginBack.Modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bibliotecario extends Usuario {

  private String codigo;

  public Bibliotecario(
    String nombreUsuario,
    String contrasena,
    String rol,
    String codigo
  ) {
    super(nombreUsuario, contrasena, rol);
    this.codigo = codigo;
  }
}
