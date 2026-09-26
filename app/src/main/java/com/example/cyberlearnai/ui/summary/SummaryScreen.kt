package com.example.securequest.ui.summary

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.securequest.data.CyberScenario
import com.example.securequest.theme.SecureQuestColors

@Composable
fun SummaryScreen(
    scenario: CyberScenario,
    score: Int,
    onSave: () -> Unit,
    onNotNow: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(SecureQuestColors.Background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "MISSION COMPLETE",
                color = SecureQuestColors.Cyan,
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold,
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Learning Summary",
                color = SecureQuestColors.TextPrimary,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
            )

            Spacer(modifier = Modifier.height(24.dp))

            Box(
                modifier = Modifier
                    .size(150.dp)
                    .background(
                        SecureQuestColors.Surface,
                        RoundedCornerShape(32.dp)
                    )
                    .border(
                        1.dp,
                        SecureQuestColors.Cyan.copy(alpha = 0.4f),
                        RoundedCornerShape(32.dp)
                    ),
                contentAlignment = Alignment.Center,
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "$score",
                        color = when {
                            score >= 80 -> SecureQuestColors.Success
                            score >= 50 -> SecureQuestColors.Warning
                            else -> SecureQuestColors.Danger
                        },
                        style = MaterialTheme.typography.displaySmall,
                        fontWeight = FontWeight.Bold,
                    )

                    Text(
                        text = "SCORE / 100",
                        color = SecureQuestColors.TextMuted,
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        SecureQuestColors.Surface,
                        RoundedCornerShape(20.dp)
                    )
                    .border(
                        1.dp,
                        SecureQuestColors.BorderSoft,
                        RoundedCornerShape(20.dp)
                    )
                    .padding(20.dp),
            ) {
                Column {
                    Text(
                        text = scenario.title,
                        color = SecureQuestColors.TextPrimary,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "KEY LESSON",
                        color = SecureQuestColors.Cyan,
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = scenario.lesson,
                        color = SecureQuestColors.TextSecondary,
                        style = MaterialTheme.typography.bodyLarge,
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = onSave,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = SecureQuestColors.Cyan,
                    contentColor = Color(0xFF00151A),
                ),
            ) {
                Text(
                    text = "Save Summary",
                    fontWeight = FontWeight.Bold,
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedButton(
                onClick = onNotNow,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = SecureQuestColors.TextSecondary,
                ),
            ) {
                Text("Back to SecureQuest")
            }
        }
    }
}