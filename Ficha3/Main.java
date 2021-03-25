
public class Main {
    public static void main(String[] args) {
        /*
        Circulo c1 = new Circulo(1,1,2);
        Circulo c2 = new Circulo(c1);
        System.out.println("c1: "+c1.toString());
        System.out.println("c2: "+c2.toString());
        System.out.println("area do c1: "+c1.calculaArea());
        System.out.println("c1==c2? "+c1.equals(c2));
        */
        Ponto p1 = new Ponto(0,0);
        Ponto p2 = new Ponto(1,0);
        Ponto p3 = new Ponto(0,1);
        Triangulo t1 = new Triangulo(p1,p2,p3);
        String res = t1.toString();
        System.out.println(res);
    }
}
