package progetto;

import java.time.LocalDate;

public class Libri extends Catalogo {

	private String autore;
	private String genere;

	public Libri(String isbn, String titolo, LocalDate annoPubblicazione, int numeroPagine, String autore,
			String genere) {

		super(isbn, titolo, annoPubblicazione, numeroPagine);
		this.autore = autore;
		this.genere = genere;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

}
