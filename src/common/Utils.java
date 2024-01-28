package common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm:ss");

    public static String getFormattedCurrentTime() {
        return dateFormatter.format(new Date());
    }

}
