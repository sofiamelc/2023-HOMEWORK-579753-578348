package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import java.util.*;

public class BorsaTest {

	Borsa b = new Borsa();
	Attrezzo cane;
	Attrezzo gatto;
	Attrezzo pappagallo;
	Attrezzo topo;
	
	@BeforeEach
	public void setUp() {
		cane = new Attrezzo("cane", 2);
		pappagallo = new Attrezzo("pappagallo", 1);
		gatto = new Attrezzo("gatto", 16);
		topo = new Attrezzo("topo", 1);
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
	
	@Test
	void testgetContenutoOrdinatoPerPesoDiverso() {
		b.addAttrezzo(cane);
		b.addAttrezzo(pappagallo);
		List<Attrezzo> att = new ArrayList<>();
		att.add(pappagallo);
		att.add(cane);
		assertEquals(att, b.getContenutoOrdinatoPerPeso());
	}
	
	@Test
	void testgetContenutoOrdinatoPerPesoUguale() {
		b.addAttrezzo(pappagallo);
		b.addAttrezzo(topo);
		List<Attrezzo> att = new ArrayList<>();
		att.add(pappagallo);
		att.add(topo);
		assertEquals(att, b.getContenutoOrdinatoPerPeso());
	}

	@Test
	void testgetContenutoOrdinatoPerNome() {
		b.addAttrezzo(pappagallo);
		b.addAttrezzo(cane);
		SortedSet<Attrezzo> set = new TreeSet<>();
		set.add(cane);
		set.add(pappagallo);
		assertEquals(set, b.getContenutoOrdinatoPerNome());
	}
	
	@Test
	void testgetSortedSetOrdinatoPerPesoUguale() {
		b.addAttrezzo(pappagallo);
		b.addAttrezzo(topo);
		SortedSet<Attrezzo> att = new TreeSet<>();
		att.add(pappagallo);
		att.add(topo);
		assertEquals(att, b.getSortedSetOrdinatoPerPeso());
	}
	
	@Test
	void testgetSortedSetOrdinatoPerPesoDiverso() {
		b.addAttrezzo(pappagallo);
		b.addAttrezzo(cane);
		SortedSet<Attrezzo> att = new TreeSet<>();
		att.add(pappagallo);
		att.add(cane);
		assertEquals(att, b.getSortedSetOrdinatoPerPeso());
	}
	
}