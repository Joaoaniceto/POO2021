import java.time.LocalDate;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        LinhaEncomenda l1 = new LinhaEncomenda("FFF","whey protein",15.99,2,0.23,0.11);
        LinhaEncomenda l2 = new LinhaEncomenda("ABR","microfone mesa",49.99,1,0.23,0.33);
        LinhaEncomenda l3 = new LinhaEncomenda("EWR","teclado RGB",199.99,1,0.23,0.33);
        ArrayList<LinhaEncomenda> array = new ArrayList<LinhaEncomenda>();
        array.add(l1);
        array.add(l2);
        array.add(l3);
        //System.out.println(array);
        EncEficiente enc = new EncEficiente("joão","123456","Braga","001", LocalDate.now(),array);
        System.out.println("valor total da encomenda: "+enc.calculaValorTotal());
        System.out.println("valor total dos descontos obtidos nos diversos produtos encomendados: "+enc.calculaValorDesconto());
        System.out.println("o número total de produtos a receber: "+enc.numeroTotalProdutos());
        System.out.println("determina se um produto vai ser encomendado: "+enc.existeProdutoEncomenda("ABR"));
        LinhaEncomenda l4 = new LinhaEncomenda("YYY","cadeira gaming xd",499.99,1,0.23,0.33);
        enc.adicionaLinha(l4);
        System.out.println(">>adiciona uma nova linha de encomenda "+enc.toString());
        enc.removeProduto("YYY");
        System.out.println(">>remove uma linha de encomenda dado a refe do produto: "+enc.toString());

    }
}