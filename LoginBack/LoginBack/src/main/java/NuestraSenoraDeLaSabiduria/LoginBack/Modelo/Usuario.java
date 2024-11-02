package NuestraSenoraDeLaSabiduria.LoginBack.Modelo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "usuarios")
public class Usuario {

  @Id
  private String id;

  private String nombreUsuario; // Podría ser el correo electrónico
  private String contrasena; // La contraseña debe almacenarse encriptada
  private String rol; // "estudiante" o "responsable"

  /**
   * Constructor de la clase
   * @param nombreUsuario
   * @param contrasena
   * @param rol
   */
  // Constructor, getters, y setters
  public Usuario(String nombreUsuario, String contrasena, String rol) {
    this.nombreUsuario = nombreUsuario;
    this.contrasena = contrasena;
    this.rol = rol;
  }
}
