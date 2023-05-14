package it.uniroma3.diadia.ambienti;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {
		private Attrezzo attrezzo1;
		private Attrezzo attrezzo2;
		private Attrezzo attrezzo3;
		private StanzaMagica stanza;
		
	@Before
	public void setup(){
		attrezzo1 = new Attrezzo("lampada", 1);
		attrezzo2 = new Attrezzo("cane", 2);
		attrezzo3 = new Attrezzo("pane", 4);
		stanza = new StanzaMagica("Stanza Magica",2);
		
	}
	@Test
	public void testStanzaMagicaEffetto() {
		assertTrue(stanza.addAttrezzo(attrezzo1));
		assertTrue(stanza.addAttrezzo(attrezzo2));
		assertTrue(stanza.addAttrezzo(attrezzo3));
		assertEquals("Ti trovi qui: Stanza Magica\nUscite: \nAttrezzi nella stanza: enap (8kg) cane (2kg) lampada (1kg) "
				,stanza.toString());
	}
}
