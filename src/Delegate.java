import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Delegate {
    //INSTANCE VARIABLES
    private Data info;
    private Menu menuPrincipal, menuSecundario, menuEquipas, menuJogos;
    private Scanner scannerIn;

    public Delegate(Data info){
        this.info = info;
        this.menuPrincipal = new Menu( new String[] {"Jogadores","Equipas","Jogos","Efetuar Transferência","Simular um Jogo"} );
        this.menuSecundario = new Menu(new String[] {"Mais Informação"});
        this.menuEquipas = new Menu(new String[] {"Schumann Athletic","Stravinsky Athletic","Bach F. C.","Debussy Athletic",
                "Mozart F. C.", "Handel Athletic", "Mendelssohn F. C.", "Sporting Club Shostakovich", "Sporting Club Schubert",
                "Sporting Club Chopin", "Mahler Athletic", "Bartok F. C.", "Beethoven F. C.", "Sporting Club Prokofiev", "Vivaldi F. C.",
                "Sporting Club Dvorak", "Brahms F. C.", "Wagner Athletic"});
        this.menuJogos = new Menu(new String[] {
                "Sporting Club Shostakovich VS Mendelssohn F. C.", "Mozart F. C. VS Sporting Club Dvorak", "Debussy Athletic  VS Stravinsky Athletic" });
        this.scannerIn = new Scanner(System.in);
    }

    public void run() {
        do {
            this.menuPrincipal.executa();
            switch (this.menuPrincipal.getOpcao()) {
                case 1:
                    System.out.println("LISTA DOS JOGADORES \n");
                    listarJogadores();
                    this.menuSecundario.executa();
                    switch (this.menuSecundario.getOpcao()) {
                        case 1:
                            listarJogadores_info();
                            break;
                    }
                    break;
                case 2:
                    System.out.println("LISTA DAS EQUIPAS \n");
                    listarEquipas();
                    this.menuSecundario.executa();
                    switch (this.menuSecundario.getOpcao()) {
                        case 1:
                            listarEquipas_info();
                            break;
                    }

                    break;
                case 3:
                    System.out.println("LISTA DOS JOGOS \n");
                    listarJogos();
                    break;
                case 4:
                    listarEquipas_upgraded();
                    break;
                case 5:
                    System.out.println("\nBEM-VINDO À SIMULAÇÃO DE JOGOS \nPor favor, escolha uma jogo:");
                    listarJogos_upgraded();
                    break;
            }
        } while (this.menuPrincipal.getOpcao() != 0);
        System.out.println("OBRIGADO :)");
    }

    public void listarJogadores() {
        for (Jogador j : info.jogadores){
            System.out.println(j.getNome());
            //System.out.println(j.toString());
        }
    }

    //se possível dar surround com try catch para evitar que last seja negativo (JogadorPerdidoException)
    public void listarJogadores_info() {
        for (Jogador j : info.jogadores){
            int last = j.getHistorial().size() - 1;
            System.out.println(j.getNome() + " (" + j.getClass().getName() + " , " + j.getHistorial().get(last).getNome() + ")");
            System.out.println(j.toString());
        }
    }

    public void listarEquipas() {
        for(Equipa e : info.equipas.values()) {
            System.out.println(e.getNome());
        }
    }

    public void listarEquipas_info() {
        for(Equipa e : info.equipas.values()) {
            System.out.println(e.toString());
        }
    }

    public void listarJogos() {
        for(Jogo jog : info.jogos) {
            System.out.println(jog.toString());
        }
    }

    public void listarEquipas_upgraded() {
        String equipaS = null;
        String equipaE = null;
        int n;

        System.out.println("\nIndique a Equipa com jogador de saida");
        this.menuEquipas.executa();
        switch (this.menuEquipas.getOpcao()){
            case 1:
                equipaS = menuEquipas.getOpcoes().get(0);
                break;
            case 2:
                equipaS = menuEquipas.getOpcoes().get(1);
                break;
            case 3:
                equipaS = menuEquipas.getOpcoes().get(2);
                break;
            case 4:
                equipaS = menuEquipas.getOpcoes().get(3);
                break;
            case 5:
                equipaS = menuEquipas.getOpcoes().get(4);
                break;
            case 6:
                equipaS = menuEquipas.getOpcoes().get(5);
                break;
            case 7:
                equipaS = menuEquipas.getOpcoes().get(6);
                break;
            case 8:
                equipaS = menuEquipas.getOpcoes().get(7);
                break;
            case 9:
                equipaS = menuEquipas.getOpcoes().get(8);
                break;
            case 10:
                equipaS = menuEquipas.getOpcoes().get(9);
                break;
            case 11:
                equipaS = menuEquipas.getOpcoes().get(10);
                break;
            case 12:
                equipaS = menuEquipas.getOpcoes().get(11);
                break;
            case 13:
                equipaS = menuEquipas.getOpcoes().get(12);
                break;
            case 14:
                equipaS = menuEquipas.getOpcoes().get(13);
                break;
            case 15:
                equipaS = menuEquipas.getOpcoes().get(14);
                break;
            case 16:
                equipaS = menuEquipas.getOpcoes().get(15);
                break;
            case 17:
                equipaS = menuEquipas.getOpcoes().get(16);
                break;
            case 18:
                equipaS = menuEquipas.getOpcoes().get(17);
                break;
        }

        System.out.println("\nIndique a Equipa com jogador de entrada");
        this.menuEquipas.executa();
        switch (this.menuEquipas.getOpcao()){
            case 1:
                equipaE = menuEquipas.getOpcoes().get(0);
                break;
            case 2:
                equipaE = menuEquipas.getOpcoes().get(1);
                break;
            case 3:
                equipaE = menuEquipas.getOpcoes().get(2);
                break;
            case 4:
                equipaE = menuEquipas.getOpcoes().get(3);
                break;
            case 5:
                equipaE = menuEquipas.getOpcoes().get(4);
                break;
            case 6:
                equipaE = menuEquipas.getOpcoes().get(5);
                break;
            case 7:
                equipaE = menuEquipas.getOpcoes().get(6);
                break;
            case 8:
                equipaE = menuEquipas.getOpcoes().get(7);
                break;
            case 9:
                equipaE = menuEquipas.getOpcoes().get(8);
                break;
            case 10:
                equipaE = menuEquipas.getOpcoes().get(9);
                break;
            case 11:
                equipaE = menuEquipas.getOpcoes().get(10);
                break;
            case 12:
                equipaE = menuEquipas.getOpcoes().get(11);
                break;
            case 13:
                equipaE = menuEquipas.getOpcoes().get(12);
                break;
            case 14:
                equipaE = menuEquipas.getOpcoes().get(13);
                break;
            case 15:
                equipaE = menuEquipas.getOpcoes().get(14);
                break;
            case 16:
                equipaE = menuEquipas.getOpcoes().get(15);
                break;
            case 17:
                equipaE = menuEquipas.getOpcoes().get(16);
                break;
            case 18:
                equipaE = menuEquipas.getOpcoes().get(17);
                break;
        }

        Scanner tf = new Scanner(System.in);
        System.out.println("\nIndique o número do Jogador");
        n = tf.nextInt();
        Equipa a = info.getEquipas().get(equipaS);
        Equipa b = info.getEquipas().get(equipaE);

        a.transferenciaJogador(b,a.getJogador(n));

    }


    public void listarJogos_upgraded() {
        List<Jogo> jogos = this.info.getJogos();
        this.menuJogos.executa();
        switch (this.menuJogos.getOpcao()){
            case 1:
                jogos.get(0).startJogo();
                break;
            case 2:
                jogos.get(1).startJogo();
                break;
            case 3:
                jogos.get(2).startJogo();
                break;
        }

    }


}