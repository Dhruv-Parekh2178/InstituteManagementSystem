package V2.CustomException;

/**
 * Implementation of custom exception to return that the enter amount is not  valid. ( amount =< 0).
 *
 * @author dhruvparekh
 * @version 2.0
 */

public class InvalidAmountException extends RuntimeException{
    public InvalidAmountException(String message){
        super(message);
    }
}
