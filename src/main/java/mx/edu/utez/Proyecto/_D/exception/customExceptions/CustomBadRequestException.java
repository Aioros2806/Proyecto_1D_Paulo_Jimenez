package mx.edu.utez.Proyecto._D.exception.customExceptions;

public class CustomBadRequestException extends RuntimeException {
    public CustomBadRequestException(String mensaje){
        super(mensaje);
    }
}
