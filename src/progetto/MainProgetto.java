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
		catalogo.add(libro1);
		catalogo.add(libro2);
		catalogo.add(libro3);
		Riviste rivista1 = new Riviste("2234567891011", "Focus", LocalDate.of(2022, 3, 1), 50, Periodicita.MENSILE);
		Riviste rivista2 = new Riviste("2234567891012", "National Geographic", LocalDate.of(1988, 9, 22), 100,
				Periodicita.MENSILE);
		Riviste rivista3 = new Riviste("2234567891013", "Time", LocalDate.of(1923, 3, 3), 50, Periodicita.SETTIMANALE);
		catalogo.add(rivista1);
		catalogo.add(rivista2);
		catalogo.add(rivista3);

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

		// RIMOZIONE DI UN ELEMENTO TRAMITE IDBN
		String isbnRimosso = "1234567891013";
		catalogo.removeIf(item -> item.getIsbn() == isbnRimosso);

		// RICERCA ELEMENTO CATALOGO TRAMITE IDBN
		String isbnCerca = "";
		Catalogo foundItem = catalogo.stream().filter(item -> item.getIsbn().equals(isbnCerca)).findFirst()
				.orElse(null);

		if (foundItem != null) {
			System.out.println("Elemento trovato: " + foundItem.getTitolo());
		} else {
			System.out.println("Elemento non trovato.");
		}

		// RICERCA ELEMNTI TRAMITE ANNO PUBBLICAZIONE
		int annoPubblicazioneToSearch = 1988;
		List<Catalogo> itemsByYear = catalogo.stream()
				.filter(item -> item.getAnnoPubblicazione().getYear() == annoPubblicazioneToSearch)
				.collect(Collectors.toList());

		if (!itemsByYear.isEmpty()) {
			System.out.println("Elementi trovati per l'anno " + annoPubblicazioneToSearch + ":");
			for (Catalogo item : itemsByYear) {
				System.out.println(item.getTitolo());
			}
		} else {
			System.out.println("Nessun elemento trovato per l'anno " + annoPubblicazioneToSearch);
		}

		// RICERCA ELEMENTI TRAMITE AUTORI
		String autoreToSearch = "Tzu Sun";
		List<Catalogo> itemsByAuthor = catalogo.stream().filter(item -> item instanceof Libri).map(item -> (Libri) item)
				.filter(libro -> libro.getAutore().equals(autoreToSearch)).collect(Collectors.toList());

		if (!itemsByAuthor.isEmpty()) {
			System.out.println("Elementi trovati per l'autore " + autoreToSearch + ":");
			for (Catalogo item : itemsByAuthor) {
				System.out.println(item.getTitolo());
			}
		} else {
			System.out.println("Nessun elemento trovato per l'autore " + autoreToSearch + ".");
		}
	}
}
