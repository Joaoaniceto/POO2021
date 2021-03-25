
public class Circulo {
    private double x , y ,raio;

    //Construtor de Objetos para esta classe
    public Circulo() {
        this.x = 0;
        this.y = 0;
        this.raio = 1;
    }

    public Circulo(double x, double y, double raio) {
        this.x = x;
        this.y = y;
        this.raio = raio;
    }

    public Circulo(Circulo c){
        this.x = c.getX();
        this.y = c.getY();
        this.raio = c.getRaio();
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double getRaio(){
        return this.raio;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public void setRaio(double raio){
        this.raio = raio;
    }

    public void alteraCentro(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double calculaArea() {
        return (Math.PI)*(Math.pow(this.raio,2));
    }

    public double calculaPerimetro(){
        return 2*Math.PI*raio;
    }

    public String toString() {
        return "Circulo(x:"+this.x+", y:"+this.y+", raio:"+this.raio+")";
    }

    public boolean equals(Object o){
        if(this==o)
            return true;
        if((o==null) | (o.getClass() != this.getClass()))
            return false;
        Circulo c = (Circulo) o;
        return this.x == c.getX() && this.y==getY() && this.raio==c.getRaio();
    }

    public Circulo clone() {
        return new Circulo(this);
    }
}






