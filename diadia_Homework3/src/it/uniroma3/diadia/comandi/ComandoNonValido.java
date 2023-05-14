package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando{
private IO io;
public ComandoNonValido() {
	super();
	this.io = new IOConsole();
}
@Override
public void esegui(Partita partita, IO io) {
	io.mostraMessaggio("Comando non valido");
}
@Override
public void setParametro(String parametro) {
	// TODO Auto-generated method stub

}

@Override
public String getParametro() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void setIo(IO io) {
	this.io = io;
	
}

@Override
public String getNome() {
	return "Comando Non Valido";
}
}
