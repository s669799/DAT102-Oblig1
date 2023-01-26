package no.hvl.dat102;

public class Film {
	private int filmnr;
	private String produsent;
	private String tittel;
	private int lansertaar;
	private Sjanger sjanger;
	private String filmselskap;

	public Film() {
		this.filmnr = 0;
		this.produsent = null;
		this.tittel = null;
		this.lansertaar = 0;
		this.sjanger = null;
		this.filmselskap = null;
	}

	public Film(int filmnr, String prod, String tittel, int lansert, Sjanger sjanger, String selskap) {
		this.filmnr = filmnr;
		this.produsent = prod;
		this.tittel = tittel;
		this.lansertaar = lansert;
		this.sjanger = sjanger;
		this.filmselskap = selskap;
	}

	public int getFilmnr() {
		return filmnr;
	}

	public void setFilmnr(int filmnr) {
		this.filmnr = filmnr;
	}

	public String getProdusent() {
		return produsent;
	}

	public void setProdusent(String produsent) {
		this.produsent = produsent;
	}

	public String getTittel() {
		return tittel;
	}

	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	public int getLansertaar() {
		return lansertaar;
	}

	public void setLansertaar(int lansertaar) {
		this.lansertaar = lansertaar;
	}

	public Sjanger getSjanger() {
		return sjanger;
	}

	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}

	public String getFilmselskap() {
		return filmselskap;
	}

	public void setFilmselskap(String filmselskap) {
		this.filmselskap = filmselskap;
	}

	@Override
	public boolean equals(Object andre) {
		if (this == andre) {
			return true;
		}

		if (andre == null) {
			return false;
		}

		if (getClass() != andre.getClass()) {
			return false;
		}

		Film denAndre = (Film) andre;
		boolean like = this.tittel == denAndre.getTittel() && this.filmnr == denAndre.getFilmnr();
		return like;
	}

	@Override
	public int hashCode() {
		Integer temp = this.filmnr;
		return temp.hashCode();
	}

	@Override
	public String toString() {

		String filmtxt = "Filmnr: " + filmnr + "\nProdusent: " + produsent + "\nTittel: " + tittel + "\nLanseringsår"
				+ lansertaar + "\nSjanger" + sjanger.toString() + "\nFilmselskap: " + filmselskap + "\n";

		return filmtxt;
	}

}
