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
				Periodicita.MENSILE);
		Riviste rivista3 = new Riviste("2234567891013", "Time", LocalDate.of(1954, 3, 3), 50, Periodicita.SETTIMANALE);
		catalogo.add(rivista1);
		catalogo.add(rivista2);
		catalogo.add(rivista3);

		// RIMOZIONE DI UN ELEMENTO TRAMITE IDBN
		String rimuoviIsbn = "1234567891012";
		rimuoviElementoIsbn(catalogo, rimuoviIsbn);

		// STAMPO RIVISTE NEL CATALOGO
		System.out.println("RIVISTE CATALOGO:");
		for (Catalogo item : catalogo) {
			if (item instanceof Riviste) {
				Riviste rivista = (Riviste) item;
				System.out.println("Titolo: " + rivista.getTitolo());
				System.out.println("ISBN: " + rivista.getIsbn());
				System.out.println("Anno pubblicazione: " + rivista.getAnnoPubblicazione());
				System.out.println("Numero pagine: " + rivista.getNumeroPagine());
				System.out.println("Periodicità: " + rivista.getPeriodo());
				System.out.println("-------------------------");
			}
		}

		System.out.println("");

		// STAMPO LIBRI NEL CATALOGO
		System.out.println("LIBRI CATALOGO:");
		for (Catalogo item : catalogo) {
			if (item instanceof Libri) {
				Libri libro = (Libri) item;
				System.out.println("Titolo: " + libro.getTitolo());
				System.out.println("Autore: " + libro.getAutore());
				System.out.println("ISBN: " + libro.getIsbn());
				System.out.println("Anno pubblicazione: " + libro.getAnnoPubblicazione());
				System.out.println("Numero pagine: " + libro.getNumeroPagine());
				System.out.println("Genere: " + libro.getGenere());
				System.out.println("-------------------------");
			}
		}

		// RICERCA ELEMENTO CATALOGO TRAMITE ISBN
		String cercaIsbn = "2234567891011";
		Catalogo isbnItem = cercaIsbn(catalogo, cercaIsbn);

		if (isbnItem != null) {
			System.out.println("Elemento trovato tramite ISBN: ");
			System.out.println(isbnItem.getTitolo());
		} else {
			System.out.println("Elemento non trovato.ERRORE ISBN");
		}

		// RICERCA ELEMENTI TRAMITE ANNO PUBBLICAZIONE
		int cercaAnnoPubblicazione = 1954;
		List<Catalogo> annoItem = catalogo.stream()
				.filter(item -> item.getAnnoPubblicazione().getYear() == cercaAnnoPubblicazione)
				.collect(Collectors.toList());

		if (!annoItem.isEmpty()) {
			System.out.println("Elementi trovati per l'anno " + cercaAnnoPubblicazione + ":");
			for (Catalogo item : annoItem) {
				System.out.println(" " + item.getTitolo() + ", ");
			}
		} else {
			System.out.println("Nessun elemento trovato per l'anno " + cercaAnnoPubblicazione);
		}

		// RICERCA ELEMENTI TRAMITE AUTORI
		String cercaAutore = "J.R.R. Tolkien";
		List<Catalogo> autoreItem = catalogo.stream().filter(item -> item instanceof Libri).map(item -> (Libri) item)
				.filter(libro -> libro.getAutore().equals(cercaAutore)).collect(Collectors.toList());

		if (!autoreItem.isEmpty()) {
			System.out.println("Elementi trovati per l'autore " + cercaAutore + ":");
			for (Catalogo item : autoreItem) {
				System.out.println(" " + item.getTitolo() + ", ");
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
