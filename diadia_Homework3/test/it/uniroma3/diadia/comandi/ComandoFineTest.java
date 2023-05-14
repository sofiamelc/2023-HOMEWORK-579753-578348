package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;

class ComandoFineTest {
	private Partita partita;
	private IOSimulator ioSimulator;
	private ComandoFine comandoFine;

	@BeforeEach
	void setUp() {
		this.partita = new Partita();
		this.ioSimulator = new IOSimulator();
		this.comandoFine = new ComandoFine();
	}

	@Test
	void testComandoCfu() {
		this.comandoFine.esegui(this.partita, this.ioSimulator);
		assertEquals(this.ioSimulator.getUltimoMessaggio(), "Grazie di aver giocato!");
		assertTrue(this.partita.getFinita());
	}
}