import java.util.HashMap;
import java.util.List;

public class Fase {
    private int golosVisitante;
    private int golosCasa;
    private int equipaAtacante; //caso seja 1 é equipa da casa, caso seja 0 é visitante
    private int fase;
    private int time;
    private Equipa equipaCasa;
    private Equipa equipaVisitante;
    private Jogador bola;
    private HashMap<String, List<Integer>> modeloCasa;
    private HashMap<String,List<Integer>> modeloVisitante;

    public Fase(){
        this.equipaCasa = new Equipa();
        this.equipaVisitante = new Equipa();
        this.equipaAtacante = 0;
        this.golosCasa = 0;
        this.golosVisitante = 0;
        this.fase = 1;
        this.time = 0;
        this.modeloCasa = new HashMap<>();
        this.modeloVisitante = new HashMap<>();

    }
    public Fase(Equipa casa,Equipa visitante,int golos,int equipa, int fase,Jogador a,HashMap<String,List<Integer>> mdc, HashMap<String,List<Integer>> mv){
        this.equipaCasa = casa;
        this.equipaVisitante = visitante;
        this.golosCasa = golos;
        this.golosVisitante = golos;
        this.equipaAtacante = equipa;
        this.fase = fase;
        this.time = 0;
        this.bola = a;
        this.modeloCasa = mdc;
        this.modeloVisitante = mv;
    }

    public int getGolosCasa(){return this.golosCasa;}
    public int getGolosVisitante(){return this.golosVisitante;}
    public int getEquipaAtacante(){return this.equipaAtacante;}
    public int getFase(){return this.fase;}
    public int getTime(){return this.time;}
    public Jogador getJogador(){return this.bola.clone();}
    public HashMap<String,List<Integer>> getModeloCasa(){ return this.modeloCasa;}
    public HashMap<String,List<Integer>> getModeloVisitante(){ return this.modeloVisitante;}
    public void setGolosCasa( int value){this.golosCasa = value; }
    public void setGolosVisitante(int value){this.golosVisitante = value;}
    public void setTime(int value){this.time = value;}
    public void setJogador(Jogador value){this.bola = value;}
    public void setmodelocasa(HashMap<String,List<Integer>> mdc){this.modeloCasa = mdc;}
    public void setModeloVisitante(HashMap<String,List<Integer>> mdc){this.modeloVisitante = mdc;}
    public void result(){
        System.out.println("Jogo terminou com o resultado: \n" + this.equipaCasa.getNome() + " : " + this.golosCasa + "\n"+ this.equipaVisitante.getNome() + " : " + this.golosVisitante );

    }
    public void getState(int equipaAtacante,int fase,Jogador bola){
        double luck = Math.random();
        String equipa =  this.equipaAtacante==1 ? equipaCasa.getNome() : equipaVisitante.getNome();

        switch(bola.getClass().getName()){

            case "Medio":
               double luckME = Math.random() * bola.gethabilidade("Medio");
               if ( luckME > 20) {
                    // caso passe
                    Equipa nova = this.equipaAtacante == 1 ? equipaCasa : equipaVisitante;
                    HashMap<String, List<Integer>> a = this.equipaAtacante == 1 ? modeloCasa : modeloVisitante;
                   this.fase  += 1;
                   Jogador recetordebola = new Medio();
                   recetordebola = nova.getJogador(a.get("Avançado").get(0));
                   System.out.println(bola.getNome() + "passa para" +  recetordebola.getNome());
                   this.bola = recetordebola;
               }else{
                   //caso perde a bola
                   this.equipaAtacante = 1 - this.equipaAtacante;
                   Equipa nova = this.equipaAtacante == 1 ? equipaCasa : equipaVisitante;
                   HashMap<String, List<Integer>> a = this.equipaAtacante == 1 ? modeloCasa : modeloVisitante;
                    Jogador roubou = nova.getJogador(a.get("Medio").get(0));
                   System.out.println(bola.getNome() + "perdeu a bola para" +  roubou.getNome());
                   this.bola = roubou;
               }
                break;

            case "Avançado":
                double luckAv = Math.random() * bola.gethabilidade("Avançado");
                if ( luckAv > 20) {
                    // caso em que o avançado passa por o defesa
                    Equipa nova =  (1 - this.equipaAtacante) == 1 ? equipaCasa : equipaVisitante;
                    HashMap<String, List<Integer>> a = (1-this.equipaAtacante) == 1 ? modeloCasa : modeloVisitante;
                      GuardaRedes guardaredes = new GuardaRedes( (GuardaRedes) nova.getJogador(a.get("GuardaRedes").get(0)));
                    if (Math.random() *100 > this.bola.getRem()){
                        // caso chute e falhe a bola é do guarda redes;
                        System.out.println( "Remate de " + bola.getNome() + " saiu completamente ao lado \n");
                        System.out.println( "Bola na mão do guarda redes \n");
                        this.bola = guardaredes;
                    } else {
                        // caso chute e acerte na baliza vamos ver se o guarda redes defende
                        if (Math.random()*100 > guardaredes.getElast()){
                            // caso defenda (falta a bola trocar de equipa)
                        this.bola = guardaredes;

                        } else {
                            //caso guardaredes nao defenda
                            System.out.println("E é goloooooo do " + this.bola);
                           // bola volta para o meio campo para um médio (falta implementar)

                        }

                    }
                }else{
                    // caso em que perde a bola
                    this.equipaAtacante = 1 - this.equipaAtacante;
                    Equipa nova = this.equipaAtacante == 1 ? equipaCasa : equipaVisitante;
                    HashMap<String, List<Integer>> a = this.equipaAtacante == 1 ? modeloCasa : modeloVisitante;
                    Jogador roubou = nova.getJogador(a.get("Defesa").get(0));
                    this.fase = 4 - this.fase;
                    System.out.println(bola.getNome() + "perdeu a bola para" +  roubou.getNome());
                    this.bola = roubou;
                }

                break;

            case "Lateral":
                System.out.println("lateral");
                break;

            case "GuardaRedes":
                System.out.println("GuardaRedes");
                break;

            case "Defesa":
                System.out.println("Defesa");
                break;


        }
      /*  switch(fase){
            case 3:
                if ( luck > 0.5){
                    System.out.println("Remate fortissimo!!!");
                    if (luck>0.75) {
                        this.fase = 2;
                        if (this.equipaAtacante==1){setGolosCasa(this.golosCasa +1 );} else setGolosVisitante(this.golosVisitante + 1);
                        System.out.println("E é Goloooooooo do " + equipa);
                    } else {
                        System.out.println("Grande defesa do Guarda redes do" + equipa);
                        System.out.println("Guarda redes passa a bola para o defesa mais isolado" );
                        this.fase = 1;
                    }
                } else {
                    this.equipaAtacante = 1- this.equipaAtacante;
                    this.fase = 1;
                    System.out.println("bola foi cortada na área defensiva e segue contra-ataque do" + equipa);
                }
                break;
            case 2:
                if (luck >0.5){
                    this.fase+=1;
                    System.out.println(equipa + " segue com a bola para a zona de perigo" );
                } else {
                    this.equipaAtacante = 1- equipaAtacante;
                    System.out.println("bola cortada no meio campo ,segue contra-ataque do " + equipa);
                }
                break;
            case 1:
                if (luck >0.5){
                    this.fase+=1;
                    System.out.println( equipa + " segue com a bola para o meio campo" );

                } else {
                    this.equipaAtacante = 1- this.equipaAtacante;
                    this.fase=3;
                    System.out.println("bola foi cortada e segue contra-ataque do" + equipa);
                }
                break;

        }
       */
    }

    private double luck() {
        double habC = this.equipaCasa.gethabilidades();
        double habD = this.equipaVisitante.gethabilidades();



        return 0.0;
    }

}