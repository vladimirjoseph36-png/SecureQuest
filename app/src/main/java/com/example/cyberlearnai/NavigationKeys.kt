package com.example.securequest

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data object Main : NavKey

@Serializable
data object Scenario : NavKey

@Serializable
data object Analysis : NavKey

@Serializable
data object AIAssistance : NavKey

@Serializable
data object AIAssistant : NavKey

@Serializable
data object ScenarioComplete : NavKey

@Serializable
data object Summary : NavKey

@Serializable
data object Profile : NavKey

@Serializable
data object LearningProgress : NavKey

@Serializable
data object Achievements : NavKey

@Serializable
data object Settings : NavKey