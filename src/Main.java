import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Musiksammlung sammlung = new Musiksammlung();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("Menü:");
            System.out.println("1. Album hinzufügen");
            System.out.println("2. Track hinzufügen");
            System.out.println("3. Album anzeigen");
            System.out.println("4. Album löschen");
            System.out.println("5. Track löschen");
            System.out.println("6. Beenden");
            System.out.print("Wähle eine Option: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    albumHinzufuegen();
                    break;
                case "2":
                    trackHinzufuegen();
                    break;
                case "3":
                    albumAnzeigen();
                    break;
                case "4":
                    albumLoeschen();
                    break;
                case "5":
                    trackLoeschen();
                    break;
                case "6":
                    running = false;
                    System.out.println("Programm beendet.");
                    break;
                default:
                    System.out.println("Ungültige Option. Bitte versuche es erneut.");
                    break;
            }
        }
    }

    private static void albumHinzufuegen() {
        System.out.print("Gib die AlbumID ein: ");
        int albumID = Integer.parseInt(scanner.nextLine());

        if (sammlung.albumVorhanden(albumID)) {
            System.out.println("Fehler: Album mit dieser ID existiert bereits.");
            return;
        }

        System.out.print("Gib den Titel des Albums ein: ");
        String titel = scanner.nextLine();
        System.out.print("Gib den Interpreten ein: ");
        String interpret = scanner.nextLine();

        if (titel.isEmpty() || interpret.isEmpty()) {
            System.out.println("Fehler: Titel und Interpret dürfen nicht leer sein.");
            return;
        }

        Album album = new Album(albumID, titel, interpret);
        sammlung.albumHinzufuegen(album);
    }

    private static void trackHinzufuegen() {
        System.out.print("Gib die AlbumID ein: ");
        int albumID = Integer.parseInt(scanner.nextLine());
        Album album = sammlung.sucheAlbum(albumID);

        if (album == null) {
            System.out.println("Fehler: Kein Album mit dieser ID gefunden.");
            return;
        }

        System.out.print("Gib die TrackID ein: ");
        int trackID = Integer.parseInt(scanner.nextLine());
        System.out.print("Gib den Titel des Tracks ein: ");
        String titel = scanner.nextLine();
        System.out.print("Gib den MP3-Dateinamen ein: ");
        String mp3Dateiname = scanner.nextLine();
        System.out.print("Gib die Länge des Tracks in Sekunden ein: ");

        int laenge;
        try {
            laenge = Integer.parseInt(scanner.nextLine());
            if (laenge <= 0) {
                System.out.println("Fehler: Die Länge muss eine positive Zahl sein.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Fehler: Ungültige Eingabe für die Länge.");
            return;
        }

        Track track = new Track(trackID, titel, mp3Dateiname, laenge);
        album.trackHinzufuegen(track);
    }

    private static void albumAnzeigen() {
        System.out.print("Gib die AlbumID ein: ");
        int albumID = Integer.parseInt(scanner.nextLine());
        Album album = sammlung.sucheAlbum(albumID);

        if (album == null) {
            System.out.println("Fehler: Kein Album mit dieser ID gefunden.");
        } else {
            album.albumInfoAusgeben();
        }
    }

    private static void albumLoeschen() {
        System.out.print("Gib die AlbumID ein: ");
        int albumID = Integer.parseInt(scanner.nextLine());
        sammlung.albumLoeschen(albumID);
    }

    private static void trackLoeschen() {
        System.out.print("Gib die AlbumID ein: ");
        int albumID = Integer.parseInt(scanner.nextLine());
        Album album = sammlung.sucheAlbum(albumID);

        if (album == null) {
            System.out.println("Fehler: Kein Album mit dieser ID gefunden.");
            return;
        }

        System.out.print("Gib die TrackID ein: ");
        int trackID = Integer.parseInt(scanner.nextLine());
        album.trackLoeschen(trackID);
    }
}