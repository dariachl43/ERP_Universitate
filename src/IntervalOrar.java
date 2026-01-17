public class IntervalOrar {
    private String zi;
    public int oraStart;
    public int oraEnd;
    public IntervalOrar(String zi, int oraStart, int oraEnd) {
        this.zi = zi;
        this.oraStart = oraStart;
        this.oraEnd = oraEnd;
    }
    public boolean suprapunere(IntervalOrar interval){
        return zi.equals(interval.zi) &&
                oraStart < interval.oraEnd &&
                interval.oraStart < oraEnd;
    }
    public String getZi() {
        return zi;
    }
    public int getOraStart() {
        return oraStart;
    }
    public int getOraEnd() {
        return oraEnd;
    }
}
