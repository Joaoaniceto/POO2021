

public class Jogo {
    private Equipa equipaCasa;
    private Equipa equipaVisitante;
    private int subsCasa;
    private int subsVisitante;
    private int estado;
    private static final int por_iniciar = 0;
    private static final int decorrer = 1;
    private static final int terminado = -1;
    private int golosCasa , golosVisitante;

    public Jogo() {
        this.equipaCasa = new Equipa();
        this.equipaVisitante = new Equipa();
        this.subsCasa = 0;
        this.subsVisitante = 0;
        this.estado = por_iniciar;
        this.golosCasa = 0;
        this.golosVisitante = 0;
    }

    public Jogo(Equipa casa,Equipa visitante,int subsCasa,int subsVisitante,int golosCasa,int golosVisitante){
        this.equipaCasa = casa;
        this.equipaVisitante = visitante;
        this.subsCasa = subsCasa;
        this.subsVisitante = subsVisitante;
        this.estado = por_iniciar;
        this.golosCasa = golosCasa;
        this.golosVisitante = golosVisitante;
    }

    public Jogo(Jogo o){
        this.equipaCasa = o.getCasa();
        this.equipaVisitante = o.getVisitante();
        this.subsCasa = o.getSubsCasa();
        this.subsVisitante = o.getSubsVisitante();
        this.estado = por_iniciar;
        this.golosCasa = o.getGolosCasa();
        this.golosVisitante = o.getGolosVisitante();
    }

    public Equipa getCasa() {return this.equipaCasa;}
    public Equipa getVisitante() {return this.equipaVisitante;}
    public int getSubsCasa() {return this.subsCasa;}
    public int getSubsVisitante() {return this.subsVisitante;}
    public int getEstado() {return this.estado;}
    public int getGolosCasa() {return this.golosCasa;}
    public int getGolosVisitante() {return this.golosVisitante;}

    public void setEquipaCasa(Equipa casa) {this.equipaCasa = casa; }
    public void setEquipaVisitante(Equipa visitante) {this.equipaVisitante = visitante;}
    public void setSubsCasa(int sc) {this.subsCasa = sc;}
    public void setSubsVisitante(int sv) {this.subsVisitante = sv;}
    public void setEstado(int e) {this.estado = e;} //falta dar bound no argumento, para que seja apenas possivel e=0, e=1 ou e=-1 // bounded argument
    public void setGolosCasa(int gc) {this.golosCasa = gc;}
    public void setGolosVisitante(int gv) {this.golosVisitante = gv;}

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Equipa da casa: "+this.equipaCasa.getNome());
        sb.append("\nEquipa visitante: "+this.equipaVisitante.getNome());
        sb.append("\nSubstituições da Equipa da Casa: "+this.subsCasa);
        sb.append("\nSubstituições da Equipa Visitante: "+this.subsVisitante);
        sb.append("\nEstado do jogo: "+this.estado);
        sb.append("\nGolos da Equipa da Casa: "+this.golosCasa);
        sb.append("\nGolos da Equipa Visitante: "+this.golosVisitante);
        sb.append("\n");
        return sb.toString();
    }

    public Jogo clone() {
        return new Jogo(this);
    }


    public boolean equals(Object o) {
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        Jogo e = (Jogo) o;
        return (this.equipaCasa) == (e.getCasa()) &&
                (this.equipaVisitante) == (e.getVisitante()) &&
                (this.subsCasa) == (e.getSubsCasa()) &&
                (this.subsVisitante) == (e.getSubsVisitante()) &&
                (this.estado) == (e.getEstado()) &&
                (this.golosCasa) == (e.getGolosCasa()) &&
                (this.golosVisitante) == (e.getGolosVisitante());

    }


}
