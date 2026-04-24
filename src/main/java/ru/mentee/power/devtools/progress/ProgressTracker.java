package ru.mentee.power.devtools.progress;

public class ProgressTracker {
  public String calculateTotalProgress(Mentee[] mentees) {
    if (mentees == null || mentees.length == 0) {
      throw new IllegalArgumentException("Массив менторов не должен быть пустой");
    }

    int totalCompleted = 0;
    int totalTotal = 0;
    int index = 0;

    while (index < mentees.length) {
      totalCompleted += mentees[index].completedLessons();
      totalTotal += mentees[index].totalLessons();
      index++;
    }

    int totalRemaining = totalTotal - totalCompleted;

    return "Суммарно: пройдено " + totalCompleted + " из " + totalTotal
        + " уроков, осталось " + totalRemaining + " уроков";
  }

  public static void main(String[] args) {
    ProgressTracker tracker = new ProgressTracker();

    Mentee[] mentees = {
        new Mentee("Иван", "Москва", "Backend разработка", 5, 12),
        new Mentee("Мария", "Санкт-Петербург", "Fullstack", 8, 12),
        new Mentee("Петр", "Казань", "Java Backend", 12, 12)
    };

    String progress = tracker.calculateTotalProgress(mentees);
    System.out.println(progress);
  }
}
