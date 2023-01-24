package no.hvl.dat102;

import no.hvl.dat102.adt.FilmarkivADT;
import no.hvl.dat102.LinearNode;

public class Filmarkiv2 implements FilmarkivADT {

	private int antall;
	private LinearNode<Film> start;
	
	
	public Filmarkiv2() {
		antall = 0;
		start = null;			
	}
	
	@Override
	public Film finnFilm(int filmnr) {
		Film temp = null;
		boolean funnet = false;
		LinearNode<Film> aktuell = start;
		
		for (int soek = 0; soek < antall && !funnet; soek++) {
			if (aktuell.getElement().getFilmnr() == filmnr) {
				funnet = true;
				temp = aktuell.getElement();
			} else {
				aktuell = aktuell.getNeste();
			}
		}
		return temp;
	}
	
	@Override
	public void leggTilFilm(Film el) {
		 LinearNode<Film> nynode = new LinearNode<Film>(el);
		 nynode.setNeste(start);
		 start = nynode;
	}
	
	@Override
	public boolean slettFilm(int filmnr) {
		boolean slettet = false;
		
		LinearNode<Film> aktuell = start;
		for (int soek = 0; soek < antall && !slettet; soek++) {
			if (aktuell.getElement().getFilmnr() == filmnr) {
				aktuell = aktuell.getNeste();		// TODO slette funksjon
				slettet = true;
				
			}
			aktuell = aktuell.getNeste();	
		}
		return slettet;
	}
	
	
	public boolean erTom() {
		return antall == 0;
	}
	
	
	@Override
	public Film[] soekTittel(String delstreng) {
		Film[] tabell = (Film[]) new Object[antall];
		int i = 0;
		int j = 0;
		LinearNode<Film> aktuell = start;
		while (aktuell != null) {
			if (aktuell.getElement().getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
				tabell[j] = aktuell.getElement();
				j++;
			}
			aktuell = aktuell.getNeste();
		}
		return trimTab(tabell,j);
	}
		
	private Film[] trimTab(Film[] tab, int n) {
		// n er antall elementer
		Film[] nytab = new Film[n];
		int i = 0;
		while (i < n) {
			nytab[i] = tab[i];
			i++;
		}
		return nytab;
	}
	
	public int antall() {
		return antall;
	}
	
	@Override
	public int antall(Sjanger sjanger) {
		int filmer = 0;
		LinearNode<Film> aktuell = start;
		for (int soek = 0; soek < antall; soek++) {
			if (aktuell.getElement().getSjanger().equals(sjanger)) {
				filmer++;
				aktuell = aktuell.getNeste();
			}
				
		}
		return filmer;
	}	
}
