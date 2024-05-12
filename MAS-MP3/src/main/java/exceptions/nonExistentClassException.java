package exceptions;

public class nonExistentClassException extends RuntimeException{

    public nonExistentClassException(String message) {
        super(message);
    }
}
