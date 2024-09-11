class Track extends Medienobjekt{
    private final String mp3Dateiname;
    private final int laenge; // in Sekunden

    // Konstruktor
    public Track(int trackID, String titel, String mp3Dateiname, int laenge) {
        super(trackID, titel);
        this.mp3Dateiname = mp3Dateiname;
        this.laenge = laenge;
    }

    // Getter für Länge
    public int getLaenge() {
        return laenge;
    }

    // Getter für Dateiname
    public String getMp3Dateiname() {
        return mp3Dateiname;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", MP3-Dateiname='" + getMp3Dateiname() + '\'' +
                ", Länge=" + getLaenge() + " Sekunden";
    }
}