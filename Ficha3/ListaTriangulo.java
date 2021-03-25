import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListaTriangulo {
    private List<Triangulo> lt;

    //construtor por omissão
    public ListaTriangulo() {
        this.lt = new ArrayList();
    }

    public ListaTriangulo(List<Triangulo> nList) {
        this.lt = new ArrayList();
        for(Triangulo t: nList){
            this.lt.add(t.clone());
        }
    }

    public ListaTriangulo(ListaTriangulo l) {
        this();
        for(Triangulo t: l.getList()){
            this.lt.add(t);       //porque o getList já produz uma copia
        }
    }

    public List<Triangulo> getList(){
        List<Triangulo> res = new ArrayList<Triangulo>();
        for(Triangulo t: this.lt) {
            res.add(t.clone());
        }
        return res;
    }

    public void setList(List<Triangulo> l){
        this.lt.clear();
        for(Triangulo t: l){
            this.lt.add(t.clone());
        }
    }

    public double somaPerimetros(){
        double res=0;
        for(Triangulo t: lt){
            res = res + t.perimetro();
        }
        return res;
    }

    public boolean temMaiorPerimetroQue(double per){
        boolean enc = false;
        Iterator<Triangulo> it = this.lt.iterator();
        while(it.hasNext() && !enc){
            Triangulo t = it.next();
            enc = t.perimetro()>per;
        }
        return enc;
    }

    public boolean equals(Object o){
        if(this == o)
            return true;
        if((o==null)||(this.getClass()!=o.getClass()))
            return false;
        ListaTriangulo t = (ListaTriangulo) o;
        return this.lt.equals(t.getList());
    }

    public String toString(){
        return "Lista de Triangulos: "+this.lt.toString();
    }

    public ListaTriangulo clone(){
        return new ListaTriangulo(this);
    }





}
