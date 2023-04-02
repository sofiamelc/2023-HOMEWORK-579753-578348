package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StanzaTest {
	private Stanza stanza0Direzioni;
	private Stanza stanza4Direzioni;

	@BeforeEach
	public void setUp(){
		stanza0Direzioni = new Stanza("0 direzioni");
		stanza4Direzioni = new Stanza("4 direzioni");
		String[] direzioni = {"nord","sud","est","ovest"};
		for(int i=0; i<direzioni.length; i++) {
			stanza4Direzioni.impostaStanzaAdiacente(direzioni[i], new Stanza("Stanza"+direzioni[i]));
		}
	}

	@Test
	void testImpostaStanzaAdiacenteStanza0Direzioni(){
		Stanza nuovaStanzaAdiacente = new Stanza("nuova stanza adiacente");
		stanza0Direzioni.impostaStanzaAdiacente("nord", nuovaStanzaAdiacente);
		assertEquals(nuovaStanzaAdiacente,stanza0Direzioni.getStanzaAdiacente("nord"));
	}
	
	@Test
	void testImpostaStanzaAdiacenteStanz4Direzioni(){
		Stanza nuovaStanzaAdiacente = new Stanza("nuova stanza adiacente");
		stanza4Direzioni.impostaStanzaAdiacente("nord", nuovaStanzaAdiacente);
		assertEquals(nuovaStanzaAdiacente,stanza4Direzioni.getStanzaAdiacente("nord"));
	}
	
	
	
	
}