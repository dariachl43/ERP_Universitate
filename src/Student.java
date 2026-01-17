import java.util.HashMap;

public class Student extends Persoana implements Comparable<Student>, Evaluabil  {
    private String programStudii;
    private int anStudiu;
    private double medieGenerala;
    private int creditePromovate;
    private double venitMediu;
    private double punctajBursaMerit;
    private double punctajBursaSociala;
    private double punctajCamin;
    private boolean situatieSpeciala;
    private HashMap<Curs, Integer> note = new HashMap<>();
    public Student(String nume, String id, String email,
                   String programStudii, int anStudiu,
                   double medieGenerala, double venitMediu){
        super(nume, id, email);
        this.programStudii = programStudii;
        this.anStudiu = anStudiu;
        this.medieGenerala = medieGenerala;
        this.venitMediu = venitMediu;
    }
    public double getMedieGenerala() {
        return medieGenerala;
    }

    public double getPunctajBursa() {
        return punctajBursaMerit;
    }

    public double getPunctajCamin() {
        return punctajCamin;
    }
    public double getPunctajBursaSociala(){
        return punctajBursaSociala;
    }
    public String getProgramStudii(){
        return programStudii;
    }
    public int getCreditePromovate(){
        return creditePromovate;
    }
    @Override
    public double calculeazaPunctaj(){
        if(areRestante()){
            punctajBursaMerit = 0;
            return 0;
        }
        punctajBursaMerit = medieGenerala * 10;
        return punctajBursaMerit;
    }
    public void calculeazaPunctajSociala(){
        if(situatieSpeciala){
            punctajBursaSociala = 100;
        }
        else{
            punctajBursaSociala = Math.max(0, 1000 - venitMediu);
        }
    }
    public double calculeazaPunctajCamin(double distanta, double venit){
        return 2 * medieGenerala + distanta + (1000 - venit) / 100;
    }
    @Override
    public int compareTo(Student o){
        return this.nume.compareTo(o.nume);
    }
    @Override
    public String toString(){
        return nume + " | medie =  " + medieGenerala;
    }
    public void adaugaNotaFinala(Curs curs, int nota){
        note.put(curs, nota);
        calculeazaCreditePromovate();
        //de fiecare data cand apare o nota finala noua
        //la un curs se recalculeaza nr de credite promovate

    }
    public void calculeazaCreditePromovate(){
        int total = 0;
        for(Curs curs : note.keySet()){
            int nota = note.get(curs);
            if(nota >= 5){
                total = total + curs.getCredite();
            }
        }
        creditePromovate = total;
    }
    public void calculeazaMedieGenerala(){
        double suma = 0;
        int totalCredite = 0;
        for(Curs curs: note.keySet()){
            int nota = note.get(curs);
            int credite = curs.getCredite();
            suma = suma + nota * credite;
            totalCredite = totalCredite + credite;
        }
        if(totalCredite > 0){
            medieGenerala = suma / totalCredite;
        }
    }
    public String getStatus(){
        if(creditePromovate >= 10 && medieGenerala >= 5){
            return "PROMOVAT";
        }
        return "REPETENT";
    }
    public boolean areRestante(){
        for(int nota : note.values()){
            if(nota < 5)
                return true;
        }
        return false;
    }
}
