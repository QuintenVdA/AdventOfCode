import java.util.ArrayList;
import java.util.List;

public class IntcodeExecutor {
    private final List<Integer> input;

    private static final int OPCODE_1 = 1;
    private static final int OPCODE_2 = 2;
    private static final int OPCODE_99 = 99;

    public IntcodeExecutor(final List<Integer> input) {
        this.input = input;
    }

    public void put(final int address, final int value) {
        input.set(address, value);
    }

    public List<Integer> getInput() {
        return input;
    }

    public List<Integer> execute() {
        List<Integer> memory = input;
        int instructionPointer = 0;

        while (instructionPointer < memory.size()) {
            final int opcode = memory.get(instructionPointer);

            switch (opcode) {
                case OPCODE_1:
                    memory = applyOpcode1(memory, instructionPointer);
                    instructionPointer += 4;
                    break;
                case OPCODE_2:
                    memory = applyOpcode2(memory, instructionPointer);
                    instructionPointer += 4;
                    break;
                case OPCODE_99:
                    return memory;
                default:
                    // Fallback: skip unknown opcode
                    instructionPointer++;
            }
        }

        return memory;
    }

    private List<Integer> applyOpcode1(final List<Integer> memory, final int instructionPointer) {
        final List<Integer> result = new ArrayList<>(memory);

        final int parameter1 = memory.get(instructionPointer + 1);
        final int parameter2 = memory.get(instructionPointer + 2);
        final int parameter3 = memory.get(instructionPointer + 3);

        final int sum = memory.get(parameter1) + memory.get(parameter2);
        result.set(parameter3, sum);

        return result;
    }

    private List<Integer> applyOpcode2(final List<Integer> memory, final int instructionPointer) {
        final List<Integer> result = new ArrayList<>(memory);

        final int parameter1 = memory.get(instructionPointer + 1);
        final int parameter2 = memory.get(instructionPointer + 2);
        final int parameter3 = memory.get(instructionPointer + 3);

        final int product = memory.get(parameter1) * memory.get(parameter2);
        result.set(parameter3, product);

        return result;
    }
}
