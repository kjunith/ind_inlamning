package profile;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProfileFormatter {
    private static final String DEFAULT_PATTERN = "HH:mm dd/MM/yyyy";
    private static final String SHORT_PATTERN = "dd/MM/yy";

    public static String toFull(long millis) {
        return new SimpleDateFormat(DEFAULT_PATTERN).format(new Date(millis));
    }

    public static String toShort(long millis) {
        return new SimpleDateFormat(SHORT_PATTERN).format(new Date(millis));
    }
}
