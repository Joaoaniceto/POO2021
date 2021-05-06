import java.util.ArrayList;
import java.lang.String;

public class Lateral extends Jogador {
    //VARIAVEL DE INSTANCIA EXTRA
    private int cruzamento;

    //construtor por omissão
    public Lateral(int i, String name, boolean b, ArrayList<Equipa> hist, int parseInt, int anInt, int i1, int parseInt1, int anInt1, int i2, int parseInt2, int anInt2, int i3){
        super();
        this.cruzamento = 0;
    }

    //construtor parametrizado
    public Lateral(int numero, String nome, boolean titular, ArrayList<Equipa> h, int vel, int res,
                   int des, int imp, int cab, int rem, int passe,int cruzamento){
        super(numero,nome,titular,h,vel,res,des,imp,cab,rem,passe);
        this.cruzamento = cruzamento;
    }

    //construtor por objeto
    public Lateral(Lateral l){
        super(l);
        this.cruzamento = l.getCruzamento();
    }

    public int getCruzamento() { return this.cruzamento; }
    public void setCruzamento(int c){ this.cruzamento = c; }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(super.toString());
        s.append("Valor de Cruzamento: ").append(getCruzamento());
        s.append("\n");
        return s.toString();
    }

    @Override
    public int compareTo(Jogador o) {
        return 0;
    }



    public Lateral clone() {
        return new Lateral(this);
    }

    public double gethabilidade(String posicao){
        switch (posicao){
            case "Avançado":
                return super.getVel()*0.2 + super.getRes()*0.05+ super.getDes()*0.05 + super.getImp()*0.1 + super.getCab()*0.1 + super.getRem()*0.2 + super.getPasse()*0.1;

            case "Medio":
                return super.getVel()*0.1 + super.getRes()*0.1+ super.getDes()*0.1 + super.getImp()*0.1 + super.getCab()*0.1 + super.getRem()*0.1 + super.getPasse()*0.1 ;


            case "Guarda-Redes":
                return super.getVel()*0.1+ super.getRes()*0.1+ super.getDes()*0.1 + super.getImp()*0.1 + super.getRem()*0.1 + super.getPasse()*0.1;


            case "Defesa":
                return super.getVel()*0.05 + super.getRes()*0.2+ super.getDes()*0.1 + super.getImp()*0.1 + super.getCab()*0.2 + super.getRem()*0.1 + super.getPasse()*0.1;

            default:
                return super.getVel()*0.1 + super.getRes()*0.1+ super.getDes()*0.1 + super.getImp()*0.05 + super.getCab()*0.1 + super.getRem()*0.15 + super.getPasse()*0.15 + this.cruzamento*0.25;

        }

    }

    public static Lateral parse(String input){
        ArrayList<Equipa> hist = new ArrayList<Equipa>();
        String[] campos = input.split(",");
        String name = campos[0];
        return new Lateral(Integer.parseInt(campos[1]),name,false,hist,
                                                  Integer.parseInt(campos[2]),
                                                  Integer.parseInt(campos[3]),
                                                  Integer.parseInt(campos[4]),
                                                  Integer.parseInt(campos[5]),
                                                  Integer.parseInt(campos[6]),
                                                  Integer.parseInt(campos[7]),
                                                  Integer.parseInt(campos[8]),
                                                  Integer.parseInt(campos[9]));
    }


}
