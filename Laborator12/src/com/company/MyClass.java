package com.company;

import org.junit.jupiter.api.Test;

public class MyClass {
    public void sayHello() {
        System.out.println("Hello from the loaded class!!");
    }

    public double publicSum(int a, double b) {
        return a + b;
    }

    public static double publicStaticMultiply(float a, long b) {
        return a * b;
    }

    private boolean privateAnd(boolean a, boolean b) {
        return a && b;
    }

    protected int protectedMax(int a, int b) {
        return a > b ? a : b;
    }

    @Test
    public static String anotherStaticMethod() {

        return null;
    }


}
