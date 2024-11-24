package NuestraSenoraDeLaSabiduria.LoginBack.Controlador.Privado;

import NuestraSenoraDeLaSabiduria.LoginBack.Controlador.AuthResponse;
import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.Bibliotecario;
import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.BibliotecarioDTO;
import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.Estudiante;
import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.EstudianteDTO;
import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.ResponsableEconomico;
import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.ResponsableEconomicoDTO;
import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.Usuario;
import NuestraSenoraDeLaSabiduria.LoginBack.Servicio.UsuarioServicio;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/usuarioPrivado")
@RequiredArgsConstructor
public class UsuarioRegistrarControlador {

  @Autowired
  private UsuarioServicio usuarioServicio;

  //Este metodo esta violando el principo de que el front solo debe mostrar la informacion y
  //no debe tener logica de negocio, de momento se deja el metodo con posibilidad de cambiar en un futuro
  /**
   * Registrar un usuario
   * @param usuario
   * @return ResponseEntity
   */
  @PostMapping("/validarResponsableEconomico")
  public boolean validarResponsableEconomico(
    @RequestBody String responsableEconomico
  ) {
    return usuarioServicio.validarResponsable(responsableEconomico);
  }

  /**
   * Registrar un responsable economico
   * @param responsableEconomicoDTO
   * @return ResponseEntity
   */
  @PostMapping("/registrarResponsableEconomico")
  public ResponseEntity<String> registrarResponsableEconomico(
    @RequestBody ResponsableEconomicoDTO responsableEconomicoDTO
  ) {
    try {
      ResponsableEconomico responsableEconomico = ResponsableEconomico
        .builder()
        .nombreCompleto(responsableEconomicoDTO.getNombreCompleto())
        .correoElectronico(responsableEconomicoDTO.getCorreoElectronico())
        .telefono(responsableEconomicoDTO.getTelefono())
        .direccion(responsableEconomicoDTO.getDireccion())
        .documentoIdentificacion(
          responsableEconomicoDTO.getDocumentoIdentificacion()
        )
        .build();
      usuarioServicio.registrarResponsable(responsableEconomico);
      return ResponseEntity
        .status(HttpStatus.CREATED)
        .body("Responsable económico registrado exitosamente");
    } catch (Exception e) {
      return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body("Error al registrar responsable económico: " + e.getMessage());
    }
  }

  /**
   * Registrar un estudiante
   * @param estudiante
   * @return ResponseEntity
   * @throws Exception  si hay un error al registrar el estudiante se lanza una excepcion
   */
  @PostMapping("/registrarEstudiante")
  public ResponseEntity<AuthResponse> registrarEstudiante(
    @RequestBody EstudianteDTO estudianteDTO
  ) {
    // Aqui se llamo al builder de la clase Estudiante para crear un objeto de tipo Estudiante
    // caso contrario que en los otros que se uso builder ya que en los otros se uso el que es propio de lombok
    try {
      Estudiante estudiante = new Estudiante.Builder(
        estudianteDTO.getNombreUsuario(),
        estudianteDTO.getContrasena(),
        estudianteDTO.getNombreCompleto()
      )
        .codigoEstudiante(estudianteDTO.getCodigoEstudiante())
        .curso(estudianteDTO.getCurso())
        .anoAcademico(estudianteDTO.getAnoAcademico())
        .responsableId(estudianteDTO.getResponsableId())
        .build();

      return ResponseEntity.ok(usuarioServicio.registrarEstudiante(estudiante));
    } catch (Exception e) {
      AuthResponse authResponse = new AuthResponse();
      return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(authResponse);
    }
  }

  /**
   * Registrar un bibliotecario
   * @param bibliotecario
   * @return ResponseEntity
   */
  @PostMapping("/registrarBibliotecario")
  public ResponseEntity<AuthResponse> registrarBibliotecario(
    @RequestBody BibliotecarioDTO bibliotecarioDTO
  ) {
    try {
      Bibliotecario bibliotecario = new Bibliotecario(
        bibliotecarioDTO.getNombreUsuario(),
        bibliotecarioDTO.getContrasena(),
        bibliotecarioDTO.getNombreCompleto()
      );

      return ResponseEntity.ok(
        usuarioServicio.registrarBibliotecario(bibliotecario)
      );
    } catch (Exception e) {
      AuthResponse authResponse = new AuthResponse();
      return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(authResponse);
    }
  }

  /**
   * Obtener todos los usuarios
   * @return List<Usuario>
   */
  @GetMapping("/obtenerUsuario")
  public List<Usuario> obtenerUsuarios() {
    return usuarioServicio.listarUsuarios();
  }

  /**
   * Obtener todos los responsables economicos
   * @return List<ResponsableEconomico>
   */
  @GetMapping("/obtenerResponsables")
  public List<ResponsableEconomico> obtenerResponsables() {
    return usuarioServicio.listarResponsables();
  }
}
