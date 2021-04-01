 

 

public class Avançado extends Jogador {
    //construtor por omissÃ£o
    public Avançado(){
        super();
    }

    //construtor parametrizado
    public Avançado(String nome,boolean titular,int vel,int res,
                   int des,int imp,int cab,int rem,int passe){
        super(nome,titular,vel,res,des,imp,cab,rem,passe);
    }

    //construtor por objeto
    public Avançado(Avançado l){
        super(l);
    }

    @Override
    public int compareTo(Jogador o) {
        return 0;
    }

    public Avançado clone() {
        return new Avançado(this);
    }
    public double gethabilidade(){
     return super.getVel()*0.2 + super.getRes()*0.05+ super.getDes()*0.05 + super.getImp()*0.1 + super.getCab()*0.2 + super.getRem()*0.3 + super.getPasse()*0.1;
    }
}
