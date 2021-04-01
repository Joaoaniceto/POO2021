import java.util.HashMap;
import java.util.Scanner;
import java.io.Serializable;
import java.util.List;

public class Equipa implements Comparable<Equipa>, Serializable{
    private String nome;
    private HashMap<Integer, Jogador> equipa;

    public Equipa(){
        this.nome = "n/a";
        this.equipa = new HashMap();
    }

    public Equipa (String nome, HashMap<Integer, Jogador> equipa){
        this.nome=nome;
        this.equipa=equipa;
    }

    public Equipa (Equipa e){
        this.nome = e.getNome();
        this.equipa = e.getEquipa();
    }

    public String getNome(){
        return this.nome;
    }

    public HashMap getEquipa(){
        return this.equipa;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setEquipa(HashMap<Integer, Jogador> nome){
        this.equipa=nome;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Jogador j : this.equipa.values()){
            sb.append(j.toString());
        }
        return sb.toString();
    }

    public Equipa clone(){
        return new Equipa(this);
    }


    public boolean equals(Object o){
        if (this==o)
            return true;
        if((o==null)||(this.getClass()!=o.getClass()))
            return false;
        Equipa e = (Equipa) o;
        return (this.equipa) == (e.getEquipa()) && (this.nome)==(e.getNome());
    }

    public void addJogador(Jogador o){
        this.equipa.put(o.getNum(),o.clone());
    }

    public void removeJogador(Jogador o){
        for(Jogador j : this.equipa.values()){
            if(o.getNum()==j.getNum()){
                this.equipa.remove(o.getNum());
                break;
            }
        //falta uma exception bonita
        }
    }
    //equipaAtual.transferenciaJogador(equipaAserTransferido,jogador da equipa atual)
    public void transferenciaJogador(Equipa a,Jogador o) {
        for (Jogador j : this.equipa.values()) {
            if (o.getNum() == j.getNum()) {
                removeJogador(o);
                a.addJogador(o);
                break;
            }
            //falta uma exception
        }
    }

    @Override
    public int compareTo(Equipa o) {
        return 0;
    }
}




