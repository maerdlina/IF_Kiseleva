#language: ru

Функция: Тест TestSeleniumATHomework

  Структура сценария: Проверка статуса задачи
    И авторизоваться в Jira
    И открыть проект Тест
    И проверка версии и статуса TestSeleniumATHomework
    И проверяем status <status>
    И проверяем fix version <version>

    Примеры:
      | status    | version       |
      | "СДЕЛАТЬ" | "Version 2.0" |