package NuestraSenoraDeLaSabiduria.LoginBack;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.Bibliotecario;
import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.Estudiante;
import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.ResponsableEconomico;
import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.Usuario;
import NuestraSenoraDeLaSabiduria.LoginBack.Repositorio.ResponsableEconomicoRepository;
import NuestraSenoraDeLaSabiduria.LoginBack.Repositorio.UsuarioRepository;
import NuestraSenoraDeLaSabiduria.LoginBack.Servicio.UsuarioServicio;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UsuarioServicioTest {

  @Mock
  private UsuarioRepository usuarioRepository;

  @Mock
  private ResponsableEconomicoRepository responsableEconomicoRepository;

  @InjectMocks
  private UsuarioServicio usuarioServicio;

  private Estudiante estudiante;
  private ResponsableEconomico responsable;
  private Bibliotecario bibliotecario;

  @BeforeEach
  void setUp() {
    estudiante =
      new Estudiante.Builder("usuarioEstudiante", "password123", "Juan Pérez")
        .codigoEstudiante("E001")
        .curso("10A")
        .anoAcademico("2024")
        .responsableId("R001")
        .build();

    responsable =
      ResponsableEconomico
        .builder()
        .nombreCompleto("Carlos López")
        .documentoIdentificacion("123456789")
        .correoElectronico("carlos.lopez@example.com")
        .telefono("555123456")
        .direccion("Calle 123")
        .build();

    bibliotecario =
      new Bibliotecario("usuarioBiblio", "password123", "Ana Gómez");
  }

  @Test
  void testRegistrarEstudiante() {
    when(usuarioRepository.save(estudiante)).thenReturn(estudiante);
    Usuario resultado = usuarioServicio.registrarEstudiante(estudiante);
    assertNotNull(resultado);
    assertEquals(estudiante.getNombreUsuario(), resultado.getNombreUsuario());
    verify(usuarioRepository, times(1)).save(estudiante);
  }

  @Test
  void testRegistrarResponsableCuandoNoExiste() throws Exception {
    when(
      responsableEconomicoRepository.existsByCorreoElectronico(
        responsable.getCorreoElectronico()
      )
    )
      .thenReturn(false);
    when(responsableEconomicoRepository.save(responsable))
      .thenReturn(responsable);

    ResponsableEconomico resultado = usuarioServicio.registrarResponsable(
      responsable
    );
    assertNotNull(resultado);
    assertEquals(
      responsable.getCorreoElectronico(),
      resultado.getCorreoElectronico()
    );
    verify(responsableEconomicoRepository, times(1)).save(responsable);
  }

  @Test
  void testRegistrarBibliotecario() {
    when(usuarioRepository.save(bibliotecario)).thenReturn(bibliotecario);
    Usuario resultado = usuarioServicio.registrarBibliotecario(bibliotecario);
    assertNotNull(resultado);
    assertEquals(
      bibliotecario.getNombreUsuario(),
      resultado.getNombreUsuario()
    );
    verify(usuarioRepository, times(1)).save(bibliotecario);
  }

  @Test
  void testLoginUsuarioConCredencialesValidas() throws Exception {
    when(usuarioRepository.findByNombreUsuario("usuarioEstudiante"))
      .thenReturn(Optional.of(estudiante));
    Usuario resultado = usuarioServicio.loginUsuario(
      "usuarioEstudiante",
      "password123"
    );
    assertNotNull(resultado);
    assertEquals("usuarioEstudiante", resultado.getNombreUsuario());
  }

  @Test
  void testLoginUsuarioConContrasenaIncorrecta() {
    when(usuarioRepository.findByNombreUsuario("usuarioEstudiante"))
      .thenReturn(Optional.of(estudiante));
    Exception exception = assertThrows(
      Exception.class,
      () -> {
        usuarioServicio.loginUsuario("usuarioEstudiante", "incorrecta");
      }
    );
    assertEquals("Contraseña incorrecta", exception.getMessage());
  }

  @Test
  void testValidarResponsableCuandoExiste() {
    when(
      responsableEconomicoRepository.existsByCorreoElectronico(
        "carlos.lopez@example.com"
      )
    )
      .thenReturn(true);
    assertTrue(usuarioServicio.validarResponsable("carlos.lopez@example.com"));
  }

  @Test
  void testValidarResponsableCuandoNoExiste() {
    when(
      responsableEconomicoRepository.existsByCorreoElectronico(
        "carlos.lopez@example.com"
      )
    )
      .thenReturn(false);
    assertFalse(usuarioServicio.validarResponsable("carlos.lopez@example.com"));
  }
}
