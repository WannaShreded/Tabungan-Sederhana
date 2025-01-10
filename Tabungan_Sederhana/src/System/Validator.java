package System;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Validator {
    public static boolean isValidDate(String date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);
            sdf.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static boolean isValidAmount(double amount) {
        return amount > 0;
    }
}