package NuestraSenoraDeLaSabiduria.LoginBack.Modelo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

/**
 * Clase que representa un usuario
 * @version 1.0
 * @Autor Diego Chicuazuque
 **/
@Setter
@Getter
public class Usuario {

  @Id
  private String id;

  private String nombreUsuario;
  private String contrasena;
  private String nombreCompleto;

  public Usuario(
    String nombreUsuario,
    String contrasena,
    String nombreCompleto
  ) {
    this.nombreUsuario = nombreUsuario;
    this.contrasena = contrasena;
    this.nombreCompleto = nombreCompleto;
  }

  public String obtenerDetallesUsuario() {
    return "Usuario: " + nombreCompleto;
  }
}
