import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
public class EncEficiente {
    // variáveis de instância 
    private String nome;
    private String nif;
    private String morada;
    private int nrEncomenda;
    private LocalDate data;
    private ArrayList<LinhaEncomenda> linhas;

    
    
    /**
     * Construtores da classe EncEficiente:
     * Omissão,Parametrizado e Cópia.
     */
    
    public EncEficiente (){
        this.nome="";
        this.nif="";
        this.morada="";
        this.nrEncomenda=0;
        this.data=null;
        this.linhas=new ArrayList<LinhaEncomenda>();
    }
    
    public EncEficiente(String nome,String nif,String morada,int nrEncomenda,LocalDate data,ArrayList<LinhaEncomenda> le){
        this.nome=nome;
        this.nif=nif;
        this.morada=morada;
        this.nrEncomenda=nrEncomenda;
        this.data=data;
        this.linhas=le;
    }
    
    public EncEficiente(EncEficiente e){
        this.nome=e.getNome();
        this.nif=e.getNif();
        this.morada=e.getMorada();
        this.nrEncomenda=e.getNrencomenda();
        this.data=e.getData();
        this.linhas=e.getLinhas();
    }
    
    //Getters
    public String getNome(){
        return this.nome;
    }
    
    public String getNif(){
        return this.nif;
    }
    
    public String getMorada(){
        return this.morada;
    }
    
    public int getNrencomenda(){
        return this.nrEncomenda;
    }
    
    public LocalDate getData(){
        return this.data;
    }
    
    public ArrayList<LinhaEncomenda> getLinhas(){
        ArrayList<LinhaEncomenda> clone=new ArrayList<LinhaEncomenda>();
        for(LinhaEncomenda l:linhas)
            clone.add(l);
            return clone;
        }
        
    //Setters
    public void setNome(String nome){
        this.nome=nome;
    }
    
    public void setNif(String nif){
        this.nif=nif;
    }
    
    public void setMorada(String morada){
        this.morada=morada;
    }
    
    public void setNrencomenda(int nrEncomenda){
        this.nrEncomenda=nrEncomenda;
    }
    
    public void setData(LocalDate data){
        this.data=data;
    }
    
    public void setLinhas(ArrayList<LinhaEncomenda> le){
        this.linhas.clear();
          for(LinhaEncomenda l: le)
              this.linhas.add(l.clone());
        }
    
    /**
     * Método Equals
     */
    
    public boolean equals(Object o){
        if(this==o)
            return true;
         else 
          if(o==null||o.getClass()!=this.getClass())
            return false;
        EncEficiente e=(EncEficiente) o;
        return(e.getNome()==this.nome &&
               e.getNif()==this.nif &&
               e.getMorada()==this.morada &&
               e.getNrencomenda()==this.nrEncomenda &&
               e.getData()==this.data &&
               e.getLinhas()==this.linhas);
            }
            
    /**
     * Método Clone
     */
    public EncEficiente clone (){
        return new EncEficiente(this);
    }
    
    /**
     * Método StringBuilder
     */
    
    public String toString(){
      StringBuilder sb=new StringBuilder();
      
      sb.append("Nome: ");
      sb.append(this.nome+"/n");
      sb.append("Nif: ");
      sb.append(this.nif+"/n");
      sb.append("Morada: ");
      sb.append(this.morada+"/n");
      sb.append("Número da encomenda: ");
      sb.append(this.nrEncomenda+"/n");
      sb.append("Data da encomenda: ");
      sb.append(this.data+"/n");
      sb.append("Linhas da encomenda: ");
      sb.append(this.linhas+"/n");
      
      return sb.toString();
    }
      
    /**
     * Método que determina o valor total da encomenda.
     */
    
    public double calculaValorTotal(){
        double total=0;
        for(LinhaEncomenda l: linhas)
            total+=l.calculaValorLinhaEnc();
            
            return total;
        }
    /**
     * Método que determina o valor total dos descontos obtidos nos diversos
     * produtos encomendados.
     */
    
    public double calculaValorDesconto(){
        double total=0;
        for(LinhaEncomenda l:linhas)
            total+=l.calculaValorDesconto();
            
            return total;
        }
        
    /**
     * Método que determina o número total de produtos a receber.
     */
    public int numeroTotalProdutos(){
        int total=0;
        for(LinhaEncomenda l:linhas)
         total+=l.getQuantidade();
         return total;
        }
    /**
     * Método que determina se um produto vai ser encomendado.
     */
    public boolean existeProdutoEncomenda(String refProduto){
        boolean flag=false;
        Iterator<LinhaEncomenda> it=linhas.iterator();
        LinhaEncomenda l;
             
            
    return true;
    }
        
 }