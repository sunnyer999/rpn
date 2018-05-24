package main.java.com.veritas.rpn.instruction;

public interface UndoableInstruction extends Instruction {
    void undo();
}
