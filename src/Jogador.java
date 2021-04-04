import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

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
    }

    public int getNum(){return this.numero;}
    public String getNome(){return this.nome;}
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
                "\nNome do Jogador: " + this.nome +
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

    public abstract double gethabilidade();
}
