package NuestraSenoraDeLaSabiduria.LoginBack.Controlador.Publico;

import NuestraSenoraDeLaSabiduria.LoginBack.Excepciones.Excepciones;
import NuestraSenoraDeLaSabiduria.LoginBack.Servicio.UsuarioServicio;
import java.util.Collections;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

  // Con estos cambios, el metodo login ahora utiliza
  // @PostMapping, lo cual es más apropiado para recibir
  // datos en el cuerpo de la solicitud.
  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody Map<String, String> requestBody) {
    String nombreUsuario = requestBody.get("nombreUsuario");
    String contrasena = requestBody.get("contrasena");
    try {
      return ResponseEntity.ok(
        usuarioServicio.loginUsuario(nombreUsuario, contrasena)
      );
    } catch (Excepciones e) {
      return ResponseEntity
        .status(HttpStatus.UNAUTHORIZED)
        .body(
          Collections.singletonMap(
            "error",
            "Error de autenticación: " + e.getMessage()
          )
        );
    } catch (Exception e) {
      return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(
          Collections.singletonMap(
            "error",
            "Error interno del servidor: " + e.getMessage()
          )
        );
    }
  }
}
