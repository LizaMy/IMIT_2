package ru.omsu.imit;


public class FunctionLinear implements IFunction {
    private double a, b;
    private double coefA, coefB;

    FunctionLinear() {
        coefA = 1;
        coefB = 0;
        a = 0.0;
        b = 1.0;
    }

    FunctionLinear(double a, double b, double coefA, double coefB) throws BadValueException {
        if (coefA == 0.0) {
            throw new BadValueException("The coefficient by x cannot equal 0");
        }
        if (a > b) {
            double temp = a;
            a = b;
            b = temp;
        }
        this.a = a;
        this.b = b;
        this.coefA = coefA;
        this.coefB = coefB;
    }

    public double getLeftBorder() {
        return a;
    }

    public double getRightBorder() {
        return b;
    }

    public double value(double x) throws BadValueException {
        if (x < a || x > b) {
            throw new BadValueException("The argument doesn't belong to determined cut [a, b]");
        }
        return coefA * x + coefB;
    }

    public void setLeftBorder(double a) {
        this.a = a;
    }

    public void setRightBorder(double b) {
        this.b = b;
    }

    public double getCoefA() {
        return coefA;
    }

    public void setCoefA(double coefA) {
        this.coefA = coefA;
    }

    public double getCoefB() {
        return coefB;
    }

    public void setCoefB(double coefB) {
        this.coefB = coefB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FunctionLinear)) return false;

        FunctionLinear that = (FunctionLinear) o;

        if (Double.compare(that.a, a) != 0) return false;
        if (Double.compare(that.b, b) != 0) return false;
        if (Double.compare(that.getCoefA(), getCoefA()) != 0) return false;
        return Double.compare(that.getCoefB(), getCoefB()) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(a);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(b);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getCoefA());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getCoefB());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "[" + a + ", " +
                b + "]\n" +
                "f(x) = " + coefA + "*x + " +
                coefB;
    }
}
