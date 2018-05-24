package main.java.com.veritas.rpn.instruction;

import main.java.com.veritas.rpn.exception.CalculatorException;

public interface Instruction {
    void execute() throws CalculatorException;
}
