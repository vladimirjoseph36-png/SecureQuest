package com.example.securequest.ui.ai

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.securequest.data.CyberScenario
import com.example.securequest.data.network.SecureQuestApi
import com.example.securequest.theme.SecureQuestColors
import com.example.securequest.ui.components.CyberQuestBackground
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private val DarkText = Color(0xFF00151A)

@Composable
fun AIAssistanceScreen(
    scenario: CyberScenario,
    selectedAnswer: Int?,
    onContinue: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var guidance by remember {
        mutableStateOf("")
    }

    var error by remember {
        mutableStateOf("")
    }

    var isLoading by remember {
        mutableStateOf(false)
    }

    val scrollState = rememberScrollState()

    val api = remember {
        SecureQuestApi()
    }

    LaunchedEffect(scenario.title, selectedAnswer) {

        if (selectedAnswer == null) {
            guidance = "No answer was selected."
            error = ""
            return@LaunchedEffect
        }

        isLoading = true
        guidance = ""
        error = ""

        val question = """
            You are the AI cybersecurity tutor inside the SecureQuest learning app.

            Analyze the student's answer to this cybersecurity scenario.

            Scenario:
            ${scenario.title}

            Student selected answer:
            $selectedAnswer

            Correct answer:
            ${scenario.correctAnswer}

            Security tip:
            ${scenario.securityTip}

            Explain whether the student's choice is safe or risky.
            Explain the reasoning clearly and briefly.
            Give the student one practical cybersecurity lesson.

            Do not reveal information that is not supported by the scenario.
            Respond as a helpful cybersecurity tutor.
        """.trimIndent()

        try {
            val response = withContext(Dispatchers.IO) {
                api.ask(question)
            }

            if (!response.answer.isNullOrBlank()) {
                guidance = response.answer
            } else {
                error = response.error ?: "No AI response was returned."
            }
        } catch (exception: Exception) {
            error = "Unable to connect to SecureQuest AI."
        } finally {
            isLoading = false
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(SecureQuestColors.Background)
            .statusBarsPadding()
    ) {

        CyberQuestBackground()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(
                    start = 18.dp,
                    end = 18.dp,
                    top = 26.dp,
                    bottom = 20.dp
                )
        ) {

            // =================================================
            // HEADER
            // =================================================

            AIHeader()

            Spacer(modifier = Modifier.height(28.dp))

            // =================================================
            // INTRODUCTION
            // =================================================

            Text(
                text = "AI SECURITY AGENT",
                color = SecureQuestColors.PurpleBright,
                fontSize = 9.sp,
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = 1.2.sp
            )

            Spacer(modifier = Modifier.height(7.dp))

            Text(
                text = "YOUR CYBER DEFENSE AI",
                color = SecureQuestColors.TextPrimary,
                fontSize = 24.sp,
                lineHeight = 29.sp,
                fontWeight = FontWeight.ExtraBold
            )

            Spacer(modifier = Modifier.height(7.dp))

            Text(
                text = "Your personal cybersecurity tutor analyzes your decision and helps you understand the threat.",
                color = SecureQuestColors.TextSecondary,
                fontSize = 10.sp,
                lineHeight = 15.sp
            )

            Spacer(modifier = Modifier.height(18.dp))

            // =================================================
            // AI HERO
            // =================================================

            AIHeroCard()

            Spacer(modifier = Modifier.height(22.dp))

            // =================================================
            // MISSION
            // =================================================

            SectionHeader(
                title = "CURRENT MISSION",
                trailing = "01 / 04"
            )

            Spacer(modifier = Modifier.height(9.dp))

            MissionContextCard(
                scenario = scenario,
                selectedAnswer = selectedAnswer
            )

            Spacer(modifier = Modifier.height(22.dp))

            // =================================================
            // AI ANALYSIS
            // =================================================

            SectionHeader(
                title = "AI ANALYSIS",
                trailing = if (isLoading) {
                    "PROCESSING"
                } else {
                    "ONLINE"
                }
            )

            Spacer(modifier = Modifier.height(9.dp))

            AIResultCard(
                guidance = guidance,
                error = error,
                isLoading = isLoading
            )

            Spacer(modifier = Modifier.height(22.dp))

            // =================================================
            // SECURITY LESSON
            // =================================================

            SectionHeader(
                title = "SECURITY LESSON",
                trailing = "LEARN"
            )

            Spacer(modifier = Modifier.height(9.dp))

            SecurityLessonCard(
                tip = scenario.securityTip
            )

            Spacer(modifier = Modifier.height(22.dp))

            // =================================================
            // ACTION
            // =================================================

            Button(
                onClick = onContinue,
                enabled = !isLoading,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = SecureQuestColors.Cyan,
                    contentColor = DarkText,
                    disabledContainerColor = SecureQuestColors.SurfaceLight,
                    disabledContentColor = SecureQuestColors.TextMuted
                )
            ) {
                Text(
                    text = if (isLoading) {
                        "ANALYZING..."
                    } else {
                        "CONTINUE TO LEARN  →"
                    },
                    fontSize = 11.sp,
                    fontWeight = FontWeight.ExtraBold,
                    letterSpacing = 0.8.sp
                )
            }

            Spacer(modifier = Modifier.height(9.dp))

            Text(
                text = "Learn from every decision and become a stronger cyber defender.",
                modifier = Modifier.fillMaxWidth(),
                color = SecureQuestColors.TextMuted,
                fontSize = 8.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

// =============================================================
// HEADER
// =============================================================

@Composable
private fun AIHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(46.dp)
                .clip(RoundedCornerShape(14.dp))
                .background(
                    Brush.linearGradient(
                        colors = listOf(
                            SecureQuestColors.PurpleBright.copy(
                                alpha = 0.16f
                            ),
                            SecureQuestColors.Cyan.copy(
                                alpha = 0.07f
                            )
                        )
                    )
                )
                .border(
                    width = 1.dp,
                    color = SecureQuestColors.PurpleBright.copy(
                        alpha = 0.38f
                    ),
                    shape = RoundedCornerShape(14.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "AI",
                color = SecureQuestColors.PurpleBright,
                fontSize = 14.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "SECUREQUEST",
                color = SecureQuestColors.TextPrimary,
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = 1.3.sp
            )

            Spacer(modifier = Modifier.height(3.dp))

            Text(
                text = "AI CYBER DEFENSE",
                color = SecureQuestColors.TextMuted,
                fontSize = 8.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.sp
            )
        }

        Box(
            modifier = Modifier
                .size(46.dp)
                .clip(RoundedCornerShape(14.dp))
                .background(
                    SecureQuestColors.Success.copy(
                        alpha = 0.09f
                    )
                )
                .border(
                    width = 1.dp,
                    color = SecureQuestColors.Success.copy(
                        alpha = 0.30f
                    ),
                    shape = RoundedCornerShape(14.dp)
                ),
            contentAlignment = Alignment.Center
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Box(
                    modifier = Modifier
                        .size(7.dp)
                        .clip(CircleShape)
                        .background(SecureQuestColors.Success)
                )

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = "ONLINE",
                    color = SecureQuestColors.Success,
                    fontSize = 5.sp,
                    fontWeight = FontWeight.ExtraBold,
                    letterSpacing = 0.4.sp
                )
            }
        }
    }
}

// =============================================================
// AI HERO
// =============================================================

@Composable
private fun AIHeroCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = SecureQuestColors.SurfaceElevated.copy(
                alpha = 0.90f
            )
        ),
        border = androidx.compose.foundation.BorderStroke(
            width = 1.dp,
            color = SecureQuestColors.PurpleBright.copy(
                alpha = 0.22f
            )
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(17.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(
                        Brush.linearGradient(
                            colors = listOf(
                                SecureQuestColors.PurpleBright.copy(
                                    alpha = 0.18f
                                ),
                                SecureQuestColors.Cyan.copy(
                                    alpha = 0.08f
                                )
                            )
                        )
                    )
                    .border(
                        width = 1.dp,
                        color = SecureQuestColors.PurpleBright.copy(
                            alpha = 0.30f
                        ),
                        shape = RoundedCornerShape(16.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "AI",
                    color = SecureQuestColors.PurpleBright,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            }

            Spacer(modifier = Modifier.width(13.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = "CYBER DEFENSE AGENT",
                    color = SecureQuestColors.TextPrimary,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold,
                    letterSpacing = 0.6.sp
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "Analyze threats, explain risks, and build better security decisions.",
                    color = SecureQuestColors.TextSecondary,
                    fontSize = 9.sp,
                    lineHeight = 14.sp
                )
            }
        }
    }
}

// =============================================================
// SECTION HEADER
// =============================================================

@Composable
private fun SectionHeader(
    title: String,
    trailing: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = title,
            modifier = Modifier.weight(1f),
            color = SecureQuestColors.TextPrimary,
            fontSize = 10.sp,
            fontWeight = FontWeight.ExtraBold,
            letterSpacing = 1.1.sp
        )

        Text(
            text = trailing,
            color = SecureQuestColors.TextMuted,
            fontSize = 7.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 0.7.sp
        )
    }
}

// =============================================================
// MISSION CONTEXT
// =============================================================

@Composable
private fun MissionContextCard(
    scenario: CyberScenario,
    selectedAnswer: Int?
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = SecureQuestColors.Surface.copy(
                alpha = 0.91f
            )
        ),
        border = androidx.compose.foundation.BorderStroke(
            width = 1.dp,
            color = SecureQuestColors.Cyan.copy(
                alpha = 0.17f
            )
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(
                            SecureQuestColors.Cyan.copy(
                                alpha = 0.10f
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "01",
                        color = SecureQuestColors.Cyan,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }

                Spacer(modifier = Modifier.width(11.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "MISSION",
                        color = SecureQuestColors.TextMuted,
                        fontSize = 7.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.8.sp
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(
                        text = scenario.title,
                        color = SecureQuestColors.TextPrimary,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(9.dp))
                        .background(
                            SecureQuestColors.Success.copy(
                                alpha = 0.10f
                            )
                        )
                        .padding(
                            horizontal = 8.dp,
                            vertical = 6.dp
                        )
                ) {
                    Text(
                        text = if (selectedAnswer != null) {
                            "ANSWERED"
                        } else {
                            "ACTIVE"
                        },
                        color = SecureQuestColors.Success,
                        fontSize = 7.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = if (selectedAnswer != null) {
                    "Your response: Option ${selectedAnswer + 1}"
                } else {
                    "Waiting for your response."
                },
                color = SecureQuestColors.TextSecondary,
                fontSize = 9.sp
            )
        }
    }
}

// =============================================================
// AI RESULT
// =============================================================

@Composable
private fun AIResultCard(
    guidance: String,
    error: String,
    isLoading: Boolean
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = SecureQuestColors.SurfaceElevated.copy(
                alpha = 0.95f
            )
        ),
        border = androidx.compose.foundation.BorderStroke(
            width = 1.dp,
            color = SecureQuestColors.PurpleBright.copy(
                alpha = 0.22f
            )
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(
                            SecureQuestColors.PurpleBright.copy(
                                alpha = 0.10f
                            )
                        )
                        .border(
                            width = 1.dp,
                            color = SecureQuestColors.PurpleBright.copy(
                                alpha = 0.20f
                            ),
                            shape = RoundedCornerShape(12.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "AI",
                        color = SecureQuestColors.PurpleBright,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "SECUREQUEST AI",
                        color = SecureQuestColors.TextPrimary,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.ExtraBold
                    )

                    Spacer(modifier = Modifier.height(2.dp))

                    Text(
                        text = "Personal security guidance",
                        color = SecureQuestColors.TextMuted,
                        fontSize = 8.sp
                    )
                }

                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(
                            when {
                                isLoading -> SecureQuestColors.Cyan
                                error.isNotBlank() -> Color(
                                    0xFFFF6B6B
                                )
                                else -> SecureQuestColors.Success
                            }
                        )
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            when {

                isLoading -> {

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        CircularProgressIndicator(
                            modifier = Modifier.size(36.dp),
                            color = SecureQuestColors.Cyan,
                            strokeWidth = 3.dp
                        )

                        Spacer(modifier = Modifier.height(11.dp))

                        Text(
                            text = "Analyzing your decision...",
                            color = SecureQuestColors.TextSecondary,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Medium
                        )

                        Spacer(modifier = Modifier.height(3.dp))

                        Text(
                            text = "SecureQuest AI is preparing your lesson.",
                            color = SecureQuestColors.TextMuted,
                            fontSize = 8.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }

                guidance.isNotBlank() -> {

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(14.dp))
                            .background(
                                SecureQuestColors.PurpleBright.copy(
                                    alpha = 0.05f
                                )
                            )
                            .padding(14.dp)
                    ) {
                        Text(
                            text = guidance,
                            color = SecureQuestColors.TextPrimary,
                            fontSize = 12.sp,
                            lineHeight = 18.sp
                        )
                    }
                }

                error.isNotBlank() -> {

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(14.dp))
                            .background(
                                Color(0xFFFF6B6B).copy(
                                    alpha = 0.07f
                                )
                            )
                            .padding(14.dp)
                    ) {
                        Text(
                            text = error,
                            color = Color(0xFFFF9AA5),
                            fontSize = 11.sp,
                            lineHeight = 17.sp
                        )
                    }
                }

                else -> {

                    Text(
                        text = "Waiting for AI analysis...",
                        modifier = Modifier.fillMaxWidth(),
                        color = SecureQuestColors.TextMuted,
                        fontSize = 10.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

// =============================================================
// SECURITY LESSON
// =============================================================

@Composable
private fun SecurityLessonCard(
    tip: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(17.dp),
        colors = CardDefaults.cardColors(
            containerColor = SecureQuestColors.Surface.copy(
                alpha = 0.90f
            )
        ),
        border = androidx.compose.foundation.BorderStroke(
            width = 1.dp,
            color = SecureQuestColors.Gold.copy(
                alpha = 0.15f
            )
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.Top
        ) {

            Box(
                modifier = Modifier
                    .size(35.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        SecureQuestColors.Gold.copy(
                            alpha = 0.09f
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "!",
                    color = SecureQuestColors.Gold,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = "SECURITY TIP",
                    color = SecureQuestColors.Gold,
                    fontSize = 9.sp,
                    fontWeight = FontWeight.ExtraBold,
                    letterSpacing = 0.8.sp
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = tip,
                    color = SecureQuestColors.TextSecondary,
                    fontSize = 11.sp,
                    lineHeight = 17.sp
                )
            }
        }
    }
}