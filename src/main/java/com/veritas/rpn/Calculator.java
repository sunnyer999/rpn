package main.java.com.veritas.rpn;

import main.java.com.veritas.rpn.exception.CalculatorException;
import main.java.com.veritas.rpn.instruction.Instruction;

import java.util.Stack;

public class Calculator {
    private InstructionManager instructionManager = new InstructionManager();
    private CalcMemory calcMemory = new CalcMemory();


    public Stack<Double> eval(String expr) throws CalculatorException {
        if (null == expr || expr.equals("")) {
            throw new CalculatorException("Input cannot be null.");
        }

        String[] tokens = expr.split(" ");
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("undo")) {
                instructionManager.undo();
            } else {
                Instruction instruction = InstructionFactory.createInstruction(tokens[i], calcMemory);
                try {
                    instructionManager.execute(instruction);
                } catch (CalculatorException e) {
                    throw new CalculatorException(String.format(e.getMessage(), i + 1));
                }
            }
        }

        return getValuesStack();
    }


    public Stack<Double> getValuesStack() {
        return calcMemory.getValueStack();
    }


    public Double getStackItem(int index) {
        return calcMemory.getValueStack().get(index);
    }

}
