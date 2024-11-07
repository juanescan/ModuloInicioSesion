package NuestraSenoraDeLaSabiduria.LoginBack.Controlador;

import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.Usuario;
import NuestraSenoraDeLaSabiduria.LoginBack.Servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para la entidad Usuario
 *
 * @version 1.0
 * @Autor Diego Chicuazuque
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioLoginControlador {

  @Autowired
  private UsuarioServicio usuarioServicio;

  public UsuarioLoginControlador(UsuarioServicio usuarioServicio) {
    this.usuarioServicio = usuarioServicio;
  }

  /**
   * Login de un usuario
   * @param usuario
   * @return ResponseEntity
   */
  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody Usuario usuario) {
    try {
      Usuario usuarioLogueado = usuarioServicio.loginUsuario(
        usuario.getNombreUsuario(),
        usuario.getContrasena()
      );
      return ResponseEntity.ok(usuarioLogueado);
    } catch (Exception e) {
      return ResponseEntity
        .status(HttpStatus.UNAUTHORIZED)
        .body("Error de autenticación: " + e.getMessage());
    }
  }
}
