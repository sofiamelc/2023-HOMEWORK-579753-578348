package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
public class ComandoAiuto implements Comando{
	//static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "guarda"};
	private IO io;
	
	public ComandoAiuto() {
		super();
		this.io = new IOConsole();
	}
	
	@Override
	public void esegui(Partita partita, IO io) {
		io.mostraMessaggio("Comandi disponibili:");
		for (String comando : new Comandi().getNomi()) {
			io.mostraMessaggio(comando);
		}
	}
	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		return;
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
		return "aiuto";
	}

}
