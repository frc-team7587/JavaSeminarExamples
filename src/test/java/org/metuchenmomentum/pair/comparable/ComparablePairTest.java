package org.metuchenmomentum.pair.comparable;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static com.google.common.truth.Truth.assertThat;

class ComparablePairTest {

  @Test
  public void accessors() {
    ComparablePair<String> pair = new ComparablePair<>("Metuchen", "Momentum");
    assertThat(pair.left()).isEqualTo("Metuchen");
    assertThat(pair.right()).isEqualTo("Momentum");
  }

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
    ComparablePair<Integer> rightSeven = new ComparablePair<>(7, Integer.MAX_VALUE);
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

  @Test
  public void mentors() {
    TreeMap<ComparablePair<String>, String> mentorExpertise = new TreeMap<>();
    ComparablePair<String> mrMcGory = new ComparablePair<>("McGory", "Patrick");
    ComparablePair<String> msMcGory = new ComparablePair<>("McGory", "Siobhan");
    ComparablePair<String> mrTang = new ComparablePair<>("Tang", "Alan");
    ComparablePair<String> mrMintz = new ComparablePair<>("Mintz", "Eric");
    mentorExpertise.put(mrTang, "Programming");
    mentorExpertise.put(mrMcGory, "Lead Mentor");
    mentorExpertise.put(mrMintz, "Electrical");
    mentorExpertise.put(msMcGory, "Business");
    for (Map.Entry<ComparablePair<String>, String> entry : mentorExpertise.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }

    assertThat(mentorExpertise.keySet()).containsExactly(mrMcGory, msMcGory, mrMintz, mrTang).inOrder();
  }
}
