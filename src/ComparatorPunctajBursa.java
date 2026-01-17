import java.util.Comparator;
public class ComparatorPunctajBursa implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        return Double.compare(o2.getPunctajBursa(), o1.getPunctajBursa());
    }
}
