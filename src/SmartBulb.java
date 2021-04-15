public class SmartBulb extends SmartDevice {
    private int tonalidade;
    public static final int WARM = 1;
    public static final int NEUTRAL = 0;
    public static final int COLD = -1;

    public SmartBulb(){
        super();
        this.tonalidade = NEUTRAL;
    }

    public SmartBulb(String id){
        super(id);
        this.tonalidade = NEUTRAL;
    }

    public SmartBulb(String id,int tonalidade){
        super(id);
        this.tonalidade = tonalidade;
    }

    public SmartBulb(String id,boolean estado,int tonalidade){
        super(id,estado);
        this.tonalidade = tonalidade;
    }

    public SmartBulb(SmartBulb o){
        super(o);
        this.tonalidade = o.getTone();
    }

    public int getTone(){return this.tonalidade;}
    public void setTone(int t){this.tonalidade = t;}




}
