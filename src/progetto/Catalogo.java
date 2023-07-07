package progetto;

import java.time.LocalDate;

public abstract class Catalogo {

	protected String isbn;
	protected String titolo;
	protected LocalDate annoPubblicazione;
	protected int numeroPagine;

	public Catalogo(String isbn, String titolo, LocalDate annoPubblicazione, int numeroPagine) {

		this.isbn = isbn;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroPagine = numeroPagine;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

}
