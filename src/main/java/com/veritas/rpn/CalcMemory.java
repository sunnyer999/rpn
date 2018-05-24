package main.java.com.veritas.rpn;

import java.util.Stack;

public class CalcMemory {
    private Stack<Double> valueStack = new Stack<Double>();

    public Stack<Double> getValueStack() {
        return this.valueStack;
    }

    public void setValueStack(Stack<Double> valueStack) {
        this.valueStack = valueStack;
    }
}
