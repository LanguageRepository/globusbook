package exception;

/**
 * @author v.bublik.
 * Class for working with exceptions caused by services.
 */
public class ServiceException extends Exception{

    public ServiceException() {}

    public ServiceException(String message) {
        super(message);
    }

}
