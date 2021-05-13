import java.util.ArrayList;
/**
 * Escreva a descrição da classe VeiculoNormal aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class VeiculoNormal extends Veiculo
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio

    /**
     * COnstrutor para objetos da classe VeiculoNormal
     */
    public VeiculoNormal()
    {
        super();
        
    }

    public VeiculoNormal(String marca,String modelo,String matricula,int ano,int kms) {
        super(marca,modelo,matricula,ano,kms);
    }

    public VeiculoNormal(String marca,String modelo,String matricula,int ano,double velociademedia,double precokm,ArrayList<Integer> classificacao,int kms,int kmsUltimo){

        super(marca,modelo,matricula,ano,velociademedia,precokm,classificacao,kms,kmsUltimo);
    
    }
    public VeiculoNormal(VeiculoNormal a){
    super(a);
    }

    /**
     * Exemplo de método - substitua este comentário pelo seu próprio
     * 
     * @param  y   exemplo de um parâmetro de método
     * @return     a soma de x com y 
     */
  
    public VeiculoNormal clone(){
        return new VeiculoNormal(this);
    }
    
}
