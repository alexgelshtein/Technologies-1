import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {

        Fraction f0 = new Fraction(2, 9);
        Fraction f1 = new Fraction(6, 8);
        Fraction f2 = new Fraction(5, 2);
        Fraction f3 = new Fraction(3, 6);
        Fraction f4 = new Fraction(7, 2);
        Fraction f5 = new Fraction(5, 9);
        Fraction f6 = new Fraction(34, 7);
        Fraction f7 = new Fraction(8, 4);

        FractionList fractionList = new FractionList();
        fractionList.add(f0).add(f1).add(f2).add(f3);
        System.out.println(fractionList);

        System.out.println("Max is " + fractionList.getMaxFraction());
        System.out.println("Min is " + fractionList.getMinFraction());
        System.out.println("Larger then " + f1 + ": "  + fractionList.countLargerThan(f1));
        System.out.println("Less then " + f3 + ": "  + fractionList.countLessThan(f3));

        FractionList fractionArray = new FractionList();
        fractionArray.add(f4).add(f5).add(f6).add(f7).add(f3).add(new Fraction(1,1));

        Polynomial p1 = new Polynomial(fractionList);
        Polynomial p2 = new Polynomial(fractionArray);
        Polynomial polynomialSum = p1.sum(p2);
        System.out.println(String.format("%s + %s = %s", p1, p2, polynomialSum));
    }
}