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
            case "Medio":
                return super.getVel()*0.1 + super.getRes()*0.1+ super.getDes()*0.1 + super.getImp()*0.1 + super.getCab()*0.1 + super.getRem()*0.1 + super.getPasse()*0.1 ;

            case "GuardaRedes":
                return super.getVel()*0.1+ super.getRes()*0.1+ super.getDes()*0.1 + super.getImp()*0.1 + super.getRem()*0.1 + super.getPasse()*0.1;

            case "Defesa":
                return super.getVel()*0.05 + super.getRes()*0.2+ super.getDes()*0.1 + super.getImp()*0.1 + super.getCab()*0.2 + super.getRem()*0.1 + super.getPasse()*0.1;

            case "Lateral":
                return super.getVel()*0.1 + super.getRes()*0.1+ super.getDes()*0.1 + super.getImp()*0.05 + super.getCab()*0.1 + super.getRem()*0.15 + super.getPasse()*0.15;

            default:
                return super.getVel()*0.2 + super.getRes()*0.05+ super.getDes()*0.05 + super.getImp()*0.1 + super.getCab()*0.1 + super.getRem()*0.2 + super.getPasse()*0.1+ this.drible*0.2;
        }

    }

    public static Avançado parse(String input){
        ArrayList<Equipa> hist = new ArrayList<Equipa>();
        String[] campos = input.split(",");
        String name = campos[0];
        return new Avançado(Integer.parseInt(campos[1]),name,false,hist,
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                70);
    }

}
