public class GuardaRedes extends Jogador {

    //VARIAVEL DE INSTANCIA EXTRA
    private int elasticidade;

    //construtor por omissão
    public GuardaRedes(){
        super();
        this.elasticidade = 0;
    }

    //construtor parametrizado
    public GuardaRedes(String nome,boolean titular,int vel,int res,
                   int des,int imp,int cab,int rem,int passe,int elast){
        super(nome,titular,vel,res,des,imp,cab,rem,passe);
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
        s.append(super.toString()); //acessar ao toSTring da superclasse(Veiculo) acrescentando informaçoes
        //s.append(getPreco()); //fazer o resto
        s.append("\nValor de Elasticidade: ").append(getElast());
        s.append("\n");
        return s.toString();
    }


    @Override
    public int compareTo(Jogador o) {
        return 0;
    }
}
