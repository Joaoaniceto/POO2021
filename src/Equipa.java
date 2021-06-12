import java.util.HashMap;
import java.util.Scanner;
import java.io.Serializable;
import java.util.List;
import java.util.stream.IntStream;

public class Equipa implements Comparable<Equipa>, Serializable {
    private String nome;                        //nome da equipa
    private HashMap<Integer, Jogador> equipa;   //(numero,jogador)

    public Equipa() {
        this.nome = "n/a";
        this.equipa = new HashMap();
    }

    public Equipa(String nome){
        this.nome = nome;
        this.equipa = new HashMap();
    }

    public Equipa(String nome, HashMap<Integer, Jogador> equipa) {
        this.nome = nome;
        this.equipa = equipa;
    }

    public Equipa(Equipa e) {
        this.nome = e.getNome();
        this.equipa = e.getEquipa();
    }

    public String getNome() {
        return this.nome;
    }

    public HashMap getEquipa() {
        return this.equipa;
    }

    public Jogador getJogador(int n) {return this.equipa.get(n);}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEquipa(HashMap<Integer, Jogador> nome) {
        this.equipa = nome;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.nome);
        sb.append("\n");
        for (Jogador j : this.equipa.values()) {
            sb.append(j.getNome());
            sb.append(" , ");
        }
        sb.append("\n");
        return sb.toString();
    }

    public Equipa clone() {
        return new Equipa(this);
    }


    public boolean equals(Object o) {
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        Equipa e = (Equipa) o;
        return (this.equipa) == (e.getEquipa()) && (this.nome) == (e.getNome());
    }

    //este metodo não verifica a priori se o jogador sai da equipa anterior,
    //caso esteja registado noutra equipa antes do call do método.
    public void addJogador(Jogador o) {
        this.equipa.put(o.getNum(), o.clone());
        o.atualizaHist(this);
    }

    public void removeJogador(Jogador o) {
        for (Jogador j : this.equipa.values()) {
            if (o.getNum() == j.getNum()) {
                this.equipa.remove(o.getNum());
                break;
            }
            //falta uma exception bonita
        }
    }

    //equipaAtual.transferenciaJogador(equipaAserTransferido,jogador da equipa atual)
    public void transferenciaJogador(Equipa a, Jogador o) {
        for (Jogador j : this.equipa.values()) {
            if (o.getNum() == j.getNum()) {
                removeJogador(o);
                a.addJogador(o);
                break;
            }
            //falta uma exception
        }
    }

    //jogador t e b trocam os seus valores de Titular
    //FALTA ATUALIZAÇÃO DINAMICA DA VARIAVEL SUBSCASA
    //E SUBSVISITANTE NA CLASSE JOGO
    public void substituicao(Jogador t, Jogador b) {

        int flag = 0;
        boolean b1 = t.getTitular();
        boolean b2 = b.getTitular();
        for (Jogador j : this.equipa.values()) {
            if ((t.getNum() == j.getNum()) || (b.getNum() == j.getNum()))
                flag++;
        }
        if ((flag == 2) && (t.getTitular()!=b.getTitular())){
            t.setTitular(b2);
            b.setTitular(b1);
        }
        else {
            System.out.println("\nErro na substituição de jogadores (verifique se têm valor titular distinto ou se pertencem à mesma equipa)");
        }
        System.out.println(t.getNomeReduzido() + " vai ser substituido por : " + b.getNomeReduzido() + "\n");
    }

    public double gethabilidades() {
        double sum = 0;
        int i=0;
        for (Jogador j : this.equipa.values()) {
            if (j.getTitular()==true) {
                sum += j.gethabilidade("");

                i += 1;
            }
        }
        double media=0;
        media = sum/i;
        return media;
    }

    public static Equipa parse(String input){
        String[] campos = input.split(",");
        return new Equipa(campos[0]);
    }



    @Override
    public int compareTo (Equipa o){
        return 0;
    }


}