public class Triangulo {
    //instance variables
    private Ponto p1,p2,p3;

    //Constructor for objects of class Triangulo
    public Triangulo() {
        //initialize instance variables
        this.p1 = new Ponto();
        this.p2 = new Ponto();
        this.p3 = new Ponto();
    }

    public Triangulo(Ponto a, Ponto b, Ponto c) {
        this.p1 = a.clone();
        this.p2 = b.clone();
        this.p3 = c.clone();
    }

    public Triangulo(Triangulo t){
        this.p1 = t.getP1();
        this.p2 = t.getP2();
        this.p3 = t.getP3();
    }

    public Ponto getP1(){
        return this.p1.clone();
    }

    public Ponto getP2(){
        return this.p2.clone();
    }

    public Ponto getP3(){
        return this.p3.clone();
    }

    public void setP1(Ponto p){
        this.p1 = p.clone();
    }

    public void setP2(Ponto p){
        this.p2 = p.clone();
    }

    public void setP3(Ponto p){
        this.p3 = p.clone();
    }

    //Perímetro
    public double perimetro(){
        return p1.distancia(p2) + p2.distancia(p3) + p3.distancia(p1);
    }

    public boolean equals(Object o){
        if(this == o)
            return true;
        if((o==null)||(this.getClass()!=o.getClass()))
            return false;
        Triangulo t = (Triangulo) o;
        return this.p1.equals(t.getP1()) && this.p2.equals(t.getP2()) && this.p3.equals(getP3());
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("Triangulo: ");
        sb.append(this.p1.toString());
        sb.append(" / ");
        sb.append(this.p2.toString());
        sb.append(" / ");
        sb.append(this.p3.toString());
        return sb.toString();
    }

    public Triangulo clone() {
        return new Triangulo(this);
    }

}
