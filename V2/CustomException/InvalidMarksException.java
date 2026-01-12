package V2.CustomException;

/**
 *  Implementation of custom exception to return that the marks of the student is  not in the range.
 *
 * @author dhruvparekh
 * @version 2.0
 */

public class InvalidMarksException extends RuntimeException{
    public InvalidMarksException(String message){
        super(message);
    }
}
