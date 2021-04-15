import java.util.ArrayList;

public class Defesa extends Jogador {
    //construtor por omissão
    public Defesa(){
        super();
        private int corte;
    }

    //construtor parametrizado
    public Defesa(int numero, String nome, boolean titular, ArrayList<Equipa> h, int vel, int res,
                  int des, int imp, int cab, int rem, int passe, int corte){
        super(numero,nome,titular,h,vel,res,des,imp,cab,rem,passe);
    }

    //construtor por objeto
    public Defesa(Defesa l){
        super(l);
        this.corte=l.getCorte;
    }
    
    public int getCorte(){ return this.corte;}
    public void setCorte(int c){ this.corte=c;}

    @Override
    public int compareTo(Jogador o) {
        return 0;
    }

    public Defesa clone() {
        return new Defesa(this);
    }

    public double gethabilidade(){
     return super.getVel()*0.05 + super.getRes()*0.2+ super.getDes()*0.1 + super.getImp()*0.1 + super.getCab()*0.2 + super.getRem()*0.1 + super.getPasse()*0.1+ this.corte*0.35;
      }

}
