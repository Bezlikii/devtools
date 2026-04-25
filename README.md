# Урок DVT-2

Пакет `ru.mentee.power` нужен для области видимости. Чтобы мы знали какие классы в каких папках лежат + чтобы классы с одинаковым именем не конфликтовали между собой.

Запускаем задачи `run`, `build` и `test` используя:
- `Ctrl + Ctrl` + `gradle run`/`gradle build`/`gradle test`
- Открываем `Gradle Tool Window` и находим там эти же команды в соответствующих пакетах

Поля record `MenteeProgress`:
- `String menteeName` — имя
- `int sprintNumber` — номер спринта
- `int plannedHoursPerWeek` — количество часов на спринт

# Git Урок DVT-3

Правила веток:
- `master` — основная ветка, оставляем чистой
- `feature/DVT-<номер урока>` — ветки для работы над заданиями

Локальный цикл:
1. `git init` — инициализировать репозиторий
2. `git status` — проверить состояние
3. `git add` — отправить файлы в индекса
4. `git commit` — сохранить изменения в локальном репозитории
5. `git branch` — создать ветку
6. `git log` — посмотреть историю

# Сценарий ручной проверки DVT-6

### Запуск приложения
1. Откройте `Gradle Tool Window` (`View` → `Tool Windows` → `Gradle`)
2. Выполните: `devtools` → `Tasks` → `application` → `run`
3. Ожидаемый вывод в `Run Tool Window`:
   `Суммарно: пройдено 25 из 36 уроков, осталось 11 уроков`

### Запуск тестов
1. Откройте `Gradle Tool Window`
2. Выполните: `devtools` → `Tasks` → `verification` → `test`
3. Ожидаемый вывод: `BUILD SUCCESSFUL`, все тесты зелёные

### Отладка через Debug
1. Установите `breakpoint` на строке цикла `while` в `ProgressTracker.calculateProgress`
2. Запустите `Debug`: кликните правой кнопкой на `main` → `Debug 'ProgressTracker.main()'`
3. Используйте `Step Over` (F8) для прохождения итераций
4. Проверьте Variables: `counter`, `remainingHours` должны изменяться корректно
5. Используйте `Evaluate Expression` (Alt+F8): вычислите `remainingLessons * 2`
6. Ожидаемый результат `Evaluate: 14` (для `completedLessons=5, totalLessons=12`)

### Что делать при ошибках
- Если вывод некорректен: проверьте логику цикла через `Debug`
- Если тесты красные: откройте вывод теста, найдите `AssertionError`, скорректируйте метод
- Если `Debug` не останавливается: убедитесь, что breakpoint установлен (красный кружок)

## Кодстайл-гайд проекта devtools

Проект следует правилам `Google Java Style Guide` с адаптацией.
Автоматическая проверка: `./gradlew checkstyleMain`

### 1. Именование методов: camelCase

До:    `public void add_student(Student s) { }`

После: `public void addStudent(Student student) { }`

Почему: `Java Convention` требует `camelCase` для методов.

Источник: https://google.github.io/styleguide/javaguide.html#s5.3-camel-case

### 2. Пробелы после if/for/while

До:    `if(condition) {`

После: `if (condition) {`

Почему: улучшает читаемость, отделяет ключевое слово от выражения.

Источник: `Oracle Code Conventions — Whitespace`

### 3. Длина строки: максимум 120 символов

До:    `public List getStudentsFromSpecificCityWithVeryLongName...`

После: `public List getStudentsByCity(String city) {`

Почему: длинные строки затрудняют чтение в редакторе и при code review.

Источник: https://google.github.io/styleguide/javaguide.html#s4.4-column-limit

### 4. Порядок импортов

До:    `import java.util.List; import java.util.ArrayList; import java.io.File;`

После: `import java.io.File; import java.util.ArrayList; import java.util.List;`

Почему: алфавитный порядок упрощает поиск импортов.

Источник: `IntelliJ IDEA → Code → Optimize Imports`

### 5. Фигурные скобки для if

До:    `if (condition) doSomething();`

После: `if (condition) { doSomething(); }`

Почему: скобки обязательны даже для однострочных блоков.

Источник: https://google.github.io/styleguide/javaguide.html#s4.1.1-braces-always-used

# CI-пайплайн настроен"