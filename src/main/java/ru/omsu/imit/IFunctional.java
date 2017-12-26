package ru.omsu.imit;


public interface IFunctional<T extends IFunction> {
    public double calculate(T function) throws BadValueException;
}