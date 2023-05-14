package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.Attrezzo;
class StanzaMagica extends Stanza {
	final static private int SOGLIA_MAGICA_DEFAULT = 3;
	private int contatoreAttrezziPosati;
	private int sogliaMagica;
	public StanzaMagica(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}
	public StanzaMagica(String nome, int soglia) {
		super(nome);
		this.contatoreAttrezziPosati = 0;
		this.sogliaMagica = soglia;
	}
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		int pesox2 = attrezzo.getPeso()*2;
		nomeInvertito = nomeInvertito.reverse();
		Attrezzo attrezzonuovo = new Attrezzo(nomeInvertito.toString(), pesox2);
		return attrezzonuovo;
	}
	
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		this.contatoreAttrezziPosati++;
		if (this.contatoreAttrezziPosati>this.sogliaMagica)
		attrezzo = this.modificaAttrezzo(attrezzo);
		return super.addAttrezzo(attrezzo);
		}
	
}
