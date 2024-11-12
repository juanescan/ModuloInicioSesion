package NuestraSenoraDeLaSabiduria.LoginBack.Modelo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase que representa un estudiante de la institución educativa
 * @version 1.0
 * @Autor Diego Chicuazuque
 **/
@Getter
@Setter
@Document(collection = "usuarios")
@TypeAlias("Estudiante")
public class Estudiante extends Usuario {

  private String codigoEstudiante;
  private String curso;
  private String anoAcademico;
  private String responsableId;

  // Constructor privado para que solo el builder pueda crear la instancia
  private Estudiante(Builder builder) {
    super(builder.nombreUsuario, builder.contrasena, builder.nombreCompleto);
    this.codigoEstudiante = builder.codigoEstudiante;
    this.curso = builder.curso;
    this.anoAcademico = builder.anoAcademico;
    this.responsableId = builder.responsableId;
  }

  /*
   * Método que retorna los detalles del estudiante
   * @return String
   */
  @Override
  public String obtenerDetallesUsuario() {
    return (
      super.obtenerDetallesUsuario() +
      " - Código Estudiante: " +
      codigoEstudiante +
      " - Curso: " +
      curso +
      " - Año Académico: " +
      anoAcademico
    );
  }

  // Implementación del patrón Builder
  /**
   * Clase Builder para la creación de instancias de Estudiante
   */
  public static class Builder {

    private String nombreUsuario;
    private String contrasena;
    private String nombreCompleto;
    private String codigoEstudiante;
    private String curso;
    private String anoAcademico;
    private String responsableId;

    /**
     * Constructor de la clase Builder
     * @param id
     * @param nombreUsuario
     * @param contrasena
     * @param nombreCompleto
     */
    public Builder(
      String nombreUsuario,
      String contrasena,
      String nombreCompleto
    ) {
      this.nombreUsuario = nombreUsuario;
      this.contrasena = contrasena;
      this.nombreCompleto = nombreCompleto;
    }

    /*
     * Métodos para asignar valores a los atributos de la clase Estudiante
     * @param codigoEstudiante
     * @return Builder
     */
    public Builder codigoEstudiante(String codigoEstudiante) {
      this.codigoEstudiante = codigoEstudiante;
      return this;
    }

    /*
     * @param curso
     * @return Builder
     */
    public Builder curso(String curso) {
      this.curso = curso;
      return this;
    }

    /*
     * @param anoAcademico
     * @return Builder
     */
    public Builder anoAcademico(String anoAcademico) {
      this.anoAcademico = anoAcademico;
      return this;
    }

    /*
     * @param responsableId
     * @return Builder
     */
    public Builder responsableId(String responsableId) {
      this.responsableId = responsableId;
      return this;
    }

    /*
     * Método que crea una instancia de Estudiante
     * @return Estudiante
     */
    public Estudiante build() {
      return new Estudiante(this);
    }
  }
}
