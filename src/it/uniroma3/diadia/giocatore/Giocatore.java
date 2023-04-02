package it.uniroma3.diadia.giocatore;

public class Giocatore {
	public Borsa borsa;
	
	public Giocatore() {
	this.borsa = new Borsa();
	}	
	
	static final private int CFU_INIZIALI = 20;
	public int cfu = CFU_INIZIALI;

	public int getCfu() {
		return this.cfu;
	}
	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
	public Borsa getBorsa() {
		return borsa;
	}
}
