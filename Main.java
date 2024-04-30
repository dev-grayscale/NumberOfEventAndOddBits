/**
 * Find the amount of even and odd bits in a number
 */
public class Main {

  /**
   * This approach compares the LSB against 1 to establish if the bit
   * is ON or OFF until the number is bigger than 0. After each comparison the LSB is discarded
   * and the one on it's left takes its place (performing right *<b>logical</b> shift with 1 position).
   * To keep track of even and odd bits amount, we have 2 variables which are incremented based on the bit
   * position, initially starting from even (0) and then flipping to its counterpart for each cycle.
   *
   * Even -> Odd -> Even -> Odd -> etc..
   *
   * <info>
   *   * If instead of logical right shift (>>>), an arithmetic (>>) is performed, an infinite loop follows.
   * </info>
   *
   * You could check: https://algorational.com/posts/common-bit-operations#shifting to understand why.
   */
  public static int[] evenOddBit(int n) {
    int even = 0;
    int odd = 0;
    boolean isOdd = false;

    while (n != 0) {
      if ((n & 1) == 1) {
        if (isOdd) {
          odd++;
        } else {
          even++;
        }
      }

      isOdd = !isOdd;
      n >>>= 1;
    }

    return new int[] { even, odd };
  }

  /**
   * In this version, instead of keeping track if the bit at the current position
   * is even or odd in a variable, we make use of <b>for loop</b> and its <b>i</b> variable to keep
   * track of the position. All we have to do is then check if it's even or odd and increment
   * the concrete variable accordingly.
   *
   * <info>
   *   This time we do not always check the LSB but traverse all (32) bits starting from its position and
   *   performing an AND operation once the 1 is shifted <b>i</b> positions to the left. If the value
   *   is bigger than 0, the bit at this position is ON, otherwise OFF.
   * </info>
   */
  public static int[] evenOddBitV2(int n) {
    int even = 0;
    int odd = 0;

    for (int i = 0; i < Integer.BYTES * 8; i++) {
      if ((n & (1 << i)) > 0) {
        if (i % 2 == 0) {
          even++;
        } else {
          odd++;
        }
      }
    }

    return new int[] { even, odd };
  }

  /**
   * The last version makes use of masks (https://algorational.com/posts/common-bit-operations#masks)
   *
   * The approach is similar as the one we did in https://algorational.com/posts/power-of-4#solution-2 (Power of 2)
   *
   * We make a mask that has its bits to ON on all even positions and OFF to all odd positions.
   *
   * Performing an AND operator on the evenMask and the number results to a number
   * represented by the even bits matched in both operands, at their concrete positions.
   * Then we count just liked we did here: https://algorational.com/posts/number-of-1-bits
   *
   * To find the odd bits amount, we simply negate the evenMask, which produces
   * a sequence with 1s at all odd positions and 0s at the even (the opposite of the previous mask) and the
   * rest is the same.
   */
  public static int[] evenOddBitV3(int n) {
    int evenMask = 1431655765;

    return new int[] { count1s(evenMask & n), count1s(~evenMask & n) };
  }

  private static int count1s(int n) {
    int counter = 0;

    while (n != 0) {
      counter++;
      n &= (n - 1);
    }

    return counter;
  }
}
