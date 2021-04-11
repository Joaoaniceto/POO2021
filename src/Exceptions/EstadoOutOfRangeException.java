package Exceptions;
/*template de exception para um metodo de input futuro,
a variavel de instancia estado da classe Jogo tem que
passar por um exception para confirmar se se trata de
int 0/1/-1. Vamos ter que criar uma função que capta
o input do utilizador.*/
public class EstadoOutOfRangeException extends Exception{

    public EstadoOutOfRangeException() {
        super();
    }

    public EstadoOutOfRangeException(String erro) {
        super(erro);
    }

}
