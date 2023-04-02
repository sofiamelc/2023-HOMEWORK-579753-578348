package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {

	Borsa b = new Borsa();
	Attrezzo cane;
	Attrezzo gatto;
	
	@BeforeEach
	public void setUp() {
		cane = new Attrezzo("cane", 2);
		gatto = new Attrezzo("gatto", 16);
	}

	@Test
	void testAddAttrezzoPesoMinoreDiDieci() {
		assertTrue(b.addAttrezzo(cane));

	}
	
	@Test
	void testAddAttrezzoPesoMaggioreDiDieci() {
		assertFalse(b.addAttrezzo(gatto));

	}
	
	@Test
	void testGetPeso() {
		b.addAttrezzo(cane);
		assertEquals(cane, b.getAttrezzo("cane"));
	}
	
	@Test
	void testremoveAttrezzo() {
		b.addAttrezzo(cane);
		assertEquals(cane,b.removeAttrezzo("cane"));
	}
}