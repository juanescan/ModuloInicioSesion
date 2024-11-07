package NuestraSenoraDeLaSabiduria.LoginBack.Modelo;

import lombok.Getter;
import lombok.Setter;

/**
 * ResponsableEconomicoDTO
 * Clase que representa un ResponsableEconomicoDTO
 * @version 1.0
 * @Autor Diego Chicuazuque
 *
 */
@Getter
@Setter
public class ResponsableEconomicoDTO {

  private String nombreCompleto;
  private String documentoIdentificacion;
  private String correoElectronico;
  private String telefono;
  private String direccion;

  public ResponsableEconomicoDTO(
    String nombreCompleto,
    String documentoIdentificacion,
    String correoElectronico,
    String telefono,
    String direccion
  ) {
    this.nombreCompleto = nombreCompleto;
    this.documentoIdentificacion = documentoIdentificacion;
    this.correoElectronico = correoElectronico;
    this.telefono = telefono;
    this.direccion = direccion;
  }
}
