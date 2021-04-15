import java.util.ArrayList;

public class Lateral extends Jogador {
    //VARIAVEL DE INSTANCIA EXTRA
    private int cruzamento;

    //construtor por omissão
    public Lateral(){
        super();
        this.cruzamento = 0;
    }

    //construtor parametrizado
    public Lateral(int numero, String nome, boolean titular, ArrayList<Equipa> h, int vel, int res,
                   int des, int imp, int cab, int rem, int passe,int cruzamento){
        super(numero,nome,titular,h,vel,res,des,imp,cab,rem,passe);
        this.cruzamento = cruzamento;
    }

    //construtor por objeto
    public Lateral(Lateral l){
        super(l);
        this.cruzamento = l.getCruzamento();
    }

    public int getCruzamento() { return this.cruzamento; }
    public void setCruzamento(int c){ this.cruzamento = c; }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(super.toString());
        s.append("Valor de Cruzamento: ").append(getCruzamento());
        s.append("\n");
        return s.toString();
    }

    @Override
    public int compareTo(Jogador o) {
        return 0;
    }

    public Lateral clone() {
        return new Lateral(this);
    }
    public double gethabilidade(){
     return super.getVel()*0.1 + super.getRes()*0.1+ super.getDes()*0.1 + super.getImp()*0.05 + super.getCab()*0.1 + super.getRem()*0.15 + super.getPasse()*0.15 + this.cruzamento*0.25 ;
    }
}
