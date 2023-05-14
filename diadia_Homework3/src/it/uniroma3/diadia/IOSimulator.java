

package it.uniroma3.diadia;

import java.util.List;
import java.util.LinkedList;

public class IOSimulator implements IO {
	/* Costanti */

	private final List<String> messaggi;
	private final List<String> righe;

	/* Costruttori */

	/**
	 * Costruttore di IOSimulator
	 */
	public IOSimulator() {
		this.messaggi = new LinkedList<>();
		this.righe = new LinkedList<>();
	}

	/* Getters e setters */

	// messaggi

	public List<String> getMessaggi() {
		return messaggi;
	}

	/* Metodi con @Override */

	/**
	 * Aggiunge un messaggio alla lista dei messaggi.
	 * 
	 * @param messaggio messaggio da salvare nella lista dei messaggi
	 */
	@Override
	public void mostraMessaggio(String messaggio) {
		this.messaggi.add(messaggio);
	}

	/**
	 * Legge l'ultima riga presente nella lista delle righe.
	 * 
	 * @return l'ultima riga presente nella lista delle righe
	 */
	@Override
	public String leggiRiga() {
		if (this.righe.isEmpty()) {
			return "fine";
		}

		return this.righe.remove(0);
	}

	/* Metodi */

	/**
	 * Aggiunge alla coda delle righe da leggere una nuova riga.
	 * 
	 * @param riga la riga da aggiungere alla lista
	 */
	public void aggiungiRiga(String riga) {
		this.righe.add(riga);
	}

	public String getUltimoMessaggio() {
		return this.getMessaggi().get(this.getMessaggi().size() - 1);
	}
}

