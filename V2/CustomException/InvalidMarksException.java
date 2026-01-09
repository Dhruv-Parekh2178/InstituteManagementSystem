package V2.CustomException;

public class InvalidMarksException extends RuntimeException{
    public InvalidMarksException(String message){
        super(message);
    }
}
