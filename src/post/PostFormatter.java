package post;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PostFormatter {
    private static final String DEFAULT_PATTERN = "HH:mm dd/MM/yyyy";
    private static final String SHORT_PATTERN = "dd/MM/yy";

    /**
     * Takes a long and returns a String with the full
     * version of a date.
     *
     * @param millis date in millis
     * @return the formatted String
     */
    public static String toFull(long millis) {
        return new SimpleDateFormat(DEFAULT_PATTERN).format(new Date(millis));
    }

    /**
     * Takes a long and returns a String with the short
     * version of a date.
     *
     * @param millis date in millis
     * @return the formatted String
     */
    public static String toShort(long millis) {
        return new SimpleDateFormat(SHORT_PATTERN).format(new Date(millis));
    }
}
