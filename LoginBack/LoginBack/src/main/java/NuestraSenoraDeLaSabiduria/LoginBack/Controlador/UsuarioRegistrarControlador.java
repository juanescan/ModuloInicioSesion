package NuestraSenoraDeLaSabiduria.LoginBack.Controlador;

import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.Estudiante;
import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.ResponsableEconomico;
import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.Usuario;
import NuestraSenoraDeLaSabiduria.LoginBack.Servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
public class UsuarioRegistrarControlador {

  @Autowired
  private UsuarioServicio usuarioServicio;

  /**
   * Constructor de la clase
   * @param usuarioServicio
   */
  public UsuarioRegistrarControlador(UsuarioServicio usuarioServicio) {
    this.usuarioServicio = usuarioServicio;
  }

  /**
   * Registrar un usuario
   * @param usuario
   * @return ResponseEntity
   */
  @GetMapping("/validarResponsableEconomico")
  public boolean validarResponsableEconomico(
    @RequestBody ResponsableEconomico responsableEconomico
  ) {
    return usuarioServicio.validarResponsable(
      responsableEconomico.getCorreoElectronico()
    );
  }

  /**
   * Registrar un responsable economico
   * @param responsableEconomico
   * @return ResponseEntity
   */
  @PostMapping("/registrarResponsableEconomico")
  public ResponsableEconomico registrarResponsableEconomico(
    @RequestBody ResponsableEconomico responsableEconomico
  ) {
    return usuarioServicio.registrarResponsable(responsableEconomico);
  }

  /**
   * Registrar un estudiante
   * @param estudiante
   * @return ResponseEntity
   */
  @PostMapping("/registrarEstudiante")
  public Usuario registrarEstudiante(@RequestBody Estudiante estudiante) {
    return usuarioServicio.registrarEstudiante(estudiante);
  }

  /**
   * Registrar un bibliotecario
   * @param bibliotecario
   * @return ResponseEntity
   */
  @PostMapping("/registrarBibliotecario")
  public Usuario registrarBibliotecario(@RequestBody Usuario bibliotecario) {
    return usuarioServicio.registrarBibliotecario(bibliotecario);
  }
}
