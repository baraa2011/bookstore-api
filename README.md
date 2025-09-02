# Book API

En enkel REST API för bokhantering byggd med Spring Boot.

## 🚀 Körinstruktioner

1. **Starta applikationen:**
   ```bash
   mvn spring-boot:run
   ```

2. **Testa API:et:**
   ```
   GET http://localhost:8080/api/books
   ```

## 🏗️ Pipeline

- Byggs med Maven
- Kör enhetstester vid varje push
- Automatisk bygge och deployment vid merge till main

## 🛠️ Tekniker

- **Backend:** Spring Boot 2.7
- **Byggsystem:** Maven
- **Loggning:** SLF4J med Logback
- **Testning:** JUnit 5

## 📦 Maven-kommandon

| Kommando | Beskrivning |
|----------|-------------|
| `mvn clean install` | Bygg och testa |
| `mvn spring-boot:run` | Starta applikationen |
| `mvn test` | Kör tester |

## 📝 Licens

MIT License
