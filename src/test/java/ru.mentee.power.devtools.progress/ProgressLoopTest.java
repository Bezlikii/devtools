package ru.mentee.power.devtools.progress;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@DisplayName("Тестирование ProgressTracker")
public class ProgressLoopTest {

    @Test
    @DisplayName("Должен корректно вычислить суммарный прогресс, когда передан массив mentee")
    void shouldCalculateTotalProgress_whenMultipleMentees() {
        ProgressTracker tracker = new ProgressTracker();
        Mentee[] mentees = {
                new Mentee("Иван", "Москва", "Backend разработка", 5, 12),
                new Mentee("Мария", "Санкт-Петербург", "Fullstack", 8, 12),
                new Mentee("Пётр", "Казань", "Java Backend", 12, 12)
        };

        String result = tracker.calculateTotalProgress(mentees);

        assertThat(result)
                .contains("пройдено 25 из 36 уроков")
                .contains("осталось 11 уроков");
    }

    @Test
    @DisplayName("Должен корректно обработать массив, когда все mentee завершили курс")
    void shouldCalculateTotalProgress_whenAllMenteesCompleted() {
        ProgressTracker tracker = new ProgressTracker();
        Mentee[] mentees = {
                new Mentee("Иван", "Москва", "Backend", 12, 12),
                new Mentee("Мария", "СПб", "Fullstack", 12, 12)
        };

        String result = tracker.calculateTotalProgress(mentees);

        assertThat(result)
                .contains("пройдено 24 из 24 уроков")
                .contains("осталось 0 уроков");
    }

    @Test
    @DisplayName("Должен выкинуть исключение, если пустой массив менти")
    void shouldThrowException_whenNoMenteeFound() {
        ProgressTracker tracker = new ProgressTracker();
        Mentee[] mentees = {};

        assertThatThrownBy(() -> tracker.calculateTotalProgress(mentees))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("пуст");
    }

    @Test
    @DisplayName("Должен выкинуть IllegalArgumentException при некорректных данных completedLessons > totalLessons")
    void shouldThrowException_whenIncorrectData() {
        assertThatThrownBy(() -> new Mentee("Иван", "Москва", "Backend", 20, 12))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
