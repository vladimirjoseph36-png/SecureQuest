package com.example.securequest.ui.analysis

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.securequest.data.CyberScenario
import com.example.securequest.theme.SecureQuestColors

@Composable
fun AnalysisScreen(
    scenario: CyberScenario,
    onContinue: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        SecureQuestColors.Background,
                        SecureQuestColors.BackgroundSecondary,
                        SecureQuestColors.Background
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(20.dp),
        ) {

            // HEADER
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(
                    modifier = Modifier
                        .size(46.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .background(
                            SecureQuestColors.Cyan.copy(alpha = 0.12f)
                        )
                        .border(
                            1.dp,
                            SecureQuestColors.Cyan.copy(alpha = 0.35f),
                            RoundedCornerShape(15.dp)
                        ),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = "⌕",
                        color = SecureQuestColors.Cyan,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                    )
                }

                Spacer(modifier = Modifier.size(12.dp))

                Column {
                    Text(
                        text = "SECUREQUEST",
                        color = SecureQuestColors.Cyan,
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                    )

                    Text(
                        text = "Analyze the Situation",
                        color = SecureQuestColors.TextPrimary,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(
                            SecureQuestColors.Purple.copy(alpha = 0.14f)
                        )
                        .border(
                            1.dp,
                            SecureQuestColors.PurpleBright.copy(alpha = 0.35f),
                            CircleShape
                        ),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = "02",
                        color = SecureQuestColors.PurpleBright,
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }

            Spacer(modifier = Modifier.height(28.dp))

            // SECTION LABEL
            Text(
                text = "THREAT ANALYSIS",
                color = SecureQuestColors.Cyan,
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold,
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Why is this suspicious?",
                color = SecureQuestColors.TextPrimary,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
            )

            Spacer(modifier = Modifier.height(18.dp))

            // MAIN ANALYSIS CARD
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(24.dp))
                    .background(
                        Brush.linearGradient(
                            colors = listOf(
                                SecureQuestColors.SurfaceElevated,
                                SecureQuestColors.Surface
                            )
                        )
                    )
                    .border(
                        1.dp,
                        SecureQuestColors.Cyan.copy(alpha = 0.22f),
                        RoundedCornerShape(24.dp)
                    )
                    .padding(20.dp),
            ) {
                Column {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Box(
                            modifier = Modifier
                                .size(44.dp)
                                .clip(RoundedCornerShape(13.dp))
                                .background(
                                    SecureQuestColors.Danger.copy(alpha = 0.12f)
                                )
                                .border(
                                    1.dp,
                                    SecureQuestColors.Danger.copy(alpha = 0.28f),
                                    RoundedCornerShape(13.dp)
                                ),
                            contentAlignment = Alignment.Center,
                        ) {
                            Text(
                                text = "!",
                                color = SecureQuestColors.Danger,
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                            )
                        }

                        Spacer(modifier = Modifier.size(12.dp))

                        Column {
                            Text(
                                text = scenario.title,
                                color = SecureQuestColors.TextPrimary,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                            )

                            Text(
                                text = "Potential security threat detected",
                                color = SecureQuestColors.Danger,
                                style = MaterialTheme.typography.bodySmall,
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(18.dp))

                    Text(
                        text = scenario.description,
                        color = SecureQuestColors.TextSecondary,
                        style = MaterialTheme.typography.bodyLarge,
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // WHY IT MATTERS
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .background(
                        SecureQuestColors.Blue.copy(alpha = 0.07f)
                    )
                    .border(
                        1.dp,
                        SecureQuestColors.Blue.copy(alpha = 0.20f),
                        RoundedCornerShape(20.dp)
                    )
                    .padding(18.dp),
            ) {
                Column {
                    Text(
                        text = "WHY IT MATTERS",
                        color = SecureQuestColors.Blue,
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Cybersecurity threats often use urgency, deception, or unexpected requests to make users act before thinking.",
                        color = SecureQuestColors.TextSecondary,
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // LEARNING SIGNALS
            Text(
                text = "SECURITY SIGNALS",
                color = SecureQuestColors.PurpleBright,
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold,
            )

            Spacer(modifier = Modifier.height(12.dp))

            AnalysisSignal(
                number = "01",
                title = "Pause",
                description = "Do not act immediately when a request feels urgent.",
            )

            Spacer(modifier = Modifier.height(10.dp))

            AnalysisSignal(
                number = "02",
                title = "Verify",
                description = "Check the source before trusting the request.",
            )

            Spacer(modifier = Modifier.height(10.dp))

            AnalysisSignal(
                number = "03",
                title = "Protect",
                description = "Avoid sharing credentials or sensitive information.",
            )

            Spacer(modifier = Modifier.height(28.dp))

            // CONTINUE
            Button(
                onClick = onContinue,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(58.dp),
                shape = RoundedCornerShape(18.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = SecureQuestColors.Cyan,
                    contentColor = Color(0xFF00151A),
                ),
            ) {
                Text(
                    text = "Continue to AI Assistance  →",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.labelLarge,
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "SecureQuest will help you understand the threat.",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = SecureQuestColors.TextMuted,
                style = MaterialTheme.typography.bodySmall,
            )

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
private fun AnalysisSignal(
    number: String,
    title: String,
    description: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(SecureQuestColors.Surface)
            .border(
                1.dp,
                SecureQuestColors.BorderSoft,
                RoundedCornerShape(16.dp)
            )
            .padding(14.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .size(38.dp)
                .clip(RoundedCornerShape(11.dp))
                .background(
                    SecureQuestColors.Purple.copy(alpha = 0.14f)
                ),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = number,
                color = SecureQuestColors.PurpleBright,
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Bold,
            )
        }

        Spacer(modifier = Modifier.size(12.dp))

        Column(
            modifier = Modifier.weight(1f),
        ) {
            Text(
                text = title,
                color = SecureQuestColors.TextPrimary,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = description,
                color = SecureQuestColors.TextMuted,
                style = MaterialTheme.typography.bodySmall,
            )
        }
    }
}