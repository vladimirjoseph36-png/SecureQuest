package com.example.securequest.ui.scenario

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.securequest.theme.SecureQuestColors
import com.example.securequest.ui.components.CyberQuestBackground

private val DarkText = Color(0xFF00151A)

@Composable
fun ScenarioScreen(
    scenario: CyberScenario,
    onContinue: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    var selectedAnswer by remember {
        mutableStateOf<Int?>(null)
    }

    val scrollState = rememberScrollState()

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
                    top = 10.dp,
                    bottom = 18.dp
                )
        ) {

            // HEADER
            MissionHeader()

            Spacer(modifier = Modifier.height(20.dp))

            // MISSION STATUS
            MissionStatus()

            Spacer(modifier = Modifier.height(9.dp))

            // MISSION TITLE
            Text(
                text = scenario.title,
                color = SecureQuestColors.TextPrimary,
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold,
                lineHeight = 29.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            // SITUATION
            SituationCard(
                description = scenario.description
            )

            Spacer(modifier = Modifier.height(20.dp))

            // DECISION SECTION
            SectionHeader(
                title = "YOUR DECISION",
                trailing = "${scenario.options.size} OPTIONS"
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = scenario.question,
                color = SecureQuestColors.TextPrimary,
                fontSize = 16.sp,
                lineHeight = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(14.dp))

            // ANSWERS
            scenario.options.forEachIndexed { index, option ->

                CyberAnswerOption(
                    index = index,
                    text = option,
                    selected = selectedAnswer == index,
                    onClick = {
                        selectedAnswer = index
                    }
                )

                if (index != scenario.options.lastIndex) {
                    Spacer(modifier = Modifier.height(9.dp))
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            // ACTION BUTTON
            Button(
                onClick = {
                    selectedAnswer?.let(onContinue)
                },
                enabled = selectedAnswer != null,
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
                    text = if (selectedAnswer == null) {
                        "SELECT A RESPONSE"
                    } else {
                        "ANALYZE THREAT  →"
                    },
                    fontSize = 11.sp,
                    fontWeight = FontWeight.ExtraBold,
                    letterSpacing = 0.8.sp
                )
            }

            Spacer(modifier = Modifier.height(9.dp))

            Text(
                text = "Choose the response that best protects the user.",
                modifier = Modifier.fillMaxWidth(),
                color = SecureQuestColors.TextMuted,
                fontSize = 9.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

// ------------------------------------------------------------
// HEADER
// ------------------------------------------------------------

@Composable
private fun MissionHeader() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(44.dp)
                .clip(RoundedCornerShape(13.dp))
                .background(
                    SecureQuestColors.Cyan.copy(alpha = 0.10f)
                )
                .border(
                    width = 1.dp,
                    color = SecureQuestColors.Cyan.copy(alpha = 0.40f),
                    shape = RoundedCornerShape(13.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "◆",
                color = SecureQuestColors.Cyan,
                fontSize = 18.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }

        Spacer(modifier = Modifier.width(11.dp))

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

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = "THREAT ANALYSIS",
                color = SecureQuestColors.TextMuted,
                fontSize = 8.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.sp
            )
        }

        Box(
            modifier = Modifier
                .size(44.dp)
                .clip(RoundedCornerShape(13.dp))
                .background(
                    SecureQuestColors.Success.copy(alpha = 0.09f)
                )
                .border(
                    width = 1.dp,
                    color = SecureQuestColors.Success.copy(alpha = 0.30f),
                    shape = RoundedCornerShape(13.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "01",
                    color = SecureQuestColors.Success,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.ExtraBold
                )

                Text(
                    text = "LIVE",
                    color = SecureQuestColors.Success.copy(alpha = 0.75f),
                    fontSize = 6.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

// ------------------------------------------------------------
// MISSION STATUS
// ------------------------------------------------------------

@Composable
private fun MissionStatus() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(8.dp)
                .clip(CircleShape)
                .background(SecureQuestColors.Cyan)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = "ACTIVE SECURITY MISSION",
            color = SecureQuestColors.Cyan,
            fontSize = 9.sp,
            fontWeight = FontWeight.ExtraBold,
            letterSpacing = 1.1.sp
        )
    }
}

// ------------------------------------------------------------
// SITUATION CARD
// ------------------------------------------------------------

@Composable
private fun SituationCard(
    description: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = SecureQuestColors.SurfaceElevated.copy(
                alpha = 0.90f
            )
        ),
        border = androidx.compose.foundation.BorderStroke(
            width = 1.dp,
            color = SecureQuestColors.Cyan.copy(alpha = 0.20f)
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
                        .size(38.dp)
                        .clip(RoundedCornerShape(11.dp))
                        .background(
                            SecureQuestColors.Blue.copy(alpha = 0.11f)
                        )
                        .border(
                            width = 1.dp,
                            color = SecureQuestColors.Blue.copy(alpha = 0.20f),
                            shape = RoundedCornerShape(11.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "!",
                        color = SecureQuestColors.Blue,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))

                Column {
                    Text(
                        text = "SITUATION",
                        color = SecureQuestColors.Blue,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.ExtraBold,
                        letterSpacing = 1.sp
                    )

                    Text(
                        text = "Threat context",
                        color = SecureQuestColors.TextMuted,
                        fontSize = 8.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(13.dp))

            Text(
                text = description,
                color = SecureQuestColors.TextSecondary,
                fontSize = 13.sp,
                lineHeight = 19.sp
            )
        }
    }
}

// ------------------------------------------------------------
// SECTION HEADER
// ------------------------------------------------------------

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
            fontSize = 8.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

// ------------------------------------------------------------
// ANSWER OPTION
// ------------------------------------------------------------

@Composable
private fun CyberAnswerOption(
    index: Int,
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
) {
    val borderColor by animateColorAsState(
        targetValue = if (selected) {
            SecureQuestColors.Cyan
        } else {
            SecureQuestColors.BorderSoft
        },
        label = "answerBorder"
    )

    val backgroundColor by animateColorAsState(
        targetValue = if (selected) {
            SecureQuestColors.Cyan.copy(alpha = 0.10f)
        } else {
            SecureQuestColors.Surface.copy(alpha = 0.92f)
        },
        label = "answerBackground"
    )

    val numberSize by animateDpAsState(
        targetValue = if (selected) 42.dp else 38.dp,
        label = "numberSize"
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
            .background(backgroundColor)
            .border(
                width = if (selected) 1.5.dp else 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(15.dp)
            )
            .clickable(onClick = onClick)
            .padding(
                horizontal = 13.dp,
                vertical = 11.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(numberSize)
                .clip(RoundedCornerShape(12.dp))
                .background(
                    if (selected) {
                        SecureQuestColors.Cyan
                    } else {
                        SecureQuestColors.SurfaceLight
                    }
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "${index + 1}",
                color = if (selected) {
                    DarkText
                } else {
                    SecureQuestColors.TextSecondary
                },
                fontSize = 13.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = text,
            modifier = Modifier.weight(1f),
            color = if (selected) {
                SecureQuestColors.TextPrimary
            } else {
                SecureQuestColors.TextSecondary
            },
            fontSize = 12.sp,
            lineHeight = 17.sp,
            fontWeight = if (selected) {
                FontWeight.Bold
            } else {
                FontWeight.Normal
            }
        )

        if (selected) {
            Spacer(modifier = Modifier.width(8.dp))

            Box(
                modifier = Modifier
                    .size(9.dp)
                    .clip(CircleShape)
                    .background(SecureQuestColors.Cyan)
            )
        }
    }
}