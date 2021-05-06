import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class main {
    public static void main(String[] args){

        ArrayList<Integer> classif = new ArrayList<Integer>();
        classif.add(8);
        classif.add(10);
        classif.add(7);

        Veiculo v1 = new Veiculo("Mitsubishi","Eclipse","RF-45-TE",1990,175.0,30.0,classif,0,0);
        Veiculo v2 = new Veiculo("Honda","RX7","AB-56-79",1978,200.0,50.0,classif,0,0);
        Veiculo v3 = new Veiculo("BMW","M5 E30","22-QE-RT",1988,150.0,60.0,classif,0,0);
        Veiculo v4 = new Veiculo("Mitsubishi","Evolution","TR-45-DG",2007,230.0,50.0,classif,0,0);

        HashMap<String,Veiculo> vs = new HashMap<String,Veiculo>();
        vs.put(v1.getMatricula(),v1);
        vs.put(v2.getMatricula(),v2);
        vs.put(v3.getMatricula(),v3);
        vs.put(v4.getMatricula(),v4);

        DriveIt veiculos = new DriveIt(vs,"Stand Automoveis");
        System.out.println(veiculos.existeVeiculo("XG-22-RT"));
        System.out.println(veiculos.existeVeiculo("22-QE-RT"));

        System.out.println("quantos veiculos: "+veiculos.quantos());
        System.out.println("quantos mitsubishi: "+veiculos.quantos("Mitsubishi"));
        System.out.println("Info do BMW M5 E30: "+veiculos.getVeiculo("22-QE-RT"));

        Veiculo v5 = new Veiculo("Honda","RX8","ZM-56-80",1978,200.0,50.0,classif,0,0);

        veiculos.adiciona(v5);

        List<BonificaKms> l = veiculos.daoPontos();

        for(BonificaKms b : l) {
            System.out.println(b.getPontosAcumulados());
        }

        try {
            veiculos.saveToCSV("info.txt");
        }

        catch (FileNotFoundException e) {
            System.out.println("Error 'FileNotFound'");
        }
        catch (IOException e) {
            System.out.println("Error 'IO'");
        }

        /*
        try {
            veiculos.guardaEstado("info.txt");
        }

        catch (FileNotFoundException e) {
            System.out.println("Error 'FileNotFound'");
        }
        catch (IOException e) {
            System.out.println("Error 'IO'");
        }

        */

    }
}