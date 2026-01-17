public abstract class Persoana implements Cautabil{
    protected String nume;
    protected String id;
    protected String email;

    public Persoana(String nume, String id, String email) {
        this.nume = nume;
        this.id = id;
        this.email = email;
    }
    public String getNume() {
        return nume;
    }

    public String getId() {
        return id;
    }
    @Override
    public boolean matches(String criteriu){
        return nume.contains(criteriu) || id.equals(criteriu);
    }
}
