## File Structure

├── MainActivity.kt
├── FixtureViewModel.kt
├── FixtureRepository.kt
├── FixtureService.kt
├── models
│   └── Fixture.kt
├── ui
│   └── FixtureScreen.kt
└── utils
     └── Extensions.kt


## Project Title
Football Fixtures App

## Description
This Android application displays a list of football fixtures using the SportMonks API. The app is built using the MVVM architecture, Jetpack Compose for UI, 
Retrofit for network operations, and Kotlin Coroutines for asynchronous operations. It demonstrates the usage of modern Android development techniques and Kotlin features.


## Libraries Used

- Retrofit: For network operations.
- Gson: For JSON parsing.
- Kotlin Coroutines: For handling asynchronous tasks.
- Jetpack Compose: For building UI.
- Lifecycle: For managing UI-related data in a lifecycle-conscious way.
- JUnit: For making unit test case

## Features

- MVVM Architecture
- Jetpack Compose UI
- Coroutines for asynchronous operations
- Retrofit for network calls
- Unit tests
- Displays a list of football fixtures.
- Fetches data from the SportMonks API.
- Uses modern Android development practices including MVVM and Jetpack Compose.
- Handles network operations and asynchronous tasks efficiently with Retrofit and Coroutines.

## API

The app fetches data from the SportMonks API:

- Base URL: `https://api.sportmonks

License
This project is licensed under the MIT License.