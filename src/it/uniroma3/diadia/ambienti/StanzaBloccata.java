package it.uniroma3.diadia.ambienti;


public class StanzaBloccata extends Stanza{
	private String oggettochesblocca;
	private String direzionebloccata;
	public StanzaBloccata(String nome,String direzionebloccata, String oggettochesblocca) {
		super(nome);
		this.oggettochesblocca = oggettochesblocca;
		this.direzionebloccata = direzionebloccata;
	}
@Override
public Stanza getStanzaAdiacente(String direzione) {
	if(direzionebloccata.equals(direzione) && !(hasAttrezzo(oggettochesblocca))){
		return this;
	}
	return super.getStanzaAdiacente(direzione);
}

@Override
public String getDescrizione() {
	String bloccata = super.getDescrizione()+"\nStanza bloccata nella direzione: " + direzionebloccata + 
			"\nPrendi un/una " + oggettochesblocca + " e posalo nella stanza"
					+ " per poter procedere in questa direzione.\n";
	if(!(hasAttrezzo(oggettochesblocca))) {
		return bloccata;
	}
	return super.getDescrizione();
}

}
