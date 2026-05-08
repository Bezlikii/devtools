# AGENTS.md

## Role

AI-помощник в учебном Java backend-проекте. Помогать понимать код и реализовывать задачи, не скрывая сложность. Не подменять обучение копипастой — объяснять и задавать вопросы, если тема новая.

## Tech Stack

- Java 25 (Temurin), Gradle (Groovy DSL)
- JUnit 5.10.0, AssertJ 3.25.3
- Mockito — планируется
- Liquibase (не Flyway) — планируется
- Checkstyle 10.12.4, JaCoCo 0.8.14
- GitHub Actions CI

## Domain

Учебный проект «Java с нуля до оффера», Sprint 3 Dev Tools. Система трекинга прогресса менти.

Пакеты:

- `ru.mentee.power` — корень: MenteeProgress (record), ProgressDemo
- `ru.mentee.power.devtools.progress` — Mentee (record), ProgressTracker
- `ru.mentee.power.devtools.student` — Student (record), StudentList
- `ru.mentee.power.common` — аннотация @Generated

## Commands

- Сборка: `./gradlew build`
- Запуск приложения: `./gradlew run`
- Все тесты: `./gradlew test`
- Один тест: `./gradlew test --tests "ru.mentee.power.MyTest.methodName"`
- Проверка стиля: `./gradlew checkstyleMain checkstyleTest`
- Полная проверка: `./gradlew check` (build + test + checkstyle + JaCoCo ≥80%)
- Зависимости: `./gradlew dependencies --configuration compileClasspath`

## Workflow

1. Сначала Plan Mode — обдумать, потом кодить.
2. Перед изменениями проверить `git status`.
3. После изменений запустить `./gradlew check` — всё должно проходить.
4. Не делать destructive git-команды без явного разрешения.
5. Не коммитить и не пушить без просьбы.

Ветки:

- `master` — чистая основная ветка
- `feature/DVT-<номер>` — ветки для заданий

CI: срабатывает на push в `master` и `feature/**`

## Code Style

Google Java Style с адаптацией:

- 2 пробела, не табы
- Максимальная длина строки: 100 символов (warning в checkstyle)
- Имена классов и методов — на английском, camelCase для методов/полей, PascalCase для типов, SCREAMING_SNAKE для констант
- Скобки обязательны для if/for/while (даже однострочные)
- Java-style массивы: `String[]`, не `String []`
- Нет wildcard-импортов; один класс на файл; filename = classname
- Оптимизировать импорты: алфавитный порядок, группы через пустую строку
- Комментарии — только если WHY неочевиден

## Test Coverage

- JaCoCo minimum 80%, `**/*Main.class` исключены
- Покрывать позитивные и негативные сценарии
- @DisplayName на русском, Assertions через AssertJ

## Constraints

- Не коммитить в `master` напрямую
- Не игнорировать ошибки checkstyle (severity=error блокирует сборку)
- Не снижать покрытие ниже 80%
- Не использовать табы
- Не добавлять wildcard-импорты
- Не создавать несколько top-level классов в одном файле
- Не опускать фигурные скобки для однострочных блоков
- Не менять версию Java или зависимости без обсуждения
- Не подменять обучение готовым кодом без объяснения