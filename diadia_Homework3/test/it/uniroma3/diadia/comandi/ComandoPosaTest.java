package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
public class ComandoPosaTest {

	private Partita partita;
	private Attrezzo a;
	private IO io;
	private Comando comando;
	private Labirinto labirinto;
	
	@Before
	public void setup() {
		labirinto = new LabirintoBuilder()
					.addStanzaIniziale("Mario")
					
					.getLabirinto();
		partita = new Partita(labirinto);
		a = new Attrezzo("spada", 2);
		comando = new ComandoPosa();
		io = new IOConsole();
		comando.setIo(io);
	}

	@Test
	public void testAttrezzoPosato(){
		partita.getGiocatore().getBorsa().addAttrezzo(a);
		comando.setParametro("spada");
		comando.esegui(partita,io);
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("spada"));
	}

	@Test
	public void testAttrezzoNonPosato() {
		comando.setParametro("spada");
		comando.esegui(partita,io);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("spada"));
	}

	public void creatoreAttrezzi() {
		for(int i= 0; i<10;i++) {
			this.labirinto.getStanzaIniziale().addAttrezzo(new Attrezzo("utensile"+i, 1));
		}
	}
	@Test
	public void testTroppiAttrezzi(){
		this.creatoreAttrezzi();
		partita.getGiocatore().getBorsa().addAttrezzo(a);
		comando.setParametro("spada");
		comando.esegui(partita,io);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("spada"));
	}

}
