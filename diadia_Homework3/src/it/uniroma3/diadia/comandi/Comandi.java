package it.uniroma3.diadia.comandi;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Comandi {
	/* Variabili d'istanza */

	private Map<String, Comando> comandi;
 
	/* Costruttori */

	/**
	 * Genera una HashMap e la riempie con i dati riguardanti i comandi.
	 */
	public Comandi() {
		this.comandi = new HashMap<>();
		this.comandi.put("aiuto", new ComandoAiuto());
		this.comandi.put("fine", new ComandoFine());
		this.comandi.put("posa", new ComandoPosa());
		this.comandi.put("prendi", new ComandoPrendi());
		this.comandi.put("vai", new ComandoVai());
		this.comandi.put("guarda", new ComandoGuarda());
	}

	/* Metodi */
	public Comando get(String nomeComando) {
		return (this.comandi.containsKey(nomeComando) || nomeComando == null) ? this.comandi.get(nomeComando)
				: new ComandoNonValido();
	}


	public TreeSet<String> getNomi() {
		return new TreeSet<String>(this.comandi.keySet());
	}
}