 


 

public class Defesa extends Jogador {
    //construtor por omissão
    public Defesa(){
        super();
    }

    //construtor parametrizado
    public Defesa(String nome,boolean titular,int vel,int res,
                   int des,int imp,int cab,int rem,int passe){
        super(nome,titular,vel,res,des,imp,cab,rem,passe);
    }

    //construtor por objeto
    public Defesa(Defesa l){
        super(l);
    }

    @Override
    public int compareTo(Jogador o) {
        return 0;
    }

    public Defesa clone() {
        return new Defesa(this);
    }
    public double gethabilidade(){
     return super.getVel()*0.1 + super.getRes()*0.2+ super.getDes()*0.2 + super.getImp()*0.1 + super.getCab()*0.2 + super.getRem()*0.1 + super.getPasse()*0.1;
      }

}
