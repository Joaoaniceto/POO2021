import java.sql.Struct;
import java.time.LocalDate;
import java.util.ArrayList;

public class EncEficiente {
    // instance variables
    private String nomeCliente;
    private String numFiscal;
    private String moradaCliente;
    private String numEncomenda;
    private LocalDate dataEnc;
    private ArrayList<LinhaEncomenda> linhasEnc;

    // construtor por omissão
    public EncEficiente() {
        this.nomeCliente = "n/a";
        this.numFiscal = "n/a";
        this.moradaCliente = "n/a";
        this.numEncomenda = "n/a";
        this.dataEnc = LocalDate.now();
        this.linhasEnc = new ArrayList<LinhaEncomenda>();
    }

    // construtor parametrizado
    public EncEficiente(String nomeCliente, String numFiscal, String moradaCliente,
                        String numEncomenda, LocalDate dataEnc, ArrayList<LinhaEncomenda> linhasEnc) {
        this.nomeCliente = nomeCliente;
        this.numFiscal = numFiscal;
        this.moradaCliente = moradaCliente;
        this.numEncomenda = numEncomenda;
        this.dataEnc = dataEnc;
        this.linhasEnc = linhasEnc;
    }

    // construtor objeto
    public EncEficiente(EncEficiente enc) {
        this.nomeCliente = enc.getNome();
        this.numFiscal = enc.getFiscal();
        this.moradaCliente = enc.getMorada();
        this.numEncomenda = enc.getEnc();
        this.dataEnc = enc.getData();
        this.linhasEnc = enc.getLinhas();
    }

    // gets
    public String getNome() {
        return this.nomeCliente;
    }

    public String getFiscal() {
        return this.numFiscal;
    }

    public String getMorada() {
        return this.moradaCliente;
    }

    public String getEnc() {
        return this.numEncomenda;
    }

    public LocalDate getData() {
        return this.dataEnc;
    }

    public ArrayList<LinhaEncomenda> getLinhas() {
        return this.linhasEnc;
    }

    // sets
    void getNome(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    void getFiscal(String numFiscal) {
        this.numFiscal = numFiscal;
    }

    void getMorada(String moradaCliente) {
        this.moradaCliente = moradaCliente;
    }

    void getEnc(String numEncomenda) {
        this.numEncomenda = numEncomenda;
    }

    void getData(LocalDate dataEnc) {
        this.dataEnc = dataEnc;
    }

    void getLinhas(ArrayList<LinhaEncomenda> linhasEnc) {
        this.linhasEnc = linhasEnc;
    }

    // valor total da encomenda
    public double calculaValorTotal() {
        double valor = 0;
        for (LinhaEncomenda linha : this.linhasEnc) {
            valor += linha.getPreco();
        }
        return valor;
    }

    // valor total dos descontos obtidos nos diversos produtos encomendados
    public double calculaValorDesconto() {
        double desconto = 0;
        for (LinhaEncomenda linha : this.linhasEnc) {
            desconto += (linha.getDesconto() * linha.getPreco());
        }
        return desconto;
    }

    // o número total de produtos a receber
    public int numeroTotalProdutos() {
        int quant = 0;
        for (LinhaEncomenda linha : this.linhasEnc) {
            quant += linha.getQuantidade();
        }
        return quant;
    }

    // determina se um produto vai ser encomendado
    public boolean existeProdutoEncomenda(String refProduto) {
        boolean flag = false;
        for (LinhaEncomenda linha : this.linhasEnc) {
            if (linha.getReferencia()==refProduto){flag=true;break;}
        }
        return flag;
    }

    // adiciona uma nova linha de encomenda
    public void adicionaLinha(LinhaEncomenda linha){
        this.linhasEnc.add(linha);
    }

    // remove uma linha de encomenda dado a referência do produto
    public void removeProduto(String codProd){
        int c = 0;
        for(LinhaEncomenda linha: this.linhasEnc){
            if(linha.getReferencia()==codProd){
                linhasEnc.remove(c);
                break;
            }
            else{c+=1;}
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nNome Cliente: ").append(this.nomeCliente);
        sb.append("\nNúmero Fiscal: ").append(this.numFiscal);
        sb.append("\nMorada Cliente: ").append(this.moradaCliente);
        sb.append("\nNúmero Encomenda: ").append(this.numEncomenda);
        sb.append("\nData da Encomenda: ").append(this.dataEnc);
        sb.append("\nLinhas da Encomenda: ").append(this.linhasEnc);
        return sb.toString();
    }

}
