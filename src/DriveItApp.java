import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class DriveItApp {
    public static void main(String args[]){
        DriveIt m;
        ArrayList<Integer> classif = new ArrayList<Integer>();
        classif.add(8);
        classif.add(10);
        classif.add(7);
        //carregar o estado (model)
        try {
            m = DriveIt.carregaEstado("DriveIt.obj");
        }
        catch (FileNotFoundException e){
            m = new DriveIt();

            String marca = "Honda";
            String modelo = "RX7";
            Veiculo v;

            for(int i=0; i<2; i++){
                v = new Veiculo("Honda","RX7","AB-56-79",1978,200.0,50.0,classif,0,0);
                m.adiciona(v);
            }

            marca = "Mitsubishi";
            modelo = "Eclipse";
            for(int i=0; i<2; i++){
                v = new Veiculo("Mitsubishi","Eclipse","RF-45-TE",1990,175.0,30.0,classif,0,0);
                m.adiciona(v);
            }

            marca = "BMW";
            modelo = "M5 E30";
            for(int i=0; i<2; i++){
                v = new Veiculo("BMW","M5 E30","22-QE-RT",1988,150.0,60.0,classif,0,0);
                m.adiciona(v);
            }

            marca = "Mitsubishi";
            modelo = "Evolution";
            for(int i=0; i<2; i++){
                v = new Veiculo("Mitsubishi","Evolution","TR-45-DG",2007,230.0,50.0,classif,0,0);
                m.adiciona(v);
            }



            marca = "bus";
            modelo = "BUSModel";
            for(int i=0; i<2; i++){
                v = new AutocarroInteligente(marca+i,modelo+1,"matricula: "+1,2020,70);
                m.adiciona(v);
            }

            e.printStackTrace();
        }
        catch (IOException e){
            m = new DriveIt();
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            m = new DriveIt();
            e.printStackTrace();
        }

        //executar o programa
        new DriveItDelegate(m).run();

        //gravar o estado
        try {
            m.guardaEstado("DriveIt.obj");
        }
        catch (IOException e) {
            System.out.println("Não foi possivel gravar os dados :(\n"+e.getMessage());
        }



    }
}
