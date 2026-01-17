public class Curs {
    private String cod;
    private String denumire;
    private int credite;
    private String tip;
    private Profesor profesorTitular;
    private int anStudiu;

    public Curs(String cod, String denumire, int credite,
                String tip, Profesor profesor, int anStudiu) {
        this.cod = cod;
        this.denumire = denumire;
        this.credite = credite;
        this.tip = tip;
        this.profesorTitular = profesor;
        this.anStudiu = anStudiu;
    }
    public String getCod() {
        return cod;
    }
    public String getTip(){
        return tip;
    }
    public int getanStudiu() {
        return anStudiu;
    }
    public String getDenumire() {
        return denumire;
    }
    public int getCredite() {
        return credite;
    }
}
