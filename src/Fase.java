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


        switch(bola.getClass().getName()){

            case "Medio":
               double luckME = Math.random() * bola.gethabilidade("Medio");
               if (this.fase == 4) System.out.println(  "Bola começa no meio campo nos pés de " + this.bola.getNomeReduzido()    );

               if ( luckME > 20) {
                    // caso passe
                   Equipa nova = this.equipaAtacante == 1 ? equipaCasa : equipaVisitante;
                   HashMap<String, List<Integer>> a = this.equipaAtacante == 1 ? modeloCasa : modeloVisitante;
                   if(Math.random() >0.5) { //passe para Avançado

                       this.fase += 1;
                       Avançado recetordebola = new Avançado((Avançado) nova.getJogador(a.get("Avançado").get(0)));

                       System.out.println(bola.getNomeReduzido() + " passa para " + recetordebola.getNomeReduzido());
                       this.bola = recetordebola;
                   } else{ // passe para lateral
                       Lateral latrec = new Lateral((Lateral) nova.getJogador(a.get("Lateral").get(0)));
                       System.out.println(this.bola.getNomeReduzido() + " passa a bola para " + latrec.getNomeReduzido());
                       this.bola = latrec;
                       this.fase = 2;
                   }
               }else{
                   //caso perde a bola
                   this.equipaAtacante = 1 - this.equipaAtacante;
                   Equipa nova = this.equipaAtacante == 1 ? equipaCasa : equipaVisitante;
                   HashMap<String, List<Integer>> a = this.equipaAtacante == 1 ? modeloCasa : modeloVisitante;
                   Medio roubou = new Medio( (Medio) nova.getJogador(a.get("Medio").get(0)) );
                   System.out.println(bola.getNomeReduzido() + " perdeu a bola para " +  roubou.getNomeReduzido());
                   this.bola = roubou;
                   this.fase = 2;
               }
                break;

            case "Avançado":
                double luckAv = Math.random() * bola.gethabilidade("Avançado");
                this.equipaAtacante = 1 - this.equipaAtacante;
                Equipa nova =  this.equipaAtacante == 1 ? equipaCasa : equipaVisitante;
                HashMap<String, List<Integer>> a = this.equipaAtacante == 1 ? modeloCasa : modeloVisitante;
                if ( luckAv > 20) {
                    // caso em que o avançado passa por o defesa
                    GuardaRedes guardaredes = new GuardaRedes( (GuardaRedes) nova.getJogador(a.get("GuardaRedes").get(0)));

                     if (this.fase == 5){
                    System.out.println(this.bola.getNomeReduzido() +  " consegue cabeceaaaaar " );
                       if (this.bola.getCab() * Math.random() > guardaredes.getDes() * Math.random()){
                           System.out.println(" Que Golaçoooooooo de " +  this.bola.getNomeReduzido());
                           Medio novo = new Medio((Medio) nova.getEquipa().get(a.get("Medio").get(0)));
                           this.bola = novo;
                           this.fase = 4;
                       } else {
                           System.out.println(" Grande defesa de " + guardaredes.getNomeReduzido());
                           this.bola = guardaredes;
                           this.fase = 1;
                       }
                     }
                    else if (Math.random() *100 > this.bola.getRem()){
                        // caso chute e falhe a bola é do guarda redes;
                        System.out.println( "Remate de " + bola.getNomeReduzido() + " saiu completamente ao lado ");
                        System.out.println( "Bola na mão do guarda redes ");
                        this.bola = guardaredes;
                    } else {
                        // caso chute e acerte na baliza vamos ver se o guarda redes defende
                        System.out.println( "Remate Fortissimo de " + bola.getNomeReduzido());
                        if (Math.random()*100 > guardaredes.getElast()){
                            System.out.println( "Mas grande defesa de " + guardaredes.getNomeReduzido());
                            this.bola = guardaredes;
                            this.fase = 1;

                        } else {
                            //caso guardaredes nao defenda
                            System.out.println("E é goloooooo do " + this.bola.getNomeReduzido());
                           // bola volta para o meio campo para um médio (falta implementar)
                            Medio meio = new Medio( (Medio) nova.getJogador(a.get("Medio").get(0)) );
                           this.bola =  meio;
                           this.fase = 4;
                            if ( (1-this.equipaAtacante) == 1){
                                this.golosCasa +=1;
                            } else {
                                this.golosVisitante +=1;
                            }
                        }

                    }
                }else{
                    // caso em que perde a bola
                    Defesa roubou = new Defesa((Defesa) nova.getJogador(a.get("Defesa").get(0)));
                    this.fase = 4 - this.fase;
                    System.out.println(bola.getNomeReduzido() + " perdeu a bola para " +  roubou.getNomeReduzido());
                    this.bola = roubou;
                }

                break;

            case "Lateral":
                Equipa atlateral =  this.equipaAtacante == 1 ? equipaCasa : equipaVisitante;
                HashMap<String, List<Integer>> modellar = this.equipaAtacante == 1 ? modeloCasa : modeloVisitante;
                double luckLT = Math.random() * bola.gethabilidade("GuardaRedes");
                switch (this.fase){
                    case 1:
                        //caso anda com a bola para a frente
                        if (luckLT>30){
                            System.out.println( this.bola.getNomeReduzido() + " Consegue avançar no terreno para o meio campo");
                            this.fase+=1;
                        }
                        //passa para defesa
                        else if (luckLT>20){
                           Defesa recebe = new Defesa((Defesa) atlateral.getEquipa().get(modellar.get("Defesa").get(0)));
                            System.out.println( this.bola.getNomeReduzido() + " faz passe interior para " + recebe.getNomeReduzido());
                            this.bola = recebe;
                       }
                        //caso em que perde a bola
                         else{
                            this.equipaAtacante = 1- this.equipaAtacante;
                             atlateral =  this.equipaAtacante == 1 ? equipaCasa : equipaVisitante;
                             modellar = this.equipaAtacante == 1 ? modeloCasa : modeloVisitante;
                             Lateral def = new Lateral((Lateral) atlateral.getEquipa().get(modellar.get("Lateral").get(0)));
                             System.out.println( this.bola.getNomeReduzido() + " perdeu a bola " + def.getNomeReduzido() + " na zona de perigo ");
                             this.fase = 3;

                        }
                        break;
                    case 2:
                        //caso anda com a bola para a frente
                        if (luckLT>30){
                            System.out.println( this.bola.getNomeReduzido() + " Consegue avançar no terreno para a zona de perigo");
                            this.fase+=1;
                        }
                        //passa para médio
                        else if (luckLT>20){
                            Medio rece = new Medio( (Medio) atlateral.getEquipa().get( modellar.get("Medio").get(0)));
                            System.out.println(this.bola.getNomeReduzido() + " faz um passe interior para " + rece.getNomeReduzido());
                            this.bola = rece;

                        }
                        //caso em que perde a bola
                        else{
                            this.equipaAtacante = 1- this.equipaAtacante;
                            atlateral =  this.equipaAtacante == 1 ? equipaCasa : equipaVisitante;
                            modellar = this.equipaAtacante == 1 ? modeloCasa : modeloVisitante;
                            Lateral cort = new Lateral((Lateral) atlateral.getEquipa().get(modellar.get("Lateral").get(0)));
                            System.out.println(this.bola.getNomeReduzido() + "perde a bola no meio campo para " + cort.getNomeReduzido());
                            this.bola = cort;


                        }
                        break;
                    case 3:
                        //caso faz cruzamento
                        if (luckLT>30){
                            Avançado cabeca = new Avançado( (Avançado) atlateral.getEquipa().get(modellar.get("Avançado").get(0)));
                            System.out.println(this.bola.getNomeReduzido() + " Faz Cruzamentoooo para " + cabeca.getNomeReduzido());
                            atlateral =  !(this.equipaAtacante == 1) ? equipaCasa : equipaVisitante;
                            modellar = !(this.equipaAtacante == 1) ? modeloCasa : modeloVisitante;
                            Defesa def = new Defesa((Defesa) atlateral.getEquipa().get(modellar.get("Defesa").get(0)));
                            // caso avançado consiga cabecear
                            if (Math.random() * cabeca.getCab() > Math.random() * def.getCab()){
                                this.fase = 5;
                                this.bola = cabeca;

                                //caso defesa consiga defender
                            }else {
                                this.bola = def;
                                this.equipaAtacante = 1- this.equipaAtacante;
                                System.out.println( this.bola.getNomeReduzido() + " consegue cortar a bola no ar");
                            }

                            //caso em que perde a bola
                        } else {
                            this.equipaAtacante = 1 - this.equipaAtacante;
                            atlateral =  this.equipaAtacante == 1 ? equipaCasa : equipaVisitante;
                            modellar = this.equipaAtacante == 1 ? modeloCasa : modeloVisitante;

                            Lateral cut = new Lateral((Lateral) atlateral.getEquipa().get(modellar.get("Lateral").get(0)));
                            System.out.println( this.bola.getNomeReduzido() + " perde a bola para " + cut.getNomeReduzido());
                            this.bola = cut;
                            this.fase = 1;

                        }

                        break;
                }
                break;

            case "GuardaRedes":
                double luckGr = Math.random() * bola.gethabilidade("GuardaRedes");
                Equipa ataque =  this.equipaAtacante == 1 ? equipaCasa : equipaVisitante;
                HashMap<String, List<Integer>> modeloataque = this.equipaAtacante == 1 ? modeloCasa : modeloVisitante;
                if ( luckGr > 20) {
                    // passar para médio por jogo de cabeça a funcionar
                    this.bola = new Medio( (Medio) ataque.getJogador(modeloataque.get("Medio").get(0)));
                    System.out.println("Guarda redes faz passe longo para " + this.bola.getNomeReduzido()  );
                    this.fase = 2;
                } else {
                    // passar para defesa

                    this.bola = new Defesa( (Defesa) ataque.getJogador(modeloataque.get("Defesa").get(0)));
                    this.fase = 1;
                    System.out.println("Guarda redes faz passe curto para " + this.bola.getNomeReduzido() );

                }
                break;

            case "Defesa":
                double luckDF = Math.random() * bola.gethabilidade("GuardaRedes");
                if(luckDF>20){
                    //Passar para médio
                    Equipa troca = this.equipaAtacante == 1 ? this.equipaCasa : this.equipaVisitante;
                    HashMap<String, List<Integer>> modelo = this.equipaAtacante == 1 ? this.modeloCasa : this.modeloVisitante;
                    if(Math.random() > 0.5) {
                        Medio recetor = new Medio((Medio) troca.getEquipa().get(modelo.get("Medio").get(0)));
                        System.out.println(this.bola.getNomeReduzido() + " passa a bola para " + recetor.getNomeReduzido());
                        this.bola = recetor;
                        this.fase++;
                    } else { //passe para lateral mais
                        Lateral rec = new Lateral((Lateral) troca.getEquipa().get(modelo.get("Lateral").get(0)));
                        System.out.println(this.bola.getNomeReduzido() + " passa a bola para " + rec.getNomeReduzido());
                        this.fase = 1;
                        this.bola = rec;
                    }
                } else{
                    //perde a bola
                    this.equipaAtacante = 1-this.equipaAtacante;
                    Equipa troca = this.equipaAtacante==1 ? this.equipaCasa : this.equipaVisitante;
                    HashMap<String,List<Integer>> modelo = this.equipaAtacante==1 ? this.modeloCasa : this.modeloVisitante;
                    this.fase = 4-this.fase;
                    Avançado intercetor = new Avançado((Avançado) troca.getEquipa().get(modelo.get("Avançado").get(0)));
                    this.bola = intercetor;
                    System.out.println("Bola foi roubada por " + this.bola.getNomeReduzido());


                }
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


}