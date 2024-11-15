package NuestraSenoraDeLaSabiduria.LoginBack.Controlador;

import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.Usuario;
import NuestraSenoraDeLaSabiduria.LoginBack.Servicio.UsuarioServicio;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para la entidad Usuario
 *
 * @version 1.1
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
   * @return ResponseEntity con el usuario logueado o un mensaje de error
   * @throws Exception
   */
  @GetMapping("/login")
  public ResponseEntity<?> login(@RequestBody Map<String, String> requestBody) {
    String nombreUsuario = requestBody.get("nombreUsuario");
    String contrasena = requestBody.get("contrasena");

    try {
      Usuario usuarioLogueado = usuarioServicio.loginUsuario(
        nombreUsuario,
        contrasena
      );

      // Obtener el tipo de usuario a partir de la clase en la cual se encuentra un
      // @TypeAlias
      String tipoUsuario = usuarioLogueado.getClass().getSimpleName();

      // Crear el mapa de respuesta
      Map<String, String> response = new HashMap<>();
      response.put("nombreUsuario", usuarioLogueado.getNombreUsuario());
      response.put("tipoUsuario", tipoUsuario);

      return ResponseEntity.ok(response);
    } catch (Exception e) {
      return ResponseEntity
        .status(HttpStatus.UNAUTHORIZED)
        .body(
          Collections.singletonMap(
            "error",
            "Error de autenticación: " + e.getMessage()
          )
        );
    }
  }
}
