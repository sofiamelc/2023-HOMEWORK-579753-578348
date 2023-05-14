package it.uniroma3.diadia.giocatore;
import java.util.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatorePerPeso;


public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Map<String,Attrezzo> Borsa;
	private int pesoMax;
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.Borsa = new HashMap<>(); 

	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		this.Borsa.put(attrezzo.getNome(), attrezzo);
		return true;
	}

	public int getPesoMax() {
		return pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
			if (nomeAttrezzo != null && this.Borsa.containsKey(nomeAttrezzo))
				a = this.Borsa.get(nomeAttrezzo);
		return a;
	}

	public int getPeso() {
		int peso = 0;
		Iterator<Attrezzo> iteratore=this.Borsa.values().iterator();
		while(iteratore.hasNext()){
			peso = +iteratore.next().getPeso();
		}
		return peso;
	}

	public boolean isEmpty() {
		return this.Borsa.isEmpty();
	}
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		return this.Borsa.remove(nomeAttrezzo);  // da controllare se funziona bene
	}



	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
				s.append(Borsa.values().toString()+" ");
	
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
	
	List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> lista = new ArrayList<>();
		lista.addAll(this.Borsa.values());
		Collections.sort(lista,new ComparatorePerPeso());
		return lista;
	}
	
	SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){ 
		SortedSet<Attrezzo> p = new TreeSet<>();
		p.addAll(this.Borsa.values());
		return p;
	}
	
	
	SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		SortedSet<Attrezzo> p = new TreeSet<>();
		p.addAll(this.Borsa.values());
		return p;
	}
	
	Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer, Set<Attrezzo>> mappa = new TreeMap<>();
		for(Attrezzo a: this.Borsa.values()) {
			if(mappa.containsKey(a.getPeso())){
				mappa.get(a.getPeso()).add(a);
			}
			else {
				Set<Attrezzo> att = new HashSet<>();
				att.add(a);
				mappa.put(a.getPeso(), att);
			}
		}
		return mappa;
				
	}
	
	
}