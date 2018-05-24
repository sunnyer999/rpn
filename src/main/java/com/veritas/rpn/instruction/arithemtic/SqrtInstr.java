package main.java.com.veritas.rpn.instruction.arithemtic;

import main.java.com.veritas.rpn.CalcMemory;
import main.java.com.veritas.rpn.exception.CalculatorException;
import main.java.com.veritas.rpn.instruction.UndoableInstruction;

import java.util.Stack;
import java.lang.Math.*;

public class SqrtInstr implements UndoableInstruction {

    private CalcMemory calcMemory;

    private Stack<Double> previous;


    public SqrtInstr(CalcMemory calcMemory) {
        this.calcMemory = calcMemory;
    }

    @Override
    public void undo() {
        calcMemory.setValueStack(previous);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void execute() throws CalculatorException {
        Stack<Double> valueStack = calcMemory.getValueStack();
        this.previous = (Stack<Double>) valueStack.clone();

        if (valueStack.size() < 1) {
            throw new CalculatorException("operator sqrt (position: %d): insufficient parameters");
        }

        valueStack.push(Math.sqrt(valueStack.pop()));
    }
}
