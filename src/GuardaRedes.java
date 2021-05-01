import java.util.ArrayList;

public class GuardaRedes extends Jogador {

    //VARIAVEL DE INSTANCIA EXTRA
    private int elasticidade;

    //construtor por omissão
    public GuardaRedes(){
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
            case "avancado":
                return super.getVel()*0.2 + super.getRes()*0.05+ super.getDes()*0.05 + super.getImp()*0.1 + super.getCab()*0.1 + super.getRem()*0.2 + super.getPasse()*0.1;

            case "medio":
                return super.getVel()*0.1 + super.getRes()*0.1+ super.getDes()*0.1 + super.getImp()*0.1 + super.getCab()*0.1 + super.getRem()*0.1 + super.getPasse()*0.1 ;


            case "defesa":
                return super.getVel()*0.05 + super.getRes()*0.2+ super.getDes()*0.1 + super.getImp()*0.1 + super.getCab()*0.2 + super.getRem()*0.1 + super.getPasse()*0.1;

            case "lateral":
                return super.getVel()*0.1 + super.getRes()*0.1+ super.getDes()*0.1 + super.getImp()*0.05 + super.getCab()*0.1 + super.getRem()*0.15 + super.getPasse()*0.15;

            default:
                return super.getVel()*0.1 + this.elasticidade*0.4 + super.getRes()*0.1+ super.getDes()*0.1 + super.getImp()*0.1 + super.getRem()*0.1 + super.getPasse()*0.1;
        }

    }


}
