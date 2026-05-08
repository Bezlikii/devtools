package ru.mentee.power.devtools.student;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StudentTest {

  @Test
  @DisplayName("Должен содержать корректные данные")
  void shouldContainCorrectArguments() {
    Student student = new Student("Андрей", "Питер");
    assertThat(student.name()).isEqualTo("Андрей");
    assertThat(student.city()).isEqualTo("Питер");
  }
}