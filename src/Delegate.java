import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Delegate {
    //INSTANCE VARIABLES
    private Parser info;
    private Menu menuPrincipal, menuSecundario;
    private Scanner scannerIn;

    public Delegate(Parser info){
        this.info = info;
        this.menuPrincipal = new Menu( new String[] {"Jogadores","Equipas","Jogos"} );
        this.menuSecundario = new Menu(new String[] {""});
        this.scannerIn = new Scanner(System.in);
    }

    public void run() {
        do {
            this.menuPrincipal.executa();
            switch (this.menuPrincipal.getOpcao()) {
                case 1:
                    System.out.println("LISTA DOS JOGADORES \n");
                    listarJogadores();
                    break;
                case 2:
                    System.out.println("LISTA DAS EQUIPAS \n");
                    listarEquipas();
                    break;
                case 3:
                    System.out.println("LISTA DOS JOGOS \n");
                    listarJogos();
                    break;
            }
        } while (this.menuPrincipal.getOpcao() != 0);
    }

    public void listarJogadores() {
        for (Jogador j : info.jogadores.values()){
            System.out.println(j.getNome());
            System.out.println(j.toString());
        }
    }

    public void listarEquipas() {
        for(Equipa e : info.equipas.equipas.values()) {
            System.out.println(e.getNome());
        }
    }

    public void listarJogos() {
        for(Jogo jog : info.jogos) {
            System.out.println(jog.toString());
        }
    }


}