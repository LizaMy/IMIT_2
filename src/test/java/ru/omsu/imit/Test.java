package ru.omsu.imit;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void testExp() throws Exception {
        FunctionExponential functionExponential = new FunctionExponential(1.0, 10.0, 1.0, 2.0);
        Assert.assertTrue((1 * Math.pow(Math.E, 1) + 2) == functionExponential.value(1.0));
    }

    @org.junit.Test
    public void testLin() throws Exception {
        FunctionLinear functionLinear = new FunctionLinear(1.0, 10.0, 1.0, 2.0);
        Assert.assertTrue(1 * 1 + 2 == functionLinear.value(1.0));
    }

    @org.junit.Test
    public void testRat() throws Exception {
        FunctionRational functionRational = new FunctionRational(0.0, 20.0, 5.0, 5.0, 3.0, 3.0);
        Assert.assertTrue(functionRational.value(1) == (((5.0 * 1.0) + 5.0) / (3.0 * 1.0 + 3.0)));
    }

    @org.junit.Test
    public void testTrig() throws Exception {
        FunctionTrigonometric functionTrigonometric = new FunctionTrigonometric(0, 100, 5, 3);
        Assert.assertTrue(functionTrigonometric.value(1) == 5.0 * Math.sin(3 * 1));
    }

    @org.junit.Test
    public void testIntegral() throws Exception {
        FunctionLinear functionLinear = new FunctionLinear(1.0, 10.0, 1.0, 2.0);
        Integral integral = new Integral(1, 10);
        System.out.println("Определенный интеграл " + functionLinear.toString() +"\nна отрезке от 0 до 10 равен \n" + integral.calculate(functionLinear));
    }

    @org.junit.Test
    public void testSum() throws Exception {
        FunctionLinear functionLinear = new FunctionLinear(1.0, 10.0, 1.0, 2.0);
        SumOfValuesOfFunc sumOfValuesOfFunc = new SumOfValuesOfFunc();
        System.out.println("Сумма значений функции " + functionLinear.toString() + " \nна концах и в середине \n" + sumOfValuesOfFunc.calculate(functionLinear));

    }
}