package it.uniroma3.diadia.ambienti;


import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
		private Attrezzo attrezzo;
		private StanzaBuia stanza;
	@Before
	public void setup(){
		attrezzo = new Attrezzo("lampada", 1);
		stanza = new StanzaBuia("Stanza Buia", "lampada");
		
	}
	@Test
	public void testStanzaBuiaIlluminata() {
		stanza.addAttrezzo(attrezzo);
		assertEquals(stanza.toString(),stanza.getDescrizione());
	}
	
	@Test
	public void testStanzaBuiaNonIlluminata() {
		String buio = "qui c'è buio pesto";
		assertEquals(buio,stanza.getDescrizione());
	}
}
