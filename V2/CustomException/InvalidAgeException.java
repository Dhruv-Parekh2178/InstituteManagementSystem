package V2.CustomException;

/**
 * Implementation of custom exception to  return that the age of the student,employee and teacher is  not in the range.
 *
 * @author dhruvparekh
 * @version 2.0
 */

public class InvalidAgeException extends RuntimeException{
    public InvalidAgeException(String message){
        super(message);
    }
}
