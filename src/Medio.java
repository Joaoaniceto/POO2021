import java.util.ArrayList;

public class Medio extends Jogador {
    //VARIAVEL DE INSTANCIA EXTRA
    
    private int recupBolas;
    
    //construtor por omissão
    public Medio(){
        super();
        this.recupBolas=0;
    }

    //construtor parametrizado
    public Medio(int numero, String nome, boolean titular, ArrayList<Equipa> h, int vel, int res,
                 int des, int imp, int cab, int rem, int passe, int recupBolas){
        super(numero,nome,titular,h,vel,res,des,imp,cab,rem,passe);
        this.recupBolas=recupBolas;
    }

    //construtor por objeto
    public Medio(Medio l){
        super(l);
        this.recupBolas = l.getRecup();
    }
    
    public int getRecup() { return this.recupBolas; }
    public void setRecup(int r){ this.recupbolas = r; }

    @Override
    public int compareTo(Jogador o) {
        return 0;
    }

    public Medio clone() {
        return new Medio(this);
    }
    public double gethabilidade(){
     return super.getVel()*0.1 + super.getRes()*0.1+ super.getDes()*0.1 + super.getImp()*0.1 + super.getCab()*0.1 + super.getRem()*0.1 + super.getPasse()*0.1 + this.recupbolas*0.3;
    }

}
