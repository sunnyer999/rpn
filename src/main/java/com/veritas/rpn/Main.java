package main.java.com.veritas.rpn;

import main.java.com.veritas.rpn.exception.CalculatorException;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        // TODO
        Calculator calculator = new Calculator();
        try {
            Stack<Double> result = calculator.eval("1 2 3 4 5");
            for (Double a : result) {
                System.out.println("buffer: " + a);
            }
        } catch (CalculatorException e) {
            System.out.println(e.getMessage());
        }
    }

}
