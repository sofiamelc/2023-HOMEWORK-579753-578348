package it.uniroma3.diadia.giocatore;

public class Giocatore {
	static final private int CFU_INIZIALI = 20;
	public Borsa borsa;
	public int cfu;
	
	public Giocatore() {
	this.cfu = CFU_INIZIALI;
	this.borsa = new Borsa();
	}	
	public Giocatore(int cfu) {
		this.cfu = cfu;
		this.borsa = new Borsa();
	}
	
	public int getCfu() {
		return this.cfu;
	}
	
	public int getCfuIniziali() {
		return this.CFU_INIZIALI;
	}
	
	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
	public Borsa getBorsa() {
		return borsa;
	}
	
}
