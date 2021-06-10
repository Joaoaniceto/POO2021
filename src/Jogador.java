import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

/*
acrescentei um metodo em todas as subsclasses para o parser funcionar bem.
cada variavel de instancia especial é repetida com o mesmo valor,
porque essas variaveis extra não estao no ficheiro origem dos stores,
logo temos q arranjar uma forma de randomizar isso.
 */

public abstract class Jogador implements Comparable<Jogador>, Serializable {
    private int numero;
    private String nome;
    private boolean titular;
    private ArrayList<Equipa> historial;
    private int velocidade;
    private int resistencia;
    private int destreza;
    private int impulsao;
    private int jogodecabeca;
    private int remate;
    private int passe;
    private double habilidade;

    //construtor por omissão
    public Jogador(){
        this.numero = 0;
        this.nome = "sem nome";
        this.titular = false;
        this.historial = new ArrayList<Equipa>();
        this.velocidade = 0;
        this.resistencia = 0;
        this.destreza = 0;
        this.impulsao = 0;
        this.jogodecabeca = 0;
        this.remate = 0;
        this.passe = 0;
        this.habilidade = 0;
    }

    //construtor parametrizado
    public Jogador(int numero, String nome,boolean titular,ArrayList<Equipa> h,int vel,int res,
                   int des,int imp,int cab,int rem,int passe) {
        this.numero = numero;
        this.nome = nome;
        this.titular = titular;
        this.historial = h;
        this.velocidade = vel;
        this.resistencia = res;
        this.destreza = des;
        this.impulsao = imp;
        this.jogodecabeca = cab;
        this.remate = rem;
        this.passe = passe;
        this.habilidade = this.gethabilidade(this.getClass().getName());
    }

    //construtor por objeto
    public Jogador(Jogador j){
        this.numero = j.getNum();
        this.nome = j.getNome();
        this.titular = j.getTitular();
        this.historial = j.getHistorial();
        this.velocidade = j.getVel();
        this.resistencia = j.getRes();
        this.destreza = j.getDes();
        this.impulsao = j.getImp();
        this.jogodecabeca = j.getCab();
        this.remate = j.getRem();
        this.passe = j.getPasse();
        this.habilidade = j.gethabilidade(j.getClass().getName());
    }

    public int getNum(){return this.numero;}
    public String getNome(){return this.nome;}
    public String getNomeReduzido(){
         String[] res= this.nome.split("\\s");
         return res[0] + " " + res[1];
    }
    public boolean getTitular(){return this.titular;}
    public ArrayList<Equipa> getHistorial(){return this.historial;}
    public int getVel(){return this.velocidade;}
    public int getRes(){return this.resistencia;}
    public int getDes(){return this.destreza;}
    public int getImp(){return this.impulsao;}
    public int getCab(){return this.jogodecabeca;}
    public int getRem(){return this.remate;}
    public int getPasse(){return this.passe;}

    public void setNumero(int num){this.numero=num;}
    public void setNome(String nome){this.nome=nome;}
    public void setTitular(boolean titular){this.titular=titular;}
    public void setHistorial(ArrayList<Equipa> h){this.historial = h;}
    public void setVel(int vel){this.velocidade=vel;}
    public void setDes(int des){this.destreza=des;}
    public void setImp(int imp){this.impulsao=imp;}
    public void setRes(int res){this.resistencia=res;}
    public void setCab(int cab){this.jogodecabeca=cab;}
    public void setRem(int rem){this.remate=rem;}
    public void setPasse(int passe){this.passe=passe;}

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Equipa e : this.historial) {
            sb.append(e.getNome());
            sb.append(" ");
        }
        return "\nNumero do Jogador: "+ this.numero +
                "\nHabilidade: " + this.habilidade +
                "\nÉ titular? " + this.titular +
                "\nHistorial: "+ sb.toString() +
                "\nValor de Velocidade: " + this.velocidade +
                "\nValor de Destreza: " + this.destreza +
                "\nValor de Impulsão: " + this.impulsao +
                "\nValor de Jogo de Cabeça: " + this.jogodecabeca +
                "\nValor de Remate: " + this.remate +
                "\nValor de Capacidade de Passe: " + this.passe +
                "\n";

    }

    public abstract Jogador clone();

    public boolean equals(Object o) {
        if(this==o){return true;}
        if((o==null)||(this.getClass()!=o.getClass())){return false;}
        Jogador j = (Jogador) o;
        return (this.numero)==(j.getNum()) &&
                (this.nome)==(j.getNome()) &&
                (this.titular)==(j.getTitular()) &&
                (this.historial)==(j.getHistorial()) &&
                (this.velocidade)==(j.getVel()) &&
                (this.resistencia)==(j.getRes()) &&
                (this.destreza)==(j.getDes()) &&
                (this.impulsao)==(j.getImp()) &&
                (this.jogodecabeca)==(j.getCab()) &&
                (this.remate)==(j.getRem()) &&
                (this.passe)==(j.getPasse()) ;


    }

    public abstract double gethabilidade(String posicao);

    public void atualizaHist(Equipa eq) {
        this.historial.add(eq.clone());
    }

    /*public static Jogador parse(String input){
    String[] campos = input.split(",");
    return new Jogador(campos[0], Integer.parseInt(campos[1]), campos[2],
                                  Integer.parseInt(campos[3]),
                                  Integer.parseInt(campos[4]),
                                  Integer.parseInt(campos[5]),
                                  Integer.parseInt(campos[6]),
                                  Integer.parseInt(campos[7]),
                                  Integer.parseInt(campos[8]));
    }*/

}
