package NuestraSenoraDeLaSabiduria.LoginBack.Servicio;

import NuestraSenoraDeLaSabiduria.LoginBack.Controlador.AuthResponse;
import NuestraSenoraDeLaSabiduria.LoginBack.Excepciones.Excepciones;
import NuestraSenoraDeLaSabiduria.LoginBack.Jwt.JwtService;
import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.Bibliotecario;
import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.Estudiante;
import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.ResponsableEconomico;
import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.Usuario;
import NuestraSenoraDeLaSabiduria.LoginBack.Repositorio.ResponsableEconomicoRepository;
import NuestraSenoraDeLaSabiduria.LoginBack.Repositorio.UsuarioRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio para la entidad Usuario (Estudiante y Bibliotecario)
 *
 * @version 1.1
 * @Autor Diego Chicuazuque
 */
@Service
@RequiredArgsConstructor
public class UsuarioServicio {

  @Autowired
  private final UsuarioRepository usuarioRepository;

  private final JwtService jwtService;

  @Autowired
  private ResponsableEconomicoRepository responsableEconomicoRepository;

  /**
   * Registrar un estudiante
   * @param estudiante
   * @return Usuario
   */
  public AuthResponse registrarEstudiante(Estudiante estudiante) {
    usuarioRepository.save(estudiante);
    return AuthResponse
      .builder()
      .token(jwtService.getToken(estudiante))
      .rol("Estudiante")
      .build();
  }

  public ResponsableEconomico registrarResponsable(
    ResponsableEconomico responsable
  ) throws Exception {
    if (validarResponsable(responsable.getCorreoElectronico())) {
      throw new Excepciones(Excepciones.USUARIO_EXISTENTE);
    }
    return responsableEconomicoRepository.save(responsable);
  }

  /**
   * Registrar un bibliotecario
   * @param bibliotecario
   * @return Usuario
   */
  public AuthResponse registrarBibliotecario(Bibliotecario bibliotecario) {
    usuarioRepository.save(bibliotecario);
    System.out.println(bibliotecario.obtenerDetallesUsuario());
    return AuthResponse
      .builder()
      .token(jwtService.getToken(bibliotecario))
      .rol("Bibliotecario")
      .build();
  }

  /**
   * Iniciar sesión de un usuario
   * @param nombreUsuario
   * @param contrasena
   * @return Usuario
   * @throws Exception
   */
  public AuthResponse loginUsuario(String nombreUsuario, String contrasena)
    throws Exception {
    // Verificar si el usuario existe
    Usuario usuario = usuarioRepository
      .findByNombreUsuario(nombreUsuario)
      .orElseThrow(() -> new Excepciones(Excepciones.USUARIO_INEXISTENTE));
    // Verificar si la contraseña es correcta
    if (!usuario.getContrasena().equals(contrasena)) {
      throw new Excepciones(Excepciones.LOGIN_INVALIDO);
    }
    return AuthResponse
      .builder()
      .rol(usuario.getClass().getSimpleName())
      .build();
  }

  /**
   * Validar si un responsable económico ya existe
   * @param responsableCorreo
   * @return boolean
   */
  public boolean validarResponsable(String responsableCorreo) {
    if (
      responsableEconomicoRepository.existsByCorreoElectronico(
        responsableCorreo
      )
    ) {
      return true;
    }
    return false;
  }

  /**
   * Listar todos los usuarios
   * @return List<Usuario>
   */
  public List<Usuario> listarUsuarios() {
    return usuarioRepository.findAll();
  }

  /**
   * Lista de todos los responsables económicos
   * @return List<ResponsableEconomico>
   */
  public List<ResponsableEconomico> listarResponsables() {
    return responsableEconomicoRepository.findAll();
  }
}
