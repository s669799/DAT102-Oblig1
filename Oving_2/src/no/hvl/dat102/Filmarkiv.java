package no.hvl.dat102;

import no.hvl.dat102.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {
	private Film[] filmarkiv;
	private int antall;

	public Filmarkiv(int antall) {
		filmarkiv = new Film[antall];
	}

	@Override
	public Film finnFilm(int filmnr) {

		Film temp = null;

		for (Film f : filmarkiv) {
			if (f.getFilmnr() == filmnr) {
				temp = f;
			}
			break;
		}
		return temp;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {

		if (antall == filmarkiv.length) {
			utvid();
		}
		filmarkiv[antall] = nyFilm;
		antall++;
	}

	private void utvid() {

		Film[] nyTab = new Film[filmarkiv.length * 2];

		for (int i = 0; i < filmarkiv.length; i++) {
			nyTab[i] = filmarkiv[i];
		}
		filmarkiv = nyTab;
	}

	@Override
	public boolean slettFilm(int filmnr) {

		boolean slettet = false;

		for (int i = 0; i < antall && !slettet; i++) {
			if (filmarkiv[i].getFilmnr() == filmnr) {
				antall--;
				filmarkiv[i] = filmarkiv[antall];
				filmarkiv[antall] = null;
			}
		}
		return slettet;
	}

	@Override
	public Film[] soekTittel(String delstreng) {

		Film[] match = new Film[antall];
		int j = 0;

		for (int i = 0; i < antall; i++) {
			if (filmarkiv[i].getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
				match[j] = filmarkiv[i];
				j++;
			}
		}
		return trimTab(match, j);
	}

	public Film[] soekProdusent(String delstreng) {
		
		Film[] match = new Film[antall];
		int j = 0;
		
		for(int i = 0; i < antall; i++) {
			if(filmarkiv[i].getProdusent().toLowerCase().contains(delstreng.toLowerCase())) {
				match[j] = filmarkiv[i];
				j++;
			}
		}
		return trimTab(match, j);
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

	@Override
	public int antall(Sjanger sjanger) {

		int filmer = 0;

		for (int i = 0; i < antall; i++) {
			if (filmarkiv[i].getSjanger() == sjanger) {
				filmer++;
			}
		}
		return filmer;
	}

	@Override
	public int antall() {
		return antall;
	}

}
