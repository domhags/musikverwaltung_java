import java.util.ArrayList;
import java.util.List;

class Album extends Medienobjekt{
    private final String interpret;
    private final List<Track> tracks;

    // Konstruktor
    public Album(int albumID, String titel, String interpret) {
        super(albumID, titel);
        this.interpret = interpret;
        this.tracks = new ArrayList<>();
    }

    // Getter für den Interpreten
    public String getInterpret() {
        return interpret;
    }

    // Methode zum Überprüfen ob der Track bereits vorhanden ist
    public boolean trackVorhanden(int trackID) {
        for (Track track : tracks) {
            if (track.getId() == trackID) {
                return true;
            }
        }
        return false;
    }

    // Methode zum Track Hinzufügen
    public void trackHinzufuegen(Track track) {
        if (trackVorhanden(track.getId())) {
            System.out.println("Fehler: Track mit der ID " + track.getId() + " existiert bereits.");
        } else {
            tracks.add(track);
            System.out.println("Track hinzugefügt: " + track.getTitel());
        }
    }

    // Methode zum Track löschen
    public void trackLoeschen(int trackID) {
        boolean trackExistiert = false;

        // Suche den Track und entferne ihn, falls vorhanden
        for (int i = 0; i < tracks.size(); i++) {
            if (tracks.get(i).getId() == trackID) {
                tracks.remove(i);
                trackExistiert = true;
                System.out.println("Track mit der ID " + trackID + " wurde gelöscht.");
                break;
            }
        }

        if (!trackExistiert) {
            System.out.println("Fehler: Kein Track mit der ID " + trackID + " gefunden.");
        }
    }

    // Methode zum Berechnen der gesamten Spieldauer
    public int berechneGesamtSpieldauer() {
        int gesamtDauer = 0;

        for (Track track : tracks) {
            gesamtDauer += track.getLaenge();
        }

        return gesamtDauer;
    }

    // Methode zum Ausgeben der Albumdetails
    public void albumInfoAusgeben() {
        System.out.println("Album: " + getTitel() + " von " + getInterpret());
        System.out.println("Gesamtspieldauer: " + berechneGesamtSpieldauer() + " Sekunden");
        System.out.println("Tracks:");
        for (Track track : tracks) {
            System.out.println(track);
        }
    }
}
