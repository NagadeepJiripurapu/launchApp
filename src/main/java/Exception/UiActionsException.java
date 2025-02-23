package Exception;

public class UiActionsException extends RuntimeException{
    public UiActionsException()
    {
        super();
    }
    public UiActionsException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
