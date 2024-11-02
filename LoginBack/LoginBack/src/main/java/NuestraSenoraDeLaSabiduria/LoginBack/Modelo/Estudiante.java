package NuestraSenoraDeLaSabiduria.LoginBack.Modelo;
import lombok.Data;

@Data
public class Estudiante  {
    private String codigo;
    private String nombreCompleto;
    private String curso;
    private String anoAcademico;
    private ResponsableEconomico responsableEconomico;

    private Estudiante(Builder builder) {
        this.codigo = builder.codigo;
        this.nombreCompleto = builder.nombreCompleto;
        this.curso = builder.curso;
        this.anoAcademico = builder.anoAcademico;
        this.responsableEconomico = builder.responsableEconomico;
    }

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

        public Builder nombreCompleto(String nombreCompleto) {
            this.nombreCompleto = nombreCompleto;
            return this;
        }

        public Builder curso(String curso) {
            this.curso = curso;
            return this;
        }

        public Builder anoAcademico(String anoAcademico) {
            this.anoAcademico = anoAcademico;
            return this;
        }

        public Builder responsableEconomico(ResponsableEconomico responsable) {
            this.responsableEconomico = responsable;
            return this;
        }

        public Estudiante build() {
            return new Estudiante(this);
        }
    }
}
