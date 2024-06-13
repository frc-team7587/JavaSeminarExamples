package org.metuchenmomentum.multipleorders;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

import static com.google.common.truth.Truth.assertThat;

class BirthdateComparatorTest {

  private static final BirthdateComparator COMPARATOR = new BirthdateComparator();

  @Test
  public void equalPeople() {
    Person joeBloggs = new Person("Joe", "Bloggs", LocalDateTime.of(1987, 11, 18, 14, 5));
    Person otherJoeBloggs = new Person("Joe", "Bloggs", LocalDateTime.of(1987, 11, 18, 14, 5));
    assertThat(COMPARATOR.compare(joeBloggs, otherJoeBloggs)).isEqualTo(0);
  }

  @Test
  public void firstNamesDiffer() {
    Person joeBloggs = new Person("Joe", "Bloggs", LocalDateTime.of(1987, 11, 18, 14, 5));
    Person frankBloggs = new Person("Frank", "Bloggs", LocalDateTime.of(1987, 11, 18, 14, 5));
    assertThat(COMPARATOR.compare(joeBloggs, frankBloggs)).isGreaterThan(0);
    assertThat(COMPARATOR.compare(frankBloggs, joeBloggs)).isLessThan(0);
  }

  @Test
  public void lastNamesDiffer() {
    Person joeBloggs = new Person("Joe", "Bloggs", LocalDateTime.of(1987, 11, 18, 14, 5));
    Person joeStalin = new Person("Joe", "Stalin", LocalDateTime.of(1987, 11, 18, 14, 5));
    assertThat(COMPARATOR.compare(joeStalin, joeBloggs)).isGreaterThan(0);
    assertThat(COMPARATOR.compare(joeBloggs, joeStalin)).isLessThan(0);
  }

  @Test
  public void datesDiffer() {
    Person joeBloggs = new Person("Joe", "Bloggs", LocalDateTime.of(1987, 11, 18, 14, 5));
    Person youngJoeBloggs = new Person("Joe", "Bloggs", LocalDateTime.of(1990, 11, 18, 14, 5));
    assertThat(COMPARATOR.compare(youngJoeBloggs, joeBloggs)).isGreaterThan(0);
    assertThat(COMPARATOR.compare(joeBloggs, youngJoeBloggs)).isLessThan(0);
  }

  @Test
  public void useInMap() {
    Person alice = new Person("Alice", "Liddell", LocalDateTime.of(2010, 7, 4, 10, 20));
    Person bruce = new Person("Bruce", "Lee", LocalDateTime.of(2009, 1, 1, 0, 1));
    Person sunita = new Person(" Sunita", "Williams", LocalDateTime.of(2011, 8, 15, 12, 1));

    TreeMap<Person, LocalDate> personToGraduation = new TreeMap<>(new BirthdateComparator());
    personToGraduation.put(alice, LocalDate.of(2025, 6, 25));
    personToGraduation.put(bruce, LocalDate.of(2024, 6, 23));
    personToGraduation.put(sunita, LocalDate.of(2023, 6, 21));

    for (Map.Entry<Person, LocalDate> entry : personToGraduation.entrySet()) {
      System.out.println(entry.getKey() + " -> " + entry.getValue());
    }
  }
}
