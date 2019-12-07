import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class InputReader {
    private final String filename;

    public InputReader(final String filename) {
        this.filename = filename;
    }

    public static InputReader create(final String filename) {
        return new InputReader(filename);
    }

    public Collection<String> read() {
        try {
            return Files.lines(Paths.get(filename)).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }
}