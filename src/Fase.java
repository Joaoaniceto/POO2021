
public class Fase {
    private int golosAtacante;
    private int equipaAtacante;
    private int fase;

    public Fase(int golos,int equipa, int fase){
        this.golosAtacante = golos;
        this.equipaAtacante = equipa;
        this.fase = fase;
    }

    public int getGolosAtacante(){return this.golosAtacante;}
    public int getEquipaAtacante(){return this.equipaAtacante;}
    public int getFase(){return this.fase;}

    public int getState(int equipaAtacante,int fase){
        switch(fase){
            case 3:
                if (Math.random() >0.5){fase = 2;golosAtacante+=1;} else {
                    equipaAtacante = 1- equipaAtacante;fase = 2;
                }
                break;
            case 2:
                if (Math.random() >0.5){fase+=1;} else {
                    equipaAtacante = 1- equipaAtacante;
                }
                break;
            case 1:
                if (Math.random() >0.5){fase+=1;} else {
                    equipaAtacante = 1- equipaAtacante;
                    //golo da outra equipa
                    fase=2;

                }
                break;

        }
        return this.fase;
    }
}