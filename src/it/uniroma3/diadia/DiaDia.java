package it.uniroma3.diadia;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;


/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

//ctr+o vedi tutte le classi

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	//static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	private Partita partita;
	private IO io;

	public DiaDia(IO io) {
		this.io = io;
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 

		io.mostraMessaggio(MESSAGGIO_BENVENUTO);		
		do		
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica(this.io);
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta())
			io.mostraMessaggio("Hai vinto!");
		if (!this.partita.giocatoreIsVivo())
			io.mostraMessaggio("Hai esaurito i CFU...");

		return this.partita.isFinita();
	}

	/*public boolean processaIstruzione(String istruzione) { 
		Comando DaEseguire = new Comando(istruzione);

		if (DaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		}
		else if(this.partita.isFinita()) {
			io.mostraMessaggio("HAI PERSO");
		}
		else if (DaEseguire.getNome().equals("vai"))
			this.vai(DaEseguire.getParametro());
		else if (DaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if(DaEseguire.getNome().equals("prendi"))
			this.prendi(DaEseguire.getParametro());
		else if(DaEseguire.getNome().equals("posa"))
			this.posa(DaEseguire.getParametro());
		else
			io.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			io.mostraMessaggio("Hai vinto!");
			return true;
		}else
			return false;
	}
	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	/*private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		io.mostraMessaggio("");
	}*/

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	/*private void vai(String direzione) { //qua era private
		if(direzione==null) {
			io.mostraMessaggio("Dove vuoi andare ?");
		}
		else {
			Stanza prossimaStanza = null;
			prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
			if (prossimaStanza == null)
				io.mostraMessaggio("Direzione inesistente.\nDove vuoi andare?");

			else {
				this.partita.getGiocatore().setCfu(this.partita.getGiocatore().getCfu()-1);
				this.partita.setStanzaCorrente(prossimaStanza);
			}
		}

			io.mostraMessaggio("Ti trovi qui: " + partita.getStanzaCorrente().getDescrizione());
			io.mostraMessaggio(partita.getGiocatore().borsa.toString());
			io.mostraMessaggio("CFU RIMANENTI:" + partita.getGiocatore().getCfu());
	}*/
	/*private void prendi(String nomeAttrezzo) {
		if (!(this.partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) || 
				(this.partita.getGiocatore().borsa.getPeso() + this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo).getPeso()>
				this.partita.getGiocatore().borsa.getPesoMax())){
			io.mostraMessaggio("Oggetto non prendibile");
		}

		else {
			Attrezzo a = this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
			this.partita.getStanzaCorrente().removeAttrezzo(a); 
			this.partita.getGiocatore().borsa.addAttrezzo(a);
		}
	}*/

	/*private void posa(String nomeAttrezzo) {

		if (this.partita.getGiocatore().borsa.getAttrezzo(nomeAttrezzo)==null){
			io.mostraMessaggio("Oggetto non posabile");
		}
		else {
			Attrezzo a = this.partita.getGiocatore().borsa.getAttrezzo(nomeAttrezzo);
			this.partita.getStanzaCorrente().addAttrezzo(a);
			this.partita.getGiocatore().borsa.removeAttrezzo(nomeAttrezzo);
		}
	}

	/**
	 * Comando "Fine".
	 */
	/*private void fine() {
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}*/

		public static void main(String[] argc) {

			IO io = new IOConsole();
			DiaDia gioco = new DiaDia(io);
			gioco.gioca();
			}
}
