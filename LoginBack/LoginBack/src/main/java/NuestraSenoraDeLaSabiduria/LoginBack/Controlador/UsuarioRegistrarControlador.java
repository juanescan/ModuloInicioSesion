package NuestraSenoraDeLaSabiduria.LoginBack.Controlador;

import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.Bibliotecario;
import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.BibliotecarioDTO;
import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.Estudiante;
import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.EstudianteDTO;
import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.ResponsableEconomico;
import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.ResponsableEconomicoDTO;
import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.Usuario;
import NuestraSenoraDeLaSabiduria.LoginBack.Servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
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
   * @param responsableEconomico
   * @return ResponseEntity
   */
  @PostMapping("/registrarResponsableEconomico")
  public ResponsableEconomico registrarResponsableEconomico(
    @RequestBody ResponsableEconomicoDTO responsableEconomicoDTO
  ) {
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
    return usuarioServicio.registrarResponsable(responsableEconomico);
  }

  /**
   * Registrar un estudiante
   * @param estudiante
   * @return ResponseEntity
   */
  @PostMapping("/registrarEstudiante")
  public Usuario registrarEstudiante(@RequestBody EstudianteDTO estudianteDTO) {
    // Aqui se llamo al builder de la clase Estudiante para crear un objeto de tipo Estudiante
    // caso contrario que en los otros que se uso builder ya que en los otros se uso el que es propio de lombok
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

    return usuarioServicio.registrarEstudiante(estudiante);
  }

  /**
   * Registrar un bibliotecario
   * @param bibliotecario
   * @return ResponseEntity
   */
  @PostMapping("/registrarBibliotecario")
  public Usuario registrarBibliotecario(
    @RequestBody BibliotecarioDTO bibliotecarioDTO
  ) {
    Bibliotecario bibliotecario = new Bibliotecario(
      bibliotecarioDTO.getNombreUsuario(),
      bibliotecarioDTO.getContrasena(),
      bibliotecarioDTO.getNombreCompleto()
    );
    return usuarioServicio.registrarBibliotecario(bibliotecario);
  }
}
