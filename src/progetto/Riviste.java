package progetto;

import java.time.LocalDate;

public class Riviste extends Catalogo {

	public Periodicita periodo;

	public Riviste(String isbn, String titolo, LocalDate annoPubblicazione, int numeroPagine, Periodicita periodo) {
		super(isbn, titolo, annoPubblicazione, numeroPagine);
		this.periodo = periodo;
	}

	public Periodicita getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodicita periodo) {
		this.periodo = periodo;
	}

}
