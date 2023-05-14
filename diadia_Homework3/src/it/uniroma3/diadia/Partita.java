package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private Stanza stanzaCorrente;
	private boolean finita;
	private Labirinto labirinto;
	private Giocatore giocatore;
	
	public Partita() {
		this(new LabirintoBuilder().creaLabirintoPredefinito().getLabirinto());
	}
	
	public Partita(Labirinto labirinto){
		this.labirinto = labirinto;
		this.setStanzaCorrente(this.labirinto.getStanzaIniziale());
		giocatore = new Giocatore();
		this.finita = false;
	}
	/**
	 * Crea tutte le stanze e le porte di collegamento
	 */

	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente() == this.labirinto.getStanzaVincente();
	} 	

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (!(giocatoreIsVivo()));
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public boolean getFinita() {
		return this.finita;
	}
	public void setFinita() {
		this.finita = true;
	}
	public boolean giocatoreIsVivo() {
		return this.giocatore.getCfu()>0;
	}
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
	
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	public Giocatore getGiocatore() {
		return this.giocatore;
	}
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
}
