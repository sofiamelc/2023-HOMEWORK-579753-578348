package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando{
	private IO io;
	private String nomeAttrezzo;
	public ComandoPosa() {
		super();
		this.io = new IOConsole();
	}
	@Override
	public void esegui(Partita partita){
		if (partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo)==null){
			io.mostraMessaggio("Oggetto non posabile");
		}
		else {
			Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
			partita.getStanzaCorrente().addAttrezzo(a);
			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		}
	}
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.nomeAttrezzo;
	}
	@Override
	public void setIo(IO io) {
		this.io = io;

	}
	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "posa";
	}

}
