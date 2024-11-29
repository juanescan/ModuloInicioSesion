package NuestraSenoraDeLaSabiduria.LoginBack.Modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstudianteDTO extends UsuarioDTO {

  private String codigoEstudiante;
  private String curso;
  private String anoAcademico;
  private String responsableId;

  // Constructor
  public EstudianteDTO(
    String nombreUsuario,
    String contrasena,
    String nombreCompleto,
    String codigoEstudiante,
    String curso,
    String anoAcademico,
    String responsableId
  ) {
    super(nombreUsuario, contrasena, nombreCompleto);
    this.codigoEstudiante = codigoEstudiante;
    this.curso = curso;
    this.anoAcademico = anoAcademico;
    this.responsableId = responsableId;
  }
}
