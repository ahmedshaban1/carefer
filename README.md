<h1 align="center"> Premier league </h1>

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=21"><img alt="API" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat"/></a>
  <a href="https://kotlinlang.org"><img alt="Kotlin" src="https://img.shields.io/badge/Kotlin-1.4.xxx-blue"/></a>
  <img alt="MVVM" src="https://img.shields.io/badge/MVVM-Architecture-orange"/>
  <a href="https://developer.android.com/kotlin/coroutines"><img alt="Coroutines" src="https://img.shields.io/badge/Coroutines-Asynchronous-red"/></a>
</p>

<p align="center">
Pl Assignment app is a small   application to demonstrate modern Android application tech-stacks with a  MVI architecture, with emphasize on Unit testing and UI testing.
</p>

## Tech stack & Open-source libraries

- Minimum SDK level 24
- [Kotlin](https://kotlinlang.org/) A modern programming language that makes developers happier.
- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) is a good for lightweight,fewer memory leaks,built-in cancellation support and Jetpack integration
- [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) A suspending function asynchronously returns a single value, but how can we return multiple asynchronously computed values
- [StateFlow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-state-flow/index.html) A SharedFlow that represents a read-only state with a single updatable data value that emits updates to the value to its collectors.
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) for dependency injection.
- [JetPack](https://developer.android.com/jetpack) Jetpack is a suite of libraries to help developers follow best practices, reduce boilerplate code, and    write code that works consistently across Android versions and devices so that developers can focus on the code they care about.
- [JetPack Compose](https://developer.android.com/jetpack/compose?gclid=Cj0KCQjwxIOXBhCrARIsAL1QFCYQrJjMxnW0gyK5bsPABpajsfMUF9lJtsYK2naZ6WI2NVFc3rd_nSUaAg07EALw_wcB&gclsrc=aw.ds) for UI implementation
- [Mockk](https://mockk.io/) for unit testing
- [Github actions](https://github.com/actions) for handling ci/cd work flows 

- Architecture
  - MVI Architecture
  - Repository pattern
  - Clean Architecture approach.
- [Gradle KotlinDsl](https://docs.gradle.org/current/userguide/kotlin_dsl.html) Gradle???s Kotlin DSL provides an alternative syntax to the traditional Groovy DSL with an enhanced editing experience in supported IDEs
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit) - Construct the REST APIs.
- [GSON](https://github.com/google/gson) - A Modern JSON library for Android.
- [Ktlint](https://github.com/pinterest/ktlint)- An anti-bikeshedding Kotlin linter with a built-in
  formatter.

## Architecture

Pl Assignment app is application with a meaningful separation for layers and features with the
necessary grouping. With MVI architecture with an additional Domain layer for each module by
itself.

## Tasks

- [x] Creating the project structure

- [x] Implementing all features

- [x] Writing test cases

# License

```xml
Designed and developed by 2022 Ahmed shaban

        Licensed under the Apache License, Version 2.0 (the "License");you may not use this file except in compliance with the License.You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, softwaredistributed under the License is distributed on an "AS IS" BASIS,WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.See the License for the specific language governing permissions andlimitations under the License.
```
