import Exceptions.NoDeviceException;

import java.awt.*;
import java.util.*;

public class CasaInteligente {
    private String morada;
    private HashMap<String, ArrayList<SmartDevice>> rooms;

    public CasaInteligente() {
        this.morada = "n/a";
        this.rooms = new HashMap<String, ArrayList<SmartDevice>>();
    }

    public CasaInteligente(String morada) {
        this.morada = morada;
        this.rooms = new HashMap<String, ArrayList<SmartDevice>>();
    }

    public CasaInteligente(String morada, HashMap<String, ArrayList<SmartDevice>> rooms) {
        this.morada = morada;
        this.rooms = rooms;
    }

    public CasaInteligente(CasaInteligente o) {
        this.morada = o.getMorada();
        this.rooms = o.getRooms();
    }

    public String getMorada() {
        return this.morada;
    }

    public HashMap<String, ArrayList<SmartDevice>> getRooms() {
        return this.rooms;
    }

    public boolean existsDevice(String ID) {
        for (HashMap.Entry<String, ArrayList<SmartDevice>> entry : this.rooms.entrySet()) {
            for (SmartDevice elem : entry.getValue()) {
                if (ID == elem.getID()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void addRoom(String quarto) {
        ArrayList<SmartDevice> a = new ArrayList<SmartDevice>();
        this.rooms.put(quarto, a);
    }

    public void removeFromRoom(String quarto,String ID){
        for(SmartDevice sd : this.rooms.get(quarto)){
            if(ID==sd.getID()){
                this.rooms.get(quarto).remove(sd);
                break;
            }
        }
    }

    public void addToRoom(String quarto,String ID) {
        int flag = 0;
        for (HashMap.Entry<String, ArrayList<SmartDevice>> entry : this.rooms.entrySet()) {
            for (SmartDevice sd : entry.getValue()) {
                if (ID == sd.getID()) {
                    if (quarto == entry.getKey()) {
                        flag = 1;
                        break;
                    } else {
                        flag = 1;

                        addDevice(sd,quarto);

                        removeFromRoom(entry.getKey(), ID);
                    }
                }
            }
        }
        if (flag == 0) {
            ArrayList<SmartDevice> a = new ArrayList<SmartDevice>();
            SmartDevice sd = new SmartDevice(ID);
            a.add(sd);
            this.rooms.put(quarto, a);
        }
    }


    public void addDevice(SmartDevice sd, String quarto) {
        int flag = 0;
        for (HashMap.Entry<String, ArrayList<SmartDevice>> entry : this.rooms.entrySet()) {
            if (entry.getKey() == quarto) {
                entry.getValue().add(sd);
                flag += 1;
                break;
            }
        }
        if (flag == 0) {
            addRoom(quarto);
            ArrayList<SmartDevice> a = new ArrayList<SmartDevice>();
            a.add(sd);
            this.rooms.put(quarto, a);
        }
    }

    public SmartDevice getDevice(String ID){
        SmartDevice s = new SmartDevice();
        for (HashMap.Entry<String, ArrayList<SmartDevice>> entry : this.rooms.entrySet()) {
            for (SmartDevice device : entry.getValue()) {
                if (device.getID() == ID) {
                    s = device;
                }
            }
        }
        return s;
    }

    public void setAllOn(boolean estado) {
        for (HashMap.Entry<String, ArrayList<SmartDevice>> entry : this.rooms.entrySet()) {
            for (SmartDevice device : entry.getValue()) {
                device.setOn(estado);
            }
        }
    }

    public boolean hasRoom(String room) {
        for (HashMap.Entry<String, ArrayList<SmartDevice>> entry : this.rooms.entrySet()) {
            if (entry.getKey() == room) {
                return true;
            }
        }
        return false;
    }

    public boolean roomHasDevice(String room,String ID) {
        for (HashMap.Entry<String, ArrayList<SmartDevice>> entry : this.rooms.entrySet()) {
            for (SmartDevice device : entry.getValue()) {
                if (device.getID() == ID && entry.getKey() == room) {
                    return true;
                }
            }
        }
        return false;
    }



}

