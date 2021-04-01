 

 

public class Avan�ado extends Jogador {
    //construtor por omissão
    public Avan�ado(){
        super();
    }

    //construtor parametrizado
    public Avan�ado(String nome,boolean titular,int vel,int res,
                   int des,int imp,int cab,int rem,int passe){
        super(nome,titular,vel,res,des,imp,cab,rem,passe);
    }

    //construtor por objeto
    public Avan�ado(Avan�ado l){
        super(l);
    }

    @Override
    public int compareTo(Jogador o) {
        return 0;
    }

    public Avan�ado clone() {
        return new Avan�ado(this);
    }
    public double gethabilidade(){
     return super.getVel()*0.2 + super.getRes()*0.05+ super.getDes()*0.05 + super.getImp()*0.1 + super.getCab()*0.2 + super.getRem()*0.3 + super.getPasse()*0.1;
    }
}
