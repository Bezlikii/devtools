package ru.mentee.power;

import ru.mentee.power.common.Generated;

public class ProgressDemo {

  @Generated
  static void main(String[] args) {
    var progress = new MenteeProgress("Михаил", 2, 10);

    System.out.println(progress.summary());
    if (progress.readyForSprint()) {
      System.out.println("Status: sprint ready");
    } else {
      System.out.println("Status: backlog first");
    }

    IO.println("feature/DVT");
  }
}