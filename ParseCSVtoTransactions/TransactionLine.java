package ParseCSVtoTransactions;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Class representation of a Mint(dot)com transaction line.
 */
public class TransactionLine implements Serializable {
    private static final long serialVersionUID = 2L;
    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("MM/dd/yyyy");


    private Date m_date;
    private String m_description;
    private String m_originalDescription;
    private double m_amount;
    private String m_transactionType;
    private String m_category;
    private String m_accountName;
    private String m_labels;
    private String m_notes;

    /**
     * Default constructor
     */
    public TransactionLine() {
    }

    /**
     * Serialize builder.
     * 
     * @throws ParseException
     */
    public TransactionLine(final Scanner scanner) throws ParseException {

        /*
         * "Date","Description","Original Description","Amount","Transaction Type"
         * ,"Category","Account Name","Labels","Notes"
         */

        m_date = DATE_FORMATTER.parse(trimString(scanner));
        m_description = trimString(scanner);
        m_originalDescription = trimString(scanner);
        m_amount = Double.valueOf(trimString(scanner));
        m_transactionType = trimString(scanner);
        m_category = trimString(scanner);
        m_accountName = trimString(scanner);
        m_labels = trimString(scanner);
        m_notes = trimString(scanner);
    }

    private String trimString(final Scanner scanner) {
        final String parsedString = scanner.next();
        return parsedString.substring(1, parsedString.length()-1);
    }

    /**
     * Fancy output for the toString for logging.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        sb.append("Date: " + dateFormat.format(m_date) + System.lineSeparator());
        sb.append("Description: " + m_description + System.lineSeparator());
        sb.append("OriginalDescription: " + m_originalDescription + System.lineSeparator());
        sb.append("Amount: " + m_amount + System.lineSeparator());
        sb.append("TransactionType: " + m_transactionType + System.lineSeparator());
        sb.append("Category: " + m_category + System.lineSeparator());
        sb.append("AccountName: " + m_accountName + System.lineSeparator());
        sb.append("Labels: " + m_labels + System.lineSeparator());
        sb.append("Notes: " + m_notes + System.lineSeparator());

        return sb.toString();
    }
}
