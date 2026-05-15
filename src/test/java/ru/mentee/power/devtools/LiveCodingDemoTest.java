package ru.mentee.power.devtools;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.OptionalInt;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Тестирование LiveCodingDemo")
class LiveCodingDemoTest {

  private final ByteArrayOutputStream out = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  @BeforeEach
  void setUp() {
    out.reset();
    System.setOut(new PrintStream(out));
  }

  @AfterEach
  void tearDown() {
    System.setOut(originalOut);
  }

  @Test
  @DisplayName("Должен вывести FizzBuzz для числа, кратного 3 и 5")
  void shouldPrintFizzBuzzForMultipleOfThreeAndFive() {
    LiveCodingDemo.printFizzBuzz(15);

    String output = out.toString();
    assertThat(output).contains("FizzBuzz");
  }

  @Test
  @DisplayName("Должен вывести Fizz для числа, кратного 3")
  void shouldPrintFizzForMultipleOfThree() {
    LiveCodingDemo.printFizzBuzz(3);

    String output = out.toString();
    assertThat(output).contains("Fizz");
  }

  @Test
  @DisplayName("Должен вывести Buzz для числа, кратного 5")
  void shouldPrintBuzzForMultipleOfFive() {
    LiveCodingDemo.printFizzBuzz(10);

    String output = out.toString();
    assertThat(output).contains("Buzz");
  }

  @Test
  @DisplayName("Должен вывести число, если оно не кратно 3 и 5")
  void shouldPrintNumberWhenNotMultipleOfThreeOrFive() {
    LiveCodingDemo.printFizzBuzz(4);

    String output = out.toString();
    assertThat(output).contains("4");
  }

  @Test
  @DisplayName("Должен посчитать сумму чётных чисел")
  void shouldSumEvenNumbers() {
    LiveCodingDemo.sumEven(new int[] {1, 2, 3, 4, 5, 6});

    String output = out.toString();
    assertThat(output).contains("12");
  }

  @Test
  @DisplayName("Должен выбросить исключение при null для sumEven")
  void shouldThrowExceptionWhenSumEvenWithNull() {
    assertThatThrownBy(() -> LiveCodingDemo.sumEven(null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("null");
  }

  @Test
  @DisplayName("Должен найти максимальное число")
  void shouldFindMaxNumber() {
    OptionalInt result = LiveCodingDemo.findMax(new int[] {3, 7, 2, 9, 1});

    assertThat(result).hasValue(9);
  }

  @Test
  @DisplayName("Должен вернуть пустой OptionalInt для пустого массива")
  void shouldReturnEmptyForEmptyArray() {
    OptionalInt result = LiveCodingDemo.findMax(new int[] {});

    assertThat(result).isEmpty();
  }

  @Test
  @DisplayName("Должен выбросить исключение при null для findMax")
  void shouldThrowExceptionWhenFindMaxWithNull() {
    assertThatThrownBy(() -> LiveCodingDemo.findMax(null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("null");
  }
}
