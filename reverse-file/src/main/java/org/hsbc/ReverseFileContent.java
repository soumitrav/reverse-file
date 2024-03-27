package org.hsbc;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseFileContent {
    public static File reverseFileContent(File file) throws IOException {
        List<String> lines = Files.lines(file.toPath()).collect(Collectors.toList());
        List<String> reversedLines = reverseLines(lines);
        return writeToFile(reversedLines);
    }

    private static List<String> reverseLines(List<String> lines) {
        List<String> reversedLines = new ArrayList<>();
        for(String content : lines) {
            reversedLines.add(new StringBuilder(content).reverse().toString());
        }
        return reversedLines;
    }

    private static File writeToFile(List<String> reversedLines) throws IOException {
        Path outputFile = Files.createTempFile("output", ".txt");
        for(String reversedContent : reversedLines) {
            Files.write(outputFile, reversedContent.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        }
        return outputFile.toFile();
    }
}

