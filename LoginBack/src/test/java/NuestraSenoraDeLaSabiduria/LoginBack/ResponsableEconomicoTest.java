package NuestraSenoraDeLaSabiduria.LoginBack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.ResponsableEconomico;
import org.junit.jupiter.api.Test;

public class ResponsableEconomicoTest {

  @Test
  public void testResponsableEconomicoCreation() {
    ResponsableEconomico responsable = ResponsableEconomico
      .builder()
      .nombreCompleto("Carlos Gutierrez")
      .documentoIdentificacion("123456789")
      .correoElectronico("carlos.gutierrez@example.com")
      .telefono("555-1234")
      .direccion("Calle Falsa 123")
      .build();

    assertNotNull(
      responsable,
      "El objeto ResponsableEconomico debería ser creado correctamente."
    );
    assertEquals(
      "Carlos Gutierrez",
      responsable.getNombreCompleto(),
      "El nombre completo debería ser 'Carlos Gutierrez'."
    );
    assertEquals(
      "123456789",
      responsable.getDocumentoIdentificacion(),
      "El documento de identificación debería ser '123456789'."
    );
    assertEquals(
      "carlos.gutierrez@example.com",
      responsable.getCorreoElectronico(),
      "El correo electrónico debería ser 'carlos.gutierrez@example.com'."
    );
    assertEquals(
      "555-1234",
      responsable.getTelefono(),
      "El teléfono debería ser '555-1234'."
    );
    assertEquals(
      "Calle Falsa 123",
      responsable.getDireccion(),
      "La dirección debería ser 'Calle Falsa 123'."
    );
  }

  @Test
  public void testObtenerDetallesResponsableEconomico() {
    ResponsableEconomico responsable = ResponsableEconomico
      .builder()
      .nombreCompleto("Carlos Gutierrez")
      .documentoIdentificacion("123456789")
      .correoElectronico("carlos.gutierrez@example.com")
      .telefono("555-1234")
      .direccion("Calle Falsa 123")
      .build();

    String detallesEsperados =
      "Nombre Completo: Carlos Gutierrez - Documento Identificación: 123456789 - Correo Electrónico: carlos.gutierrez@example.com - Teléfono: 555-1234 - Dirección: Calle Falsa 123";
    assertEquals(
      detallesEsperados,
      responsable.obtenerDetallesResponsableEconomico(),
      "Los detalles del responsable económico deberían coincidir con el formato esperado."
    );
  }
}
