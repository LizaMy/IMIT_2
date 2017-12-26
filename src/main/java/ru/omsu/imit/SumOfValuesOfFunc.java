package ru.omsu.imit;


public class SumOfValuesOfFunc<T extends IFunction> implements IFunctional<T> {
    public double calculate(T function) throws BadValueException {
        return function.value(function.getLeftBorder()) + function.value(function.getRightBorder()) + function.value((function.getLeftBorder() + function.getRightBorder()) / 2);
    }

}
