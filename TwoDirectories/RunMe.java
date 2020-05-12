package TwoDirectories;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class RunMe {
    public static void main(String[] args) {
        // Initialize parameters. Normally this would just be passed in as a method parameter.
        String cwd = System.getProperty("user.dir");
        String thisProjectName = "TwoDirectories";
        String leftDirectory = "Left";
        String rightDirectory = "Right";
        File leftFullDir = new File(Paths.get(cwd, thisProjectName, leftDirectory).toString());
        File rightFullDir = new File(Paths.get(cwd, thisProjectName, rightDirectory).toString());

        System.out.println("Running in " + Paths.get(cwd, thisProjectName));

        // Call the method we're testing.        
        Set<String> filesInCommon = getFilesInCommon(leftFullDir, rightFullDir);

        // Output the results.
        System.out.println("Files present under path: " + leftFullDir.getParentFile() + ": \\Left vs \\Right");
        filesInCommon.stream().sorted().forEach(System.out::println);
    }

    /**
     * Get the filenames of the files in common for both directories.
     * Note: comparison is case sensitive.
     */
    private static Set<String> getFilesInCommon(File leftDirectory, File rightDirectory) {
        File[] leftList = leftDirectory.listFiles();
        File[] rightList = rightDirectory.listFiles();
        Set<String> rightListStream = Arrays.stream(rightList)
                .map(f -> f.getName())
                .collect(Collectors.toSet());

        // Use left as base.
        Set<String> commonFiles = Arrays.stream(leftList)
                .map(f -> f.getName())
                .filter(lfn -> rightListStream.contains(lfn))
                .collect(Collectors.toSet());

        return commonFiles;
    }
}