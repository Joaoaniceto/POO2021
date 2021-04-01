import java.io.Serializable;
import java.util.ArrayList;

public class Equipas implements Comparable<Equipa>, Serializable {
    //variaveis de instancia
    ArrayList<Equipa> equipas;

    //construtor por omissão
    public Equipas() {
        this.equipas = new ArrayList<Equipa>();
    }

    //construtor parametrizado
    public Equipas(ArrayList<Equipa> equipas) {
        this.equipas = equipas;
    }

    //construtor objeto
    public Equipas(Equipas obj){
        this.equipas = obj.getEquipas();
    }

    public ArrayList<Equipa> getEquipas(){
        return this.equipas;
    }

    public void setEquipas(ArrayList<Equipa> equipas){
        this.equipas = equipas;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for(Equipa e : this.equipas){
            sb.append("\n\nEquipa nº "+i+": "+e.getNome()+"\n"+e.toString());
            i+=1;
        }
        return sb.toString();
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
