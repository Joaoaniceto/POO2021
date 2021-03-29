import java.util.HashMap;
import java.util.scanner;
import java.io.Serializable;

public abstract class Equipa implements Comparable<Equipa>, Serializable{
	private HashMap<String, List<Jogador>> nome;
}

public Equipa(){
	this.nome = new HashMap();
}

public Equipa (HashMap<String, List<Jogador>> nome){
	this.nome=nome;
}

public Equipa (Equipa e){
	this.nome = e.getNome();
}

public HashMap getNome(){
	return this.nome;
}

public void setNome(HashMap<String, List<Jogador>> name){
	this.name=nome;
}

public toString(){
	return "Nome da Equipa: "+ this.nome;
}

public abstract Equipa clone();

public boolean equals(Object o){
	if (this==o)
		return true;
	if((o==null)||(this.getClass()!=o.getClass()))
		return false;
	Equipa e = (Equipa) o;
	return (this.nome) == (e.getNome());
}




