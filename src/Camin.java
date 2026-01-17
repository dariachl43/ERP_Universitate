import java.util.ArrayList;
import java.util.List;
public class Camin {
    private String nume;
    private int capacitate;
    private List<Camera> listaCamere = new ArrayList<>();
    public Camin(String nume, int capacitate) {
        this.nume = nume;
        this.capacitate = capacitate;
    }
    public String getNume() {
        return nume;
    }
    public boolean cazeazaStudent(Student s){
        for(Camera c : listaCamere){
            if(c.areLocLiber()){
                c.adaugaStudent(s);
                return true;
            }

        }
        return false;
    }
    public List<Camera> getListaCamere() {
        return listaCamere;
    }
    public int getCapacitate() {
        return capacitate;
    }
    public void adaugaCacmera(Camera a){
        listaCamere.add(a);
    }
}
