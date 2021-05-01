import java.util.ArrayList;

public class Avançado extends Jogador {
    //variavel de intancia extra
    private int drible;

    //construtor por omissão
    public Avançado(){
        super();
        this.drible = 0;
    }

    //construtor parametrizado
    public Avançado(int numero, String nome, boolean titular, ArrayList<Equipa> h, int vel, int res,
                    int des, int imp, int cab, int rem, int passe, int drible){
        super(numero,nome,titular,h,vel,res,des,imp,cab,rem,passe);
        this.drible=drible;
    }

    //construtor por objeto
    public Avançado(Avançado l){
        super(l);
        this.drible= l.getDrible();
    }
    
    public int getDrible(){ return this.drible; }
    public void setDrible(int d){this.drible = d;}

    @Override
    public int compareTo(Jogador o) {
        return 0;
    }

    public Avançado clone() {
        return new Avançado(this);
    }


    public double gethabilidade(String posicao){
        switch (posicao){
            case "medio":
                return super.getVel()*0.1 + super.getRes()*0.1+ super.getDes()*0.1 + super.getImp()*0.1 + super.getCab()*0.1 + super.getRem()*0.1 + super.getPasse()*0.1 ;

            case "guarda-redes":
                return super.getVel()*0.1+ super.getRes()*0.1+ super.getDes()*0.1 + super.getImp()*0.1 + super.getRem()*0.1 + super.getPasse()*0.1;


            case "defesa":
                return super.getVel()*0.05 + super.getRes()*0.2+ super.getDes()*0.1 + super.getImp()*0.1 + super.getCab()*0.2 + super.getRem()*0.1 + super.getPasse()*0.1;

            case "lateral":
                return super.getVel()*0.1 + super.getRes()*0.1+ super.getDes()*0.1 + super.getImp()*0.05 + super.getCab()*0.1 + super.getRem()*0.15 + super.getPasse()*0.15;


            default:
                return super.getVel()*0.2 + super.getRes()*0.05+ super.getDes()*0.05 + super.getImp()*0.1 + super.getCab()*0.1 + super.getRem()*0.2 + super.getPasse()*0.1+ this.drible*0.2;
        }

    }
}
