package NuestraSenoraDeLaSabiduria.LoginBack.Modelo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase que representa un responsable económico de un estudiante
 * @version 1.0
 * @Autor Diego Chicuazuque
 **/

@Getter
@Setter
@Builder
@Document(collection = "responsablesEconomicos")
public class ResponsableEconomico {

  private String nombreCompleto;
  private String documentoIdentificacion;
  private String correoElectronico;
  private String telefono;
  private String direccion;

  /*
   * Método que retorna los detalles del responsable económico
   * @return String
   */
  public String obtenerDetallesResponsableEconomico() {
    return (
      "Nombre Completo: " +
      nombreCompleto +
      " - Documento Identificación: " +
      documentoIdentificacion +
      " - Correo Electrónico: " +
      correoElectronico +
      " - Teléfono: " +
      telefono +
      " - Dirección: " +
      direccion
    );
  }
}
