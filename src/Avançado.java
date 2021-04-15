import java.util.ArrayList;

public class Avançado extends Jogador {
    //construtor por omissão
    public Avançado(){
        super();
        private int drible;
    }

    //construtor parametrizado
    public Avançado(int numero, String nome, boolean titular, ArrayList<Equipa> h, int vel, int res,
                    int des, int imp, int cab, int rem, int passe,  int drible){
        super(numero,nome,titular,h,vel,res,des,imp,cab,rem,passe);
        this.drible=drible;
    }

    //construtor por objeto
    public Avançado(Avançado l){
        super(l);
        this.corte= l.getDrible();
    }
    
    public int getDrible(){ return this.drible:}
    public void setCorte(int d){ this.drible=d;}

    @Override
    public int compareTo(Jogador o) {
        return 0;
    }

    public Avançado clone() {
        return new Avançado(this);
    }

    public double gethabilidade(){
        return super.getVel()*0.2 + super.getRes()*0.05+ super.getDes()*0.05 + super.getImp()*0.1 + super.getCab()*0.1 + super.getRem()*0.2 + super.getPasse()*0.1+ this.drible*0.2;
    }
}
