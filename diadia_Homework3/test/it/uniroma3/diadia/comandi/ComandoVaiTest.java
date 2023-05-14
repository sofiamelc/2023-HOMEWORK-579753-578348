package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoVaiTest {
    private Partita partita;
    private Giocatore giocatore;
    private IO io;
    private ComandoVai comandoVai;

    @BeforeEach
    void setUp() {
    	
        this.partita = new Partita();
        this.giocatore = this.partita.getGiocatore();
        this.io = new IOConsole();
        this.comandoVai = new ComandoVai();
    }

    @Test
    void testDiminuzioneCfu() {
        this.comandoVai.setParametro("nord");
        this.comandoVai.esegui(this.partita,io);
        assertTrue(this.giocatore.getCfu() < this.giocatore.getCfuIniziali());
    }
    
    @Test
    void testSeDirezioneNullaNonRimuovereCfu() {
        this.comandoVai.setParametro("");
        this.comandoVai.esegui(this.partita,io);
        assertTrue(this.giocatore.getCfu() == this.giocatore.getCfuIniziali());
    }
    
    @Test
    void testSeStanzaNullaNonRimuovereCfu() {
        this.comandoVai.setParametro("est");
        this.comandoVai.esegui(this.partita,io);
        
        this.comandoVai.setParametro("nord");
        this.comandoVai.esegui(this.partita,io);
        assertTrue(this.giocatore.getCfu() == this.giocatore.getCfuIniziali() - 1);
    }
}