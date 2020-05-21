package ScannerCSV;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class representation of a Mint(dot)com transaction line.
 */
public class TransactionLine implements Serializable {
    private static final long serialVersionUID = 1L;

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
    public TransactionLine(final String date, final String description, final String originalDescription,
            final String amount, final String transactionType, final String category, final String accountName,
            final String labels, final String notes) throws ParseException {
        final SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

        m_date = formatter.parse(date);
        m_description = description;
        m_originalDescription = originalDescription;
        m_amount = Double.valueOf(amount);
        m_transactionType = transactionType;
        m_category = category;
        m_accountName = accountName;
        m_labels = labels;
        m_notes = notes;
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
