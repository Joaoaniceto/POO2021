public class Avançado extends Jogador {
    //construtor por omissão
    public Avançado(){
        super();
    }

    //construtor parametrizado
    public Avançado(int numero,String nome,boolean titular,int vel,int res,
                   int des,int imp,int cab,int rem,int passe){
        super(numero,nome,titular,vel,res,des,imp,cab,rem,passe);
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
}
