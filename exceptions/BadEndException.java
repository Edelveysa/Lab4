package exceptions;

public class BadEndException extends Exception{
    public BadEndException(){
        super("Их тут нет.");
    }
}
