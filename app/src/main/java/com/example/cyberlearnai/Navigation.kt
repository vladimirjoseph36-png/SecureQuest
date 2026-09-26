package com.example.securequest

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.securequest.data.cyberScenarios
import com.example.securequest.ui.ai.AIAssistanceScreen
import com.example.securequest.ui.analysis.AnalysisScreen
import com.example.securequest.ui.complete.ScenarioCompleteScreen
import com.example.securequest.ui.main.BottomNavigationBar
import com.example.securequest.ui.main.MainScreen
import com.example.securequest.ui.profile.AchievementsScreen
import com.example.securequest.ui.profile.LearningProgressScreen
import com.example.securequest.ui.profile.ProfileScreen
import com.example.securequest.ui.scenario.ScenarioScreen
import com.example.securequest.ui.summary.SummaryScreen
import com.revenuecat.purchases.ui.revenuecatui.PaywallDialog
import com.revenuecat.purchases.ui.revenuecatui.PaywallDialogOptions

@Composable
fun MainNavigation() {

    val backStack = rememberNavBackStack(Main)

    var selectedAnswer by remember {
        mutableStateOf<Int?>(null)
    }

    var score by remember {
        mutableStateOf(0)
    }

    var showRevenueCatPaywall by remember {
        mutableStateOf(false)
    }

    val scenario = cyberScenarios.first()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {

            NavDisplay(
                backStack = backStack,

                onBack = {
                    if (backStack.size > 1) {
                        backStack.removeLastOrNull()
                    }
                },

                entryProvider = entryProvider {

                    entry<Main> {
                        MainScreen(
                            onItemClick = { key: NavKey ->

                                when (key) {

                                    Main -> {
                                        backStack.clear()
                                        backStack.add(Main)
                                    }

                                    Scenario -> {
                                        selectedAnswer = null
                                        score = 0

                                        backStack.clear()
                                        backStack.add(Main)
                                        backStack.add(Scenario)
                                    }

                                    AIAssistant -> {
                                        backStack.clear()
                                        backStack.add(Main)
                                        backStack.add(AIAssistant)
                                    }

                                    Profile -> {
                                        backStack.clear()
                                        backStack.add(Main)
                                        backStack.add(Profile)
                                    }

                                    else -> Unit
                                }
                            },

                            onPremiumClick = {
                                showRevenueCatPaywall = true
                            }
                        )
                    }

                    entry<Scenario> {
                        ScenarioScreen(
                            scenario = scenario,
                            onContinue = { answer ->
                                selectedAnswer = answer
                                backStack.add(Analysis)
                            }
                        )
                    }

                    entry<Analysis> {
                        AnalysisScreen(
                            scenario = scenario,
                            onContinue = {
                                backStack.add(AIAssistant)
                            }
                        )
                    }

                    entry<AIAssistant> {
                        AIAssistanceScreen(
                            scenario = scenario,
                            selectedAnswer = selectedAnswer,
                            onContinue = {

                                if (selectedAnswer != null) {

                                    score =
                                        if (selectedAnswer == scenario.correctAnswer) {
                                            100
                                        } else {
                                            0
                                        }

                                    backStack.add(ScenarioComplete)

                                } else {

                                    if (backStack.size > 1) {
                                        backStack.removeLastOrNull()
                                    }
                                }
                            }
                        )
                    }

                    entry<ScenarioComplete> {
                        ScenarioCompleteScreen(
                            score = score,
                            onContinue = {
                                backStack.add(Summary)
                            }
                        )
                    }

                    entry<Summary> {
                        SummaryScreen(
                            scenario = scenario,
                            score = score,

                            onSave = {
                                backStack.clear()
                                backStack.add(Main)
                            },

                            onNotNow = {
                                backStack.clear()
                                backStack.add(Main)
                            }
                        )
                    }

                    entry<Profile> {
                        ProfileScreen(
                            onBack = {
                                if (backStack.size > 1) {
                                    backStack.removeLastOrNull()
                                }
                            },

                            onLearningProgress = {
                                backStack.add(LearningProgress)
                            },

                            onAchievements = {
                                backStack.add(Achievements)
                            },

                            onSettings = {
                                backStack.add(Settings)
                            }
                        )
                    }

                    entry<LearningProgress> {
                        LearningProgressScreen(
                            onBack = {
                                if (backStack.size > 1) {
                                    backStack.removeLastOrNull()
                                }
                            }
                        )
                    }

                    entry<Achievements> {
                        AchievementsScreen(
                            onBack = {
                                if (backStack.size > 1) {
                                    backStack.removeLastOrNull()
                                }
                            }
                        )
                    }
                }
            )
        }

        BottomNavigationBar(
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding(),

            onHome = {
                backStack.clear()
                backStack.add(Main)
            },

            onMissions = {
                selectedAnswer = null
                score = 0

                backStack.clear()
                backStack.add(Main)
                backStack.add(Scenario)
            },

            onAI = {
                backStack.clear()
                backStack.add(Main)
                backStack.add(AIAssistant)
            },

            onProfile = {
                backStack.clear()
                backStack.add(Main)
                backStack.add(Profile)
            }
        )
    }

    if (showRevenueCatPaywall) {
        PaywallDialog(
            paywallDialogOptions = PaywallDialogOptions.Builder()
                .setDismissRequest {
                    showRevenueCatPaywall = false
                }
                .build()
        )
    }
}
