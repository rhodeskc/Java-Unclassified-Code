package ScannerCSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Scanner;

public class RunScanner {
    private static final String TRANSACTIONS_CSV = "transactions.csv";
    private static final String PROJECT_NAME = "ScannerCSV";

    public static void main(String[] args) {
        // Get the input file relative to the running directory
        File inputFile = new File(Paths.get(System.getProperty("user.dir"), PROJECT_NAME, TRANSACTIONS_CSV).toString());

        Scanner scanner = null;
        try {
            if (!inputFile.exists() || !inputFile.isFile()) {
                throw new FileNotFoundException(
                        String.format("Could not find file %s; did you change the name of the project from %s?",
                                inputFile.getAbsolutePath(), PROJECT_NAME));
            }

            scanner = new Scanner(inputFile, "UTF-8");
             
             // Set the delimiter used in file to: "," (including the ")
             scanner.useDelimiter(",");

             while(scanner.hasNext()) {
                 System.out.println(scanner.next());
             }
        }
        catch(FileNotFoundException fnnfex) {
            fnnfex.printStackTrace();
        }
        finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
