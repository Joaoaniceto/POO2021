import java.util.List;
import java.util.Map;

public class MenuApp {
    public static void main(String args[]) throws Exception {

        Data d = Parser.parse();

        //TESTE TRANSFERENCIA DE EQUIPA : PASSED
        //Equipa a = d.getEquipas().get("Schumann Athletic");
        //Equipa b = d.getEquipas().get("Stravinsky Athletic");
        //a.transferenciaJogador(b,a.getJogador(32));

        new Delegate(d).run();

    }
}
