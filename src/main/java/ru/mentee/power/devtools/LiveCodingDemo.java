package ru.mentee.power.devtools;

import java.util.OptionalInt;

public class LiveCodingDemo {

  static void main() {
    printFizzBuzz(15);
    sumEven(new int[] {1, 2, 3, 4, 5, 6});
    findMax(new int[] {3, 7, 2, 9, 1});
  }

  public static void printFizzBuzz(int n) {
    for (int i = 1; i <= n; i++) {
      if (i % 3 == 0 && i % 5 == 0) {
        System.out.println("FizzBuzz");
      } else if (i % 5 == 0) {
        System.out.println("Buzz");
      } else if (i % 3 == 0) {
        System.out.println("Fizz");
      } else {
        System.out.println(i);
      }
    }
  }

  public static void sumEven(int[] numbers) {
    if (numbers == null) {
      throw new IllegalArgumentException("Array must not be null");
    }

    int sum = 0;
    for (int n : numbers) {
      if (n % 2 == 0) {
        sum += n;
      }
    }
    System.out.println(sum);
  }

  public static OptionalInt findMax(int[] numbers) {
    if (numbers == null) {
      throw new IllegalArgumentException("Array must not be null");
    }
    if (numbers.length == 0) {
      return OptionalInt.empty();
    }

    int max = numbers[0];
    for (int num : numbers) {
      if (num > max) {
        max = num;
      }
    }
    return OptionalInt.of(max);
  }
}
