package main.java.com.veritas.rpn.instruction;

import main.java.com.veritas.rpn.CalcMemory;

import java.util.Stack;

public class NumInstr implements UndoableInstruction {
    private CalcMemory calcMemory;
    private Double value;
    private Stack<Double> previous = new Stack<>();
    private Instruction instruction;


    public NumInstr(CalcMemory calcMemory) {
        this.calcMemory = calcMemory;
    }

    @Override
    public void undo() {
        calcMemory.setValueStack(previous);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void execute() {
        Stack<Double> valueStack = calcMemory.getValueStack();
        this.previous = (Stack<Double>) valueStack.clone();
        valueStack.push(this.value);
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
