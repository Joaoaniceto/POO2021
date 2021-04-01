import java.util.HashMap;
import java.util.Scanner;
import java.io.Serializable;
import java.util.TreeMap;

public abstract class Equipa implements Comparable<Equipa>, Serializable{
    private String name;
    private HashMap<Integer, Jogador> jogadores;

public Equipa(){
    this.name = "";
    this.jogadores = new HashMap<Integer, Jogador>();
}

public Equipa (String name,HashMap<Integer, Jogador> jogadores){
    this.name=name;
    this.jogadores = jogadores;
}

public Equipa (Equipa e){
    this.name = e.getName();
    this.jogadores = e.getJogadores();
}

public String getName(){
    return this.name;
}

public HashMap<Integer, Jogador> getJogadores() {
        return this.jogadores;
    }

public void setNome(String name){
    this.name=name;
}
   
public void setjogadores(HashMap<Integer, Jogador> jogadores){
    this.jogadores=jogadores;
}
public abstract Equipa clone();
public boolean equals(Object o){
    if (this==o)
        return true;
    if((o==null)||(this.getClass()!=o.getClass()))
        return false;
    Equipa e = (Equipa) o;
    return (this.name) == (e.getName());
}
public void addJogador(Jogador o){
   this.jogadores.put(o.getNum(),o.clone());
}
public void removeJogador(Jogador o){
    if (this.jogadores.entrySet().stream().anyMatch(b -> b.equals(o))){
    this.jogadores.remove(o.getNum());
}
}
public void transferenciaJogador(Equipa a,Jogador o){
   if (this.jogadores.entrySet().stream().anyMatch(b -> b.equals(o))){
    removeJogador(o);
    a.addJogador(o);
}


}


}



