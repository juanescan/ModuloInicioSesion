package NuestraSenoraDeLaSabiduria.LoginBack.Controlador.Publico;

import NuestraSenoraDeLaSabiduria.LoginBack.Controlador.ValidacionRequest;
import NuestraSenoraDeLaSabiduria.LoginBack.Jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para la entidad Usuario
 *
 * @version 1.1
 * @Autor Diego Chicuazuque
 */
@RestController
@RequestMapping("/validador")
public class ValidadorController {

  @Autowired
  private JwtService jwtService;

  @Autowired
  private UserDetailsService userDetailsService;

  @PostMapping("/validar")
  public ResponseEntity<String> validarToken(
    @RequestBody ValidacionRequest request
  ) {
    String token = request.getToken();
    String rol = request.getRol();
    String nombreUsuario = request.getNombreUsuario();

    // Validar el nombre de usuario
    UserDetails userDetails = userDetailsService.loadUserByUsername(
      nombreUsuario
    );
    // Validar el token
    if (!jwtService.isTokenValid(token, userDetails)) {
      return ResponseEntity.status(401).body("Error de autenticación");
    }
    // Validar el rol
    boolean hasRole = userDetails
      .getAuthorities()
      .stream()
      .anyMatch(authority -> authority.getAuthority().equals(rol));
    if (!hasRole) {
      return ResponseEntity.status(403).body("Error de autorización");
    }

    return ResponseEntity.ok("Validación exitosa");
  }
}
