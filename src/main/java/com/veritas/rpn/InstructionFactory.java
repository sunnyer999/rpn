package main.java.com.veritas.rpn;

import main.java.com.veritas.rpn.exception.CalculatorException;
import main.java.com.veritas.rpn.instruction.ClearInstr;
import main.java.com.veritas.rpn.instruction.Instruction;
import main.java.com.veritas.rpn.instruction.NumInstr;
import main.java.com.veritas.rpn.instruction.arithemtic.*;

import java.util.HashMap;
import java.util.function.Function;

public class InstructionFactory {

    private static HashMap<String, Function<CalcMemory, Instruction>> instructions = new HashMap<>();

    static {
        instructions.put("+", AddInstr::new);
        instructions.put("-", SubInstr::new);
        instructions.put("*", MulInstr::new);
        instructions.put("/", DivInstr::new);
        instructions.put("sqrt", SqrtInstr::new);
        instructions.put("num", NumInstr::new);
        instructions.put("clear", ClearInstr::new);
    }


    static Instruction createInstruction(String symbol, CalcMemory calcMemory) throws CalculatorException {
        Double value = tryParseDouble(symbol);
        Instruction result = null;

        if (value != null) {
            NumInstr numInstr = (NumInstr) instructions.get("num").apply(calcMemory);
            numInstr.setValue(value);
            return numInstr;
        }

        try {
            result = instructions.get(symbol).apply(calcMemory);
        } catch (NullPointerException e) {
            throw new CalculatorException("Invalid symbol: " + symbol);
        }

        return result;
    }


    private static Double tryParseDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return null;
        }
    }

}
