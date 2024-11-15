package NuestraSenoraDeLaSabiduria.LoginBack.Servicio;

import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.Bibliotecario;
import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.Estudiante;
import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.ResponsableEconomico;
import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.Usuario;
import NuestraSenoraDeLaSabiduria.LoginBack.Repositorio.ResponsableEconomicoRepository;
import NuestraSenoraDeLaSabiduria.LoginBack.Repositorio.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio para la entidad Usuario (Estudiante y Bibliotecario)
 *
 * @version 1.0
 * @Autor Diego Chicuazuque
 */
@Service
public class UsuarioServicio {

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Autowired
  private ResponsableEconomicoRepository responsableEconomicoRepository;

  /**
   * Registrar un estudiante
   * @param estudiante
   * @return Usuario
   */
  public Usuario registrarEstudiante(Estudiante estudiante) {
    return usuarioRepository.save(estudiante);
  }

  public ResponsableEconomico registrarResponsable(
    ResponsableEconomico responsable
  ) throws Exception {
    if (validarResponsable(responsable.getCorreoElectronico())) {
      throw new Exception("El responsable económico ya existe");
    }
    return responsableEconomicoRepository.save(responsable);
  }

  /**
   * Registrar un bibliotecario
   * @param bibliotecario
   * @return Usuario
   */
  public Usuario registrarBibliotecario(Bibliotecario bibliotecario) {
    return usuarioRepository.save(bibliotecario);
  }

  /**
   * Iniciar sesión de un usuario
   * @param nombreUsuario
   * @param contrasena
   * @return Usuario
   * @throws Exception
   */
  public Usuario loginUsuario(String nombreUsuario, String contrasena)
    throws Exception {
    System.out.println("Buscando usuario: " + nombreUsuario);
    // Verificar si el usuario existe
    Usuario usuario = usuarioRepository
      .findByNombreUsuario(nombreUsuario)
      .orElseThrow(() -> new Exception("Usuario no encontrado 3"));
    // Verificar si la contraseña es correcta
    if (!usuario.getContrasena().equals(contrasena)) {
      throw new Exception("Contraseña incorrecta");
    }
    return usuario;
  }

  /**
   * Validar si un responsable económico ya existe
   * @param responsable
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
