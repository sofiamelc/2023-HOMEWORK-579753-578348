package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;

class ComandoAiutoTest {
    private Partita partita;
    private IOSimulator ioSimulator;
	private ComandoAiuto comandoAiuto;
	private List<String> messaggioAiuto;
	
	@BeforeEach
	void setUp() {
        this.partita = new Partita();
        this.ioSimulator = new IOSimulator();
		this.comandoAiuto = new ComandoAiuto();
		
		this.messaggioAiuto = new LinkedList<>();
		this.messaggioAiuto.add("Comandi disponibili:");
		this.messaggioAiuto.add("aiuto");
		this.messaggioAiuto.add("fine");
		this.messaggioAiuto.add("guarda");
		this.messaggioAiuto.add("posa");
		this.messaggioAiuto.add("prendi");
		this.messaggioAiuto.add("vai");
	}

	@Test
	void testComandoAiuto() {
		this.comandoAiuto.esegui(this.partita, this.ioSimulator);
		assertEquals(this.ioSimulator.getMessaggi(), this.messaggioAiuto);
	}
}