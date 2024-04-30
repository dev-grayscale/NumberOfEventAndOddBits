import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MainTest {

  @Test
  public void test() {
    Assertions.assertTrue(Arrays.equals(new int[] { 2, 0 }, Main.evenOddBit(17)));
    Assertions.assertTrue(Arrays.equals(new int[] { 0, 1 }, Main.evenOddBit(2)));
    Assertions.assertTrue(Arrays.equals(new int[] { 0, 1 }, Main.evenOddBit(Integer.MIN_VALUE)));
  }

  @Test
  public void testV2() {
    Assertions.assertTrue(Arrays.equals(new int[] { 2, 0 }, Main.evenOddBitV2(17)));
    Assertions.assertTrue(Arrays.equals(new int[] { 0, 1 }, Main.evenOddBitV2(2)));
  }

  @Test
  public void testV3() {
    Assertions.assertTrue(Arrays.equals(new int[] { 2, 0 }, Main.evenOddBitV3(17)));
    Assertions.assertTrue(Arrays.equals(new int[] { 0, 1 }, Main.evenOddBitV3(2)));
  }
}
