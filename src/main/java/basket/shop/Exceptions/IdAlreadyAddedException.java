package basket.shop.Exceptions;

public class IdAlreadyAddedException extends RuntimeException{
    public IdAlreadyAddedException(String message){
        super(message);
    }
}