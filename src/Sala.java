import java.util.ArrayList;
import java.util.List;

public class Sala {
    private String codSala;
    private int capacitate;
    private String tipSala;
    private List<String> dotari;

    public Sala(String codSala, int capacitate, String tipSala) {
        this.codSala = codSala;
        this.capacitate = capacitate;
        this.tipSala = tipSala;
        this.dotari = new ArrayList<String>();
    }
    public String getCodSala() {
        return codSala;
    }
    public int getCapacitate() {
        return capacitate;
    }

    public String getTipSala() {
        return tipSala;
    }
    public void adaugaDotare(String dotare){
        dotari.add(dotare);
    }
    public List<String> getDotari() {
        return dotari;
    }

}
