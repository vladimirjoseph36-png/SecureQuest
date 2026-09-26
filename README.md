# SecureQuest

**Created by Anio Joseph and Vladimir Joseph**

SecureQuest is a mobile cybersecurity learning application designed to help users build practical cybersecurity awareness through interactive scenarios, decision-making exercises, and AI-powered guidance.

The project was created by **Anio Joseph and Vladimir Joseph** as a learning-focused cybersecurity application combining mobile development, artificial intelligence, cybersecurity education, and modern app monetization.

## About the Project

SecureQuest turns cybersecurity concepts into interactive missions. Instead of only reading security information, users make decisions in realistic cybersecurity scenarios and receive immediate guidance explaining the security implications of their choices.

The goal is to make cybersecurity learning more practical, engaging, and accessible.

## Features

* Interactive cybersecurity missions
* Phishing and threat-detection scenarios
* Decision-based cybersecurity learning
* AI cybersecurity tutor
* Gemini-powered threat analysis and explanations
* Security tips and practical lessons
* Learning progress tracking
* Achievement tracking
* Premium experience powered by RevenueCat
* Modern dark cyber-defense interface
* Responsive Android UI

## Created By

**Anio Joseph and Vladimir Joseph**

SecureQuest was designed and developed as a learning-focused cybersecurity project combining:

* Cybersecurity education
* Android development
* Artificial intelligence
* Interactive learning
* Mobile monetization

## Technology Stack

### Android

* Kotlin
* Jetpack Compose
* Material 3
* Navigation 3
* Kotlin Serialization
* OkHttp

### AI Backend

* Node.js
* Express
* Google Gemini API

### Monetization

* RevenueCat SDK
* RevenueCat Paywall UI

## Project Architecture

```text
SecureQuest
|
|-- Android Application
|   |-- Kotlin
|   |-- Jetpack Compose
|   |-- Interactive Missions
|   |-- AI Assistant
|   `-- Progress and Achievements
|
`-- Backend
    |-- Node.js
    |-- Express
    `-- Google Gemini API
```

## AI Architecture

The Android application communicates with the SecureQuest backend through a REST API.

```text
Android App
    |
    | REST API
    v
SecureQuest Backend
    |
    | Gemini API
    v
Google Gemini
```

The Gemini API key is kept on the backend and is not stored in the Android client.

## Backend Configuration

The backend requires a Gemini API key.

Create a local file:

```text
backend/.env
```

with:

```text
GEMINI_API_KEY=your_gemini_api_key
```

The `.env` file is ignored by Git and must never be committed.

Start the backend:

```powershell
cd backend
npm install
npm start
```

The backend exposes:

```text
GET  /health
POST /api/ask
```

Test the health endpoint:

```powershell
Invoke-RestMethod "http://127.0.0.1:3000/health"
```

## Android API Configuration

The Android application reads the backend URL from:

```text
SECUREQUEST_API_BASE_URL
```

For local development, add this property to the project's `local.properties` file:

```text
SECUREQUEST_API_BASE_URL=http://YOUR_COMPUTER_IP:3000
```

Replace `YOUR_COMPUTER_IP` with the local IP address reachable from the Android device.

For an Android emulator, the host machine can normally be reached with:

```text
http://10.0.2.2:3000
```

Do not commit `local.properties`.

## RevenueCat

SecureQuest uses RevenueCat to power its premium monetization experience and paywall.

The project uses separate RevenueCat configurations for development and production.

RevenueCat credentials must be supplied through local Gradle configuration and must not be committed to the repository.

## Development

### Requirements

* Android Studio
* JDK 17+
* Android SDK
* Node.js 20+

### Build the Android application

From the project root on Windows:

```powershell
.\gradlew.bat assembleDebug
```

### Run the backend

```powershell
cd backend
npm install
npm start
```

## Environment Variables

The backend requires:

```text
GEMINI_API_KEY=your_api_key
```

The Android application can use:

```text
SECUREQUEST_API_BASE_URL=http://YOUR_COMPUTER_IP:3000
```

Secrets and local configuration must remain outside version control.

## Project Structure

```text
SecureQuest/
|-- app/
|   `-- src/
|       |-- main/
|       |   |-- java/
|       |   `-- res/
|       |
|       `-- test/
|
|-- backend/
|   |-- ai.js
|   |-- package.json
|   |-- package-lock.json
|   `-- server.js
|
|-- gradle/
|-- build.gradle.kts
|-- settings.gradle.kts
|-- LICENSE
`-- README.md
```

## Purpose

SecureQuest was built to demonstrate how cybersecurity education can be transformed into an interactive mobile experience using modern Android technologies and AI.

## Author

**Anio Joseph and Vladimir Joseph**

SecureQuest is an independently developed cybersecurity learning project.

## License

SecureQuest is released under the MIT License.

See `LICENSE` for details.
