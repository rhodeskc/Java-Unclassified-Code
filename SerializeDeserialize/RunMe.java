package SerializeDeserialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;
import java.text.ParseException;

public class RunMe {
    private static final String THIS_PROJECT = "SerializeDeserialize";
    private static String SERIALIZED_FILENAME = "TransactionLineSerialized.ser";
    private static final File FILE_SERIALIZED_FILE = new File(
            Paths.get(System.getProperty("user.dir"), THIS_PROJECT, SERIALIZED_FILENAME).toString());

    public static void main(final String[] args) {
        TransactionLine stransaction = createTransactionObject();

        System.out.println("Transaction before: ");
        System.out.println(stransaction.toString());

        printHyphens(80);
        serializeTransaction(stransaction);
        printHyphens(80);
        TransactionLine dtransaction = deserializeTransaction();
        printHyphens(80);

        System.out.println("Transaction after : ");
        System.out.println(dtransaction.toString());
    }

    /**
     * Builder method for creating a dummy transaction to play with.
     * @return
     */
    private static TransactionLine createTransactionObject() {
        TransactionLine transaction = null;
        try {
            transaction = new TransactionLine("5/20/2020", "SNEAKY DINGO ENT.", "SQ *SNEAKY DINGO", "10.46", "debit",
                    "Gifts", "BankOfAmerica1234", "", "");
        } catch (final ParseException e) {
            e.printStackTrace();
        }
        return transaction;
    }

    /**
    * Deserialize the transaction from the file.
    */
    private static TransactionLine deserializeTransaction() {
        System.out.println(String.format("Attempting to deserializing to object from file %s",
                FILE_SERIALIZED_FILE.getAbsolutePath()));
        TransactionLine retTransaction = null;

        try {
            FileInputStream fileInputStream = new FileInputStream(FILE_SERIALIZED_FILE.getAbsolutePath());
            ObjectInputStream inStream = new ObjectInputStream(fileInputStream);

            retTransaction = (TransactionLine) inStream.readObject();

            inStream.close();
            fileInputStream.close();
        } catch (IOException ex) {
            System.err.println("IOException is caught");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.err.println("ClassNotFoundException is caught");
        }

        return retTransaction;
    }

    /**
     * Serialize the transaction into a file.
     */
    private static void serializeTransaction(final TransactionLine transaction) {
        System.out.println("Attempting to serializing to file");

        try {
            final FileOutputStream fileOutputStream = new FileOutputStream(FILE_SERIALIZED_FILE.getAbsolutePath());
            final ObjectOutputStream objOutputStream = new ObjectOutputStream(fileOutputStream);

            objOutputStream.writeObject(transaction);

            objOutputStream.close();
            fileOutputStream.close();
        } catch (final IOException ex) {
            System.err.println("IOException is caught");
            ex.printStackTrace();
        }

        System.out.println(String.format("File written to %s", FILE_SERIALIZED_FILE.getAbsolutePath()));
    }
    
    /**
     * Print a bunch of hyphons
     * @param n Number of hyphens to output.
     */
    private static void printHyphens(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print('-');
        }
        System.out.println();
    }
}