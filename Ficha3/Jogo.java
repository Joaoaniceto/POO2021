
public class Jogo {
    private String visitado , visitante;
    private static final int por_iniciar = 0;
    private static final int decorrer = 1;
    private static final int terminado = -1;
    private int estado;
    private int golos_visitado , golos_visitante;

    public void startGame(){
        this.visitado = "Benfica";
        this.visitante = "Sporting";
        this.estado = decorrer;
        this.golos_visitado = 0;
        this.golos_visitante = 0;
    }

    public void endGame() {
        this.estado = terminado;
    }
}













