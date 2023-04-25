package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;

public class ComandoGuarda implements Comando{
	private IO io;
	public ComandoGuarda() {
		super();
		this.io = new IOConsole();
	}
	@Override
	public void esegui(Partita partita) {
	io.mostraMessaggio("Ti trovi qui: " + partita.getStanzaCorrente().getDescrizione());
	io.mostraMessaggio(partita.getGiocatore().borsa.toString());
	io.mostraMessaggio("CFU RIMANENTI:" + partita.getGiocatore().getCfu());
}
	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setIo(IO io) {
		this.io = io;
		
	}

	@Override
	public String getNome() {
		return "guarda";
	}
}
