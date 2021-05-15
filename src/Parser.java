import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser implements Cloneable {
    //INSTANCE VARIABLES
    public static Equipas equipas; //nome, equipa
    public static Map<Integer, Jogador> jogadores; //numero, jogador
    public static List<Jogo> jogos;

    public Parser() {
        this.equipas = new Equipas();
        this.jogadores = new HashMap<>();
        this.jogos = new ArrayList<>();
    }

    public Parser (Parser obj){
        this.equipas = obj.getEquipas();
        this.jogadores = obj.getJogadores();
        this.jogos = obj.getJogos();
    }

    public static void parse() throws LinhaIncorretaException, FileNotFoundException, IOException {
        List<String> linhas = lerFicheiro("input.txt");
        Equipa ultima = null; Jogador j = null;
        String[] linhaPartida;
        for (String linha : linhas) {
            linhaPartida = linha.split(":", 2);
            switch(linhaPartida[0]){
                case "Equipa":
                    Equipa e = Equipa.parse(linhaPartida[1]);
                    equipas.addEquipa(e);
                    ultima = e;
                    break;
                case "Guarda-Redes":
                    j = GuardaRedes.parse(linhaPartida[1]);
                    jogadores.put(j.getNum(), j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Defesa":
                    j = Defesa.parse(linhaPartida[1]);
                    jogadores.put(j.getNum(), j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Medio":
                    j = Medio.parse(linhaPartida[1]);
                    jogadores.put(j.getNum(), j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Lateral":
                    j = Lateral.parse(linhaPartida[1]);
                    jogadores.put(j.getNum(), j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Avancado":
                    j = Avançado.parse(linhaPartida[1]);
                    jogadores.put(j.getNum(), j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Jogo":
                    Jogo jo = Jogo.parse(linhaPartida[1]);
                    jogos.add(jo);
                    break;
                default:
                    throw new LinhaIncorretaException();

            }
        }


        PrintWriter pw1 = new PrintWriter(new FileOutputStream("equipas.txt"));
        for(Equipa e : equipas.equipas.values()) {
            pw1.println(e.getNome());
        }
        pw1.close();


        //debug
        PrintWriter pw2 = new PrintWriter(new FileOutputStream("jogadores.txt"));
        for (Equipa e: equipas.equipas.values()){
            pw2.println(e.getNome());
            pw2.println(e.toString());
        }
        pw2.close();


        PrintWriter pw3 = new PrintWriter(new FileOutputStream("jogos.txt"));
        for(Jogo jog : jogos) {
            pw3.println(jog.toString());
        }
        pw3.close();

        //for (Jogo jog: jogos){
        //    System.out.println(jog.toString());
        //}


    }

    public static List<String> lerFicheiro(String nomeFich) {
        List<String> lines;
        try { lines = Files.readAllLines(Paths.get(nomeFich), StandardCharsets.UTF_8); }
        catch(IOException exc) { lines = new ArrayList<>(); }
        return lines;
    }




    public Parser clone() {return new Parser(this);}

    public Equipas getEquipas() {return this.equipas;}
    public Map<Integer, Jogador> getJogadores() {return this.jogadores;}
    public List<Jogo> getJogos() {return this.jogos;}



}
