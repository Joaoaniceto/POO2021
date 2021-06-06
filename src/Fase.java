
public class Fase {
    private int golosVisitante;
    private int golosCasa;
    private int equipaAtacante; //caso seja 1 é equipa da casa, caso seja 0 é visitante
    private int fase;
    private int time;
    private Equipa equipaCasa;
    private Equipa equipaVisitante;

    public Fase(){
        this.equipaCasa = new Equipa();
        this.equipaVisitante = new Equipa();
        this.equipaAtacante = 0;
        this.golosCasa = 0;
        this.golosVisitante = 0;
        this.fase = 1;
        this.time = 0;
    }
    public Fase(Equipa casa,Equipa visitante,int golos,int equipa, int fase){
        this.equipaCasa = casa;
        this.equipaVisitante = visitante;
        this.golosCasa = golos;
        this.golosVisitante = golos;
        this.equipaAtacante = equipa;
        this.fase = fase;
        this.time = 0;
    }

    public int getGolosCasa(){return this.golosCasa;}
    public int getGolosVisitante(){return this.golosVisitante;}
    public int getEquipaAtacante(){return this.equipaAtacante;}
    public int getFase(){return this.fase;}
    public int getTime(){return this.time;}
    public void setGolosCasa( int value){this.golosCasa = value; }
    public void setGolosVisitante(int value){this.golosVisitante = value;}
    public void setTime(int value){this.time = value;}
    public void result(){
        System.out.println("Jogo terminou com o resultado: \n" + this.equipaCasa.getNome() + " : " + this.golosCasa + "\n"+ this.equipaVisitante.getNome() + " : " + this.golosVisitante );

    }
    public int getState(int equipaAtacante,int fase){
        double luck = Math.random();
        switch(fase){
            case 3:
                if ( luck > 0.5){
                    System.out.println("Remate fortissimo!!!");
                    if (luck>0.75) {
                        this.fase = 2;
                        if (this.equipaAtacante==1){setGolosCasa(this.golosCasa +1 );} else setGolosVisitante(this.golosVisitante + 1);
                        System.out.println("E é Goloooooooo do " + (this.equipaAtacante==1 ? equipaCasa.getNome() : equipaVisitante.getNome()));
                    } else {
                        System.out.println("Grande defesa do Guarda redes do" + (this.equipaAtacante==1 ? equipaCasa.getNome() : equipaVisitante.getNome()));
                        System.out.println("Guarda redes passa a bola para o defesa mais isolado" );
                        this.fase = 1;
                    }
                } else {
                    this.equipaAtacante = 1- this.equipaAtacante;
                    this.fase = 1;
                    System.out.println("bola foi cortada na área defensiva e segue contra-ataque do" + (this.equipaAtacante==1 ? equipaCasa.getNome() : equipaVisitante.getNome()));
                }
                break;
            case 2:
                if (luck >0.5){
                    this.fase+=1;
                    System.out.println((this.equipaAtacante==1 ? equipaCasa.getNome() : equipaVisitante.getNome()) + " segue com a bola para a zona de perigo" );
                } else {
                    this.equipaAtacante = 1- equipaAtacante;
                    System.out.println("bola cortada no meio campo ,segue contra-ataque do " + (this.equipaAtacante==1 ? equipaCasa.getNome() : equipaVisitante.getNome()));
                }
                break;
            case 1:
                if (luck >0.5){
                    this.fase+=1;
                    System.out.println( (this.equipaAtacante==1 ? equipaCasa.getNome() : equipaVisitante.getNome()) + " segue com a bola para o meio campo" );

                } else {
                    this.equipaAtacante = 1- this.equipaAtacante;
                    this.fase=3;
                    System.out.println("bola foi cortada e segue contra-ataque do" + (this.equipaAtacante==1 ? equipaCasa.getNome() : equipaVisitante.getNome()));
                }
                break;

        }
        return this.fase;
    }

    private double luck() {
        double habC = this.equipaCasa.gethabilidades();
        double habD = this.equipaVisitante.gethabilidades();



        return 0.0;
    }

}