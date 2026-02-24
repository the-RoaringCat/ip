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
