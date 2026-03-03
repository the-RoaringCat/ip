package a9527.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class Date {
    private LocalDate localDate;
    private String date;

    private static final List<DateTimeFormatter> FORMATTERS = List.of(DateTimeFormatter.ofPattern("dd/MM/yyyy"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    private static final String[] MONTH = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"};

    /**
     * Store the dateString as standard LocalDate format.
     * <p>
     *     If the dateString cannot be parsed to a LocalDate format, it will be stored as a string.
     * </p>
     * <p>
     *     If it is stored as LocalDate, the string field will be null. If it is store as String, the LocalDate field will be null.
     * </p>
     * @param dateString A date to be store
     */
    public Date(String dateString){
        try {
            localDate = parseDate(dateString);
            date = null;
        } catch (DateTimeParseException e) {
            //not in localDate format
            localDate = null;
            date = dateString;
        }
    }

    /**
     * Converts the instance to string representation.
     * @return The date  stored by the instance in MMM dd yyyy format or a string.
     */
    @Override
    public String toString() {
        //Exactly one attribute is null
        if(localDate != null) {
            String[] dates = localDate.toString().split("-");
            return (MONTH[Integer.parseInt(dates[1]) - 1] + " " + dates[2] + " " + dates[0]);
        }
        return date;
    }

    private static LocalDate parseDate(String dateString) {
        //ChatGPT teach me how to use formatter
        for(DateTimeFormatter formatter : FORMATTERS) {
            try {
                return LocalDate.parse(dateString, formatter);
            } catch (DateTimeParseException ignored) {
                //ignore to try other format
            }
        }
        throw new DateTimeParseException(null, dateString, 0);
    }
}
