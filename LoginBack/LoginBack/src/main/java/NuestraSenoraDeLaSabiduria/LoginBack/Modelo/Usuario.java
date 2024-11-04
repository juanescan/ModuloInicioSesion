package NuestraSenoraDeLaSabiduria.LoginBack.Modelo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase que representa un usuario
 * @version 1.0
 * @Autor Diego Chicuazuque
 **/
@Setter
@Getter
@Document(collection = "usuarios")
public abstract class Usuario {

  private String id;
  private String nombreUsuario;
  private String contrasena;
  private String nombreCompleto;

  /*
   * Constructor de la clase
   * @param id
   * @param nombreUsuario
   * @param contrasena
   * @param nombreCompleto
   */
  public Usuario(
    String id,
    String nombreUsuario,
    String contrasena,
    String nombreCompleto
  ) {
    this.id = id;
    this.nombreUsuario = nombreUsuario;
    this.contrasena = contrasena;
    this.nombreCompleto = nombreCompleto;
  }

  // Método común para obtener los detalles del usuario
  public String obtenerDetallesUsuario() {
    return "Usuario: " + nombreCompleto;
  }
}
