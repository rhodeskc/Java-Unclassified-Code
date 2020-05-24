package ParseCSVtoTransactions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Scanner;

public class RunParseCSVToTransactions {
    private static final String TRANSACTIONS_CSV = "transactions.csv";
    private static final String PROJECT_NAME = "ParseCSVtoTransactions";

    public static void main(String[] args) {
        // Get the input file relative to the running directory
        File inputFile = new File(Paths.get(System.getProperty("user.dir"), PROJECT_NAME, TRANSACTIONS_CSV).toString());
        
        Scanner scanner = null;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            if (!inputFile.exists() || !inputFile.isFile()) {
                throw new FileNotFoundException(
                        String.format("Could not find file %s; did you change the name of the project from %s?",
                                inputFile.getAbsolutePath(), PROJECT_NAME));
            }

            fileReader = new FileReader(inputFile);
            bufferedReader = new BufferedReader(fileReader);

            String thisLine = bufferedReader.readLine();

            // Scrap the first line as it's headers.
            thisLine = bufferedReader.readLine();
            while(thisLine != null) {
                scanner = new Scanner(thisLine);
                scanner.useDelimiter(",");

                TransactionLine transaction = new TransactionLine(scanner);
                System.out.println(transaction.toString());
                thisLine = bufferedReader.readLine();
            }
        } catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        } catch (IOException ioex) {
            ioex.printStackTrace();
        } catch (ParseException pe) {
            pe.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
