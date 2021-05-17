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

    public static Data parse() throws LinhaIncorretaException, FileNotFoundException, IOException {
        Data data = new Data();
        List<String> linhas = lerFicheiro("input.txt");
        Equipa ultima = null;
        Jogador j = null;
        String[] linhaPartida;
        for (String linha : linhas) {
            linhaPartida = linha.split(":", 2);
            switch(linhaPartida[0]){
                case "Equipa":
                    Equipa e = Equipa.parse(linhaPartida[1]);
                    data.addEquipa(e);
                    ultima = e;
                    break;
                case "Guarda-Redes":
                    j = GuardaRedes.parse(linhaPartida[1]);
                    data.addJogador(j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Defesa":
                    j = Defesa.parse(linhaPartida[1]);
                    data.addJogador(j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Medio":
                    j = Medio.parse(linhaPartida[1]);
                    data.addJogador(j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Lateral":
                    j = Lateral.parse(linhaPartida[1]);
                    data.addJogador(j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Avancado":
                    j = Avançado.parse(linhaPartida[1]);
                    data.addJogador(j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Jogo":
                    Jogo jo = Jogo.parse(linhaPartida[1]);
                    data.addJogo(jo);
                    break;
                default:
                    throw new LinhaIncorretaException();

            }
        }


        PrintWriter pw1 = new PrintWriter(new FileOutputStream("equipas.txt"));
        for(Equipa e : data.equipas.values()) {
            pw1.println(e.getNome());
        }
        pw1.close();


        PrintWriter pw2 = new PrintWriter(new FileOutputStream("jogadores.txt"));
        for (Equipa e: data.equipas.values()){
            pw2.println(e.getNome());
            pw2.println(e.toString());
        }
        pw2.close();


        PrintWriter pw3 = new PrintWriter(new FileOutputStream("jogos.txt"));
        for(Jogo jog : data.jogos) {
            pw3.println(jog.toString());
        }
        pw3.close();


        return data;
    }

    public static List<String> lerFicheiro(String nomeFich) {
        List<String> lines;
        try { lines = Files.readAllLines(Paths.get(nomeFich), StandardCharsets.UTF_8); }
        catch(IOException exc) { lines = new ArrayList<>(); }
        return lines;
    }






}
