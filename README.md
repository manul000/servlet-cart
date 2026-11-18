# Каталог и корзина

Установите JDK 22. В переменных среды Windows задайте `JAVA_HOME` — папку JDK, а в `Path` добавьте `%JAVA_HOME%\bin`.
Затем откройте PowerShell в папке проекта. Maven загрузится автоматически; первый запуск требует интернета.

Установка зависимостей и сборка:

```powershell
.\mvnw.cmd package
```

Запуск:

```powershell
.\mvnw.cmd exec:java
```

Открыть [http://localhost:8080/shop](http://localhost:8080/shop). Остановка — `Ctrl+C`.
