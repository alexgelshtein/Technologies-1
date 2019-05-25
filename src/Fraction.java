public class Fraction implements Comparable<Fraction> {

    private final int numerator;
    private final int denominator;

    protected Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    protected Fraction add(Fraction f) {
        return new Fraction(this.numerator * f.denominator + f.numerator * this.denominator,
                this.denominator * f.denominator);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public int compareTo(Fraction o) {
        long a = this.numerator * o.denominator;
        long b = o.numerator * this.denominator;
        if(a > b) {
            return 1;
        } else if(a < b) {
            return -1;
        }
        return 0;
    }
}