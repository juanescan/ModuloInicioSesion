package NuestraSenoraDeLaSabiduria.LoginBack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import NuestraSenoraDeLaSabiduria.LoginBack.Controlador.UsuarioRegistrarControlador;
import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.*;
import NuestraSenoraDeLaSabiduria.LoginBack.Servicio.UsuarioServicio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class UsuarioRegistrarControladorTest {

  @Mock
  private UsuarioServicio usuarioServicio;

  @InjectMocks
  private UsuarioRegistrarControlador usuarioRegistrarControlador;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testValidarResponsableEconomico() {
    // Configuración de datos de prueba
    String responsableEconomico = "responsable1";

    // Configuración del comportamiento del servicio
    when(usuarioServicio.validarResponsable(responsableEconomico))
      .thenReturn(true);

    // Llamada al método de prueba
    boolean resultado = usuarioRegistrarControlador.validarResponsableEconomico(
      responsableEconomico
    );

    // Verificación del resultado
    assertEquals(true, resultado);
  }

  @Test
  void testRegistrarResponsableEconomico() {
    // Configuración de datos de prueba
    ResponsableEconomicoDTO responsableEconomicoDTO = new ResponsableEconomicoDTO(
      "pepitoPerez",
      "1234123",
      "pepito@mail.com",
      "32342412",
      "cra 72bis #12 - 2"
    );
    responsableEconomicoDTO.setNombreCompleto("Juan Perez");
    responsableEconomicoDTO.setCorreoElectronico("juan.perez@example.com");
    responsableEconomicoDTO.setTelefono("123456789");
    responsableEconomicoDTO.setDireccion("Calle Falsa 123");
    responsableEconomicoDTO.setDocumentoIdentificacion("987654321");

    ResponsableEconomico responsableEconomico = ResponsableEconomico
      .builder()
      .nombreCompleto("Juan Perez")
      .correoElectronico("juan.perez@example.com")
      .telefono("123456789")
      .direccion("Calle Falsa 123")
      .documentoIdentificacion("987654321")
      .build();

    // Configuración del comportamiento del servicio
    when(usuarioServicio.registrarResponsable(any(ResponsableEconomico.class)))
      .thenReturn(responsableEconomico);

    // Llamada al método de prueba
    ResponsableEconomico resultado = usuarioRegistrarControlador.registrarResponsableEconomico(
      responsableEconomicoDTO
    );

    // Verificación del resultado
    assertEquals(responsableEconomico, resultado);
  }

  @Test
  void testRegistrarEstudiante() {
    // Configuración de datos de prueba
    EstudianteDTO estudianteDTO = new EstudianteDTO(
      "pepito",
      "123",
      "PepitoPerez",
      "12345",
      "once",
      "2024",
      "padrePepito"
    );
    estudianteDTO.setNombreUsuario("estudiante1");
    estudianteDTO.setContrasena("password");
    estudianteDTO.setNombreCompleto("Estudiante Uno");
    estudianteDTO.setCodigoEstudiante("2024001");
    estudianteDTO.setCurso("Curso 1");
    estudianteDTO.setAnoAcademico("2024");
    estudianteDTO.setResponsableId("responsable1");

    Estudiante estudiante = new Estudiante.Builder(
      "estudiante1",
      "password",
      "Estudiante Uno"
    )
      .codigoEstudiante("2024001")
      .curso("Curso 1")
      .anoAcademico("2024")
      .responsableId("responsable1")
      .build();

    // Configuración del comportamiento del servicio
    when(usuarioServicio.registrarEstudiante(any(Estudiante.class)))
      .thenReturn(estudiante);

    // Llamada al método de prueba
    Usuario resultado = usuarioRegistrarControlador.registrarEstudiante(
      estudianteDTO
    );

    // Verificación del resultado
    assertEquals(estudiante, resultado);
  }

  @Test
  void testRegistrarBibliotecario() {
    // Configuración de datos de prueba
    BibliotecarioDTO bibliotecarioDTO = new BibliotecarioDTO(
      "pepito",
      "123",
      "pepitoPerez"
    );
    bibliotecarioDTO.setNombreUsuario("bibliotecario1");
    bibliotecarioDTO.setContrasena("password");
    bibliotecarioDTO.setNombreCompleto("Bibliotecario Uno");

    Bibliotecario bibliotecario = new Bibliotecario(
      "bibliotecario1",
      "password",
      "Bibliotecario Uno"
    );

    // Configuración del comportamiento del servicio
    when(usuarioServicio.registrarBibliotecario(any(Bibliotecario.class)))
      .thenReturn(bibliotecario);

    // Llamada al método de prueba
    Usuario resultado = usuarioRegistrarControlador.registrarBibliotecario(
      bibliotecarioDTO
    );

    // Verificación del resultado
    assertEquals(bibliotecario, resultado);
  }
}
