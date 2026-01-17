import java.util.Comparator;
public class ComparatorMedie implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return Double.compare(o2.getMedieGenerala(), o1.getMedieGenerala());
    }
}
