package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class LabirintoBuilder {
	private Labirinto labirinto;
	private Stanza ultimaStanzaAggiunta;
	private Map<String, Stanza> mappa;
	
	
	public LabirintoBuilder() {
		this.labirinto = new Labirinto();
		this.mappa = new HashMap<String, Stanza>();
	}
	
	public Map<String, Stanza> getNome2stanza() {
		return mappa;
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	public LabirintoBuilder addStanzaIniziale(String stanzaIniziale) {
		Stanza i = new Stanza(stanzaIniziale);
		this.labirinto.setStanzaIniziale(i);
		this.UltimaStanzaInserita(i);
		return this;
	}
	
	public LabirintoBuilder addStanzaVincente(String stanzaVincente) {
		Stanza v = new Stanza(stanzaVincente);
		this.labirinto.setStanzaVincente(v);
		this.UltimaStanzaInserita(v);
		return this;
	}
	public LabirintoBuilder addStanza(String stanza) {
		Stanza s = new Stanza(stanza);
		this.UltimaStanzaInserita(s);
		return this;
	}
	
	public LabirintoBuilder addAdiacenza(String stanzaCorrente, String stanzaAdiacente, String direzione) {
		Stanza c = this.mappa.get(stanzaCorrente);
		Stanza a = this.mappa.get(stanzaAdiacente);
		c.impostaStanzaAdiacente(direzione, a);
		return this;
	}
	
	public LabirintoBuilder addStanzaMagica(String stanza, int numero) {
		Stanza s = new StanzaMagica(stanza, numero);
		this.UltimaStanzaInserita(s);
		return this;
	}
	
	public LabirintoBuilder addStanzaBloccata(String stanza,String direzionebloccata, String oggettochesblocca ) {
		Stanza s = new StanzaBloccata(stanza,direzionebloccata,oggettochesblocca);
		this.UltimaStanzaInserita(s);
		return this;
	}
	public LabirintoBuilder addStanzaBuia(String stanza, String oggetto) {
		Stanza s = new StanzaBuia(stanza, oggetto);
		this.UltimaStanzaInserita(s);
		return this;
	}
	
	public LabirintoBuilder addAttrezzo(String attrezzo, int peso) {
		Attrezzo a = new Attrezzo(attrezzo, peso);
		if(this.ultimaStanzaAggiunta==null)
			return this;
		this.ultimaStanzaAggiunta.addAttrezzo(a);
		return this;
	}
	
	
	public void UltimaStanzaInserita(Stanza stanza) {
		this.ultimaStanzaAggiunta = stanza;
		this.mappa.put(stanza.getNome(), stanza);
	}
	
	
    public LabirintoBuilder creaLabirintoPredefinito() {
        return this.addStanzaIniziale("Atrio")
        		.addAttrezzo("osso", 1)
        		.addAttrezzo("piedediporco", 2)
        		.addStanzaVincente("Biblioteca")
                .addStanzaBloccata("Aula N10", "ovest", "piedediporco")
                .addAttrezzo("lanterna", 3)
                .addStanzaMagica("Aula N11",3)
                .addStanzaBuia("Laboratorio", "lanterna")
                .addAdiacenza("Atrio", "Biblioteca", "nord")
                .addAdiacenza("Atrio", "Aula N11", "est")
                .addAdiacenza("Atrio", "Aula N10", "sud")
                .addAdiacenza("Atrio", "Laboratorio", "ovest")
                .addAdiacenza("Aula N11", "Laboratorio", "est")
                .addAdiacenza("Aula N11", "Atrio", "ovest")
                .addAdiacenza("Aula N10", "Atrio", "nord")
                .addAdiacenza("Aula N10", "Aula N11", "est")
                .addAdiacenza("Aula N10", "Laboratorio", "ovest")
                .addAdiacenza("Laboratorio", "Atrio", "est")
                .addAdiacenza("Laboratorio", "Aula N11", "ovest")
                .addAdiacenza("Biblioteca", "Atrio", "sud");
    }
    
	public Map<String,Stanza> getListaStanze() {
		// TODO Auto-generated method stub
		Map<String, Stanza> lista = new HashMap<>();
		for(Stanza s : mappa.values()) {
			lista.put(s.getNome(), s);
		}
		return lista;
	}
}
