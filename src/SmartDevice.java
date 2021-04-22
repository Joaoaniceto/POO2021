import java.io.Serializable;

public class SmartDevice implements Comparable<SmartDevice>, Serializable {
    private String id;
    private boolean estado; //ligado = true, desligado = false

    public SmartDevice() {
        this.id = "";
        this.estado = false;
    }

    public SmartDevice(String id){
        this.id = id;
        this.estado = false;
    }

    public SmartDevice(String id,boolean estado){
        this.id = id;
        this.estado = estado;
    }

    public SmartDevice(SmartDevice o){
        this.id = o.getID();
        this.estado = o.getOn();
    }

    public String getID(){return this.id;}
    public boolean getOn(){return this.estado;}

    public void setID(String id){this.id = id;}
    public void setOn(boolean estado){this.estado = estado;}


    @Override
    public int compareTo(SmartDevice o) {
        return 0;
    }
}
