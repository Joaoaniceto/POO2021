import java.util.ArrayList;

public class GuardaRedes extends Jogador {

    //VARIAVEL DE INSTANCIA EXTRA
    private int elasticidade;

    //construtor por omissão
    public GuardaRedes(int i, String name, boolean b, ArrayList<Equipa> hist, int parseInt, int anInt, int i1, int parseInt1, int anInt1, int i2, int parseInt2, int anInt2, int i3){
        super();
        this.elasticidade = 0;
    }

    //construtor parametrizado
    public GuardaRedes(int numero, String nome, boolean titular, ArrayList<Equipa> h, int vel, int res,
                       int des, int imp, int cab, int rem, int passe, int elast){
        super(numero,nome,titular,h,vel,res,des,imp,cab,rem,passe);
        this.elasticidade = elast;
    }

    //construtor por objeto
    public GuardaRedes(GuardaRedes l){
        super(l);
        this.elasticidade = l.getElast();
    }

    public int getElast(){return this.elasticidade;}
    
    public void setElast(int e){this.elasticidade = e; }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(super.toString()); 
        s.append("Valor de Elasticidade: ").append(getElast());
        s.append("\n");
        return s.toString();
    }


    @Override
    public int compareTo(Jogador o) {
        return 0;
    }

    public GuardaRedes clone() {
        return new GuardaRedes(this);
    }

    public double gethabilidade(String posicao){
        switch (posicao){
            case "Avançado":
                return super.getVel()*0.2 + super.getRes()*0.05+ super.getDes()*0.05 + super.getImp()*0.1 + super.getCab()*0.1 + super.getRem()*0.2 + super.getPasse()*0.1;

            case "Medio":
                return super.getVel()*0.1 + super.getRes()*0.1+ super.getDes()*0.1 + super.getImp()*0.1 + super.getCab()*0.1 + super.getRem()*0.1 + super.getPasse()*0.1 ;


            case "Defesa":
                return super.getVel()*0.05 + super.getRes()*0.2+ super.getDes()*0.1 + super.getImp()*0.1 + super.getCab()*0.2 + super.getRem()*0.1 + super.getPasse()*0.1;

            case "Lateral":
                return super.getVel()*0.1 + super.getRes()*0.1+ super.getDes()*0.1 + super.getImp()*0.05 + super.getCab()*0.1 + super.getRem()*0.15 + super.getPasse()*0.15;

            default:
                return super.getVel()*0.1 + this.elasticidade*0.4 + super.getRes()*0.1+ super.getDes()*0.1 + super.getImp()*0.1 + super.getRem()*0.1 + super.getPasse()*0.1;
        }

    }

    public static GuardaRedes parse(String input){
        ArrayList<Equipa> hist = new ArrayList<Equipa>();
        String[] campos = input.split(",");
        String name = campos[0];
        return new GuardaRedes(Integer.parseInt(campos[1]),name,false,hist,
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
