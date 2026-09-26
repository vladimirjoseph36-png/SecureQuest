package com.example.securequest.ui.main

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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.navigation3.runtime.NavKey
import com.example.securequest.AIAssistant
import com.example.securequest.Scenario
import com.example.securequest.ui.components.CyberQuestBackground
import kotlin.math.cos
import kotlin.math.sin

private val Background = Color(0xFF020812)
private val Surface = Color(0xFF081A2C)
private val SurfaceElevated = Color(0xFF0A2035)
private val SurfaceBorder = Color(0xFF123B58)

private val Cyan = Color(0xFF35E7FF)
private val Purple = Color(0xFFA875FF)
private val Green = Color(0xFF35D98A)
private val Gold = Color(0xFFFFD45A)

private val TextPrimary = Color(0xFFF2FAFF)
private val TextSecondary = Color(0xFF91A9BE)
private val TextMuted = Color(0xFF5E7488)

private enum class AppIcon {
    Security,
    Person,
    Star,
    ArrowForward,
    Robot,
    Challenges,
    Home,
    Missions,
    AI,
    Profile
}

@Composable
fun MainScreen(
    onItemClick: (NavKey) -> Unit,
    onPremiumClick: () -> Unit,
    modifier: Modifier = Modifier,
    currentMission: Int = 1,
    totalMissions: Int = 4,
    missionTitle: String = "PHISHING DETECTION",
    missionSubtitle: String =
        "Identify the suspicious message before it reaches the target."
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Background)
            .statusBarsPadding()
    ) {

        CyberQuestBackground()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 18.dp,
                    end = 18.dp,
                    top = 10.dp,
                    bottom = 12.dp
                )
        ) {

            // ============================================================
            // HEADER
            // ============================================================

            SecureQuestHeader(
                onPremiumClick = onPremiumClick
            )

            Spacer(modifier = Modifier.height(24.dp))

            // ============================================================
            // HERO
            // ============================================================

            DefenderHero()

            Spacer(modifier = Modifier.height(20.dp))

            // ============================================================
            // SECURITY STATUS
            // ============================================================

            SecurityStatusCard()

            Spacer(modifier = Modifier.height(20.dp))

            // ============================================================
            // ACTIVE MISSION
            // ============================================================

            SectionHeader(
                title = "ACTIVE MISSION",
                trailing = String.format(
                    "%02d / %02d",
                    currentMission,
                    totalMissions
                )
            )

            Spacer(modifier = Modifier.height(9.dp))

            ActiveMissionCard(
                missionNumber = currentMission,
                missionTitle = missionTitle,
                missionSubtitle = missionSubtitle,
                onStartMission = {
                    onItemClick(Scenario)
                }
            )

            Spacer(modifier = Modifier.height(20.dp))

            // ============================================================
            // DEFENDER TOOLS
            // ============================================================

            SectionHeader(
                title = "DEFENDER TOOLS",
                trailing = "2 TOOLS"
            )

            Spacer(modifier = Modifier.height(9.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                ToolCard(
                    modifier = Modifier.weight(1f),
                    icon = AppIcon.Robot,
                    title = "AI ASSIST",
                    subtitle = "Smart guidance",
                    iconColor = Purple,
                    onClick = {
                        onItemClick(AIAssistant)
                    }
                )

                ToolCard(
                    modifier = Modifier.weight(1f),
                    icon = AppIcon.Challenges,
                    title = "CHALLENGES",
                    subtitle = "Test your skills",
                    iconColor = Green,
                    onClick = {
                        onItemClick(Scenario)
                    }
                )
            }

            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

// ========================================================================
// HEADER
// ========================================================================

@Composable
private fun SecureQuestHeader(
    onPremiumClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(44.dp)
                .clip(RoundedCornerShape(13.dp))
                .background(
                    Cyan.copy(alpha = 0.10f)
                )
                .border(
                    width = 1.dp,
                    color = Cyan.copy(alpha = 0.40f),
                    shape = RoundedCornerShape(13.dp)
                ),
            contentAlignment = Alignment.Center
        ) {

            AppIconView(
                icon = AppIcon.Security,
                color = Cyan,
                modifier = Modifier.size(24.dp)
            )
        }

        Spacer(modifier = Modifier.width(11.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = "SECUREQUEST",
                color = TextPrimary,
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = 1.3.sp
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = "CYBER DEFENSE SYSTEM",
                color = TextMuted,
                fontSize = 8.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.sp
            )
        }

        Button(
            onClick = onPremiumClick,
            modifier = Modifier.size(44.dp),
            shape = RoundedCornerShape(13.dp),
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Purple.copy(alpha = 0.13f),
                contentColor = Purple
            )
        ) {

            AppIconView(
                icon = AppIcon.Person,
                color = Purple,
                modifier = Modifier.size(21.dp)
            )
        }
    }
}

// ========================================================================
// ACTIVE MISSION
// ========================================================================

@Composable
private fun ActiveMissionCard(
    missionNumber: Int,
    missionTitle: String,
    missionSubtitle: String,
    onStartMission: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Surface.copy(alpha = 0.94f)
        ),
        border = androidx.compose.foundation.BorderStroke(
            width = 1.dp,
            color = Cyan.copy(alpha = 0.20f)
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .size(46.dp)
                        .clip(RoundedCornerShape(13.dp))
                        .background(
                            Cyan.copy(alpha = 0.10f)
                        )
                        .border(
                            width = 1.dp,
                            color = Cyan.copy(alpha = 0.25f),
                            shape = RoundedCornerShape(13.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = String.format(
                            "%02d",
                            missionNumber
                        ),
                        color = Cyan,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = missionTitle,
                        color = TextPrimary,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.ExtraBold,
                        letterSpacing = 0.6.sp
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = missionSubtitle,
                        color = TextSecondary,
                        fontSize = 9.sp,
                        lineHeight = 13.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Button(
                onClick = onStartMission,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(11.dp),
                contentPadding = PaddingValues(
                    vertical = 11.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Cyan.copy(alpha = 0.12f),
                    contentColor = Cyan
                )
            ) {

                Text(
                    text = "START MISSION",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.8.sp
                )

                Spacer(modifier = Modifier.width(7.dp))

                AppIconView(
                    icon = AppIcon.ArrowForward,
                    color = Cyan,
                    modifier = Modifier.size(15.dp)
                )
            }
        }
    }
}

// ========================================================================
// SECTION HEADER
// ========================================================================

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
            color = TextPrimary,
            fontSize = 10.sp,
            fontWeight = FontWeight.ExtraBold,
            letterSpacing = 1.2.sp,
            modifier = Modifier.weight(1f)
        )

        Text(
            text = trailing,
            color = TextMuted,
            fontSize = 8.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

// ========================================================================
// DEFENDER HERO
// ========================================================================

@Composable
private fun DefenderHero() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = SurfaceElevated.copy(alpha = 0.88f)
        ),
        border = androidx.compose.foundation.BorderStroke(
            width = 1.dp,
            color = Purple.copy(alpha = 0.18f)
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(17.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(
                            Purple.copy(alpha = 0.10f)
                        )
                        .border(
                            width = 1.dp,
                            color = Purple.copy(alpha = 0.25f),
                            shape = RoundedCornerShape(14.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {

                    AppIconView(
                        icon = AppIcon.Security,
                        color = Purple,
                        modifier = Modifier.size(25.dp)
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "CYBER DEFENDER",
                        color = TextPrimary,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.ExtraBold,
                        letterSpacing = 0.8.sp
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(
                        text = "Security Level 04",
                        color = TextSecondary,
                        fontSize = 9.sp
                    )
                }

                Column(
                    horizontalAlignment = Alignment.End
                ) {

                    Text(
                        text = "72%",
                        color = Cyan,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.ExtraBold
                    )

                    Text(
                        text = "PROGRESS",
                        color = TextMuted,
                        fontSize = 7.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(13.dp))

            LinearProgressIndicator(
                progress = { 0.72f },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(5.dp)
                    .clip(RoundedCornerShape(5.dp)),
                color = Cyan,
                trackColor = Cyan.copy(alpha = 0.10f)
            )

            Spacer(modifier = Modifier.height(9.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "12 BADGES",
                    color = Gold,
                    fontSize = 8.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "NEXT LEVEL: 80%",
                    color = TextMuted,
                    fontSize = 8.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

// ========================================================================
// SECURITY STATUS
// ========================================================================

@Composable
private fun SecurityStatusCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Surface.copy(alpha = 0.82f)
        ),
        border = androidx.compose.foundation.BorderStroke(
            width = 1.dp,
            color = Green.copy(alpha = 0.16f)
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 15.dp,
                    vertical = 12.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(9.dp)
                    .clip(RoundedCornerShape(50))
                    .background(Green)
            )

            Spacer(modifier = Modifier.width(10.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = "SECURITY STATUS",
                    color = TextPrimary,
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Your defense system is operational",
                    color = TextSecondary,
                    fontSize = 8.sp
                )
            }

            Text(
                text = "SECURE",
                color = Green,
                fontSize = 8.sp,
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = 0.7.sp
            )
        }
    }
}

// ========================================================================
// TOOL CARD
// ========================================================================

@Composable
private fun ToolCard(
    modifier: Modifier = Modifier,
    icon: AppIcon,
    title: String,
    subtitle: String,
    iconColor: Color,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Surface.copy(alpha = 0.90f)
        ),
        border = androidx.compose.foundation.BorderStroke(
            width = 1.dp,
            color = iconColor.copy(alpha = 0.15f)
        ),
        onClick = onClick
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(13.dp)
        ) {

            Box(
                modifier = Modifier
                    .size(35.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        iconColor.copy(alpha = 0.10f)
                    ),
                contentAlignment = Alignment.Center
            ) {

                AppIconView(
                    icon = icon,
                    color = iconColor,
                    modifier = Modifier.size(20.dp)
                )
            }

            Spacer(modifier = Modifier.height(9.dp))

            Text(
                text = title,
                color = TextPrimary,
                fontSize = 9.sp,
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = 0.7.sp
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = subtitle,
                color = TextSecondary,
                fontSize = 8.sp
            )
        }
    }
}

// ========================================================================
// BOTTOM NAVIGATION
// ========================================================================

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    onHome: () -> Unit,
    onMissions: () -> Unit,
    onAI: () -> Unit,
    onProfile: () -> Unit,
) {
    Row(
        modifier = modifier
            .background(
                Color(0xFF061321).copy(alpha = 0.96f)
            )
            .border(
                width = 1.dp,
                color = Cyan.copy(alpha = 0.12f)
            )
            .padding(
                horizontal = 4.dp,
                vertical = 5.dp
            )
            .navigationBarsPadding(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {

        BottomNavigationItem(
            icon = AppIcon.Home,
            label = "Home",
            selected = true,
            onClick = onHome
        )

        BottomNavigationItem(
            icon = AppIcon.Missions,
            label = "Missions",
            selected = false,
            onClick = onMissions
        )

        BottomNavigationItem(
            icon = AppIcon.AI,
            label = "AI",
            selected = false,
            onClick = onAI
        )

        BottomNavigationItem(
            icon = AppIcon.Profile,
            label = "Profile",
            selected = false,
            onClick = onProfile
        )
    }
}

@Composable
private fun BottomNavigationItem(
    icon: AppIcon,
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier.width(76.dp),
        shape = RoundedCornerShape(12.dp),
        contentPadding = PaddingValues(
            vertical = 4.dp
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selected) {
                Cyan.copy(alpha = 0.08f)
            } else {
                Color.Transparent
            },
            contentColor = if (selected) {
                Cyan
            } else {
                TextSecondary
            }
        )
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            AppIconView(
                icon = icon,
                color = if (selected) Cyan else TextSecondary,
                modifier = Modifier.size(19.dp)
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = label,
                fontSize = 8.sp,
                fontWeight = if (selected) {
                    FontWeight.Bold
                } else {
                    FontWeight.Normal
                }
            )
        }
    }
}

// ========================================================================
// ICON SYSTEM
// ========================================================================

@Composable
private fun AppIconView(
    icon: AppIcon,
    color: Color,
    modifier: Modifier = Modifier
) {
    androidx.compose.foundation.Canvas(
        modifier = modifier
    ) {

        val strokeWidth = size.minDimension * 0.09f

        val center = Offset(
            size.width / 2f,
            size.height / 2f
        )

        when (icon) {

            AppIcon.Home -> {

                val path = Path().apply {
                    moveTo(
                        size.width * 0.18f,
                        size.height * 0.48f
                    )
                    lineTo(
                        size.width * 0.50f,
                        size.height * 0.20f
                    )
                    lineTo(
                        size.width * 0.82f,
                        size.height * 0.48f
                    )
                }

                drawPath(
                    path = path,
                    color = color,
                    style = Stroke(
                        width = strokeWidth,
                        cap = StrokeCap.Round,
                        join = StrokeJoin.Round
                    )
                )

                drawRoundRect(
                    color = color,
                    topLeft = Offset(
                        size.width * 0.27f,
                        size.height * 0.46f
                    ),
                    size = Size(
                        size.width * 0.46f,
                        size.height * 0.35f
                    ),
                    cornerRadius = androidx.compose.ui.geometry.CornerRadius(
                        size.width * 0.04f
                    ),
                    style = Stroke(
                        width = strokeWidth
                    )
                )
            }

            AppIcon.Missions,
            AppIcon.Challenges -> {

                drawCircle(
                    color = color,
                    radius = size.minDimension * 0.34f,
                    center = center,
                    style = Stroke(
                        width = strokeWidth
                    )
                )

                drawCircle(
                    color = color,
                    radius = size.minDimension * 0.15f,
                    center = center,
                    style = Stroke(
                        width = strokeWidth
                    )
                )

                drawLine(
                    color = color,
                    start = Offset(
                        size.width * 0.50f,
                        size.height * 0.05f
                    ),
                    end = Offset(
                        size.width * 0.50f,
                        size.height * 0.25f
                    ),
                    strokeWidth = strokeWidth,
                    cap = StrokeCap.Round
                )

                drawLine(
                    color = color,
                    start = Offset(
                        size.width * 0.50f,
                        size.height * 0.75f
                    ),
                    end = Offset(
                        size.width * 0.50f,
                        size.height * 0.95f
                    ),
                    strokeWidth = strokeWidth,
                    cap = StrokeCap.Round
                )

                drawLine(
                    color = color,
                    start = Offset(
                        size.width * 0.05f,
                        size.height * 0.50f
                    ),
                    end = Offset(
                        size.width * 0.25f,
                        size.height * 0.50f
                    ),
                    strokeWidth = strokeWidth,
                    cap = StrokeCap.Round
                )

                drawLine(
                    color = color,
                    start = Offset(
                        size.width * 0.75f,
                        size.height * 0.50f
                    ),
                    end = Offset(
                        size.width * 0.95f,
                        size.height * 0.50f
                    ),
                    strokeWidth = strokeWidth,
                    cap = StrokeCap.Round
                )
            }

            AppIcon.AI,
            AppIcon.Robot -> {

                drawRoundRect(
                    color = color,
                    topLeft = Offset(
                        size.width * 0.20f,
                        size.height * 0.27f
                    ),
                    size = Size(
                        size.width * 0.60f,
                        size.height * 0.50f
                    ),
                    cornerRadius = androidx.compose.ui.geometry.CornerRadius(
                        size.width * 0.12f
                    ),
                    style = Stroke(
                        width = strokeWidth
                    )
                )

                drawCircle(
                    color = color,
                    radius = size.minDimension * 0.055f,
                    center = Offset(
                        size.width * 0.39f,
                        size.height * 0.49f
                    )
                )

                drawCircle(
                    color = color,
                    radius = size.minDimension * 0.055f,
                    center = Offset(
                        size.width * 0.61f,
                        size.height * 0.49f
                    )
                )

                drawLine(
                    color = color,
                    start = Offset(
                        size.width * 0.39f,
                        size.height * 0.65f
                    ),
                    end = Offset(
                        size.width * 0.61f,
                        size.height * 0.65f
                    ),
                    strokeWidth = strokeWidth,
                    cap = StrokeCap.Round
                )

                drawLine(
                    color = color,
                    start = Offset(
                        size.width * 0.50f,
                        size.height * 0.27f
                    ),
                    end = Offset(
                        size.width * 0.50f,
                        size.height * 0.10f
                    ),
                    strokeWidth = strokeWidth,
                    cap = StrokeCap.Round
                )

                drawCircle(
                    color = color,
                    radius = size.minDimension * 0.06f,
                    center = Offset(
                        size.width * 0.50f,
                        size.height * 0.08f
                    )
                )
            }

            AppIcon.Profile,
            AppIcon.Person -> {

                drawCircle(
                    color = color,
                    radius = size.minDimension * 0.18f,
                    center = Offset(
                        size.width * 0.50f,
                        size.height * 0.30f
                    )
                )

                drawArc(
                    color = color,
                    startAngle = 200f,
                    sweepAngle = 140f,
                    useCenter = false,
                    topLeft = Offset(
                        size.width * 0.22f,
                        size.height * 0.43f
                    ),
                    size = Size(
                        size.width * 0.56f,
                        size.height * 0.43f
                    ),
                    style = Stroke(
                        width = strokeWidth,
                        cap = StrokeCap.Round
                    )
                )
            }

            AppIcon.Security -> {

                val path = Path().apply {
                    moveTo(
                        size.width * 0.50f,
                        size.height * 0.08f
                    )
                    lineTo(
                        size.width * 0.82f,
                        size.height * 0.20f
                    )
                    lineTo(
                        size.width * 0.76f,
                        size.height * 0.62f
                    )
                    lineTo(
                        size.width * 0.50f,
                        size.height * 0.88f
                    )
                    lineTo(
                        size.width * 0.24f,
                        size.height * 0.62f
                    )
                    lineTo(
                        size.width * 0.18f,
                        size.height * 0.20f
                    )
                    close()
                }

                drawPath(
                    path = path,
                    color = color,
                    style = Stroke(
                        width = strokeWidth,
                        join = StrokeJoin.Round
                    )
                )

                drawLine(
                    color = color,
                    start = Offset(
                        size.width * 0.34f,
                        size.height * 0.48f
                    ),
                    end = Offset(
                        size.width * 0.46f,
                        size.height * 0.60f
                    ),
                    strokeWidth = strokeWidth,
                    cap = StrokeCap.Round
                )

                drawLine(
                    color = color,
                    start = Offset(
                        size.width * 0.46f,
                        size.height * 0.60f
                    ),
                    end = Offset(
                        size.width * 0.68f,
                        size.height * 0.36f
                    ),
                    strokeWidth = strokeWidth,
                    cap = StrokeCap.Round
                )
            }

            AppIcon.Star -> {

                val path = Path()

                for (i in 0 until 10) {

                    val angle = Math.toRadians(
                        -90.0 + i * 36.0
                    )

                    val radius =
                        if (i % 2 == 0) {
                            size.minDimension * 0.42f
                        } else {
                            size.minDimension * 0.18f
                        }

                    val x =
                        center.x +
                            (cos(angle) * radius).toFloat()

                    val y =
                        center.y +
                            (sin(angle) * radius).toFloat()

                    if (i == 0) {
                        path.moveTo(x, y)
                    } else {
                        path.lineTo(x, y)
                    }
                }

                path.close()

                drawPath(
                    path = path,
                    color = color
                )
            }

            AppIcon.ArrowForward -> {

                drawLine(
                    color = color,
                    start = Offset(
                        size.width * 0.18f,
                        size.height * 0.50f
                    ),
                    end = Offset(
                        size.width * 0.78f,
                        size.height * 0.50f
                    ),
                    strokeWidth = strokeWidth,
                    cap = StrokeCap.Round
                )

                drawLine(
                    color = color,
                    start = Offset(
                        size.width * 0.57f,
                        size.height * 0.27f
                    ),
                    end = Offset(
                        size.width * 0.82f,
                        size.height * 0.50f
                    ),
                    strokeWidth = strokeWidth,
                    cap = StrokeCap.Round
                )

                drawLine(
                    color = color,
                    start = Offset(
                        size.width * 0.57f,
                        size.height * 0.73f
                    ),
                    end = Offset(
                        size.width * 0.82f,
                        size.height * 0.50f
                    ),
                    strokeWidth = strokeWidth,
                    cap = StrokeCap.Round
                )
            }
        }
    }
}