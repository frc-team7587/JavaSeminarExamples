package org.metuchenmomentum.pair.comparable;

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

class ComparablePairTest {

  @Test
  public void compareEqualIntegerPairs() {
    // Note: autoboxing, Java automatically creates Integer instances from ints where needed.

    ComparablePair<Integer> leftZero = new ComparablePair<>(0, 0);
    ComparablePair<Integer> rightZero = new ComparablePair<>(0, 0);
    assertThat(leftZero.compareTo(rightZero)).isEqualTo(0);
  }

  @Test
  public void compareSameIntegerPair() {
    ComparablePair<Integer> theNines = new ComparablePair<>(9, 9);
    assertThat(theNines.compareTo(theNines)).isEqualTo(0);
  }

  @Test
  public void leftNineGreaterThanLeftSeven() {
    ComparablePair<Integer> leftNine = new ComparablePair<>(9, Integer.MIN_VALUE);
    ComparablePair<Integer> rightSeven = new ComparablePair<>(9, Integer.MAX_VALUE);
    assertThat(leftNine.compareTo(rightSeven)).isGreaterThan(0);
    assertThat(rightSeven.compareTo(leftNine)).isLessThan(0);
  }

  @Test
  public void rightNineGreaterThanRightSeven() {
    ComparablePair<Integer> rightNine = new ComparablePair<>(0, 9);
    ComparablePair<Integer> rightSeven = new ComparablePair<>(0, 7);
    assertThat(rightNine.compareTo(rightSeven)).isGreaterThan(0);
    assertThat(rightSeven.compareTo(rightNine)).isLessThan(0);
  }
}
