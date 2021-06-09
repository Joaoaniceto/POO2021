import java.util.ArrayList;

public class Medio extends Jogador {
    //VARIAVEL DE INSTANCIA EXTRA
    private int recup;
    
    //construtor por omissão

    public Medio(){
        super();
        this.recup=0;
    }

    //construtor parametrizado
    public Medio(int numero, String nome, boolean titular, ArrayList<Equipa> h, int vel, int res,
                 int des, int imp, int cab, int rem, int passe, int recupBolas){
        super(numero,nome,titular,h,vel,res,des,imp,cab,rem,passe);
        this.recup=recupBolas;
    }

    //construtor por objeto
    public Medio(Medio l){
        super(l);
        this.recup = l.getRecup();
    }
    
    public int getRecup() { return this.recup; }
    public void setRecup(int r){ this.recup = r; }

    @Override
    public int compareTo(Jogador o) {
        return 0;
    }

    public Medio clone() {
        return new Medio(this);
    }

    public double gethabilidade(String posicao){
        switch (posicao){
            case "Avançado":
                return super.getVel()*0.2 + super.getRes()*0.05+ super.getDes()*0.05 + super.getImp()*0.1 + super.getCab()*0.1 + super.getRem()*0.2 + super.getPasse()*0.1;


            case "Guarda-Redes":
                return super.getVel()*0.1+ super.getRes()*0.1+ super.getDes()*0.1 + super.getImp()*0.1 + super.getRem()*0.1 + super.getPasse()*0.1;


            case "Defesa":
                return super.getVel()*0.05 + super.getRes()*0.2+ super.getDes()*0.1 + super.getImp()*0.1 + super.getCab()*0.2 + super.getRem()*0.1 + super.getPasse()*0.1;

            case "Lateral":
                return super.getVel()*0.1 + super.getRes()*0.1+ super.getDes()*0.1 + super.getImp()*0.05 + super.getCab()*0.1 + super.getRem()*0.15 + super.getPasse()*0.15;

            default:
                return super.getVel()*0.1 + super.getRes()*0.1+ super.getDes()*0.1 + super.getImp()*0.1 + super.getCab()*0.1 + super.getRem()*0.1 + super.getPasse()*0.1 + this.recup*0.3;
        }

    }

    public static Medio parse(String input){
        ArrayList<Equipa> hist = new ArrayList<Equipa>();
        String[] campos = input.split(",");
        String name = campos[0];
        return new Medio(Integer.parseInt(campos[1]),name,false,hist,
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                Integer.parseInt(campos[9]));
    }

}
