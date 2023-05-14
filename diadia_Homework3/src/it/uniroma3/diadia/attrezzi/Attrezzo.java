package it.uniroma3.diadia.attrezzi;

import it.uniroma3.diadia.ambienti.Stanza;
import java.util.Comparator;
/**
 * Una semplice classe che modella un attrezzo.
 * Gli attrezzi possono trovarsi all'interno delle stanze
 * del labirinto.
 * Ogni attrezzo ha un nome ed un peso.
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */
public class Attrezzo implements Comparable<Attrezzo>{

	public String nome; //era private
	private int peso;

	/**
	 * Crea un attrezzo
	 * @param nome il nome che identifica l'attrezzo
	 * @param peso il peso dell'attrezzo
	 */
	public Attrezzo(String nome, int peso) {
		this.peso = peso;
		if(nome != null){
			this.nome = nome;	
		}
	}
	
	/**
	 * Restituisce il nome identificatore dell'attrezzo
	 * @return il nome identificatore dell'attrezzo
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce il peso dell'attrezzo
	 * @return il peso dell'attrezzo
	 */
	public int getPeso() {
		return this.peso;
	}

	/**
	 * Restituisce una rappresentazione stringa di questo attrezzo
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		return this.getNome()+" ("+this.getPeso()+"kg)";
	}

	@Override
	public int compareTo(Attrezzo a1) {
		// TODO Auto-generated method stub
		return this.getNome().compareTo(a1.getNome());
	}
	
	@Override
	public boolean equals(Object obj) {
		Attrezzo that = (Attrezzo)obj;
		return (this.getNome().equals(that.getNome()) && this.getPeso() == that.getPeso());
	}
		
}