import java.io.FileNotFoundException;
import java.io.IOException;

public class DriveItApp {
    public static void main(String args[]){
        DriveIt m;

        //carregar o estado (model)
        try {
            m = DriveIt.carregaEstado("DriveIt.obj");
        }
        catch (FileNotFoundException e){
            m = new DriveIt();

            String marca = "marca";
            String modelo = "modelo";
            Veiculo v;

            for(int i=0; i<2; i++){
                v = new VeiculoNormal(marca+i,modelo+1,"matricula o"+1,2020,70);
                m.adiciona(v);
            }

            marca = "marcaP";
            modelo = "modelo$$$";
            for(int i=0; i<2; i++){
                v = new VeiculoPremium(marca+i,modelo+1,"matricula p"+1,2020,70);
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
