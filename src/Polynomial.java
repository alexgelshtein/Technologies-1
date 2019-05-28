public class Polynomial {

    private int degree;
    private FractionList coefficients;

    protected Polynomial(FractionList fractionList) {
        this.coefficients = fractionList;
        this.degree = fractionList.length() - 1;
    }

    private int getDegree() {
        return degree;
    }

    private Fraction getCoefficient(int part) {
        return coefficients.getFraction(part);
    }

    protected Polynomial sum(Polynomial polynomial) {
        FractionList polynomialSumList = new FractionList();
        int minDegree;
        if (polynomial.getDegree() > this.degree) {
            minDegree = this.degree;
            for (int i = 0; i < polynomial.getDegree() - minDegree; i++) {
                polynomialSumList.add(polynomial.getCoefficient(i), i);
            }
        } else {
            minDegree = polynomial.getDegree();
            for (int i = 0; i < this.degree - minDegree; i++) {
                polynomialSumList.add(this.getCoefficient(i), i);
            }
        }
        for (int i = 0; i <= minDegree; i++) {
            polynomialSumList.add(
                    this.getCoefficient(this.degree - i).add(polynomial.getCoefficient(polynomial.getDegree() - i)),
                    minDegree - 1
            );
        }
        return new Polynomial(polynomialSumList);
    }

    @Override
    public String toString() {
        String toReturn = "";
        for (int i = 0; i < coefficients.length(); i++) {
            if (i < coefficients.length() - 2) {
                toReturn += coefficients.getFraction(i) + "x^" + (coefficients.length() - 1 - i);
            } else if (i < coefficients.length() - 1) {
                toReturn += coefficients.getFraction(i) + "x";
            } else {
                toReturn += coefficients.getFraction(i);
            }
            if (i != coefficients.length() - 1) toReturn += " + ";
        }
        return "Polynomial{" + toReturn + '}';
    }
}