import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, BCryptPasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario registrarUsuario(String nombreUsuario, String contrasena, String rol) throws Exception {
        if (usuarioRepository.existsByNombreUsuario(nombreUsuario)) {
            throw new Exception("El nombre de usuario ya está en uso.");
        }

        String contrasenaEncriptada = passwordEncoder.encode(contrasena);
        Usuario usuario = new Usuario(nombreUsuario, contrasenaEncriptada, rol);
        return usuarioRepository.save(usuario);
    }
}
