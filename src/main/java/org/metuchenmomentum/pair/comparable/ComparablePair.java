package org.metuchenmomentum.pair.comparable;

import com.google.common.base.Preconditions;

/**
 * A pair of {@link Comparable} objects that leverages the contained objects to implement
 * the pair's {@link Comparable#compareTo} method. Comparison is lexicographic, with the
 * left hand member having more significance than the right.
 */
public class ComparablePair<T extends Comparable<T>> implements Comparable<ComparablePair<T>> {

  private final T left;
  private final T right;

  public ComparablePair(T left, T right) {
    this.left = Preconditions.checkNotNull(left);
    this.right = Preconditions.checkNotNull(right);
  }

  @Override
  public int compareTo(ComparablePair<T> compareTo) {
    int result = this.left.compareTo(compareTo.left);
    return
        result == 0
        ? this.right.compareTo(compareTo.right)
        : result;
  }
}
