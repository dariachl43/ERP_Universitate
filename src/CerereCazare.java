public class CerereCazare {
    private Student student;
    private Camin preferintaCamin;
    private double distantaDomiciliu;
    private double venit;
    //private double punctaj;
    public CerereCazare(Student student, Camin preferintaCamin, double distantaDomiciliu, double venit) {
        this.student = student;
        this.preferintaCamin = preferintaCamin;
        this.distantaDomiciliu = distantaDomiciliu;
        this.venit = venit;
    }
    public Student getStudent() {
        return student;
    }
    public Camin getPreferintaCamin() {
        return preferintaCamin;
    }
    public double getDistantaDomiciliu() {
        return distantaDomiciliu;
    }
    public double getVenit() {
        return venit;
    }
}
