package NuestraSenoraDeLaSabiduria.LoginBack.Controlador.Publico;

import NuestraSenoraDeLaSabiduria.LoginBack.Controlador.AuthResponse;
import NuestraSenoraDeLaSabiduria.LoginBack.Servicio.UsuarioServicio;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
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
  public ResponseEntity<AuthResponse> login(
    @RequestBody Map<String, String> requestBody
  ) throws Exception {
    String nombreUsuario = requestBody.get("nombreUsuario");
    String contrasena = requestBody.get("contrasena");
    return ResponseEntity.ok(
      usuarioServicio.loginUsuario(nombreUsuario, contrasena)
    );
  }
}
