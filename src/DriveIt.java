import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class DriveIt implements Serializable {
    private Map<String,Veiculo> veiculos;
    private String nome;

    public DriveIt(){
        HashMap<String,Veiculo> v = new HashMap<String,Veiculo>() ;
        this.veiculos = v;
        this.nome = "";
    }

    public DriveIt(Map<String,Veiculo> v,String nome){
        this.veiculos = v;
        this.nome = nome;
    }

    public DriveIt(DriveIt obj){
        this.veiculos = obj.getVeiculos();
        this.nome = obj.getNome();
    }

    public Map<String,Veiculo> getVeiculos() {return this.veiculos;}
    public String getNome() {return this.nome;}
    public void setVeiculos(Map<String,Veiculo> v){this.veiculos = v;}
    public void setNome(String nome) {this.nome = nome;}

    public boolean existeVeiculo(String cod){
        for(Veiculo v : this.veiculos.values()){
            //System.out.println("mat: "+v.getMatricula()+" cod: "+cod);
            if(v.getMatricula().equals(cod)){return true;}
        }
        return false;
    }

    public int quantos() {
        return veiculos.size();
    }

    public int quantos(String marca){
        int c = 0;
        for(Veiculo v : this.veiculos.values()){
            if(v.getMarca().equals(marca)){c++;}
        }
        return c;
    }

    public Veiculo getVeiculo(String cod){
        Veiculo v = this.veiculos.get(cod);
        return v!=null?v.clone():v;
    }


    public void adiciona(Veiculo v) {
        this.veiculos.put(v.getMatricula(), v);
    }
/*
    public List<Veiculo> getVeiculos() {
        List<Veiculo> l = new ArrayList<Veiculo>();
        l = (List<Veiculo>) this.veiculos.values();
        return l;
    }
*/

    public void adiciona(Set<Veiculo> vs){
        for(Veiculo v : vs){
            this.adiciona(v);
        }
    }

    public void registarAluguer(String codVeiculo, int numKms){
        int km = 0;
        //double preco = 0;
        for(Veiculo v : this.veiculos.values()){
            if(codVeiculo.equals(v.getMatricula())){
                km = v.getKms();
                km += numKms;
                v.setKms(km);
                //preco = v.getPrecokm() * km;
            }
        }

    }



    public List<BonificaKms> daoPontos(){
        return this.veiculos.values()
                            .stream()
                            .filter(v -> v instanceof BonificaKms)
                            .map(v -> (BonificaKms) v.clone())
                            .collect(Collectors.toList());
    }

    public void saveToCSV(String fn) throws FileNotFoundException, IOException {

        PrintWriter pw = new PrintWriter(new FileOutputStream(fn));
        pw.println(this.nome);

        for(Veiculo v : this.veiculos.values()) {
            pw.println(v.toString());
        }

        pw.close();
    }

    public void guardaEstado(String fn) throws FileNotFoundException, IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fn));
        oos.writeObject(this);
        oos.close();
    }

    public static DriveIt carregaEstado(String fn) throws FileNotFoundException,
                                                          IOException,
                                                          ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fn));
        DriveIt di = (DriveIt) ois.readObject();
        ois.close();
        return di;
    }


}
