public class Profesor extends Persoana{
    private String departament;
    private String gradDidactic;
    public Profesor(String nume, String id, String email,
                    String departament, String gradDidactic){
        super(nume, id, email);
        this.departament = departament;
        this.gradDidactic = gradDidactic;
    }
}
