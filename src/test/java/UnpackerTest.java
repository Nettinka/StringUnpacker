import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UnpackerTest {
    String first;
    String wrong;
    Unpacker unpacker;
    private String errorMsg = "String is unvalid.";

    @Before
    public void setUp() throws Exception {
        first = "2[ko]3[2[kra]]";
        wrong = "котробокот23";
        unpacker = new Unpacker();
    }

    @Test
    public void testUnpackerWrongMsg() {
        String actual = unpacker.unpack(wrong);
        Assert.assertEquals(errorMsg, actual);
    }

    @Test
    public void testUnpackerLongMsg() {
        String actual = unpacker.unpack(first);
        String expected = "kokokrakrakrakrakrakra";
        Assert.assertEquals(expected, actual);
    }
}
