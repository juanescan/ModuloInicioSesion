package NuestraSenoraDeLaSabiduria.LoginBack.Controlador.Publico;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class ApiController {

  @GetMapping("/secure-data")
  public ResponseEntity<String> getSecureData() {
    return ResponseEntity.ok(
      "El token es válido, has accedido a datos seguros."
    );
  }
}
