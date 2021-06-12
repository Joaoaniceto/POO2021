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
        this.equipas.put(e.getNome(),e.clone());
    }

    public void addJogador(Jogador j){
        this.jogadores.add(j.clone());
    }

    public void addJogo(Jogo jogo){
        this.jogos.add(jogo.clone());
    }

    public Data clone() {return new Data(this);}

    public void deleteEstado() {
        this.equipas = new HashMap<>();
        this.jogadores = new ArrayList<>() ;
        this.jogos = new ArrayList<>();
    }

    public void guardaEstado(String fn) throws IOException {
        FileOutputStream fos = new FileOutputStream(fn);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.close();
    }

    public static Data carregaEstado(String fn) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fn));
        Data d = (Data) ois.readObject();
        ois.close();
        return d;
    }
}