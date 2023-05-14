package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {
		private Attrezzo attrezzo;
		private StanzaBloccata stanza;
		private Stanza stanzabella;
	@Before
	public void setup(){

		attrezzo = new Attrezzo("passepartout", 1);
		stanza = new StanzaBloccata("Stanza Bloccata", "nord", "passepartout");
		stanzabella = new Stanza("Stanza bella");
		stanza.impostaStanzaAdiacente("nord", stanzabella);
	}
	@Test
	public void testgetStanzaAdiacenteBloccata() {
		assertEquals(stanza, stanza.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testStanzaSbloccata() {
		stanza.addAttrezzo(attrezzo);
		assertEquals(stanzabella, stanza.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testgetDescrizioneBloccata() {
		String bloccata = "Ti trovi qui: Stanza Bloccata" + "\nUscite:  nord" + "\nAttrezzi nella stanza: "
						+ "\nStanza bloccata nella direzione: nord" + 
						"\nPrendi un/una passepartout" + " e posalo nella stanza"
						+ " per poter procedere in questa direzione.";
		assertEquals(bloccata,stanza.getDescrizione());
	}
	
	@Test
	public void testgetDescrizioneSbloccata() {
		stanza.addAttrezzo(attrezzo);
		assertEquals(stanza.toString(),stanza.getDescrizione());
	}
	
}