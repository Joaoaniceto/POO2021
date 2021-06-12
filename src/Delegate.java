import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;
import Exceptions.*;

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

    public void run() throws IOException, ClassNotFoundException, JogadorPerdidoException, JogadorNExisteException {
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
                    listarEquipas_upgraded2();
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
                    this.info = Data.carregaEstado("Benfica.tmp");
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
    public void listarJogadores_info() throws JogadorPerdidoException {
        try {
            for (Jogador j : info.getJogadores()) {
                if (j.getHistorial().size() == 0) throw new JogadorPerdidoException();
                int last = j.getHistorial().size() - 1;
                System.out.println(j.getNome() + " (" + j.getClass().getName() + " , " + j.getHistorial().get(last).getNome() + ")");
                System.out.println(j.toString());
            }
        } catch (JogadorPerdidoException e){
            System.out.println("Jogador sem historial");
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

    public void listarEquipas_upgraded2() {
        int i;
        System.out.println("Indique a equipa com o jogador de saída.");

        Set<String> eq = this.info.getEquipas().keySet();
        List<String> equipas = new ArrayList<>(eq);
        //String[] n_eq = new String[equipas.size()];
        for(i=0;i<equipas.size();i++){
            System.out.printf("%d - ",i);
            System.out.println(equipas.get(i));
            //n_eq[i] = equipas.get(i);
        }
        System.out.println("Opção:");
        Scanner scan = new Scanner(System.in);
        int s = scan.nextInt();


        System.out.println("Indique a equipa com o jogador de entrada.");

        for(i=0;i<equipas.size();i++){
            System.out.printf("%d - ",i);
            System.out.println(equipas.get(i));
        }
        System.out.println("Opção:");
        int e = scan.nextInt();

        Equipa a = this.info.getEquipas().get(equipas.get(s));
        Equipa b = this.info.getEquipas().get(equipas.get(e));

        Scanner tf = new Scanner(System.in);
        System.out.println("\nIndique o número do Jogador");
        int n = tf.nextInt();

        while(a.getJogador(n) == null){
            System.out.println( "Não existe o jogador com o número" + n + "\nIndique o número do Jogador");
            n = tf.nextInt();
        }


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
        while(jogos.get(n) == null){
            System.out.println( "Não existe o jogo que selecionou" + "\nIndique outro jogo:");
            n = scan.nextInt();
        }
        //scan.close();
        jogos.get(n).startJogo();
    }


    public Integer[] hibilitiesAUX(Scanner scan) {
        try {

            String habilidades = scan.nextLine();

            String[] hab_split = habilidades.split("\\s+");

            Integer[] converted = new Integer[8];
            if (hab_split.length != 8) {
                throw new habmalcriadaException();
            }
            for (int i = 0; i < hab_split.length; i++) {
                converted[i] = Integer.parseInt(hab_split[i]);
                if (0 > converted[i] && converted[i] > 100) {
                  throw new habmalcriadaException();
                }


            }
            return converted;
        }catch (habmalcriadaException e){
            System.out.println("Todos os valores tem de estar entre 0 e 100. \nA string tem de conter 8 valores todos separados por espaços");
            return hibilitiesAUX(scan);
        }
        //hab.close();
    }
//num jogador
  private int numjogador(Scanner scan){
      System.out.println("Qual é o número de camisola?\n");

      int n = scan.nextInt();
      return n;

  }
  //nome do jogador
  private String nomejogador(Scanner scan){

      scan.nextLine();  // Consume newline left-over

      System.out.println("Qual é o nome do Jogador?\n");
      //Scanner s_nome = new Scanner((System.in));
      String nome = scan.nextLine();

      return nome;
  }
// se e titular
  private boolean titjogador(Scanner scan){

      boolean titular = false;
      System.out.println("Joga como titular?\n");
      //Scanner s_t = new Scanner(System.in);
      String t = scan.nextLine();
      switch (t) {
          case "true":
              titular = true;
              break;
          default:
              titular = false;
              break;
      }

      return titular;
  }
 // historial do jog
  private ArrayList<Equipa> histjogador(Scanner scan){

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

      return historial;
  }

  // get equipa jogador
    private void eqpJogador(Jogador gr,Scanner scan){

        String equipa = scan.nextLine();
        int i = 0;  //se for zero significa q não foi encontrada uma equipa com o nome especificado logo é necessário criar uma
        for (Map.Entry<String, Equipa> entry : this.info.getEquipas().entrySet()) {
            String eq_nome = entry.getKey();
            Equipa eq_obj = entry.getValue();
            if (equipa.equals(eq_nome)) {
                eq_obj.addJogador(gr);
                i = 1;
            }
        }
        if (i == 0) {
            Equipa nova = new Equipa(equipa);
            nova.addJogador(gr);
            this.info.addEquipa(nova);
        }

    }
 //posicao do jogador
  private void posijogador(int n,String nome,boolean titular,ArrayList<Equipa> historial,Scanner scan){
        try{


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
              converted = hibilitiesAUX(scan);
              GuardaRedes gr = new GuardaRedes(n, nome, titular, historial, converted[0], converted[1], converted[2], converted[3], converted[4], converted[5], converted[6], converted[7]);
              this.info.addJogador(gr);
              System.out.println("Finalmente, qual é a sua equipa?\n");
              eqpJogador(gr,scan);
              //scan.close();
              break;
          case "Avancado":
          case "Avançado":
              System.out.println("Quais of valores de velocidade, resistência, destreza, impulsão, cabeceamento, remate, passe e drible por ordem?\n");
              converted = hibilitiesAUX(scan);
              Avançado a = new Avançado(n, nome, titular, historial, converted[0], converted[1], converted[2], converted[3], converted[4], converted[5], converted[6], converted[7]);
              this.info.addJogador(a);
              System.out.println("Finalmente, qual é a sua equipa?\n");
              eqpJogador(a,scan);

              break;
          case "Lateral":
              System.out.println("Quais of valores de velocidade, resistência, destreza, impulsão, cabeceamento, remate, passe e cruzamento por ordem?\n");
              converted = hibilitiesAUX(scan);
              Lateral l = new Lateral(n, nome, titular, historial, converted[0], converted[1], converted[2], converted[3], converted[4], converted[5], converted[6], converted[7]);
              this.info.addJogador(l);
              System.out.println("Finalmente, qual é a sua equipa?\n");
              eqpJogador(l,scan);

              break;
          case "Medio":

              System.out.println("Quais of valores de velocidade, resistência, destreza, impulsão, cabeceamento, remate, passe e recuperação por ordem?\n");
              converted = hibilitiesAUX(scan);
              Medio m = new Medio(n, nome, titular, historial, converted[0], converted[1], converted[2], converted[3], converted[4], converted[5], converted[6], converted[7]);
              this.info.addJogador(m);
              System.out.println("Finalmente, qual é a sua equipa?\n");
              eqpJogador(m,scan);

              break;
          case "Defesa":
              System.out.println("Quais of valores de velocidade, resistência, destreza, impulsão, cabeceamento, remate, passe e corte por ordem?\n");
              converted = hibilitiesAUX(scan);
              Defesa d = new Defesa(n, nome, titular, historial, converted[0], converted[1], converted[2], converted[3], converted[4], converted[5], converted[6], converted[7]);
              this.info.addJogador(d);
              System.out.println("Finalmente, qual é a sua equipa?\n");
              eqpJogador(d,scan);
              break;
          default:
              throw new habmalcriadaException();


      }
            System.out.println("Jogador criado com sucesso");
      } catch (habmalcriadaException e){
            System.out.println("Posição inválido tente Novamente\n");
            posijogador(n,nome, titular,historial,scan);
        }

  }

    public void criarJogador() {
        Scanner scan = new Scanner(System.in);

        int n = numjogador(scan);
        String nome = nomejogador(scan);

        boolean titular = titjogador(scan);

        ArrayList<Equipa> historial = histjogador(scan);
        System.out.println("É GuardaRedes, Avançado, Lateral, Médio ou Defesa?\n");
        posijogador(n,nome,titular,historial,scan);

    }

    public void criarEquipa() {
        System.out.println("Qual o nome da equipa?\n");
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        Equipa e = new Equipa(s);
        this.info.addEquipa(e);

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

        System.out.println("Jogadores que saem: ");
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

        System.out.println("Jogadores que saem: ");
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