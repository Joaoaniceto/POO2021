public class SmartBulb extends SmartDevice {
    private int tonalidade;
    public static final int WARM = 2;
    public static final int NEUTRAL = 1;
    public static final int COLD = 0;

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
    public void setTone(int t){
        if(t>2){this.tonalidade = WARM;}
        if(t<0){this.tonalidade = COLD;}
        if(t==0||t==1||t==2){this.tonalidade=t;}
    }




}
