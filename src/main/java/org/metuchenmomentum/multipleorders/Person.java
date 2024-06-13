package org.metuchenmomentum.multipleorders;

import java.time.LocalDateTime;

/**
 * A simple representation of a person
 */
public class Person {
  private final String firstName;
  private final String lastName;
  private final LocalDateTime birthdate;

  public Person(String firstName, String lastName, LocalDateTime birthdate) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthdate = birthdate;
  }

  public String firstName() {
    return firstName;
  }

  public String lastName() {
    return lastName;
  }

  public LocalDateTime birthdate() {
    return birthdate;
  }

  @Override
  public String toString() {
    return lastName + ", " + firstName + ": " + birthdate;
  }
}
