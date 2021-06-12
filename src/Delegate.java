import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class Delegate {
    //INSTANCE VARIABLES
    private Data info;
    private Menu menuPrincipal, menuSecundario, menuEquipas, menuJogos, menuCriacao;
    private Scanner scannerIn;

    public Delegate(Data info){
        this.info = info;
        this.menuPrincipal = new Menu( new String[] {"Jogadores","Equipas","Jogos","Efetuar Transferência","Simular um Jogo","Modo Criação",
                "Salvar Dados","Carregar Dados","Eliminar Dados"} );
        this.menuSecundario = new Menu(new String[] {"Mais Informação"});
        this.menuEquipas = new Menu(new String[] {"Schumann Athletic","Stravinsky Athletic","Bach F. C.","Debussy Athletic",
                "Mozart F. C.", "Handel Athletic", "Mendelssohn F. C.", "Sporting Club Shostakovich", "Sporting Club Schubert",
                "Sporting Club Chopin", "Mahler Athletic", "Bartok F. C.", "Beethoven F. C.", "Sporting Club Prokofiev", "Vivaldi F. C.",
                "Sporting Club Dvorak", "Brahms F. C.", "Wagner Athletic"});
        this.scannerIn = new Scanner(System.in);
        this.menuCriacao = new Menu(new String[] {"Criar Jogador","Criar Equipa","Criar Jogo"});
    }

    public void run() throws IOException, ClassNotFoundException {
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
                    listarJogos_upgraded2();
                    break;
                case 6:
                    System.out.println("\nMENU DE PERSONALIZAÇÃO\nPor favor, escolha uma opção:");
                    this.menuCriacao.executa();
                    switch (this.menuCriacao.getOpcao()) {
                        case 1:
                            criarJogador();
                            break;
                        case 2:
                            criarEquipa();
                            break;
                        case 3:
                            criarJogo();
                            break;
                    }
                    break;
                case 7:
                    this.info.guardaEstado("save.tmp");
                    System.out.println("Salvaguarda de dados completa.\n");
                    break;
                case 8:
                    this.info = Data.carregaEstado("save.tmp");
                    System.out.println("Carregamento de dados efetuado.\n");
                    break;
                case 9:
                    System.out.println("Tem a certeza que pretende eliminar todos os dados?\n");
                    this.info.deleteEstado();
                    break;
            }
        } while (this.menuPrincipal.getOpcao() != 0);
        System.out.println("OBRIGADO :)");
    }

    public void listarJogadores() {
        for (Jogador j : info.getJogadores()){
            System.out.println(j.getNome());
            //System.out.println(j.toString());
        }
    }

    //se possível dar surround com try catch para evitar que last seja negativo (JogadorPerdidoException)
    public void listarJogadores_info() {
        for (Jogador j : info.getJogadores()){
            int last = j.getHistorial().size() - 1;
            System.out.println(j.getNome() + " (" + j.getClass().getName() + " , " + j.getHistorial().get(last).getNome() + ")");
            System.out.println(j.toString());
        }
    }

    public void listarEquipas() {
        for(Equipa e : info.getEquipas().values()) {
            System.out.println(e.getNome());
        }
    }

    public void listarEquipas_info() {
        for(Equipa e : info.getEquipas().values()) {
            System.out.println(e.toString());
        }
    }

    public void listarJogos() {
        for(Jogo jog : info.getJogos()) {
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

    public void listarJogos_upgraded2() {
        List<Jogo> jogos = this.info.getJogos();
        for(int i=0;i<jogos.size();i++){
            System.out.printf("%d - ",i);
            System.out.println(jogos.get(i).getCasa().getNome()+" VS "+jogos.get(i).getVisitante().getNome());
        }
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        jogos.get(n).startJogo();
    }


    public Integer[] hibilitiesAUX() {
        Scanner hab = new Scanner(System.in);
        String habilidades = hab.nextLine();
        String[] hab_split = habilidades.split("\\s+");
        Integer[] converted = new Integer[8];
        for (int i = 0; i < hab_split.length; i++) converted[i] = Integer.parseInt(hab_split[i]);
        //hab.close();
        return converted;
    }

    public void criarJogador() {
        System.out.println("Qual é o número de camisola?\n");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();  // Consume newline left-over

        System.out.println("Qual é o nome do Jogador?\n");
        //Scanner s_nome = new Scanner((System.in));
        String nome = scan.nextLine();

        boolean titular = false;
        System.out.println("Joga como titular?\n");
        //Scanner s_t = new Scanner(System.in);
        String t = scan.nextLine();
        switch (t) {
            case "true":
            case "True":
                titular = true;
                break;
            case "false":
            case "False":
                titular = false;
                break;
        }

        System.out.println("Qual é o seu historial?\n");
        //Scanner h = new Scanner(System.in);
        String hist = scan.nextLine();
        String[] split = hist.split(",");
        //List<String> list = Arrays.asList(split);
        List<String> list = new ArrayList<>(Arrays.asList(split));
        ArrayList<Equipa> historial = new ArrayList<>();
        for(Map.Entry<String,Equipa> entry : this.info.getEquipas().entrySet()) {
            String eq_nome = entry.getKey();
            Equipa eq_obj = entry.getValue();
            if (list.contains(eq_nome)) {
                historial.add(eq_obj);
                list.remove(eq_nome);
            }
        }

        if (!list.isEmpty()) {
            for (String s : list) {
                Equipa nova = new Equipa(s);
                historial.add(nova);
                //this.info.addEquipa(nova);
                //this.menuEquipas.addOpcao(s);
            }
        }

        System.out.println("É GuardaRedes, Avançado, Lateral, Médio ou Defesa?\n");
        //Scanner s = new Scanner(System.in);
        String role = scan.nextLine();

        //scope variables
        Integer[] converted;
        Scanner e;
        String equipa;
        int i;

        switch (role) {
            case "GuardaRedes":
                System.out.println("Quais of valores de velocidade, resistência, destreza, impulsão, cabeceamento, remate, passe e elasticidade por ordem?\n");
                converted = hibilitiesAUX();
                GuardaRedes gr = new GuardaRedes(n,nome,titular,historial,converted[0],converted[1],converted[2],converted[3],converted[4],converted[5],converted[6],converted[7]);
                this.info.addJogador(gr);
                System.out.println("Finalmente, qual é a sua equipa?\n");
                //e = new Scanner(System.in);
                equipa = scan.nextLine();
                i = 0;  //se for zero significa q não foi encontrada uma equipa com o nome especificado logo é necessário criar uma
                for(Map.Entry<String,Equipa> entry : this.info.getEquipas().entrySet()) {
                    String eq_nome = entry.getKey();
                    Equipa eq_obj = entry.getValue();
                    if ( equipa.equals(eq_nome) ) {eq_obj.addJogador(gr);i=1;}
                }
                if (i==0) {
                    Equipa nova = new Equipa(equipa);
                    nova.addJogador(gr);
                    this.info.addEquipa(nova);
                }
                //scan.close();
                break;
            case "Avançado":
                System.out.println("Quais of valores de velocidade, resistência, destreza, impulsão, cabeceamento, remate, passe e drible por ordem?\n");
                converted = hibilitiesAUX();
                Avançado a = new Avançado(n,nome,titular,historial,converted[0],converted[1],converted[2],converted[3],converted[4],converted[5],converted[6],converted[7]);
                this.info.addJogador(a);
                System.out.println("Finalmente, qual é a sua equipa?\n");
                e = new Scanner(System.in);
                equipa = e.nextLine();
                i = 0;  //se for zero significa q não foi encontrada uma equipa com o nome especificado logo é necessário criar uma
                for(Map.Entry<String,Equipa> entry : this.info.getEquipas().entrySet()) {
                    String eq_nome = entry.getKey();
                    Equipa eq_obj = entry.getValue();
                    if ( equipa.equals(eq_nome) ) {eq_obj.addJogador(a);i=1;}
                }
                if (i==0) {
                    Equipa nova = new Equipa(equipa);
                    nova.addJogador(a);
                    this.info.addEquipa(nova);
                }

                break;
            case "Lateral":
                System.out.println("Quais of valores de velocidade, resistência, destreza, impulsão, cabeceamento, remate, passe e cruzamento por ordem?\n");
                converted = hibilitiesAUX();
                Lateral l = new Lateral(n,nome,titular,historial,converted[0],converted[1],converted[2],converted[3],converted[4],converted[5],converted[6],converted[7]);
                this.info.addJogador(l);
                System.out.println("Finalmente, qual é a sua equipa?\n");
                e = new Scanner(System.in);
                equipa = e.nextLine();
                i = 0;  //se for zero significa q não foi encontrada uma equipa com o nome especificado logo é necessário criar uma
                for(Map.Entry<String,Equipa> entry : this.info.getEquipas().entrySet()) {
                    String eq_nome = entry.getKey();
                    Equipa eq_obj = entry.getValue();
                    if ( equipa.equals(eq_nome) ) {eq_obj.addJogador(l);i=1;}
                }
                if (i==0) {
                    Equipa nova = new Equipa(equipa);
                    nova.addJogador(l);
                    this.info.addEquipa(nova);
                }

                break;
            case "Medio":
            case "Médio":
                System.out.println("Quais of valores de velocidade, resistência, destreza, impulsão, cabeceamento, remate, passe e recuperação por ordem?\n");
                converted = hibilitiesAUX();
                Medio m = new Medio(n,nome,titular,historial,converted[0],converted[1],converted[2],converted[3],converted[4],converted[5],converted[6],converted[7]);
                this.info.addJogador(m);
                System.out.println("Finalmente, qual é a sua equipa?\n");
                e = new Scanner(System.in);
                equipa = e.nextLine();
                i = 0;  //se for zero significa q não foi encontrada uma equipa com o nome especificado logo é necessário criar uma
                for(Map.Entry<String,Equipa> entry : this.info.getEquipas().entrySet()) {
                    String eq_nome = entry.getKey();
                    Equipa eq_obj = entry.getValue();
                    if ( equipa.equals(eq_nome) ) {eq_obj.addJogador(m);i=1;}
                }
                if (i==0) {
                    Equipa nova = new Equipa(equipa);
                    nova.addJogador(m);
                    this.info.addEquipa(nova);
                }

                break;
            case "Defesa":
                System.out.println("Quais of valores de velocidade, resistência, destreza, impulsão, cabeceamento, remate, passe e corte por ordem?\n");
                converted = hibilitiesAUX();
                Defesa d = new Defesa(n,nome,titular,historial,converted[0],converted[1],converted[2],converted[3],converted[4],converted[5],converted[6],converted[7]);
                this.info.addJogador(d);
                System.out.println("Finalmente, qual é a sua equipa?\n");
                //e = new Scanner(System.in);
                equipa = scan.nextLine();
                i = 0;  //se for zero significa q não foi encontrada uma equipa com o nome especificado logo é necessário criar uma
                for(Map.Entry<String,Equipa> entry : this.info.getEquipas().entrySet()) {
                    String eq_nome = entry.getKey();
                    Equipa eq_obj = entry.getValue();
                    if ( equipa.equals(eq_nome) ) {eq_obj.addJogador(d);i=1;}
                }
                if (i==0) {
                    Equipa nova = new Equipa(equipa);
                    nova.addJogador(d);
                    this.info.addEquipa(nova);
                }

                break;
        }
    }

    public void criarEquipa() {
        System.out.println("Qual o nome da equipa?\n");
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        Equipa e = new Equipa(s);
        this.info.addEquipa(e);
        scan.close();
    }


    public void criarJogo() {
        int i=0;

        System.out.println("Qual é a equipa da casa?\n");
        Scanner scan = new Scanner(System.in);
        String Casa = scan.nextLine();

        System.out.println("Quais são as substituições da equipa da casa?\n"+"Jogadores que entram: ");
        //Scanner ec_scan = new Scanner(System.in);
        String ec = scan.nextLine();
        String[] ec_split = ec.split(" ");
        ArrayList<Integer> entraCasa = new ArrayList<>();
        entraCasa.add(Integer.parseInt(ec_split[0]));
        entraCasa.add(Integer.parseInt(ec_split[1]));
        entraCasa.add(Integer.parseInt(ec_split[2]));

        System.out.println("Jogadores que entram: ");
        //Scanner sc_scan = new Scanner(System.in);
        String sc = scan.nextLine();
        String[] sc_split = sc.split(" ");
        ArrayList<Integer> saiCasa = new ArrayList<>();
        saiCasa.add(Integer.parseInt(sc_split[0]));
        saiCasa.add(Integer.parseInt(sc_split[1]));
        saiCasa.add(Integer.parseInt(sc_split[2]));

        System.out.println("Qual é a equipa Visitante?\n");
        String Visitante = scan.nextLine();

        System.out.println("Quais são as substituições da equipa Visitante?\n"+"Jogadores que entram: ");
        String ev = scan.nextLine();
        String[] ev_split = ev.split(" ");
        ArrayList<Integer> entraVisitante = new ArrayList<>();
        entraVisitante.add(Integer.parseInt(ev_split[0]));
        entraVisitante.add(Integer.parseInt(ev_split[1]));
        entraVisitante.add(Integer.parseInt(ev_split[2]));

        System.out.println("Jogadores que entram: ");
        String sv = scan.nextLine();
        String[] sv_split = sv.split(" ");
        ArrayList<Integer> saiVisitante = new ArrayList<>();
        saiVisitante.add(Integer.parseInt(sv_split[0]));
        saiVisitante.add(Integer.parseInt(sv_split[1]));
        saiVisitante.add(Integer.parseInt(sv_split[2]));



        System.out.println("Quais os 11 titulares da equipa da Casa?\n");
        String tc = scan.nextLine();
        String[] tc_split = tc.split(" ");
        List<Integer> titularesCasa = new ArrayList<>();
        for (i = 0; i < tc_split.length; i++) {
            titularesCasa.add(Integer.parseInt(tc_split[i]));
        }

        System.out.println("Quais os 11 titulares da equipa Visitante?\n");
        String tv = scan.nextLine();
        String[] tv_split = tv.split(" ");
        List<Integer> titularesVisitante = new ArrayList<>();
        for (i = 0; i < tv_split.length; i++) {
            titularesVisitante.add(Integer.parseInt(tv_split[i]));
        }


        Equipa c = new Equipa();
        Equipa v = new Equipa();
        for(Map.Entry<String,Equipa> entry : this.info.getEquipas().entrySet()) {
            String eq_nome = entry.getKey();
            Equipa eq_obj = entry.getValue();
            if (Casa.equals(eq_nome)) {c=eq_obj;}
            if (Visitante.equals(eq_nome)) {v=eq_obj;}
        }

        Jogo j = new Jogo(c,v,entraCasa,saiCasa,entraVisitante,saiVisitante,0,0, LocalDate.now(),titularesCasa,titularesVisitante);
        this.info.addJogo(j);

        //scan.close();

        }

}