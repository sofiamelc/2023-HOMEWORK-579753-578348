package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {
	private Partita partita;
	private Attrezzo a;
	private Attrezzo b;
	private IO io;
	private Comando comando;
	
	@Before
	public void setup() {
		partita = new Partita();
		a = new Attrezzo("spada", 2);
		b = new Attrezzo("zappa", 12);
		comando = new ComandoPrendi();
		io = new IOConsole();
		comando.setIo(io);
	}
	
	@Test
	public void testAttrezzoNormale() {
		this.partita.getStanzaCorrente().addAttrezzo(a);
		comando.setParametro("spada");
		comando.esegui(partita);
		assertFalse((partita.getStanzaCorrente().hasAttrezzo("spada")));
	}
	
	@Test 
	public void testAttrezzoPesante(){
		this.partita.getStanzaCorrente().addAttrezzo(b);
		comando.setParametro("zappa");
		comando.esegui(partita);
		assertTrue((partita.getStanzaCorrente().hasAttrezzo("zappa")));
	}
	
	@Test
	public void testAttrezzoNullo(){
		comando.setParametro("spada");
		comando.esegui(partita);
		assertFalse((partita.getStanzaCorrente().hasAttrezzo("spada")));
	}

}
