package NuestraSenoraDeLaSabiduria.LoginBack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.Estudiante;
import org.junit.jupiter.api.Test;

public class EstudianteTest {

    @Test
    public void testEstudianteCreation() {
        Estudiante estudiante = new Estudiante.Builder("estudiante123", "password123", "Ana Martinez")
                .codigoEstudiante("EST12345")
                .curso("Matematicas")
                .anoAcademico("2024")
                .responsableId("RESP987")
                .build();

        assertNotNull(estudiante, "El objeto Estudiante debería ser creado correctamente.");
        assertEquals("estudiante123", estudiante.getNombreUsuario(), "El nombre de usuario debería ser 'estudiante123'.");
        assertEquals("password123", estudiante.getContrasena(), "La contraseña debería ser 'password123'.");
        assertEquals("Ana Martinez", estudiante.getNombreCompleto(), "El nombre completo debería ser 'Ana Martinez'.");
        assertEquals("EST12345", estudiante.getCodigoEstudiante(), "El código de estudiante debería ser 'EST12345'.");
        assertEquals("Matematicas", estudiante.getCurso(), "El curso debería ser 'Matematicas'.");
        assertEquals("2024", estudiante.getAnoAcademico(), "El año académico debería ser '2024'.");
        assertEquals("RESP987", estudiante.getResponsableId(), "El ID del responsable debería ser 'RESP987'.");
    }
}