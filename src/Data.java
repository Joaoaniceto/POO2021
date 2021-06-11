import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.Serializable;

public class Data implements Cloneable,Serializable {
    //INSTANCE VARIABLES
    private Map<String, Equipa>  equipas; //nome, equipa
    private List<Jogador> jogadores; //numero, jogador
    private List<Jogo> jogos;

    //CONSTRUCTORS
    public Data() {
        this.equipas = new HashMap<>();
        this.jogadores = new ArrayList<>();
        this.jogos = new ArrayList<>();
    }

    public Data(Map<String,Equipa> equipas, List<Jogador> jogadores, ArrayList<Jogo> jogos) {
        this.equipas = equipas;
        this.jogadores = jogadores;
        this.jogos = jogos;
    }

    public Data(Data obj) {
        this.equipas = obj.getEquipas();
        this.jogadores = obj.getJogadores();
        this.jogos = obj.getJogos();
    }

    public Map<String, Equipa> getEquipas() {return this.equipas;}
    public List<Jogador> getJogadores() {return this.jogadores;}
    public List<Jogo> getJogos() {return this.jogos;}

    public void addEquipa(Equipa e){
        this.equipas.put(e.getNome(),e);
    }

    public void addJogador(Jogador j){
        this.jogadores.add(j);
    }

    public void addJogo(Jogo jogo){
        this.jogos.add(jogo);
    }

    public Data clone() {return new Data(this);}

    /*
    public void saveToCSV(String fn) throws FileNotFoundException, IOException {

        PrintWriter pw = new PrintWriter(new FileOutputStream(fn));
        pw.println(this.nome);

        for(Veiculo v : this.veiculos.values()) {
            pw.println(v.toString());
        }

        pw.close();
    }
*/
    public void deleteEstado() {
        this.equipas = new HashMap<>();
        this.jogadores = new ArrayList<>() ;
        this.jogos = new ArrayList<>();
    }

    public void guardaEstado() throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream("save.tmp");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.close();
    }

    public static Data carregaEstado(String fn) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fn));
        Data d = (Data) ois.readObject();
        ois.close();
        return d;
    }
}