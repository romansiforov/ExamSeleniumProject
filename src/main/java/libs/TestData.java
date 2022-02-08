package libs;

import org.junit.Rule;
import org.junit.rules.TestName;

import java.util.Date;

public class TestData {
    public final static String VALID_FIRST_NAME = "Roman"+(new Date().getTime());
    public final static String VALID_FIRST_NAMECHARECTERS = "Roman";
    public final static String VALID_LAST_NAME = "Siforov"+(new Date().getTime());
    public final static String VALID_LAST_NAME_CHARACTERS = "Siforov";
    public final static String VALID_EMAIL = "roman"+(new Date().getTime())+"@gmail.com";
    public final static String VALID_REGISTER_PASSWORD = "RomanSiforov1988";

}
