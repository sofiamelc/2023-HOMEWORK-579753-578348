package it.uniroma3.diadia.ambienti;


public class StanzaBuia extends Stanza{
	private String oggetto;
	public StanzaBuia(String nome,String oggetto) {
		super(nome);
		this.oggetto = oggetto;
	}
	
	@Override
	public String getDescrizione() {
		String buio;
		buio = "qui c'è buio pesto";
		if(!hasAttrezzo(oggetto)) {
			return buio;
		}
		return super.getDescrizione();
	}
}
