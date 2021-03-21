public class Lateral extends Jogador {
    //construtor por omissão
    public Lateral(){
        super();
    }

    //construtor parametrizado
    public Lateral(String nome,boolean titular,int vel,int res,
                   int des,int imp,int cab,int rem,int passe){
        super(nome,titular,vel,res,des,imp,cab,rem,passe);
    }

    //construtor por objeto
    public Lateral(Lateral l){
        super(l);
    }

    @Override
    public int compareTo(Jogador o) {
        return 0;
    }

    public Lateral clone() {
        return new Lateral(this);
    }
}
