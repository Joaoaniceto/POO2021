import java.time.LocalDate;
import java.util.*;
import java.lang.Math;

/*
o projeto teve q levar mts alterações, mudei os tipos das variaveis
subsCasa e subsVisitante para ser mais facil de trabalhar e para irem de
acordo com o parser dos stores. tb criei um construtor novo para a classe Jogo.

 */

enum estado {por_iniciar,decorrer,terminado}

public class Jogo {
    private Equipa equipaCasa;
    private Equipa equipaVisitante;
    private LocalDate data;
    private Map<Integer,Integer> subsCasa;        //falta metodo atualiza subs casa
    private Map<Integer,Integer> subsVisitante;  //falta metodo atualiza subs casa
    private estado state;
    private int golosCasa , golosVisitante;
    private HashMap<String,List<Integer>> modeloCasa;
    private HashMap<String,List<Integer>> modeloVisitante;
    private List<Integer> titularesCasa;
    private List<Integer> titularesVisitante;

    public Jogo() {
        this.equipaCasa = new Equipa();
        this.equipaVisitante = new Equipa();
        this.subsCasa = new HashMap<Integer,Integer>();
        this.subsVisitante = new HashMap<Integer,Integer>();
        this.state= estado.por_iniciar;
        this.golosCasa = 0;
        this.golosVisitante = 0;
        this.modeloCasa = new HashMap<>();
        this.modeloVisitante = new HashMap<>();
    }

    public Jogo(Equipa casa, Equipa visitante, Map<Integer,Integer> subsC, Map<Integer,Integer> subsV, int golosC, int golosV, LocalDate data, List<Integer> jc, List<Integer> jv) {
        this.equipaCasa = casa;
        this.equipaVisitante = visitante;
        this.subsCasa = subsC;
        this.subsVisitante = subsV;
        this.golosCasa = golosC;
        this.golosVisitante = golosV;
        this.data = data;
        this.titularesCasa = jc;
        this.titularesVisitante = jv;
    }

    public Jogo(Equipa casa,Equipa visitante,Map<Integer,Integer> subsCasa,Map<Integer,Integer> subsVisitante,int golosCasa,int golosVisitante,HashMap<String,List<Integer>> mc,HashMap<String,List<Integer>> mv){
        this.equipaCasa = casa;
        this.equipaVisitante = visitante;
        this.data = LocalDate.now();
        this.subsCasa = subsCasa;
        this.subsVisitante = subsVisitante;
        this.state = estado.por_iniciar;
        this.golosCasa = golosCasa;
        this.golosVisitante = golosVisitante;
        this.modeloCasa = mc;
        this.modeloVisitante = mv;
    }

    public Jogo(Jogo o){
        this.equipaCasa = o.getCasa();
        this.equipaVisitante = o.getVisitante();
        this.data = o.getData();
        this.subsCasa = o.getSubsCasa();
        this.subsVisitante = o.getSubsVisitante();
        this.state = estado.por_iniciar;
        this.golosCasa = o.getGolosCasa();
        this.golosVisitante = o.getGolosVisitante();
        this.modeloCasa = o.getModeloCasa();
        this.modeloVisitante = o.getModeloVisitante();
    }

    public Equipa getCasa() {return this.equipaCasa;}
    public Equipa getVisitante() {return this.equipaVisitante;}
    public LocalDate getData() {return this.data;}
    public Map<Integer,Integer> getSubsCasa() {return this.subsCasa;}
    public Map<Integer,Integer> getSubsVisitante() {return this.subsVisitante;}
    public estado getEstado() {return this.state;}
    public int getGolosCasa() {return this.golosCasa;}
    public int getGolosVisitante() {return this.golosVisitante;}
    public List<Integer> getTitularesCasa() {return this.titularesCasa;}
    public List<Integer> getTitularesVisitante() {return this.titularesVisitante;}
    public HashMap<String,List<Integer>> getModeloCasa() {return this.modeloCasa;}
    public HashMap<String,List<Integer>> getModeloVisitante() {return this.modeloVisitante;}

    public void setEquipaCasa(Equipa casa) {this.equipaCasa = casa; }
    public void setEquipaVisitante(Equipa visitante) {this.equipaVisitante = visitante;}
    public void setData(LocalDate data) {this.data = data;};
    public void setSubsCasa(Map<Integer,Integer> sc) {this.subsCasa = sc;}
    public void setSubsVisitante(Map<Integer,Integer> sv) {this.subsVisitante = sv;}
    public void setEstado(estado e) {this.state = e;} //falta dar bound no argumento, para que seja apenas possivel e=0, e=1 ou e=-1 // bounded argument
    public void setGolosCasa(int gc) {this.golosCasa = gc;}
    public void setGolosVisitante(int gv) {this.golosVisitante = gv;}
    public void setModeloCasa(HashMap<String,List<Integer>> mc) {this.modeloCasa = mc;}
    public void setModeloVisitante(HashMap<String,List<Integer>> mv) {this.modeloVisitante = mv;}

    public void setTitularesCasa(List<Integer> jc) {
        HashMap<Integer,Jogador> e = this.equipaCasa.getEquipa();
        //System.out.println("e: "+e);
        HashMap<String,List<Integer>> tactic = new HashMap<>();
        for (Map.Entry<Integer, Jogador> entry : e.entrySet()) {
            Integer i = entry.getKey();
            Jogador j = entry.getValue();
            //System.out.println("contains? "+jc.contains(i));
            if (jc.contains(i)) {
                //faz jogador ser titular :)
                j.setTitular(true);

                //adiciona o jogador à tatica :)
                String role = j.getClass().getName();
                //System.out.println("role: "+role);
                if ( tactic.containsKey(role) ) {
                    tactic.get(role).add(i);
                }
                else {
                    ArrayList<Integer> nr = new ArrayList<>();
                    nr.add(i);
                    tactic.put(role,nr);
                }
            }
            else {j.setTitular(false);}
        }
        //System.out.println("tactic: "+tactic);
        setModeloCasa(tactic);
    }

    public void setTitularesVisitante(List<Integer> jv) {
        HashMap<Integer,Jogador> e = this.equipaVisitante.getEquipa();
        HashMap<String,List<Integer>> tactic = new HashMap<>();
        for (Map.Entry<Integer, Jogador> entry : e.entrySet()) {
            Integer i = entry.getKey();
            Jogador j = entry.getValue();
            if (jv.contains(i)) {
                //faz jogador ser titular :)
                j.setTitular(true);

                //adiciona o jogador à tatica :)
                String role = j.getClass().getName();

                if ( tactic.containsKey(role) ) {
                    tactic.get(role).add(i);
                }
                else {
                    ArrayList<Integer> nr = new ArrayList<>();
                    nr.add(i);
                    tactic.put(role,nr);
                }
            }
            else {j.setTitular(false);}
        }
        this.modeloVisitante = tactic;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Equipa da casa: "+this.equipaCasa.getNome());
        sb.append("\nEquipa visitante: "+this.equipaVisitante.getNome());
        sb.append("\nData: "+this.data);
        sb.append("\nSubstituições da Equipa da Casa: "+this.subsCasa);        //falta percorrer a lista de jogadores
        sb.append("\nSubstituições da Equipa Visitante: "+this.subsVisitante);     //substituidos e dar append do nome
        sb.append("\nEstado do jogo: "+this.state);
        sb.append("\nGolos da Equipa da Casa: "+this.golosCasa);
        sb.append("\nGolos da Equipa Visitante: "+this.golosVisitante);
        sb.append("\nModelo Tático Equipa Casa: "+this.modeloCasa);
        sb.append("\nModelo Tático Equipa Visitante: "+this.modeloVisitante);
        sb.append("\nLista de Jogadores Titulares da Casa: "+this.titularesCasa);
        sb.append("\nLista de Jogadores Titulares Visitantes: "+this.titularesVisitante);
        sb.append("\n");
        return sb.toString();
    }

    public Jogo clone() {
        return new Jogo(this);
    }


    public boolean equals(Object o) {
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        Jogo e = (Jogo) o;
        return (this.equipaCasa) == (e.getCasa()) &&
                (this.equipaVisitante) == (e.getVisitante()) &&
                (this.data) == (e.getData()) &&
                (this.subsCasa) == (e.getSubsCasa()) &&
                (this.subsVisitante) == (e.getSubsVisitante()) &&
                (this.state) == (e.getEstado()) &&
                (this.golosCasa) == (e.getGolosCasa()) &&
                (this.golosVisitante) == (e.getGolosVisitante());
    }

    public void estadoModeloCasa(String pos,Integer ID,Integer order){
        this.modeloCasa.get(pos).set(order,ID);
    }

    public void estadoModeloVisitante(String pos,Integer ID,Integer order){
        this.modeloVisitante.get(pos).set(order,ID);
    }

    public static Jogo parse(String input,Map<String, Equipa> equipas){
        Equipa eC = new Equipa();
        Equipa eV = new Equipa();
        String[] campos = input.split(",");
        String[] data = campos[4].split("-");
        List<Integer> jc = new ArrayList<>();
        List<Integer> jf = new ArrayList<>();
        Map<Integer, Integer> subsC = new HashMap<>();
        Map<Integer, Integer> subsF = new HashMap<>();
        Integer c = 0;
        //System.out.println("compare: "+equipas.get("Schumann Athletic").getNome()+" with "+campos[0]);
        for (Map.Entry<String, Equipa> entry : equipas.entrySet()) {
            //System.out.println("compare: "+entry.getKey()+" with: "+campos[0]);
            if(campos[0].equals(entry.getKey())){eC=entry.getValue();c++;}
            if(campos[1].equals(entry.getKey())){eV=entry.getValue();c++;}
        }
        for (int i = 5; i < 16; i++){
            jc.add(Integer.parseInt(campos[i]));
        }
        for (int i = 16; i < 19; i++){
            String[] sub = campos[i].split("->");
            subsC.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }
        for (int i = 19; i < 30; i++){
            jf.add(Integer.parseInt(campos[i]));
        }
        for (int i = 30; i < 33; i++){
            String[] sub = campos[i].split("->");
            subsF.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }              //equipaC   equipaV   subsC   subsV      golosC                    gologV
        return new Jogo(eC,eV, subsC, subsF,Integer.parseInt(campos[2]), Integer.parseInt(campos[3]),
                LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])),
                jc,  jf);
    }

    public String gethab() {
        double a = this.equipaCasa.gethabilidades();
        double b = this.equipaVisitante.gethabilidades();

        return  this.equipaCasa.getNome() + " tem habilidade de " + a + "\n" + this.equipaVisitante.getNome() + " tem hab de " + b;
    }




    public void startJogo() {
        //antes do jogo começar, convém atribuir os valores de titular a cada um dos jogadores
        //cada jogo tem titulares diferentes. temos que percorrer todos os jogadores de ambas as equipas,
        //caso um jogador que nao esteja em titularesCasa esteja definido como titular em consequencia de um jogo anterior.
        setTitularesCasa(this.titularesCasa);
        setTitularesVisitante(this.titularesVisitante);
        this.toString();
        System.out.println("Começa o jogo na casa do " + this.equipaCasa.getNome()+ " contra " + this.equipaVisitante.getNome() + "\n" );
        System.out.println(this.gethab());
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            double coin = Math.random();

            Fase fase = new Fase(equipaCasa,equipaVisitante,0,coin >0.5 ? 1 : 0 ,4,coin>0.5 ? equipaCasa.getJogador(modeloCasa.get("Medio").get(0)) : equipaVisitante.getJogador(modeloVisitante.get("Medio").get(0)),modeloCasa,modeloVisitante );


            @Override
            public void run() {
                fase.getState(fase.getEquipaAtacante(),fase.getFase(),fase.getJogador());
                fase.setTime(fase.getTime() + 1);
                if (fase.getTime() == 90) {
                    timer.cancel();  //stop the timer
                    fase.result();
                };
            }
        }, 0, 1000);//wait 0 ms before doing the action and do it every 1000ms (1second)

    }
// teste de comentario

}
