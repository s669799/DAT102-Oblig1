package no.hvl.dat102.klient;

import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;
import no.hvl.dat102.adt.FilmarkivADT;

public class Meny {
	private Tekstgrensesnitt tekstgr;
	private FilmarkivADT filmarkiv;

	public Meny(FilmarkivADT filmarkiv) {
		tekstgr = new Tekstgrensesnitt();
		this.filmarkiv = filmarkiv;
	}

	public void start() {
		// legg inn en del forhåndsdefinerte filmer
		Film f1 = new Film(1, "Dag", "Pirates", 2014, Sjanger.HISTORY, "Studio");
		Film f2 = new Film(2, "Severin", "En film", 1893, Sjanger.SCIFI, "perf");
		Film f3 = new Film(3, "Alex", "Yeti", 2022, Sjanger.ACTION, "Sammen");
		Film f4 = new Film(4, "Mateuz", "En annen film", 2019, Sjanger.DRAMA, "Femten");
		Film f5 = new Film(5, "Leo", "Noe om historie", 2012, Sjanger.HISTORY, "Evo");
		Film f6 = new Film(6, "Rune", "Swift 3", 1912, Sjanger.ACTION, "Et filmstudio");
	
		//Div tester
		filmarkiv.leggTilFilm(f1);
		filmarkiv.leggTilFilm(f2);
		filmarkiv.leggTilFilm(f3);
		filmarkiv.leggTilFilm(f4);
		filmarkiv.leggTilFilm(f5);
		filmarkiv.leggTilFilm(f6);
		
		System.out.println("----------------------------------");
		Tekstgrensesnitt.skrivUtStatistikk(filmarkiv);
		
		filmarkiv.slettFilm(1);
		
		Tekstgrensesnitt.skrivUtStatistikk(filmarkiv);
				
		System.out.println("----------------------------------");
	}
}
