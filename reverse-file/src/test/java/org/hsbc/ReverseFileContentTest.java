package org.hsbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseFileContentTest {
    @Test
    public void testReverseFileContent() throws IOException {
        File tempFile = Files.createTempFile("input", ".txt").toFile();
        Files.write(tempFile.toPath(), "ABC".getBytes(StandardCharsets.UTF_8));
        File file = ReverseFileContent.reverseFileContent(tempFile);
        List<String> lines = Files.lines(file.toPath()).collect(Collectors.toList());
        Assertions.assertEquals("CBA", lines.get(0));
        Assertions.assertTrue(file.getName().startsWith("output"));
    }
}
