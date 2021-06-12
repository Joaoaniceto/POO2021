package Exceptions;

public class JogadorPerdidoException extends Exception {
    public JogadorPerdidoException(){
        super();
    }
    public JogadorPerdidoException(String g){
        super(g);
    }
}
