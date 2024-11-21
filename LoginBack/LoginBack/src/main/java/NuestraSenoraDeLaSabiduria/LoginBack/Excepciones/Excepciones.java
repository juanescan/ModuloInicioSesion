package NuestraSenoraDeLaSabiduria.LoginBack.Excepciones;
/**
 * Custom exception class for handling specific application errors.
 *
 * @version 1.0
 * @Author Felipe Martinez
 */
public class Excepciones extends Exception {
    /**
     * Error message indicating an error.
     */
    public static final String USUARIO_EXISTENTE = "El usuario ya existe";
    public static final String RESPONSABLE_INVALIDO = "El responsable no es valido";
    public static final String LOGIN_INVALIDO = "El login no es valido los datos no son validos";
    public static final String USUARIO_INEXISTENTE = "El usuario no existe";
    public static final String ELEMENTO_NULO = "Este elemento no puede ser nulo: ";
    public static final String FORMATO_CORREO_INVALIDO = "El formato del correo no es valido";

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message
     */
    public Excepciones(String message) {
        super(message);
    }

    /**
     * Constructs a new exception with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause of the exception
     */
    public Excepciones(String message, Throwable cause) {
        super(message, cause);
    }
}