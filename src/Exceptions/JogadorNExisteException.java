package Exceptions;

public class JogadorNExisteException extends Exception {
    public JogadorNExisteException(){
        super();
    }

    public JogadorNExisteException(String s){
        super(s);
    }
}
