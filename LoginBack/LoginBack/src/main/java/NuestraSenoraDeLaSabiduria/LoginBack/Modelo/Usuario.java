package NuestraSenoraDeLaSabiduria.LoginBack.Modelo;

import java.util.Collection;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Clase que representa un usuario
 * @version 1.0
 * @Autor Diego Chicuazuque
 **/
@Setter
@Getter
@Document(collection = "usuarios")
public class Usuario implements UserDetails {

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

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(this.getClass().getSimpleName()));
  }

  @Override
  public String getPassword() {
    return contrasena;
  }

  @Override
  public String getUsername() {
    return nombreUsuario;
  }
}
