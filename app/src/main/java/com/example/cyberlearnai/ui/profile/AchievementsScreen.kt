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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.securequest.theme.SecureQuestColors

@Composable
fun AchievementsScreen(
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
                .verticalScroll(rememberScrollState())
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
                    modifier = Modifier.width(12.dp)
                )

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "SECUREQUEST",
                        color = SecureQuestColors.Cyan,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Achievements",
                        color = SecureQuestColors.TextPrimary,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            AchievementCard(
                icon = "*",
                title = "First Mission",
                description = "Complete your first cybersecurity challenge.",
                status = "UNLOCKED"
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            AchievementCard(
                icon = "+",
                title = "Cyber Defender",
                description = "Successfully complete multiple cybersecurity scenarios.",
                status = "UNLOCKED"
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            AchievementCard(
                icon = "#",
                title = "Security Expert",
                description = "Master advanced cybersecurity challenges.",
                status = "LOCKED"
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            AchievementCard(
                icon = "!",
                title = "Perfect Score",
                description = "Complete a challenge with a perfect score.",
                status = "LOCKED"
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )
        }
    }
}

@Composable
private fun AchievementCard(
    icon: String,
    title: String,
    description: String,
    status: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.linearGradient(
                    colors = listOf(
                        SecureQuestColors.SurfaceElevated,
                        SecureQuestColors.Surface
                    )
                ),
                RoundedCornerShape(18.dp)
            )
            .border(
                width = 1.dp,
                color = SecureQuestColors.Cyan.copy(alpha = 0.22f),
                shape = RoundedCornerShape(18.dp)
            )
            .padding(
                horizontal = 16.dp,
                vertical = 15.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(52.dp)
                .background(
                    SecureQuestColors.SurfaceLight,
                    RoundedCornerShape(16.dp)
                )
                .border(
                    width = 1.dp,
                    color = SecureQuestColors.Cyan.copy(alpha = 0.35f),
                    shape = RoundedCornerShape(16.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = icon,
                color = SecureQuestColors.Cyan,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(
            modifier = Modifier.width(14.dp)
        )

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = title,
                color = SecureQuestColors.TextPrimary,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1
            )

            Spacer(
                modifier = Modifier.height(5.dp)
            )

            Text(
                text = description,
                color = SecureQuestColors.TextSecondary,
                fontSize = 11.sp,
                maxLines = 3
            )
        }

        Spacer(
            modifier = Modifier.width(10.dp)
        )

        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = status,
                color = SecureQuestColors.Cyan,
                fontSize = 9.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1
            )
        }
    }
}