package alexp.macrobase;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class BenchmarkTest {
    private String output = "";
    private String errorOutput = "";
    private int returnCode;

    @Rule
    public TemporaryFolder tmpFolder = new TemporaryFolder();

    private void run(String[] args) throws Exception {
        ByteArrayOutputStream outBaos = new ByteArrayOutputStream();
        ByteArrayOutputStream errBaos = new ByteArrayOutputStream();

        Benchmark benchmark = new Benchmark();
        benchmark.out = new PrintStream(outBaos);
        benchmark.err = new PrintStream(errBaos);

        returnCode = benchmark.run(args);

        output = new String(outBaos.toByteArray(), StandardCharsets.UTF_8);
        errorOutput = new String(errBaos.toByteArray(), StandardCharsets.UTF_8);
    }

    private void assertShowsHelp() {
        assertThat(output, containsString("Examples:"));
    }

    private void assertReturnCodeOk() {
        assertEquals(0, returnCode);
    }

    private void assertReturnCodeFail() {
        assertNotEquals(0, returnCode);
    }

    private static String resourcesFilePath(String path) {
        return "src/test/resources/" + path;
    }

    @Test
    public void showsHelpWhenNoArgs() throws Exception {
        run(new String[]{ });

        assertReturnCodeFail();
        assertShowsHelp();
        assertThat(errorOutput.toLowerCase(), containsString("parameters"));
    }

    @Test
    public void showsHelpWhenNotEnoughArgs() throws Exception {
        run(new String[]{ "--save-output", "dir" });

        assertReturnCodeFail();
        assertShowsHelp();
        assertThat(errorOutput.toLowerCase(), containsString("parameters"));
    }

    @Test
    @Parameters({"-b"})
    public void failsWhenHasBadArgs(String param) throws Exception {
        run(new String[]{ param, "f", "--qwerty" });

        assertReturnCodeFail();
        assertShowsHelp();
        assertThat(errorOutput, containsString("qwerty"));
        assertThat(errorOutput, containsString("recognized"));
    }

    @Test
    @Parameters({"-b"})
    public void failsWhenConfigNotFound(String param) throws Exception {
        run(new String[]{ param, "not_existing.yaml" });

        assertReturnCodeFail();
        assertThat(errorOutput.toLowerCase(), containsString("not found"));
    }

    @Test
    @Parameters({"-b,benchmark_config.yaml"})
    public void clearsDir(String param, String configName) throws Exception {
        File outputDir = tmpFolder.getRoot();
        String outputDirPath = outputDir.getAbsolutePath();

        String oldDirPath1 = outputDirPath + "/should_not_remain1";
        String oldDirPath = oldDirPath1 + "/should_not_remain2";
        String oldFilePath = oldDirPath + "/should_not_remain.txt";
        new File(oldDirPath).mkdirs();
        new File(oldFilePath).createNewFile();
        assertTrue(new File(oldFilePath).exists());

        run(new String[]{ param, resourcesFilePath(configName), "--so", outputDirPath, "--co" });

        assertReturnCodeOk();
        assertEquals("", errorOutput);

        assertFalse(new File(oldFilePath).exists());
        assertFalse(new File(oldDirPath1).exists());
    }
}