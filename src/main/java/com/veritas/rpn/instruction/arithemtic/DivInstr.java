package main.java.com.veritas.rpn.instruction.arithemtic;

import main.java.com.veritas.rpn.CalcMemory;
import main.java.com.veritas.rpn.exception.CalculatorException;
import main.java.com.veritas.rpn.instruction.UndoableInstruction;

import java.util.Stack;

public class DivInstr implements UndoableInstruction {

    private CalcMemory calcMemory;

    private Stack<Double> previous;

    public DivInstr(CalcMemory CalcMemory) {
        this.calcMemory = CalcMemory;
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

        if (valueStack.size() < 2) {
            throw new CalculatorException("operator / (position: %d): insufficient parameters");
        }

        Double first = valueStack.pop();
        Double snd = valueStack.pop();
        if (first == 0) {
            throw new CalculatorException("Cannot divide by 0.");
        }

        valueStack.push(snd / first);
    }
}
