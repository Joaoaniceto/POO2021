import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//a variavel de isntancia equipas passou de ArrayList<Equipa> para Map<String, Equipa> ;)

public class Equipas implements Comparable<Equipa>, Serializable {
    //variaveis de instancia
    Map<String, Equipa> equipas;     //(nome,equipa)

    //construtor por omissão
    public Equipas() {
        this.equipas = new HashMap<String,Equipa>();
    }

    //construtor parametrizado
    public Equipas(Map<String,Equipa> equipas) {
        this.equipas = equipas;
    }

    //construtor objeto
    public Equipas(Equipas obj){
        this.equipas = obj.getEquipas();
    }

    public Map<String,Equipa> getEquipas(){
        return this.equipas;
    }

    public void setEquipas(Map<String,Equipa> equipas){
        this.equipas = equipas;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for(Equipa e : this.equipas.values()){
            sb.append("\n\nEquipa nº "+i+": "+e.getNome()+"\n"+e.toString());
            i+=1;
        }
        return sb.toString();
    }

    public void addEquipa(Equipa e){
        this.equipas.put(e.getNome(),e);
    }

    public Equipas clone(){
        return new Equipas(this);
    }

    public boolean equals(Object o){
        if (this==o)
            return true;
        if((o==null)||(this.getClass()!=o.getClass()))
            return false;
        Equipas e = (Equipas) o;
        return (this.equipas) == (e.getEquipas());
    }

    @Override
    public int compareTo(Equipa o) {
        return 0;
    }
}
