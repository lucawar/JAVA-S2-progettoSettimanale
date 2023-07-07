package progetto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainProgetto {

	public static void main(String[] args) {

		// CREAZIONE LISTA
		List<Catalogo> catalogo = new ArrayList<>();

		// AGGIUNGO LIBRI E RIVISTE
		Libri libro1 = new Libri("1234567891011", "L'Arte Della Guerra", LocalDate.of(1954, 7, 29), 200, "Tzu Sun",
				"Storia");
		Libri libro2 = new Libri("1234567891012", "Harry Potter e la Pietra Filosofale", LocalDate.of(1997, 6, 26), 332,
				"J.K. Rowling", "Fantasy");
		Libri libro3 = new Libri("1234567891013", "Il Signore Degli Anelli", LocalDate.of(1949, 6, 8), 328,
				"J.R.R. Tolkien", "Fantasy");
		Libri libro4 = new Libri("1234567891014", "Lo Hobbit", LocalDate.of(1937, 11, 21), 350, "J.R.R. Tolkien",
				"Fantasy");
		catalogo.add(libro1);
		catalogo.add(libro2);
		catalogo.add(libro3);
		catalogo.add(libro4);
		Riviste rivista1 = new Riviste("2234567891011", "Focus", LocalDate.of(2022, 3, 1), 50, Periodicita.MENSILE);
		Riviste rivista2 = new Riviste("2234567891012", "National Geographic", LocalDate.of(1988, 9, 22), 100,
				Periodicita.TRIMESTRALE);
		Riviste rivista3 = new Riviste("2234567891013", "Time", LocalDate.of(1954, 3, 3), 50, Periodicita.SETTIMANALE);
		catalogo.add(rivista1);
		catalogo.add(rivista2);
		catalogo.add(rivista3);

		// STAMPO RIVISTE NEL CATALOGO
		System.out.println("RIVISTE CATALOGO:");
		for (Catalogo item : catalogo) {
			if (item instanceof Riviste) {
				Riviste rivista = (Riviste) item;
				System.out.println("Titolo: " + rivista.titolo);
				System.out.println("ISBN: " + rivista.isbn);
				System.out.println("Anno pubblicazione: " + rivista.annoPubblicazione);
				System.out.println("Numero pagine: " + rivista.numeroPagine);
				System.out.println("Periodicità: " + rivista.periodo);
				System.out.println("-------------------------");
			}
		}

		System.out.println("");

		// STAMPO LIBRI NEL CATALOGO
		System.out.println("LIBRI CATALOGO:");
		for (Catalogo item : catalogo) {
			if (item instanceof Libri) {
				Libri libro = (Libri) item;
				System.out.println("Titolo: " + libro.titolo);
				System.out.println("Autore: " + libro.getAutore());
				System.out.println("ISBN: " + libro.isbn);
				System.out.println("Anno pubblicazione: " + libro.annoPubblicazione);
				System.out.println("Numero pagine: " + libro.numeroPagine);
				System.out.println("Genere: " + libro.getGenere());
				System.out.println("-------------------------");
			}
		}

		System.out.println("");

		// RIMOZIONE DI UN ELEMENTO TRAMITE ISBN ["ARTE DELLA GUERRA"]
		String rimuoviIsbn = "1234567891011";
		rimuoviElementoIsbn(catalogo, rimuoviIsbn);

		// STAMPO RIVISTE NEL CATALOGO DOPO RIMOZIONE ELEMENTI
		System.out.println("RIVISTE CATALOGO DOPO RIMOZIONE ELEMENTI:");
		for (Catalogo item : catalogo) {
			if (item instanceof Riviste) {
				Riviste rivista = (Riviste) item;
				System.out.println("Titolo: " + rivista.titolo);
				System.out.println("ISBN: " + rivista.isbn);
				System.out.println("Anno pubblicazione: " + rivista.annoPubblicazione);
				System.out.println("Numero pagine: " + rivista.numeroPagine);
				System.out.println("Periodicità: " + rivista.periodo);
				System.out.println("-------------------------");
			}
		}

		System.out.println("");

		// STAMPO LIBRI NEL CATALOGO DOPO RIMOZIONE ELEMENTI
		System.out.println("LIBRI CATALOGO DOPO RIMOZIONE ELEMENTI:");
		for (Catalogo item : catalogo) {
			if (item instanceof Libri) {
				Libri libro = (Libri) item;
				System.out.println("Titolo: " + libro.titolo);
				System.out.println("Autore: " + libro.getAutore());
				System.out.println("ISBN: " + libro.isbn);
				System.out.println("Anno pubblicazione: " + libro.annoPubblicazione);
				System.out.println("Numero pagine: " + libro.numeroPagine);
				System.out.println("Genere: " + libro.getGenere());
				System.out.println("-------------------------");
			}
		}

		System.out.println("");

		// RICERCA ELEMENTO CATALOGO TRAMITE ISBN
		String cercaIsbn = "1234567891014";
		Catalogo isbnItem = cercaIsbn(catalogo, cercaIsbn);

		if (isbnItem != null) {
			System.out.println("Elemento trovato tramite ISBN: ");
			System.out.println(isbnItem.titolo);
		} else {
			System.out.println("Elemento non trovato.ERRORE ISBN");
		}

		System.out.println("");

		// RICERCA ELEMENTI TRAMITE ANNO PUBBLICAZIONE
		int cercaAnnoPubblicazione = 1954;
		List<Catalogo> annoItem = catalogo.stream()
				.filter(item -> item.annoPubblicazione.getYear() == cercaAnnoPubblicazione)
				.collect(Collectors.toList());

		if (!annoItem.isEmpty()) {
			System.out.println("Elementi trovati per l'anno " + cercaAnnoPubblicazione + ":");
			for (Catalogo item : annoItem) {
				System.out.println("Titolo: " + item.titolo + ", " + item.annoPubblicazione);
			}
		} else {
			System.out.println("Nessun elemento trovato per l'anno " + cercaAnnoPubblicazione);
		}

		System.out.println("");

		// RICERCA ELEMENTI TRAMITE AUTORI
		String cercaAutore = "J.R.R. Tolkien";
		List<Catalogo> autoreItem = catalogo.stream().filter(item -> item instanceof Libri).map(item -> (Libri) item)
				.filter(libro -> libro.getAutore().equals(cercaAutore)).collect(Collectors.toList());

		if (!autoreItem.isEmpty()) {
			System.out.println("Elementi trovati per l'autore " + cercaAutore + ":");
			for (Catalogo item : autoreItem) {
				System.out.println("Titolo: " + item.titolo + ", " + item.annoPubblicazione);
			}
		} else {
			System.out.println("Nessun elemento trovato per l'autore " + cercaAutore + ".");
		}
	}

	// METODO ELIMINA ELEMENTO CATALOGO TRAMITE ISBN
	public static void rimuoviElementoIsbn(List<Catalogo> catalogo, String isbn) {
		catalogo.removeIf(e -> e.getIsbn() == isbn);
	}

	// METODO RICERCA ELEMENTO CATALOGO TRAMITE ISBN
	public static Catalogo cercaIsbn(List<Catalogo> catalogo, String isbn) {
		return catalogo.stream().filter(e -> e.getIsbn() == isbn).findFirst().orElse(null);
	}
}
