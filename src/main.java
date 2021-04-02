import java.util.ArrayList;
import java.util.HashMap;

public class main {
    public static void main(String[] args) {
        Lateral l = new Lateral(3,"Pepe",true,70,60,80,67,58,99,45);
        Defesa d = new Defesa(13,"Ruben Dias",false,60,60,60,60,60,60,60);
        Medio m = new Medio(8,"João Moutinho",true,80,80,80,80,80,80,80);
        Avançado a = new Avançado(7,"Cristiano Ronaldo",true,90,90,90,90,90,90,90);
        GuardaRedes g = new GuardaRedes(1,"Rui Patrício",false,100,100,100,100,100,100,100,100);

        /* This is how to declare HashMap */
        HashMap<Integer, Jogador> hmap = new HashMap<Integer, Jogador>();

        /*Adding elements to HashMap*/
        hmap.put(l.getNum(), l);
        hmap.put(d.getNum(), d);
        hmap.put(m.getNum(), m);
        hmap.put(a.getNum(), a);
        hmap.put(g.getNum(), g);

        Equipa selecaoA= new Equipa("Seleção Portuguesa A",hmap);

        Lateral l1 = new Lateral(4,"João",true,70,60,80,67,58,99,45);
        Defesa d1 = new Defesa(16,"Felipe",false,60,60,60,60,60,60,60);
        Medio m1 = new Medio(32,"Mário",true,80,80,80,80,80,80,80);
        Avançado a1 = new Avançado(12,"Rodrigo",true,90,90,90,90,90,90,90);
        GuardaRedes g1 = new GuardaRedes(17,"Vítor",true,100,100,100,100,100,100,100,100);

        HashMap<Integer, Jogador> hmap1 = new HashMap<Integer, Jogador>();

        /*Adding elements to HashMap*/
        hmap1.put(l1.getNum(), l1);
        hmap1.put(d1.getNum(), d1);
        hmap1.put(m1.getNum(), m1);
        hmap1.put(a1.getNum(), a1);
        hmap1.put(g1.getNum(), g1);

        Equipa selecaoB = new Equipa("Seleção Portuguesa B",hmap1);

        selecaoB.removeJogador(g1);
        selecaoA.addJogador(g1);
        selecaoA.transferenciaJogador(selecaoB,a);
        selecaoA.substituicao(l,d);

        ArrayList<Equipa> array = new ArrayList<Equipa>();
        array.add(selecaoA);
        array.add(selecaoB);
        Equipas equipas = new Equipas(array);

        System.out.println(equipas.toString());




    }
}
