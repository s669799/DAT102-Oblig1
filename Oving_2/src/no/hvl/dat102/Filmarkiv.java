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
		// TODO Auto-generated method stub

	}

	@Override
	public boolean slettFilm(int filmnr) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		// TODO Auto-generated method stub
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
