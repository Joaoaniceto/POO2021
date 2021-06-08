import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class main {
    public static void main(String[] args) throws Exception {
        /*
        ArrayList<Equipa> h1 = new ArrayList<Equipa>();

        Lateral l = new Lateral(3,"Pepe",true,h1,70,60,80,67,58,99,45,80);
        Defesa d = new Defesa(13,"Ruben Dias",false,h1,60,60,60,60,60,60,60,70);
        Medio m = new Medio(8,"João Moutinho",true,h1,80,80,80,80,80,80,80,90);
        Avançado a = new Avançado(7,"Cristiano Ronaldo",true,h1,90,90,90,90,90,90,90,99);
        GuardaRedes g = new GuardaRedes(1,"Rui Patrício",false,h1,100,100,100,100,100,100,100,100);
        */
        /* This is how to declare HashMap */
        //HashMap<Integer, Jogador> hmap = new HashMap<Integer, Jogador>();

        /*Adding elements to HashMap*/
        /*
        hmap.put(l.getNum(), l);
        hmap.put(d.getNum(), d);
        hmap.put(m.getNum(), m);
        hmap.put(a.getNum(), a);
        hmap.put(g.getNum(), g);

        Equipa selecaoA= new Equipa("Seleção Portuguesa A",hmap);

        Lateral l1 = new Lateral(4,"João",true,h1,70,60,80,67,58,99,45,86);
        Defesa d1 = new Defesa(16   ,"Felipe",false,h1,60,60,60,60,60,60,60,77);
        Medio m1 = new Medio(32,"Mário",true,h1,80,80,80,80,80,80,80,70);
        Avançado a1 = new Avançado(12,"Rodrigo",true,h1,90,90,90,90,90,90,90,85);
        GuardaRedes g1 = new GuardaRedes(17,"Vítor",true,h1,100,100,100,100,100,100,100,100);

        HashMap<Integer, Jogador> hmap1 = new HashMap<Integer, Jogador>();
        */
        /*Adding elements to HashMap*/
        /*
        hmap1.put(l1.getNum(), l1);
        hmap1.put(d1.getNum(), d1);
        hmap1.put(m1.getNum(), m1);
        hmap1.put(a1.getNum(), a1);
        hmap1.put(g1.getNum(), g1);

        Equipa selecaoB = new Equipa("Seleção Portuguesa B",hmap1);

        selecaoB.removeJogador(g1);
        selecaoA.addJogador(g1);
        selecaoA.transferenciaJogador(selecaoB,a);

        StringBuilder sb = new StringBuilder();
        sb.append("Historial do Cristiano Ronaldo: \n");
        for(Equipa eq : a.getHistorial()) {
            sb.append(eq.getNome());
            sb.append("\n");
        }
        System.out.println(sb.toString());

        selecaoA.substituicao(l,d);

        ArrayList<Equipa> array = new ArrayList<Equipa>();
        array.add(selecaoA);
        array.add(selecaoB);
        Equipas equipas = new Equipas(array);

        System.out.println(equipas.toString());

        System.out.println("\n\nCR7: "+a.gethabilidade("")+"\n");

        System.out.println("\nhabilidade da seleção A: "+selecaoA.gethabilidades());
        System.out.println("habilidade da seleção B: "+selecaoB.gethabilidades());

        ArrayList<Jogador> subV = new ArrayList<>();
        ArrayList<Jogador> subC = new ArrayList<>();

        HashMap<String,ArrayList<Integer>> modeloC = new HashMap<>();
        HashMap<String,ArrayList<Integer>> modeloV = new HashMap<>();

        ArrayList<Integer> i = new ArrayList<>();
        i.add(0);

        ArrayList<Integer> j = new ArrayList<>();
        j.add(0);
        j.add(0);

        modeloC.put("guarda-redes",i);
        modeloC.put("defesas",j);

        //Jogo game = new Jogo(selecaoA,selecaoB, subC,subV,0,0,modeloC,modeloV);

        //game.estadoModeloCasa("guarda-redes",1,0);
        //game.estadoModeloCasa("defesas",13,0);
        //game.estadoModeloCasa("defesas",32,1);

        //System.out.println("\n"+game.toString());
        */

        Data d = Parser.parse();
        List<Jogo> jogos = d.getJogos();
        Jogo j = jogos.get(0);
        // j.startJogo();

         j.setTitularesCasa(j.getTitularesCasa());
         j.setTitularesVisitante(j.getTitularesVisitante());
         System.out.println(j.toString());

    }
}
