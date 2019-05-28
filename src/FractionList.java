import java.util.*;

public class FractionList {

    private List<Fraction> fractions = new ArrayList<>();
    private Fraction maxFraction = null;
    private Fraction minFraction = null;

    protected Fraction getMaxFraction() {
        return this.maxFraction;
    }

    protected Fraction getMinFraction() {
        return this.minFraction;
    }

    protected FractionList add(Fraction fraction) {
        fractions.add(fraction);
        this.updateMinAndMax(fraction);

        return this;
    }

    protected FractionList add(Fraction fraction, int index) {
        if (index < 0 || index > fractions.size()) {
            System.out.println("Invalid index");
        } else {
            fractions.add(index, fraction);
            this.updateMinAndMax(fraction);
        }
        return this;
    }

    protected Fraction getFraction(int index) {
        return fractions.get(index);
    }

    protected int length() {
        return fractions.size();
    }

    protected int countLargerThan(Fraction fraction) {
        int count = 0;
        for (Fraction f : fractions) {
            if (f.compareTo(fraction) > 0) {
                ++count;
            }
        }
        return count;
    }

    protected int countLessThan(Fraction fraction) {
        int count = 0;
        for (Fraction f : fractions) {
            if (f.compareTo(fraction) < 0) {
                ++count;
            }
        }
        return count;
    }

    private void updateMinAndMax(Fraction fraction) {
        if (this.maxFraction == null) {
            this.maxFraction = fraction;
            this.minFraction = fraction;
        } else {
            if (fraction.compareTo(this.maxFraction) > 0) {
                this.maxFraction = fraction;
            }
            if (fraction.compareTo(this.minFraction) < 0) {
                this.minFraction = fraction;
            }
        }
    }

    @Override
    public String toString() {
        return String.format("FractionList{%s}", fractions);
    }
}