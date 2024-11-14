package NuestraSenoraDeLaSabiduria.LoginBack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.BibliotecarioDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BibliotecarioDTOTest {

    private BibliotecarioDTO bibliotecario;

    @BeforeEach
    public void setUp() {
        bibliotecario = new BibliotecarioDTO("bibliotecario1", "password123", "Juan Perez");
    }

    @Test
    public void testBibliotecarioDTOCreation() {
        assertNotNull(bibliotecario, "El objeto BibliotecarioDTO debería ser creado correctamente.");
    }

    @Test
    public void testGetNombreUsuario() {
        assertEquals("bibliotecario1", bibliotecario.getNombreUsuario(), "El nombre de usuario debería ser 'bibliotecario1'.");
    }

    @Test
    public void testGetContrasena() {
        assertEquals("password123", bibliotecario.getContrasena(), "La contraseña debería ser 'password123'.");
    }

    @Test
    public void testGetNombreCompleto() {
        assertEquals("Juan Perez", bibliotecario.getNombreCompleto(), "El nombre completo debería ser 'Juan Perez'.");
    }

    @Test
    public void testSetNombreUsuario() {
        bibliotecario.setNombreUsuario("nuevoUsuario");
        assertEquals("nuevoUsuario", bibliotecario.getNombreUsuario(), "El nombre de usuario debería actualizarse a 'nuevoUsuario'.");
    }

    @Test
    public void testSetContrasena() {
        bibliotecario.setContrasena("nuevaPassword");
        assertEquals("nuevaPassword", bibliotecario.getContrasena(), "La contraseña debería actualizarse a 'nuevaPassword'.");
    }

    @Test
    public void testSetNombreCompleto() {
        bibliotecario.setNombreCompleto("Maria Lopez");
        assertEquals("Maria Lopez", bibliotecario.getNombreCompleto(), "El nombre completo debería actualizarse a 'Maria Lopez'.");
    }
}
