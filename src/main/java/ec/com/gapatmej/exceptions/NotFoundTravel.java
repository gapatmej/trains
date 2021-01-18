package ec.com.gapatmej.exceptions;

public class NotFoundTravel extends Exception{
    private static final String MESSAGE = "NO SUCH ROUTE ";

    public NotFoundTravel(){
        super(MESSAGE);
    }

}
