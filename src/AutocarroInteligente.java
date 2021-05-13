import java.util.ArrayList;

public class AutocarroInteligente extends Veiculo implements BonificaKms
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private int ocupacao;
    private int pontosAtribuir;
    private int pontosAcumulados;


    public AutocarroInteligente()
    {
        super();
        this.ocupacao = 0;
        this.pontosAtribuir = 0;
        this.pontosAcumulados = 0;
    }

    public AutocarroInteligente(String marca,String modelo,String matricula,int ano,int kms) {
        super(marca,modelo,matricula,ano,kms);
    }

    public AutocarroInteligente(String marca,String modelo,String matricula,int ano,double velociademedia,
                                double precokm,ArrayList<Integer> classificacao,int kms,int kmsUltimo,int ocup,int p_atrib,int p_acum)
    {
        super(marca,modelo,matricula,ano,velociademedia,precokm,classificacao,kms,kmsUltimo);
        this.ocupacao = ocup;
        this.pontosAtribuir = p_atrib;
        this.pontosAcumulados = p_acum;
    }

    public AutocarroInteligente(AutocarroInteligente a){
        super(a);
        this.ocupacao = a.getOcupacao();
        this.pontosAtribuir = a.getPontosAtribuir();
        this.pontosAcumulados = a.getPontosAcumulados();
    }

    public int getOcupacao() {return this.ocupacao;}
    public void setOcupacao(int o) {this.ocupacao = o;}

    public boolean equals(Object o) {
        if (o==this) return true;
        if (o==null || ! o.getClass().equals(this.getClass())) return false;
        AutocarroInteligente v = (AutocarroInteligente) o;
        return super.equals(v) && v.getOcupacao() == this.ocupacao
                && v.getPontosAtribuir() == this.pontosAtribuir
                && v.getPontosAcumulados() == this.pontosAcumulados;
    }

    public AutocarroInteligente clone(){
        return new AutocarroInteligente(this);
    }


    public void addViagem(int nKms){
        super.addViagem(nKms);
        this.pontosAcumulados += nKms * this.pontosAtribuir;
    }


    //IMPLEMENTAÇÃO DA INTERFACE

    @Override
    public void setPontosAtribuir(int pontos) {
        this.pontosAtribuir = pontos;
    }

    @Override
    public int getPontosAtribuir() {
        return this.pontosAtribuir;
    }

    @Override
    public int getPontosAcumulados() {
        return this.pontosAcumulados;
    }





}
