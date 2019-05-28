public class Fraction implements Comparable<Fraction> {

    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            System.out.println("0 division");
            throw new RuntimeException();
        } else {
            int g = gcd(numerator, denominator);
            this.numerator = numerator / g;
            this.denominator = denominator / g;
        }
    }

    protected Fraction add(Fraction f) {
        return new Fraction(this.numerator * f.denominator + f.numerator * this.denominator,
                this.denominator * f.denominator);
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
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