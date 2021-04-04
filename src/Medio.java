import java.util.ArrayList;

public class Medio extends Jogador {
    //construtor por omissão
    public Medio(){
        super();
    }

    //construtor parametrizado
    public Medio(int numero, String nome, boolean titular, ArrayList<Equipa> h, int vel, int res,
                 int des, int imp, int cab, int rem, int passe){
        super(numero,nome,titular,h,vel,res,des,imp,cab,rem,passe);
    }

    //construtor por objeto
    public Medio(Medio l){
        super(l);
    }

    @Override
    public int compareTo(Jogador o) {
        return 0;
    }

    public Medio clone() {
        return new Medio(this);
    }
    public double gethabilidade(){
     return super.getVel()*0.1 + super.getRes()*0.2+ super.getDes()*0.1 + super.getImp()*0.1 + super.getCab()*0.1 + super.getRem()*0.1 + super.getPasse()*0.3;
    }

}
