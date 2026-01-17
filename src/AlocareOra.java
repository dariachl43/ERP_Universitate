public class AlocareOra {
    private Curs curs;
    private Profesor profesor;
    private Sala sala;
    private IntervalOrar intervalOrar;
    public AlocareOra(Curs curs, Profesor profesor, Sala sala, IntervalOrar intervalOrar) {
        this.curs = curs;
        this.profesor = profesor;
        this.sala = sala;
        this.intervalOrar = intervalOrar;
    }
    public Profesor getProfesor() {
        return profesor;
    }
    public IntervalOrar getIntervalOrar() {
        return intervalOrar;
    }
    public Sala getSala() {
        return sala;
    }
    public Curs getCurs() {
        return curs;
    }
}