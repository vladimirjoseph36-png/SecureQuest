package com.example.securequest.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.securequest.theme.SecureQuestColors

@Composable
fun LearningProgressScreen(
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
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
                .padding(
                    horizontal = 20.dp,
                    vertical = 18.dp
                )
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = onBack,
                    modifier = Modifier.size(44.dp),
                    contentPadding = PaddingValues(0.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = SecureQuestColors.SurfaceLight,
                        contentColor = SecureQuestColors.Cyan
                    )
                ) {
                    Text(
                        text = "<",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(
                    modifier = Modifier.size(12.dp)
                )

                Column {
                    Text(
                        text = "SECUREQUEST",
                        color = SecureQuestColors.Cyan,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Learning Progress",
                        color = SecureQuestColors.TextPrimary,
                        fontSize = 21.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            ProgressCard(
                title = "Overall Progress",
                value = "72%",
                subtitle = "Cybersecurity learning progress"
            )

            Spacer(
                modifier = Modifier.height(14.dp)
            )

            ProgressCard(
                title = "Scenarios Completed",
                value = "8",
                subtitle = "Cybersecurity challenges completed"
            )

            Spacer(
                modifier = Modifier.height(14.dp)
            )

            ProgressCard(
                title = "Current Level",
                value = "04",
                subtitle = "Cyber Defender"
            )

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            Text(
                text = "LEARNING ACTIVITY",
                color = SecureQuestColors.Cyan,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            ActivityRow(
                title = "Phishing Awareness",
                status = "Completed"
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            ActivityRow(
                title = "Password Security",
                status = "Completed"
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            ActivityRow(
                title = "Network Security",
                status = "In Progress"
            )
        }
    }
}

@Composable
private fun ProgressCard(
    title: String,
    value: String,
    subtitle: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.linearGradient(
                    colors = listOf(
                        SecureQuestColors.SurfaceElevated,
                        SecureQuestColors.Surface
                    )
                ),
                RoundedCornerShape(20.dp)
            )
            .border(
                width = 1.dp,
                color = SecureQuestColors.Cyan.copy(alpha = 0.22f),
                shape = RoundedCornerShape(20.dp)
            )
            .padding(18.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = title,
                    color = SecureQuestColors.TextPrimary,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(
                    text = subtitle,
                    color = SecureQuestColors.TextSecondary,
                    fontSize = 10.sp
                )
            }

            Text(
                text = value,
                color = SecureQuestColors.Cyan,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun ActivityRow(
    title: String,
    status: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Color.Transparent,
                RoundedCornerShape(14.dp)
            )
            .padding(
                horizontal = 14.dp,
                vertical = 12.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            color = SecureQuestColors.TextPrimary,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium
        )

        Text(
            text = status,
            color = SecureQuestColors.Cyan,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold
        )
    }
}