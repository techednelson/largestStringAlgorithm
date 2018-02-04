import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.*;

public class LargestNumberTest {
  @Test
  public void evaluatesList() {
    LargestNumber testList = new LargestNumber();
    List<Integer> testNumbers = Arrays.asList(420, 42, 423);
    String testSrt = LargestNumber.findLargestNumber(testNumbers);
    assertEquals("42423420", testSrt);
  }
}