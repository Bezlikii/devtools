package ru.mentee.power.devtools.student;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StudentListTest {

  @Test
  void whenStudentIsNull() {

  }

  @Test
  void shouldReturnStudentFromRequestedCity() {
    StudentList studentList = new StudentList();

    Student vasya = new Student("Вася", "Воронеж");
    Student anya = new Student("Аня", "Екатеринбург");
    studentList.addStudent(vasya);
    studentList.addStudent(anya);

    List<Student> result = studentList.getStudentsByCity("Воронеж");
    assertThat(result).contains(vasya);
  }

  @Test
  void shouldReturnEmptyCollectionWhenStudentIsNull() {
    StudentList studentList = new StudentList();
    studentList.addStudent(null);

    List<Student> result = studentList.getStudentsByCity("Воронеж");
    assertThat(result).isEmpty();
  }
}