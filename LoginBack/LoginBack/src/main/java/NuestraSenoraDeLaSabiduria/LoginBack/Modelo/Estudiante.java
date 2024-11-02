package NuestraSenoraDeLaSabiduria.LoginBack.Modelo;
import lombok.Data;

/**
 * Clase que representa un estudiante
 **/
@Data
public class Estudiante  {
    private String codigo;
    private String nombreCompleto;
    private String curso;
    private String anoAcademico;
    private ResponsableEconomico responsableEconomico;

    /**
     * Constructor de la clase
     * @param builder
     */
    private Estudiante(Builder builder) {
        this.codigo = builder.codigo;
        this.nombreCompleto = builder.nombreCompleto;
        this.curso = builder.curso;
        this.anoAcademico = builder.anoAcademico;
        this.responsableEconomico = builder.responsableEconomico;
    }

    /**
     * Método que crea un objeto de la clase Estudiante
     * @return Estudiante
     */
    public static class Builder {
        private String codigo;
        private String nombreCompleto;
        private String curso;
        private String anoAcademico;
        private ResponsableEconomico responsableEconomico;

        public Builder(String codigo, String nombreCompleto, String curso, String anoAcademico, ResponsableEconomico responsable) {
            this.codigo = codigo;
            this.nombreCompleto = nombreCompleto;
            this.curso = curso;
            this.anoAcademico = anoAcademico;
            this.responsableEconomico = responsable;

        }

        /**
         * Método que asigna un valor al atributo codigo
         * @param codigo
         * @return Builder
         */
        public Builder codigo(String codigo) {
            this.codigo = codigo;
            return this;
        }

        /**
         * Método que asigna un valor al atributo nombreCompleto
         * @param nombreCompleto
         * @return Builder
         */
        public Builder nombreCompleto(String nombreCompleto) {
            this.nombreCompleto = nombreCompleto;
            return this;
        }

        /**
         * Método que asigna un valor al atributo curso
         * @param curso
         * @return Builder
         */
        public Builder curso(String curso) {
            this.curso = curso;
            return this;
        }

        /**
         * Método que asigna un valor al atributo anoAcademico
         * @param anoAcademico
         * @return Builder
         */
        public Builder anoAcademico(String anoAcademico) {
            this.anoAcademico = anoAcademico;
            return this;
        }

        /**
         * Método que asigna un valor al atributo responsableEconomico
         * @param responsable
         * @return Builder
         */
        public Builder responsableEconomico(ResponsableEconomico responsable) {
            this.responsableEconomico = responsable;
            return this;
        }

        /**
         * Método que crea un objeto de la clase Estudiante
         * @return Estudiante
         */
        public Estudiante build() {
            return new Estudiante(this);
        }
    }
}
