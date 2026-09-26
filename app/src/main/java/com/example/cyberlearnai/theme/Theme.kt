package com.example.securequest.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/*
 * ============================================================
 * SECUREQUEST DESIGN SYSTEM
 * ============================================================
 *
 * Dark futuristic cybersecurity theme.
 *
 * Main colors:
 * - Deep space background
 * - Cyber blue
 * - Neon cyan
 * - Electric purple
 * - Premium gold
 *
 * This theme intentionally does NOT use Android Dynamic Colors.
 * SecureQuest should look the same on every supported device.
 */

private val SecureQuestDarkColors = darkColorScheme(

    // Primary actions
    primary = Color(0xFF22D3EE),
    onPrimary = Color(0xFF00151A),

    // Secondary actions
    secondary = Color(0xFF7C3AED),
    onSecondary = Color.White,

    // Accent
    tertiary = Color(0xFF38BDF8),
    onTertiary = Color(0xFF00151A),

    // Main application background
    background = Color(0xFF050B18),
    onBackground = Color(0xFFF8FAFC),

    // Cards / surfaces
    surface = Color(0xFF0B1629),
    onSurface = Color(0xFFF8FAFC),

    surfaceVariant = Color(0xFF12233D),
    onSurfaceVariant = Color(0xFFB7C5D9),

    // Borders / outlines
    outline = Color(0xFF28517A),
    outlineVariant = Color(0xFF173653),

    // Error
    error = Color(0xFFFF5577),
    onError = Color.White,

    // Inverse colors
    inverseSurface = Color(0xFFE8F7FF),
    inverseOnSurface = Color(0xFF07101D),
    inversePrimary = Color(0xFF006B7D),
)

/*
 * Shared SecureQuest colors.
 *
 * Other UI files can use these instead of defining their
 * own unrelated colors.
 */

object SecureQuestColors {

    // Backgrounds
    val Background = Color(0xFF050B18)
    val BackgroundSecondary = Color(0xFF081225)

    // Cards
    val Surface = Color(0xFF0B1629)
    val SurfaceLight = Color(0xFF12233D)
    val SurfaceElevated = Color(0xFF172B49)

    // Cyber blue / cyan
    val Cyan = Color(0xFF22D3EE)
    val CyanBright = Color(0xFF00E5FF)
    val Blue = Color(0xFF38BDF8)
    val BlueDeep = Color(0xFF0EA5E9)

    // Purple
    val Purple = Color(0xFF7C3AED)
    val PurpleBright = Color(0xFFA855F7)

    // Premium
    val Gold = Color(0xFFFBBF24)
    val GoldBright = Color(0xFFFFD166)

    // Success
    val Success = Color(0xFF34D399)
    val SuccessBright = Color(0xFF2AF5B4)

    // Warning
    val Warning = Color(0xFFF59E0B)

    // Danger
    val Danger = Color(0xFFFF5577)
    val DangerDark = Color(0xFFB91C4A)

    // Text
    val TextPrimary = Color(0xFFF8FAFC)
    val TextSecondary = Color(0xFFB7C5D9)
    val TextMuted = Color(0xFF71839D)

    // Borders
    val Border = Color(0xFF28517A)
    val BorderSoft = Color(0xFF173653)

    // Transparent overlays
    val CyanOverlay = Color(0x3322D3EE)
    val BlueOverlay = Color(0x2638BDF8)
    val PurpleOverlay = Color(0x337C3AED)
}

/*
 * SecureQuest typography.
 *
 * We keep Material 3 typography but use slightly stronger
 * weights for headings so the interface feels more modern.
 */

private val SecureQuestTypography = Typography(
    displayLarge = Typography().displayLarge.copy(
        color = SecureQuestColors.TextPrimary
    ),

    displayMedium = Typography().displayMedium.copy(
        color = SecureQuestColors.TextPrimary
    ),

    displaySmall = Typography().displaySmall.copy(
        color = SecureQuestColors.TextPrimary
    ),

    headlineLarge = Typography().headlineLarge.copy(
        color = SecureQuestColors.TextPrimary
    ),

    headlineMedium = Typography().headlineMedium.copy(
        color = SecureQuestColors.TextPrimary
    ),

    headlineSmall = Typography().headlineSmall.copy(
        color = SecureQuestColors.TextPrimary
    ),

    titleLarge = Typography().titleLarge.copy(
        color = SecureQuestColors.TextPrimary
    ),

    titleMedium = Typography().titleMedium.copy(
        color = SecureQuestColors.TextPrimary
    ),

    titleSmall = Typography().titleSmall.copy(
        color = SecureQuestColors.TextSecondary
    ),

    bodyLarge = Typography().bodyLarge.copy(
        color = SecureQuestColors.TextSecondary
    ),

    bodyMedium = Typography().bodyMedium.copy(
        color = SecureQuestColors.TextSecondary
    ),

    bodySmall = Typography().bodySmall.copy(
        color = SecureQuestColors.TextMuted
    ),

    labelLarge = Typography().labelLarge.copy(
        color = SecureQuestColors.TextPrimary
    ),

    labelMedium = Typography().labelMedium.copy(
        color = SecureQuestColors.TextSecondary
    ),

    labelSmall = Typography().labelSmall.copy(
        color = SecureQuestColors.TextMuted
    ),
)

/**
 * Global SecureQuest theme.
 *
 * Dynamic Android colors are intentionally disabled so the
 * application keeps the same visual identity on every phone.
 */
@Composable
fun CyberLearnAITheme(
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = SecureQuestDarkColors,
        typography = SecureQuestTypography,
        content = content,
    )
}