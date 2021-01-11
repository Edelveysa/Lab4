package exceptions;

public class NoLegendException extends RuntimeException{

    public NoLegendException(){
        super("Никто не слышал легенду о драконе.");
    }

}
