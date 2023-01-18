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
		
		Film[] match;
		
		for (int i = 0; i < antall; i++) {
			if(filmarkiv[i].getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
				
			}
		}
		
		
		return null;
	}

	@Override
	public int antall(Sjanger sjanger) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int antall() {
		// TODO Auto-generated method stub
		return 0;
	}

}
