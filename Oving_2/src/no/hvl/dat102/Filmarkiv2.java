package no.hvl.dat102;

import no.hvl.dat102.adt.FilmarkivADT;

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
		 antall++;
	}
	
	@Override
	public boolean slettFilm(int filmnr) {
		boolean slettet = false;
		
		LinearNode<Film> aktuell = start;
		for (int soek = 0; soek < antall && !slettet; soek++) {
			if (aktuell.getElement().getFilmnr() == filmnr) {
				aktuell.setElement(aktuell.getNeste().getElement());
				aktuell.setNeste(aktuell.getNeste().getNeste());        // TODO check if it works
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
		LinearNode<Film> aktuell = start;
		while (aktuell != null) {
			if (aktuell.getElement().getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
				tabell[i] = aktuell.getElement();
				i++;
			}
			aktuell = aktuell.getNeste();
		}
		return trimTab(tabell,i);
	}
	
	@Override
	public Film[] soekProdusent(String delstreng) {
		Film[] tabell = (Film[]) new Object[antall];
		int i = 0;
		LinearNode<Film> aktuell = start;
		while (aktuell != null) {
			if (aktuell.getElement().getProdusent().toLowerCase().contains(delstreng.toLowerCase())) {
				tabell[i] = aktuell.getElement();
				i++;
			}
			aktuell = aktuell.getNeste();
		}
		return null;
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
			}
			aktuell = aktuell.getNeste();
		}
		return filmer;
	}	
}
