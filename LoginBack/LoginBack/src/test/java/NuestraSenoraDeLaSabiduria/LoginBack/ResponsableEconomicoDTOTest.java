package NuestraSenoraDeLaSabiduria.LoginBack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.ResponsableEconomicoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ResponsableEconomicoDTOTest {

    private ResponsableEconomicoDTO responsable;

    @BeforeEach
    public void setUp() {
        responsable = new ResponsableEconomicoDTO(
                "Carlos Gutierrez",
                "123456789",
                "carlos.gutierrez@example.com",
                "555-1234",
                "Calle Falsa 123"
        );
    }

    @Test
    public void testResponsableEconomicoDTOCreation() {
        assertNotNull(responsable, "El objeto ResponsableEconomicoDTO debería ser creado correctamente.");
    }

    @Test
    public void testGetNombreCompleto() {
        assertEquals("Carlos Gutierrez", responsable.getNombreCompleto(), "El nombre completo debería ser 'Carlos Gutierrez'.");
    }

    @Test
    public void testGetDocumentoIdentificacion() {
        assertEquals("123456789", responsable.getDocumentoIdentificacion(), "El documento de identificación debería ser '123456789'.");
    }

    @Test
    public void testGetCorreoElectronico() {
        assertEquals("carlos.gutierrez@example.com", responsable.getCorreoElectronico(), "El correo electrónico debería ser 'carlos.gutierrez@example.com'.");
    }

    @Test
    public void testGetTelefono() {
        assertEquals("555-1234", responsable.getTelefono(), "El teléfono debería ser '555-1234'.");
    }

    @Test
    public void testGetDireccion() {
        assertEquals("Calle Falsa 123", responsable.getDireccion(), "La dirección debería ser 'Calle Falsa 123'.");
    }

    @Test
    public void testSetNombreCompleto() {
        responsable.setNombreCompleto("Laura Rodriguez");
        assertEquals("Laura Rodriguez", responsable.getNombreCompleto(), "El nombre completo debería actualizarse a 'Laura Rodriguez'.");
    }

    @Test
    public void testSetDocumentoIdentificacion() {
        responsable.setDocumentoIdentificacion("987654321");
        assertEquals("987654321", responsable.getDocumentoIdentificacion(), "El documento de identificación debería actualizarse a '987654321'.");
    }

    @Test
    public void testSetCorreoElectronico() {
        responsable.setCorreoElectronico("laura.rodriguez@example.com");
        assertEquals("laura.rodriguez@example.com", responsable.getCorreoElectronico(), "El correo electrónico debería actualizarse a 'laura.rodriguez@example.com'.");
    }

    @Test
    public void testSetTelefono() {
        responsable.setTelefono("555-4321");
        assertEquals("555-4321", responsable.getTelefono(), "El teléfono debería actualizarse a '555-4321'.");
    }

    @Test
    public void testSetDireccion() {
        responsable.setDireccion("Avenida Siempre Viva 742");
        assertEquals("Avenida Siempre Viva 742", responsable.getDireccion(), "La dirección debería actualizarse a 'Avenida Siempre Viva 742'.");
    }
}
