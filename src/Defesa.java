import java.util.ArrayList;

public class Defesa extends Jogador {
    //variavel de instancia extra
    private int corte;

    //construtor por omissão
    public Defesa(){
        super();
        this.corte = 0;
    }

    //construtor parametrizado
    public Defesa(int numero, String nome, boolean titular, ArrayList<Equipa> h, int vel, int res,
                  int des, int imp, int cab, int rem, int passe, int corte){
        super(numero,nome,titular,h,vel,res,des,imp,cab,rem,passe);
        this.corte=corte;
    }

    //construtor por objeto
    public Defesa(Defesa l){
        super(l);
        this.corte=l.getCorte();
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

    public double gethabilidade(String posicao){
        switch (posicao){
            case "Avançado":
                return super.getVel()*0.2 + super.getRes()*0.05+ super.getDes()*0.05 + super.getImp()*0.1 + super.getCab()*0.1 + super.getRem()*0.2 + super.getPasse()*0.1;

            case "Medio":
                return super.getVel()*0.1 + super.getRes()*0.1+ super.getDes()*0.1 + super.getImp()*0.1 + super.getCab()*0.1 + super.getRem()*0.1 + super.getPasse()*0.1 ;


            case "GuardaRedes":
                return super.getVel()*0.1+ super.getRes()*0.1+ super.getDes()*0.1 + super.getImp()*0.1 + super.getRem()*0.1 + super.getPasse()*0.1;


            case "Lateral":
                return super.getVel()*0.1 + super.getRes()*0.1+ super.getDes()*0.1 + super.getImp()*0.05 + super.getCab()*0.1 + super.getRem()*0.15 + super.getPasse()*0.15;

            default:
                return super.getVel()*0.05 + super.getRes()*0.2+ super.getDes()*0.1 + super.getImp()*0.1 + super.getCab()*0.2 + super.getRem()*0.1 + super.getPasse()*0.1+ this.corte*0.35;
        }

    }

    public static Defesa parse(String input){
        ArrayList<Equipa> hist = new ArrayList<Equipa>();
        String[] campos = input.split(",");
        String name = campos[0];
        return new Defesa(Integer.parseInt(campos[1]),name,false,hist,
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
