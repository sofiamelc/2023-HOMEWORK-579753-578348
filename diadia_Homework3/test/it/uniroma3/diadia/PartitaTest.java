package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;

class PartitaTest {
	private Partita partitaNuova;
	private Partita partitaFinita;
	private Partita partita0Cfu;
	
	private Partita partitaVinta;
	private Labirinto labirinto;
	@BeforeEach
	void setUp() {
		labirinto = new LabirintoBuilder()
					.creaLabirintoPredefinito()
					.getLabirinto();
		partitaFinita =  new Partita(labirinto);
		partita0Cfu = new Partita(labirinto);
		partitaNuova = new Partita(labirinto);
		partita0Cfu.getGiocatore().setCfu(0);
		partitaFinita.setFinita(); 
		partitaVinta = new Partita(labirinto);
		partitaVinta.setStanzaCorrente(partitaVinta.getLabirinto().getStanzaVincente());
	}

	@Test
	void testIsFinitaPartitaFinita() {
		assertTrue(partitaFinita.isFinita());
	}
	
	@Test
	void testIsFinitaPartita0Cfu() {
		assertTrue(partita0Cfu.isFinita());
	}
	
	@Test
	void testIsFinitaPartitaNuova() {
		assertFalse(partitaNuova.isFinita());
	}
	
	@Test
	void testVintaPartitaFinita(){
		assertTrue(partitaVinta.vinta());
	}
	
	@Test
	void testVintaPartita0Cfu(){
		assertFalse(partita0Cfu.vinta());
	}
	@Test
	void testVintaPartitaNuova(){
		assertFalse(partitaNuova.vinta());
	}
	
}