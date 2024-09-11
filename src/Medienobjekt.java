abstract class Medienobjekt {
    private final int id;
    private final String titel;

    // Konstruktor
    public Medienobjekt(int id, String titel) {
        this.id = id;
        this.titel = titel;
    }

    // Getter für ID
    public int getId() {
        return id;
    }

    // Getter für Titel
    public String getTitel() {
        return titel;
    }

    @Override
    public String toString() {
        return "Medienobjekt{" +
                "ID=" + getId() +
                ", Titel='" + getTitel() + '\'' +
                '}';
    }
}
