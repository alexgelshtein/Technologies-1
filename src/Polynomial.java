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

    protected Polynomial addPolynomial(Polynomial polynomial) {
        FractionList polynomialSumList = new FractionList();
        int minDegree = degree;
        int insertPos = 0;
        if (polynomial.getDegree() > degree) {
            insertPos = 1;
            minDegree = degree;
            for (int i = 0; i < polynomial.getDegree() - degree; i++) {
                polynomialSumList.insert(polynomial.getCoefficient(i));
            }
        } else if (polynomial.getDegree() < degree) {
            insertPos = 1;
            minDegree = polynomial.getDegree();
            for (int i = 0; i < degree - polynomial.getDegree(); i++) {
                polynomialSumList.insert(this.getCoefficient(i), i);
            }
        }
        for (int j = 0; j <= minDegree; j++) {
            polynomialSumList.insert(this.getCoefficient(this.degree - j).add(polynomial.getCoefficient(polynomial.getDegree() - j)), insertPos);
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