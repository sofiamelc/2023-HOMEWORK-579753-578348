package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosaTest {

	private Partita partita;
	private Attrezzo a;
	private IO io;
	private Comando comando;

	@Before
	public void setup() {
		partita = new Partita();
		a = new Attrezzo("spada", 2);
		comando = new ComandoPosa();
		io = new IOConsole();
		comando.setIo(io);
	}

	@Test
	public void testAttrezzoPosato(){
		partita.getGiocatore().getBorsa().addAttrezzo(a);
		comando.setParametro("spada");
		comando.esegui(partita);
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("spada"));
	}

	@Test
	public void testAttrezzoNonPosato() {
		comando.setParametro("spada");
		comando.esegui(partita);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("spada"));
	}

	public void creatoreAttrezzi() {
		for(int i= 0; i<10;i++) {
			partita.getStanzaCorrente().addAttrezzo(new Attrezzo("utensile"+i, 1));
		}
	}
	@Test
	public void testTroppiAttrezzi(){
		this.creatoreAttrezzi();
		partita.getGiocatore().getBorsa().addAttrezzo(a);
		comando.setParametro("spada");
		comando.esegui(partita);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("spada"));
	}

}
