package NuestraSenoraDeLaSabiduria.LoginBack.Controlador;

public class ValidacionRequest {

  private String token;
  private String rol;
  private String nombreUsuario;

  // Getters y setters
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getRol() {
    return rol;
  }

  public void setRol(String rol) {
    this.rol = rol;
  }

  public String getNombreUsuario() {
    return nombreUsuario;
  }

  public void setNombreUsuario(String nombreUsuario) {
    this.nombreUsuario = nombreUsuario;
  }
}
