package NuestraSenoraDeLaSabiduria.LoginBack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.EstudianteDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EstudianteDTOTest {

  private EstudianteDTO estudiante;

  @BeforeEach
  public void setUp() {
    estudiante =
      new EstudianteDTO(
        "estudiante123",
        "password123",
        "Ana Martinez",
        "EST12345",
        "Matematicas",
        "2024",
        "RESP987"
      );
  }

  @Test
  public void testEstudianteDTOCreation() {
    assertNotNull(
      estudiante,
      "El objeto EstudianteDTO debería ser creado correctamente."
    );
  }

  @Test
  public void testGetNombreUsuario() {
    assertEquals(
      "estudiante123",
      estudiante.getNombreUsuario(),
      "El nombre de usuario debería ser 'estudiante123'."
    );
  }

  @Test
  public void testGetContrasena() {
    assertEquals(
      "password123",
      estudiante.getContrasena(),
      "La contraseña debería ser 'password123'."
    );
  }

  @Test
  public void testGetNombreCompleto() {
    assertEquals(
      "Ana Martinez",
      estudiante.getNombreCompleto(),
      "El nombre completo debería ser 'Ana Martinez'."
    );
  }

  @Test
  public void testGetCodigoEstudiante() {
    assertEquals(
      "EST12345",
      estudiante.getCodigoEstudiante(),
      "El código de estudiante debería ser 'EST12345'."
    );
  }

  @Test
  public void testGetCurso() {
    assertEquals(
      "Matematicas",
      estudiante.getCurso(),
      "El curso debería ser 'Matematicas'."
    );
  }

  @Test
  public void testGetAnoAcademico() {
    assertEquals(
      "2024",
      estudiante.getAnoAcademico(),
      "El año académico debería ser '2024'."
    );
  }

  @Test
  public void testGetResponsableId() {
    assertEquals(
      "RESP987",
      estudiante.getResponsableId(),
      "El ID del responsable debería ser 'RESP987'."
    );
  }

  @Test
  public void testSetNombreUsuario() {
    estudiante.setNombreUsuario("nuevoUsuario");
    assertEquals(
      "nuevoUsuario",
      estudiante.getNombreUsuario(),
      "El nombre de usuario debería actualizarse a 'nuevoUsuario'."
    );
  }

  @Test
  public void testSetContrasena() {
    estudiante.setContrasena("nuevaPassword");
    assertEquals(
      "nuevaPassword",
      estudiante.getContrasena(),
      "La contraseña debería actualizarse a 'nuevaPassword'."
    );
  }

  @Test
  public void testSetNombreCompleto() {
    estudiante.setNombreCompleto("Carlos Lopez");
    assertEquals(
      "Carlos Lopez",
      estudiante.getNombreCompleto(),
      "El nombre completo debería actualizarse a 'Carlos Lopez'."
    );
  }

  @Test
  public void testSetCodigoEstudiante() {
    estudiante.setCodigoEstudiante("EST54321");
    assertEquals(
      "EST54321",
      estudiante.getCodigoEstudiante(),
      "El código de estudiante debería actualizarse a 'EST54321'."
    );
  }

  @Test
  public void testSetCurso() {
    estudiante.setCurso("Ciencias");
    assertEquals(
      "Ciencias",
      estudiante.getCurso(),
      "El curso debería actualizarse a 'Ciencias'."
    );
  }

  @Test
  public void testSetAnoAcademico() {
    estudiante.setAnoAcademico("2025");
    assertEquals(
      "2025",
      estudiante.getAnoAcademico(),
      "El año académico debería actualizarse a '2025'."
    );
  }

  @Test
  public void testSetResponsableId() {
    estudiante.setResponsableId("RESP123");
    assertEquals(
      "RESP123",
      estudiante.getResponsableId(),
      "El ID del responsable debería actualizarse a 'RESP123'."
    );
  }
}
