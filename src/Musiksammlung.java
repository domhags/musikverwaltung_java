import java.util.ArrayList;
import java.util.List;

class Musiksammlung {
    private final List<Album> alben;

    // Konstruktor
    public Musiksammlung() {
        this.alben = new ArrayList<>();
    }

    // Methode zum Überprüfen, ob das Album vorhanden ist
    public boolean albumVorhanden(int albumID) {
        for (Album album : alben) {
            if (album.getId() == albumID) {
                return true;
            }
        }
        return false;
    }

    // Methode zum Hinzufügen eines Albums
    public void albumHinzufuegen(Album album) {
        if (albumVorhanden(album.getId())) {
            System.out.println("Fehler: Album mit der ID " + album.getId() + " existiert bereits.");
        } else {
            alben.add(album);
            System.out.println("Album hinzugefügt: " + album.getId());
        }
    }

    // Methode zum Löschen eines Albums
    public void albumLoeschen(int albumID) {
        boolean albumExistiert = false;

        for (int i = 0; i < alben.size(); i++) {
            if (alben.get(i).getId() == albumID) {
                alben.remove(i);
                albumExistiert = true;
                System.out.println("Album mit der ID " + albumID + " wurde gelöscht.");
                break;
            }
        }

        if (!albumExistiert) {
            System.out.println("Fehler: Kein Album mit der ID " + albumID + " gefunden.");
        }
    }


    // Methode zum Suchen eines Albums anhand der AlbumID
    public Album sucheAlbum(int albumID) {
        for (Album album : alben) {
            if (album.getId() == albumID) {
                return album;
            }
        }
        return null;
    }
}