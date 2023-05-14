package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;



public class ComandoPrendi implements Comando {
	private IO io;
	private String nomeAttrezzo;
	public ComandoPrendi() {
		super();
		this.io = new IOConsole();
	}
	@Override
	public void esegui(Partita partita, IO io){
	if (!(partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) || 
			(partita.getGiocatore().borsa.getPeso() + partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo).getPeso()>
			partita.getGiocatore().borsa.getPesoMax())){
		io.mostraMessaggio("Oggetto non prendibile");
	}

	else {
		Attrezzo a = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		partita.getStanzaCorrente().removeAttrezzo(a); 
		partita.getGiocatore().borsa.addAttrezzo(a);
	}
}
	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		this.nomeAttrezzo = parametro;

	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return nomeAttrezzo;
	}

	@Override
	public void setIo(IO io) {
		this.io = io;
		
	}

	@Override
	public String getNome() {
		return "prendi";
	}
	
}
