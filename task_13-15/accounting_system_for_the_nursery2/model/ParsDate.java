package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParsDate {
    public static boolean checkDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date tempDate = dateFormat.parse(dateString);
            String checkDate = dateFormat.format(tempDate);
            return dateString.equals(checkDate) && tempDate.before(new Date());
        } catch (ParseException e) {
            return false;
        }
    }
}
