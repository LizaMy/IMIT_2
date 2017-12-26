package ru.omsu.imit;


public class Integral<T extends IFunction> implements IFunctional<T> {
    private double a, b;

    public Integral() {
        a = 0.0;
        b = 1.0;
    }

    public Integral(double a, double b) {
        if (a > b) {
            double buf = 0;
            buf = a;
            a = b;
            b = buf;
        }
        this.a = a;
        this.b = b;
    }

    public double calculate(T function) throws BadValueException {
        if (function.getLeftBorder() > a || function.getRightBorder() < b) {
            throw new BadValueException("The function is over the limits of the integral");
        }
        int split = 5;
        double result1 = 0.0;
        double result2 = 0.1;

        double h = 0;
        while (Math.abs(result2 - result1) > 0.01) {
            double begin = a + ((b - a) / (2 * split));
            h = (b - a) / split;

            for (int i = 0; i < split; i++) {
                result1 += h * function.value(begin);
                begin += h;
            }
            if (Math.abs(result2 - result1) > 0.01) {
                result2 = result1;
                result1 = 0;
            }
            split += 5;
        }
        return result1;
    }
}
