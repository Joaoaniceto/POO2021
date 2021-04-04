import java.util.ArrayList;

public class Lateral extends Jogador {
    //construtor por omissão
    public Lateral(){
        super();
    }

    //construtor parametrizado
    public Lateral(int numero, String nome, boolean titular, ArrayList<Equipa> h, int vel, int res,
                   int des, int imp, int cab, int rem, int passe){
        super(numero,nome,titular,h,vel,res,des,imp,cab,rem,passe);
    }

    //construtor por objeto
    public Lateral(Lateral l){
        super(l);
    }

    @Override
    public int compareTo(Jogador o) {
        return 0;
    }

    public Lateral clone() {
        return new Lateral(this);
    }
    public double gethabilidade(){
     return super.getVel()*0.2 + super.getRes()*0.2+ super.getDes()*0.1 + super.getImp()*0.05 + super.getCab()*0.1 + super.getRem()*0.15 + super.getPasse()*0.2;
    }
}
