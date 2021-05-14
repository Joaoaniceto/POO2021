
/**
 * Escreva a descrição da classe VeiculoOcasiao aqui.
 *
 * @author (seu nome)
 * @version (número de versão ou data)
 */
//ficha 6 - exercicio 2
public class VeiculoOcasiao extends Veiculo
{
    private boolean promocao;

    public VeiculoOcasiao(){
        super();
        this.promocao = false;
    }

    public VeiculoOcasiao(String id, String ma, String mo, int ano, float velo,
                          double preco, int classificacao, int kms, int nrUtilizadores,
                          int media, boolean p){
        super(ma,mo,id,ano,kms);
        this.promocao = p;
    }

    public VeiculoOcasiao(VeiculoOcasiao v){
        super(v);
        this.promocao = v.getPromocao();
    }

    public boolean getPromocao(){
        return this.promocao;
    }

    public void setPromocao(boolean p){
        this.promocao = p;
    }

    public double getPrecoTeorico(){
        return this.promocao ? 0.75 * super.getPrecokm() : super.getPrecokm();
    }

    public double custoRealKm(){
        return 1.10 * getKms() * getPrecoTeorico();
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(super.toString()); //acessar ao toSTring da superclasse(Veiculo) acrescentando informaçoes
        //s.append(getPreco()); //fazer o resto
        if(this.promocao) s.append("EM PROMOÇAO!").append(getPrecoTeorico());
        else s.append("SEM PROMOÇAO!");
        s.append("\n");
        return s.toString();
    }

    public VeiculoOcasiao clone(){ //e preciso para a classe teste do objeto veiculoOcasiao(caso contrario ia buscar o clone de Veiculo)
        return new VeiculoOcasiao(this);
    }
}