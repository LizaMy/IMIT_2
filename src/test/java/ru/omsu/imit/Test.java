package ru.omsu.imit;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void testExp() throws Exception {
        FunctionExponential functionExponential = new FunctionExponential(1.0, 10.0, 1.0,2.0);
        Assert.assertTrue( (1 * Math.pow(Math.E, 1) + 2) == functionExponential.value(1.0));
    }

    @org.junit.Test
    public void testLin() throws Exception {
        FunctionLinear functionLinear = new FunctionLinear(1.0, 10.0, 1.0,2.0);
        Assert.assertTrue( 1*1+2 == functionLinear.value(1.0));
    }

    @org.junit.Test
    public void testRat() throws Exception {

    }
}