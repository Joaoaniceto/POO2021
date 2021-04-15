public class SmartSpeaker extends SmartDevice {
    private String canal;
    private int volume;
    public static final int MAX = 10;

    public SmartSpeaker(){
        super();
        this.canal = "n/a";
        this.volume = 0;
    }

    public SmartSpeaker(String id){
        super(id);
        this.canal = "n/a";
        this.volume = 0;
    }

    public SmartSpeaker(String id,String canal,int volume){
        super(id);
        this.canal = canal;
        this.volume = volume;
    }

    public SmartSpeaker(String id,boolean estado,String canal,int volume){
        super(id,estado);
        this.canal = canal;
        this.volume = volume;
    }

    public SmartSpeaker(SmartSpeaker o){
        super(o);
        this.canal = o.getChannel();
        this.volume = o.getVolume();
    }

    public String getChannel(){return this.canal;}
    public int getVolume(){return this.volume;}
    public void setChannel(String canal){this.canal = canal;}
    public void setVolume(int vol){this.volume = vol;}

    public void volumeUp(){
        this.volume += 1;
    }

    public void volumeDown(){
        this.volume -= 1;
    }

}
