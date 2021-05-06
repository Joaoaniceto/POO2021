
import java.util.ArrayList;

public class VeiculoPremium extends Veiculo implements BonificaKms {

    //VARIAVEIS DE INSTANCIA
    private int taxa;
    private int pontosAtribuir;
    private int pontosAcumulados;


    public VeiculoPremium()
    {
        super();
        this.pontosAtribuir = 0;
        this.pontosAcumulados = 0;
        
    }
    public VeiculoPremium(String marca,String modelo,String matricula,int ano,double velociademedia,
                          double precokm,ArrayList<Integer> classificacao,int kms,int kmsUltimo,int taxa,int p_atrib,int p_acum){
        super(marca,modelo,matricula,ano,velociademedia,precokm,classificacao,kms,kmsUltimo);
        this.taxa = taxa;
        this.pontosAtribuir = p_atrib;
        this.pontosAcumulados = p_acum;
    }

    public VeiculoPremium(VeiculoPremium a){
        super(a);
        this.pontosAcumulados = a.getPontosAcumulados();
        this.pontosAtribuir = a.getPontosAtribuir();
    }

    public VeiculoPremium clone(){
        return new VeiculoPremium(this);
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
