import java.util.ArrayList;
import java.util.List;
public class Camera {
    private int numar;
    private int capacitate;
    private List<Student> studenti = new ArrayList<>();
    public Camera(int numar, int capacitate) {
        this.numar = numar;
        this.capacitate = capacitate;
    }
    public boolean areLocLiber(){
        return studenti.size() < capacitate;
    }
    public void adaugaStudent(Student s){
        if(areLocLiber()){
            studenti.add(s);
        }
    }
    public List<Student> getStudenti() {
        return studenti;
    }
    public int getNumar(){
        return numar;
    }

}
