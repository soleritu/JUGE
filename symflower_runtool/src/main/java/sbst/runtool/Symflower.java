package sbst.runtool;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Symflower implements ITestingTool {

    private String cutClassPath;

    public List<File> getExtraClassPath() {
       return null;
    }

    public void initialize(File src, File bin, List<File> classPath) {
        this.cutClassPath = src.getAbsolutePath();
    }

    public void run(String cName, long timeBudget) {
        List<String> command;
        ProcessBuilder pbuilder = new ProcessBuilder();
        try {
            command = new ArrayList<>();
            command.add("lib/symflower");
            command.add("unit-tests");
            command.add("--code-disable-fetch-dependencies");
            command.add("--test-generation-solver-timeout=" + timeBudget);
            //command.add("--test-generation-timeout=" + timeBudget);
            command.add("--tests-path=/temp/testcases/");
            command.add("--java-test-framework=JUnit4");
            //command.add("test-style=basic");
            //Path tempDir = Files.createTempDirectory("");
            Path classPath = Paths.get(
                    this.cutClassPath + "/" + cName.replaceAll("(.*)\\..*$", "$1").replaceAll("\\.", "/") + "/"
            );
            //Files.copy(classPath, tempDir.resolve(cName + ".java"));

            command.add("--workspace=" + classPath);

            command.add("filter::" + cName.replaceAll("(.*)\\.(.*$)", "$2") + ".java");
            System.err.println("Running Symflower with command: " + command);
            pbuilder.command(command);

            // redirect error stream to a file
            File errorFile = new File("error.txt");
            pbuilder.redirectError(errorFile);
            Process process = pbuilder.start();

            process.waitFor();

            if (process.exitValue() != 0) {
                System.err.println("Error running Symflower, see error.txt for details");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

}
