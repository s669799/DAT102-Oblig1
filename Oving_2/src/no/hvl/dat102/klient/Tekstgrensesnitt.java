package no.hvl.dat102.klient;

import java.util.InputMismatchException;
import java.util.Scanner;

import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;
import no.hvl.dat102.adt.FilmarkivADT;

public class Tekstgrensesnitt {

	// lese opplysningene om en FILM fra tastatur
	public Film lesFilm() {

		Film f = null;
		boolean innlest = false;

		for (int i = 0; i < 3 && !innlest; i++) {
			try {
				Scanner input = new Scanner(System.in);
				System.out.println("Fyll inn forespurt informasjon");

				System.out.println("Filmnummer");
				int filmnr = input.nextInt();

				System.out.println("Produsent");
				String produsent = input.nextLine();

				System.out.println("Tittel");
				String tittel = input.nextLine();

				System.out.println("Lanseringsår");
				int lansertaar = input.nextInt();

				System.out.println("Sjanger");
				Sjanger sjanger = Sjanger.valueOf(input.nextLine());

				System.out.println("Filmselskap");
				String selskap = input.nextLine();

				f = new Film(filmnr, produsent, tittel, lansertaar, sjanger, selskap);

				innlest = true;

			} catch (InputMismatchException e) {
				System.out.println("Feil datatype. Prøv igjen");
			}
		}
		return f;
	}

	// vise en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void visFilm(Film film) {

		System.out.println(film.toString());
	}

	// Skrive ut alle Filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FilmarkivADT filma, String delstreng) {

		Film[] treff = filma.soekTittel(delstreng);

		for (int i = 0; i < treff.length; i++) {
			System.out.println(filma.toString());
		}
	}

	// Skriver ut alle Filmer av en produsent / en gruppe
	public void skrivUtFilmProdusent(FilmarkivADT filma, String delstreng) {

		Film[] treff = filma.soekProdusent(delstreng);

		for (int i = 0; i < treff.length; i++) {
			System.out.println(filma.toString());
		}
	}

	// Skrive ut en enkel statistikk som inneholder antall Filmer totalt
	// og hvor mange det er i hver sjanger
	public static void skrivUtStatistikk(FilmarkivADT filma) {

		System.out.println("Antall filmer: " + filma.antall());
		System.out.println("Antall per sjanger ");
		
		for (Sjanger sj : Sjanger.values()) {
			int filmer = filma.antall(sj);
			System.out.println(sj + "-filmer: " + filmer);

		}
	}
	// ... Ev. andre metoder

}
