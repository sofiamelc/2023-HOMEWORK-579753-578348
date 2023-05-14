package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoVai implements Comando {
private String direzione;
private IO io;

public ComandoVai() {
	super();
	this.io = new IOConsole();
}
/*
* esecuzione del comando
*/

@Override
public void esegui(Partita partita, IO io) {
// qui il codice per cambiare stanza ...
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		if (this.direzione == null) {
			System.out.println("Dove vuoi andare? Devi specificare una direzione");
			return;
		}

		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		if (prossimaStanza == null) {
			System.out.println("Direzione inesistente");
			return;
		}
		partita.setStanzaCorrente(prossimaStanza);
		System.out.println(partita.getStanzaCorrente().getNome());
		Giocatore giocatore = partita.getGiocatore();
		giocatore.setCfu(giocatore.getCfu() - 1);
	}

@Override
public void setParametro(String parametro) {
	this.direzione = parametro;
	
}

@Override
public String getParametro() {
	// TODO Auto-generated method stub
	return this.direzione;
}
@Override
public void setIo(IO io) {
	this.io = io;
	
}
@Override
public String getNome() {
	// TODO Auto-generated method stub
	return "vai";
}


}