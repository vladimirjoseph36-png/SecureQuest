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
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.securequest.theme.SecureQuestColors

@Composable
fun ProfileScreen(
    onBack: () -> Unit,
    onLearningProgress: () -> Unit,
    onAchievements: () -> Unit,
    onSettings: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF03050D),
                        SecureQuestColors.Background,
                        Color(0xFF08051A)
                    )
                )
            )
            .navigationBarsPadding()
    ) {

        // ---------------------------------------------------------
        // CYBERPUNK ATMOSPHERE
        // ---------------------------------------------------------

        // Main cyan atmospheric glow
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.radialGradient(
                        colors = listOf(
                            SecureQuestColors.Cyan.copy(alpha = 0.13f),
                            Color.Transparent
                        ),
                        radius = 900f
                    )
                )
        )

        // Purple atmospheric glow
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.radialGradient(
                        colors = listOf(
                            SecureQuestColors.Purple.copy(alpha = 0.14f),
                            Color.Transparent
                        ),
                        radius = 760f
                    )
                )
        )

        // Upper cyan glow
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            SecureQuestColors.Cyan.copy(alpha = 0.07f),
                            Color.Transparent
                        )
                    )
                )
        )

        // Lower purple glow
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(520.dp)
                .align(Alignment.BottomCenter)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            SecureQuestColors.Purple.copy(alpha = 0.06f)
                        )
                    )
                )
        )

        // ---------------------------------------------------------
        // MAIN CONTENT
        // ---------------------------------------------------------

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(
                    start = 20.dp,
                    end = 20.dp,
                    top = 34.dp,
                    bottom = 32.dp
                )
        ) {

            // -----------------------------------------------------
            // TOP BAR
            // -----------------------------------------------------

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 26.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Button(
                    onClick = onBack,
                    modifier = Modifier.size(48.dp),
                    contentPadding = PaddingValues(0.dp),
                    shape = RoundedCornerShape(15.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF10182B),
                        contentColor = SecureQuestColors.Cyan
                    )
                ) {
                    Text(
                        text = "‹",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Light
                    )
                }

                Spacer(
                    modifier = Modifier.width(14.dp)
                )

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "SECUREQUEST",
                        color = SecureQuestColors.Cyan,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.ExtraBold,
                        letterSpacing = 2.sp
                    )

                    Spacer(
                        modifier = Modifier.height(2.dp)
                    )

                    Text(
                        text = "Profile",
                        color = Color.White,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                // Profile indicator
                Box(
                    modifier = Modifier
                        .size(42.dp)
                        .background(
                            SecureQuestColors.Cyan.copy(alpha = 0.08f),
                            CircleShape
                        )
                        .border(
                            1.dp,
                            SecureQuestColors.Cyan.copy(alpha = 0.35f),
                            CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "A",
                        color = SecureQuestColors.Cyan,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            }

            // -----------------------------------------------------
            // PROFILE HERO
            // -----------------------------------------------------

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(28.dp))
                    .background(
                        Brush.linearGradient(
                            colors = listOf(
                                Color(0xFF111D3C),
                                Color(0xFF111126)
                            )
                        )
                    )
                    .border(
                        width = 1.dp,
                        brush = Brush.linearGradient(
                            colors = listOf(
                                SecureQuestColors.Cyan.copy(alpha = 0.60f),
                                SecureQuestColors.Purple.copy(alpha = 0.45f),
                                Color.Transparent
                            )
                        ),
                        shape = RoundedCornerShape(28.dp)
                    )
                    .padding(22.dp)
            ) {

                Column {

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        // Avatar
                        Box(
                            modifier = Modifier
                                .size(80.dp)
                                .background(
                                    Brush.linearGradient(
                                        colors = listOf(
                                            SecureQuestColors.Cyan.copy(alpha = 0.30f),
                                            SecureQuestColors.Purple.copy(alpha = 0.32f)
                                        )
                                    ),
                                    CircleShape
                                )
                                .border(
                                    2.dp,
                                    brush = Brush.linearGradient(
                                        colors = listOf(
                                            SecureQuestColors.Cyan,
                                            SecureQuestColors.Purple
                                        )
                                    ),
                                    shape = CircleShape
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "A",
                                color = Color.White,
                                fontSize = 32.sp,
                                fontWeight = FontWeight.ExtraBold
                            )
                        }

                        Spacer(
                            modifier = Modifier.width(16.dp)
                        )

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {

                            Text(
                                text = "CYBER DEFENDER",
                                color = SecureQuestColors.Cyan,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.ExtraBold,
                                letterSpacing = 1.5.sp
                            )

                            Spacer(
                                modifier = Modifier.height(4.dp)
                            )

                            Text(
                                text = "Security Level 04",
                                color = Color.White,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(
                                modifier = Modifier.height(4.dp)
                            )

                            Text(
                                text = "Active defender",
                                color = SecureQuestColors.TextSecondary,
                                fontSize = 11.sp
                            )
                        }
                    }

                    Spacer(
                        modifier = Modifier.height(22.dp)
                    )

                    // Progress header
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(
                            text = "MISSION PROGRESS",
                            color = SecureQuestColors.TextSecondary,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.sp
                        )

                        Text(
                            text = "72%",
                            color = SecureQuestColors.Cyan,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                    }

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    // Progress track
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(8.dp)
                            .clip(RoundedCornerShape(50))
                            .background(
                                Color.White.copy(alpha = 0.08f)
                            )
                    ) {

                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.72f)
                                .height(8.dp)
                                .clip(RoundedCornerShape(50))
                                .background(
                                    Brush.horizontalGradient(
                                        colors = listOf(
                                            SecureQuestColors.Cyan,
                                            SecureQuestColors.Purple
                                        )
                                    )
                                )
                        )
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(18.dp)
            )

            // -----------------------------------------------------
            // QUICK STATS
            // -----------------------------------------------------

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                ProfileStat(
                    modifier = Modifier.weight(1f),
                    symbol = "◆",
                    value = "04",
                    label = "LEVEL"
                )

                ProfileStat(
                    modifier = Modifier.weight(1f),
                    symbol = "◈",
                    value = "72%",
                    label = "PROGRESS"
                )

                ProfileStat(
                    modifier = Modifier.weight(1f),
                    symbol = "★",
                    value = "12",
                    label = "BADGES"
                )
            }

            Spacer(
                modifier = Modifier.height(22.dp)
            )

            // -----------------------------------------------------
            // PREMIUM
            // -----------------------------------------------------

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(26.dp))
                    .background(
                        Brush.linearGradient(
                            colors = listOf(
                                Color(0xFF291C5B),
                                Color(0xFF101A40)
                            )
                        )
                    )
                    .border(
                        1.dp,
                        brush = Brush.linearGradient(
                            colors = listOf(
                                SecureQuestColors.Gold.copy(alpha = 0.75f),
                                SecureQuestColors.Purple.copy(alpha = 0.40f),
                                Color.Transparent
                            )
                        ),
                        shape = RoundedCornerShape(26.dp)
                    )
                    .padding(20.dp)
            ) {

                Column {

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .background(
                                    SecureQuestColors.Gold.copy(alpha = 0.13f),
                                    RoundedCornerShape(15.dp)
                                )
                                .border(
                                    1.dp,
                                    SecureQuestColors.Gold.copy(alpha = 0.35f),
                                    RoundedCornerShape(15.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "★",
                                color = SecureQuestColors.Gold,
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(
                            modifier = Modifier.width(13.dp)
                        )

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {

                            Text(
                                text = "SECUREQUEST PREMIUM",
                                color = SecureQuestColors.Gold,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.ExtraBold,
                                letterSpacing = 1.2.sp
                            )

                            Spacer(
                                modifier = Modifier.height(3.dp)
                            )

                            Text(
                                text = "Unlock advanced training",
                                color = Color.White,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Spacer(
                        modifier = Modifier.height(18.dp)
                    )

                    PremiumFeature("Advanced AI assistance")
                    PremiumFeature("More cybersecurity scenarios")
                    PremiumFeature("Detailed learning insights")
                    PremiumFeature("Progress tracking")
                }
            }

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            // -----------------------------------------------------
            // ACCOUNT HEADER
            // -----------------------------------------------------

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "ACCOUNT",
                    color = SecureQuestColors.Cyan,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.ExtraBold,
                    letterSpacing = 1.5.sp
                )

                Spacer(
                    modifier = Modifier.width(10.dp)
                )

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(1.dp)
                        .background(
                            SecureQuestColors.Cyan.copy(alpha = 0.16f)
                        )
                )
            }

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            // -----------------------------------------------------
            // LEARNING PROGRESS
            // -----------------------------------------------------

            ProfileAction(
                symbol = "◈",
                title = "Learning Progress",
                subtitle = "View your cybersecurity progress",
                onClick = onLearningProgress
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            // -----------------------------------------------------
            // ACHIEVEMENTS
            // -----------------------------------------------------

            ProfileAction(
                symbol = "★",
                title = "Achievements",
                subtitle = "View completed challenges",
                onClick = onAchievements
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            // -----------------------------------------------------
            // SETTINGS
            // -----------------------------------------------------

            ProfileAction(
                symbol = "⚙",
                title = "Settings",
                subtitle = "Manage application preferences",
                onClick = onSettings
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            // -----------------------------------------------------
            // SECURITY STATUS
            // -----------------------------------------------------

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .background(
                        Color(0xFF0B1425).copy(alpha = 0.96f)
                    )
                    .border(
                        1.dp,
                        SecureQuestColors.Cyan.copy(alpha = 0.16f),
                        RoundedCornerShape(20.dp)
                    )
                    .padding(16.dp)
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(
                        modifier = Modifier
                            .size(38.dp)
                            .background(
                                SecureQuestColors.Cyan.copy(alpha = 0.10f),
                                CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "◆",
                            color = SecureQuestColors.Cyan,
                            fontSize = 15.sp
                        )
                    }

                    Spacer(
                        modifier = Modifier.width(12.dp)
                    )

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Text(
                            text = "SECURITY STATUS",
                            color = SecureQuestColors.TextSecondary,
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.sp
                        )

                        Spacer(
                            modifier = Modifier.height(2.dp)
                        )

                        Text(
                            text = "Defender profile active",
                            color = Color.White,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    Box(
                        modifier = Modifier
                            .size(9.dp)
                            .background(
                                SecureQuestColors.Cyan,
                                CircleShape
                            )
                    )
                }
            }
        }
    }
}

@Composable
private fun ProfileStat(
    modifier: Modifier,
    symbol: String,
    value: String,
    label: String
) {
    Box(
        modifier = modifier
            .height(92.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(
                Color(0xFF0D1629).copy(alpha = 0.96f)
            )
            .border(
                1.dp,
                SecureQuestColors.Cyan.copy(alpha = 0.14f),
                RoundedCornerShape(20.dp)
            )
            .padding(12.dp)
    ) {

        Column(
            horizontalAlignment = Alignment.Start
        ) {

            Text(
                text = symbol,
                color = SecureQuestColors.Cyan,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(5.dp)
            )

            Text(
                text = value,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.ExtraBold
            )

            Text(
                text = label,
                color = SecureQuestColors.TextSecondary,
                fontSize = 8.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.8.sp
            )
        }
    }
}

@Composable
private fun PremiumFeature(
    text: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(7.dp)
                .background(
                    SecureQuestColors.Gold,
                    CircleShape
                )
        )

        Spacer(
            modifier = Modifier.width(10.dp)
        )

        Text(
            text = text,
            color = Color.White.copy(alpha = 0.82f),
            fontSize = 11.sp
        )
    }
}

@Composable
private fun ProfileAction(
    symbol: String,
    title: String,
    subtitle: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(76.dp),
        contentPadding = PaddingValues(
            horizontal = 15.dp,
            vertical = 10.dp
        ),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF0D1629).copy(alpha = 0.96f),
            contentColor = Color.White
        )
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(46.dp)
                    .background(
                        SecureQuestColors.Cyan.copy(alpha = 0.09f),
                        RoundedCornerShape(14.dp)
                    )
                    .border(
                        1.dp,
                        SecureQuestColors.Cyan.copy(alpha = 0.18f),
                        RoundedCornerShape(14.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = symbol,
                    color = SecureQuestColors.Cyan,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(
                modifier = Modifier.width(13.dp)
            )

            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.Start
            ) {

                Text(
                    text = title,
                    color = Color.White,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(2.dp)
                )

                Text(
                    text = subtitle,
                    color = SecureQuestColors.TextSecondary,
                    fontSize = 10.sp
                )
            }

            Text(
                text = "›",
                color = SecureQuestColors.Cyan,
                fontSize = 28.sp,
                fontWeight = FontWeight.Light
            )
        }
    }
}
