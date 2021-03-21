public class main {
    public static void main(String[] args) {
        Lateral l = new Lateral();
        Defesa d = new Defesa();
        Medio m = new Medio();
        Avançado a = new Avançado();
        GuardaRedes g = new GuardaRedes("Rui Patrício",true,100,100,100,100,100,100,100,100);
        String res = g.toString();
        System.out.println(res);



    }
}
