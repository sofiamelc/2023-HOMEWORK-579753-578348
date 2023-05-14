package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import java.util.*;
/** * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
 */

public class Stanza {

	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	static final private int NUMERO_MASSIMO_ATTREZZI = 10;

	private String nome;
	private Map<String,Attrezzo> Attrezzi;
	private int numeroAttrezzi;
	private int numeroStanzeAdiacenti;
	private Map<String,Stanza> stanzeAdiacenti;

	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param nome il nome della stanza
	 */
	public Stanza(String nome) {
		this.nome = nome;
		this.Attrezzi =  new HashMap<>();
		this.stanzeAdiacenti= new HashMap<>();
		this.numeroAttrezzi = 0;
		this.numeroStanzeAdiacenti = 0;
	}
	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
	 */
	public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
		if(this.stanzeAdiacenti.containsKey(direzione)) {
			this.stanzeAdiacenti.put(direzione, stanza);
		}
		else if(this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
				this.stanzeAdiacenti.put(direzione, stanza);
				this.numeroStanzeAdiacenti++;
				}
		}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * @param direzione
	 */
	public Stanza getStanzaAdiacente(String direzione) {
		Stanza stanza = null;
		if(direzione.equals("nord") || direzione.equals("sud") || direzione.equals("est") || direzione.equals("ovest")) {
			if (direzione != null && this.stanzeAdiacenti.containsKey(direzione))
				stanza = this.stanzeAdiacenti.get(direzione);
		}
		return stanza;
		
	}
	
	/**
	 * Restituisce il nome della stanza.
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce la descrizione della stanza.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * @return la collezione di attrezzi nella stanza.
	 */
	public List<Attrezzo> getAttrezzi() {
		List<Attrezzo> attrezzi = new ArrayList<>();
		for(Attrezzo a : Attrezzi.values()) {
			attrezzi.add(a);
		}
		return attrezzi; //modifica tutti i metodi con getAttrezzi non dovrebbero esserci 
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
			this.Attrezzi.put(attrezzo.getNome(), attrezzo);
			this.numeroAttrezzi++;
			return true;
		}
			return false;
	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append("Ti trovi qui: ");
		risultato.append(this.nome);
		risultato.append("\nUscite: ");
		for (String direzione : this.getDirezioni())
			if (direzione!=null)
				risultato.append(" " + direzione);
		risultato.append("\nAttrezzi nella stanza: ");
		for (Attrezzo attrezzo : this.getAttrezzi()) {
			if(attrezzo != null) {
				risultato.append(attrezzo.toString()+" ");
			}
		}
		return risultato.toString();
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.Attrezzi.containsKey(nomeAttrezzo);
	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
	 * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato;
		attrezzoCercato = null;
		if(nomeAttrezzo != null && this.Attrezzi.containsKey(nomeAttrezzo))
			attrezzoCercato = this.Attrezzi.get(nomeAttrezzo);
		return attrezzoCercato;	
	}


	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		if(this.Attrezzi.remove(attrezzo.getNome()) != null)
			return true;
		return false;
	}

	public boolean isMagica() {
		return this instanceof StanzaMagica;
	}
	
	public boolean isBloccata() {
		return this instanceof StanzaBloccata;
	}
	
	public boolean isBuia() {
		return this instanceof StanzaBuia;
	}
	
	public List<String> getDirezioni() {
		List<String> lista = new ArrayList<>();
		for(String s : stanzeAdiacenti.keySet()) {
			lista.add(s);
		}
		return lista;
	}
	
	public Map<String, Stanza> getStanze(){
		return this.stanzeAdiacenti;
	}
}