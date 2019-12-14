import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
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

    /**
     * Read the lines of the file and put every separate line in a collection.
     */
    public Collection<String> read() {
        try {
            return Files.lines(Paths.get(filename)).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    /**
     * Read the lines of the file, split each line on the delimiter and put the results in a collection.
     */
    public Collection<String> read(final String delimiter) {
        return read().stream()
                .map(string -> string.split(delimiter))
                .map(Arrays::asList)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    /**
     * Read the lines of the file, split each line on the delimiter and put the results in a separate collection.
     */
    public Collection<Collection<String>> readSeparately(final String delimiter) {
        return read().stream()
                .map(string -> string.split(delimiter))
                .map(Arrays::asList)
                .collect(Collectors.toList());
    }
}