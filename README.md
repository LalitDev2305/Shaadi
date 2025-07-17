# 📱 Shaadi Matching App

A modern Android matchmaking app built using clean architecture and a modular design. It calculates compatibility using age, gender, location, and other factors — with a clear focus on code maintainability and scalability.

---

## 🏗️ Project Structure

This is a **multi-module project** organized like this:

shaadi
├── app/                   # Main Android launcher module (DI setup, navigation)
│   ├── data/
│   ├── domain/
├── feature/
│   ├── data/
│   ├── domain/
├── common/
│   ├── data/
│   ├── domain/
├── database/              # Room database setup
├── network/               # Ktor HTTP client setup

---

## 🔧 Why Java/Kotlin Library Modules?

Some modules (like `common/domain`, `network`, and `database`) are **Kotlin/JVM modules**, not Android library modules.

**Why?**

- ✅ Faster build times (no Android dependencies)
- ✅ Easier unit testing (pure JUnit)
- ✅ Platform-agnostic (KMP-ready)
- ✅ Clean separation of concerns

---

## 🧩 Tech Stack

| Technology           | Purpose                                        |
|----------------------|------------------------------------------------|
| Jetpack Compose      | Modern declarative UI                          |
| Hilt                 | Dependency Injection                           |
| Kotlin Coroutines    | Lightweight threading                          |
| Room                 | Local data persistence                         |
| Ktor Client          | Networking (Kotlin-first)                      |
| Kotlin/JVM Modules   | Clean, testable, and reusable non-Android code |

---

## 🌐 Why Ktor?

We chose **Ktor Client** instead of Retrofit because:

- It’s built for Kotlin and Coroutines
- Easier to customize
- Better suited for potential multiplatform use
- Lightweight and flexible

---

## 🗃 Why Room?

Room is used for local storage:

- For caching user profiles
- For offline support
- Easy integration with Kotlin Flow

---

## 💡 Dependency Injection with Hilt

Used for injecting ViewModels, UseCases, Repositories, etc.

```kotlin
@HiltViewModel
class MatchViewModel @Inject constructor(
    private val getMatchesUseCase: GetMatchesUseCase
) : ViewModel() {
    // ...
}

🧮 Matchmaking Logic
<pre>
┌──────────────────────────────┬────────────┬────────────────────────────────────┐
│ Factor                       │ Weight (%) │ Why It's Used                       │
├──────────────────────────────┼────────────┼────────────────────────────────────┤
│ Opposite Gender              │    25%     │ Basic compatibility                 │
│ Age Difference ≤ 8 years     │    20%     │ Ideal gap for matching              │
│ Same Country                 │    15%     │ Cultural alignment                  │
│ Same State                   │    10%     │ Regional relevance                  │
│ Same Location                │    10%     │ Proximity helps                     │
│ Wage Compatibility           │    10%     │ Socioeconomic match                 │
│ Misc (future params)         │    10%     │ Extendability                       │
└──────────────────────────────┴────────────┴────────────────────────────────────┘
</pre>

🚀 Getting Started

	1.	Open in Android Studio (Giraffe or newer)
	2.	Let Gradle sync
	3.	Run on emulator or device

✍️ Author

Built with ❤️ by Lalit Naiya