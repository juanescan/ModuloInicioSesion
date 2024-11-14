package NuestraSenoraDeLaSabiduria.LoginBack;

import NuestraSenoraDeLaSabiduria.LoginBack.Controlador.UsuarioLoginControlador;
import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.Usuario;
import NuestraSenoraDeLaSabiduria.LoginBack.Servicio.UsuarioServicio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;

class UsuarioLoginControladorTest {

    @Mock
    private UsuarioServicio usuarioServicio;

    @InjectMocks
    private UsuarioLoginControlador usuarioLoginControlador;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testLoginUsuarioExitoso() throws Exception {
        // Configuración de datos de prueba
        Usuario usuario = new Usuario("pepito","123","pepitoPerez");
        usuario.setNombreUsuario("testuser");
        usuario.setContrasena("password");

        Usuario usuarioLogueado = new Usuario("pepito","123","pepitoPerez");;
        usuarioLogueado.setNombreUsuario("testuser");

        // Configuración del comportamiento del servicio
        when(usuarioServicio.loginUsuario("testuser", "password")).thenReturn(usuarioLogueado);

        // Llamada al método de prueba
        ResponseEntity<?> response = usuarioLoginControlador.login(usuario);

        // Verificación de la respuesta
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(usuarioLogueado, response.getBody());
    }

    @Test
    void testLoginUsuarioFallido() throws Exception {
        // Configuración de datos de prueba
        Usuario usuario = new Usuario("pepito","123","pepitoPerez");;
        usuario.setNombreUsuario("testuser");
        usuario.setContrasena("wrongpassword");

        // Configuración del comportamiento del servicio para lanzar una excepción
        doThrow(new RuntimeException("Credenciales incorrectas"))
                .when(usuarioServicio).loginUsuario(anyString(), anyString());

        // Llamada al método de prueba
        ResponseEntity<?> response = usuarioLoginControlador.login(usuario);

        // Verificación de la respuesta
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        assertEquals("Error de autenticación: Credenciales incorrectas", response.getBody());
    }
}