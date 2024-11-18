package NuestraSenoraDeLaSabiduria.LoginBack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import NuestraSenoraDeLaSabiduria.LoginBack.Controlador.Publico.UsuarioLoginControlador;
import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.Usuario;
import NuestraSenoraDeLaSabiduria.LoginBack.Servicio.UsuarioServicio;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
    Usuario usuario = new Usuario("pepito", "123", "pepitoPerez");
    usuario.setNombreUsuario("testuser");
    usuario.setContrasena("password");

    Usuario usuarioLogueado = new Usuario("pepito", "123", "pepitoPerez");
    usuarioLogueado.setNombreUsuario("testuser");
    // Configuración del comportamiento del servicio
    when(usuarioServicio.loginUsuario("testuser", "password"))
      .thenReturn(usuarioLogueado);

    // Llamada al método de prueba
    Map<String, String> loginData = new HashMap<>();
    loginData.put("nombreUsuario", usuario.getNombreUsuario());
    loginData.put("contrasena", usuario.getContrasena());
    ResponseEntity<?> response = usuarioLoginControlador.login(loginData);

    // Verificación de la respuesta
    assertEquals(HttpStatus.OK, response.getStatusCode());
    //assertEquals(usuarioLogueado, response.getBody());
  }

  @Test
  void testLoginUsuarioFallido() throws Exception {
    // Configuración de datos de prueba
    Usuario usuario = new Usuario("pepito", "123", "pepitoPerez");
    usuario.setNombreUsuario("testuser");
    usuario.setContrasena("wrongpassword");
    // Configuración del comportamiento del servicio para lanzar una excepción
    doThrow(new RuntimeException("Credenciales incorrectas"))
      .when(usuarioServicio)
      .loginUsuario(anyString(), anyString());

    // Llamada al método de prueba
    Map<String, String> loginData = new HashMap<>();
    loginData.put("nombreUsuario", usuario.getNombreUsuario());
    loginData.put("contrasena", usuario.getContrasena());
    //ResponseEntity<?> response = usuarioLoginControlador.login(loginData);
    // Verificación de la respuesta
    //assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());

    //assertEquals(
    //"Error de autenticación: Credenciales incorrectas",
    //response.getBody()
    //);
  }
}
