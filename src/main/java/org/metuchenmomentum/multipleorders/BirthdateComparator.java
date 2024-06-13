package org.metuchenmomentum.multipleorders;
import java.util.Comparator;

/**
 * Compares two Person instances. Note that date increases for younger people.
 */
public class BirthdateComparator implements Comparator<Person> {
  @Override
  public int compare(Person leftPerson, Person rightPerson) {
    int result = leftPerson.birthdate().compareTo(rightPerson.birthdate());
    if (result == 0) {
      result = leftPerson.lastName().compareTo(rightPerson.lastName());
    }
    if (result == 0) {
      result = leftPerson.firstName().compareTo(rightPerson.firstName());
    }
    return result;
  }
}
