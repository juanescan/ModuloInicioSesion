package NuestraSenoraDeLaSabiduria.LoginBack.Modelo;

import lombok.Data;
/**
 * Clase que representa un responsable económico de un estudiante
 **/

@Data
public class ResponsableEconomico {
    private String nombreCompleto;
    private String documentoIdentificacion;
    private String relacionEstudiante;
    private String correoElectronico;
    private String telefono;
    private String direccion;

    /**
     * Constructor de la clase
     * @param builder
     */
    private ResponsableEconomico(Builder builder) {
        this.nombreCompleto = builder.nombreCompleto;
        this.documentoIdentificacion = builder.documentoIdentificacion;
        this.relacionEstudiante = builder.relacionEstudiante;
        this.correoElectronico = builder.correoElectronico;
        this.telefono = builder.telefono;
        this.direccion = builder.direccion;
    }
    /**
     * Método que crea un objeto de la clase ResponsableEconomico
     * @return ResponsableEconomico
     */
    public static class Builder {
        private String nombreCompleto;
        private String documentoIdentificacion;
        private String relacionEstudiante;
        private String correoElectronico;
        private String telefono;
        private String direccion;

        public Builder(String codigoResponsable, String nombreCompleto, String documentoIdentificacion, String relacionEstudiante, String correoElectronico, String telefono, String direccion) {
            this.nombreCompleto = nombreCompleto;
            this.documentoIdentificacion = documentoIdentificacion;
            this.relacionEstudiante = relacionEstudiante;
            this.correoElectronico = correoElectronico;
            this.telefono = telefono;
            this.direccion = direccion;
        }

        public Builder nombreCompleto(String nombreCompleto) {
            this.nombreCompleto = nombreCompleto;
            return this;
        }

        public Builder documentoIdentificacion(String documentoIdentificacion) {
            this.documentoIdentificacion = documentoIdentificacion;
            return this;
        }

        public Builder relacionEstudiante(String relacionEstudiante) {
            this.relacionEstudiante = relacionEstudiante;
            return this;
        }

        public Builder correoElectronico(String correoElectronico) {
            this.correoElectronico = correoElectronico;
            return this;
        }

        public Builder telefono(String telefono) {
            this.telefono = telefono;
            return this;
        }

        public Builder direccion(String direccion) {
            this.direccion = direccion;
            return this;
        }

        public ResponsableEconomico build() {
            return new ResponsableEconomico(this);
        }
    }
}
