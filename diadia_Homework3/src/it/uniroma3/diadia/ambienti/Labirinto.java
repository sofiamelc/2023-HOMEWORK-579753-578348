package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * @author 578348 579753
 * @see Attrezzo
 * @version base
 */

public class Labirinto {

	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;

//	/*public Labirinto() {
//		Attrezzo lanterna = new Attrezzo("lanterna",3);
//		Attrezzo osso = new Attrezzo("osso",1);
//		Attrezzo piedediporco = new Attrezzo("piedediporco",2);
//
//		/* crea stanze del labirinto */
//			Stanza atrio = new Stanza("Atrio");
//			Stanza aulaN11 = new StanzaMagica("Aula N11");
//			Stanza aulaN10 = new StanzaBloccata("Aula N10", "ovest", "piedediporco");;
//			Stanza laboratorio = new StanzaBuia("Laboratorio", "lanterna");
//			Stanza biblioteca = new Stanza("Biblioteca");
//
//		/* collega le stanze */
//		atrio.impostaStanzaAdiacente("nord", biblioteca);
//		atrio.impostaStanzaAdiacente("est", aulaN11);
//		atrio.impostaStanzaAdiacente("sud", aulaN10);
//		atrio.impostaStanzaAdiacente("ovest", laboratorio);
//		aulaN11.impostaStanzaAdiacente("est", laboratorio);
//		aulaN11.impostaStanzaAdiacente("ovest", atrio);
//		aulaN10.impostaStanzaAdiacente("nord", atrio);
//		aulaN10.impostaStanzaAdiacente("est", aulaN11);
//		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
//		laboratorio.impostaStanzaAdiacente("est", atrio);
//		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
//		biblioteca.impostaStanzaAdiacente("sud", atrio);
//
//		/* pone gli attrezzi nelle stanze */
//		aulaN10.addAttrezzo(lanterna);
//		atrio.addAttrezzo(osso);
//		aulaN11.addAttrezzo(piedediporco);
//		
//		// il gioco comincia nell'atrio
//		stanzaIniziale = atrio;  
//		stanzaVincente = biblioteca;
//	} 
	
	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}

	public void setStanzaIniziale(Stanza stanzaIniziale) {
		this.stanzaIniziale = stanzaIniziale;
	}

	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}
	
	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}

}