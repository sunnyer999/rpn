package main.java.com.veritas.rpn;

import main.java.com.veritas.rpn.exception.CalculatorException;
import main.java.com.veritas.rpn.instruction.ClearInstr;
import main.java.com.veritas.rpn.instruction.Instruction;
import main.java.com.veritas.rpn.instruction.UndoableInstruction;

import java.util.Stack;


public class InstructionManager {

    private Stack<Instruction> history = new Stack<>();

    public void execute(Instruction instruction) throws CalculatorException {
        instruction.execute();

        if (instruction instanceof ClearInstr) {
            this.clear();
        }

        if (instruction instanceof UndoableInstruction) {
            history.push(instruction);
        }
    }

    public void undo() {
        if (!history.isEmpty()) {
            UndoableInstruction cmd = (UndoableInstruction) history.pop();
            cmd.undo();
        }
    }

    private void clear() {
        history.clear();
    }

}
