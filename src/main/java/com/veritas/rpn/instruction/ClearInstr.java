package main.java.com.veritas.rpn.instruction;

import main.java.com.veritas.rpn.CalcMemory;

public class ClearInstr implements Instruction {
    private CalcMemory CalcMemory;

    public ClearInstr(CalcMemory CalcMemory) {
        this.CalcMemory = CalcMemory;
    }

    @Override
    public void execute() {
        CalcMemory.getValueStack().clear();
    }
}
