package NuestraSenoraDeLaSabiduria.LoginBack.Servicio;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import NuestraSenoraDeLaSabiduria.LoginBack.Repositorio.UsuarioRepository;
import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.Usuario;

@Service
public class AutenticacionService {
    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AutenticacionService(UsuarioRepository usuarioRepository, BCryptPasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario iniciarSesion(String nombreUsuario, String contrasena) throws Exception {
        Usuario usuario = usuarioRepository.findByNombreUsuario(nombreUsuario)
                .orElseThrow(() -> new Exception("Usuario no encontrado."));

        if (!passwordEncoder.matches(contrasena, usuario.getContrasena())) {
            throw new Exception("Contraseña incorrecta.");
        }

        // Generar JWT o crear una sesión si la autenticación es exitosa
        return usuario;
    }
}
