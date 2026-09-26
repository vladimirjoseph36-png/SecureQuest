package com.example.securequest.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import kotlin.math.cos
import kotlin.math.sin

private val CyberBlack = Color(0xFF02060D)
private val CyberBlue = Color(0xFF061525)
private val CyberCyan = Color(0xFF27E7FF)
private val CyberPurple = Color(0xFF9B6CFF)
private val CyberGreen = Color(0xFF36E39A)

@Composable
fun CyberQuestBackground(
    modifier: Modifier = Modifier
) {
    Canvas(
        modifier = modifier.fillMaxSize()
    ) {

        val width = size.width
        val height = size.height

        // ================================================================
        // BASE BACKGROUND
        // ================================================================

        drawRect(
            brush = Brush.verticalGradient(
                colors = listOf(
                    CyberBlack,
                    CyberBlue,
                    CyberBlack
                )
            )
        )

        // ================================================================
        // AMBIENT GLOW
        // ================================================================

        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(
                    CyberCyan.copy(alpha = 0.14f),
                    CyberCyan.copy(alpha = 0.035f),
                    Color.Transparent
                )
            ),
            radius = width * 0.72f,
            center = Offset(
                width * 0.90f,
                height * 0.10f
            )
        )

        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(
                    CyberPurple.copy(alpha = 0.12f),
                    CyberPurple.copy(alpha = 0.025f),
                    Color.Transparent
                )
            ),
            radius = width * 0.65f,
            center = Offset(
                width * 0.05f,
                height * 0.78f
            )
        )

        // ================================================================
        // CYBER GRID
        // ================================================================

        val grid = 42.dp.toPx()

        var x = 0f

        while (x <= width) {

            drawLine(
                color = CyberCyan.copy(alpha = 0.016f),
                start = Offset(x, 0f),
                end = Offset(x, height),
                strokeWidth = 1.dp.toPx()
            )

            x += grid
        }

        var y = 0f

        while (y <= height) {

            drawLine(
                color = CyberCyan.copy(alpha = 0.016f),
                start = Offset(0f, y),
                end = Offset(width, y),
                strokeWidth = 1.dp.toPx()
            )

            y += grid
        }

        // ================================================================
        // SECUREQUEST BACKGROUND BRAND
        // ================================================================
        //
        // Instead of Android native text rendering, we create a large
        // geometric wordmark using horizontal segments.
        //
        // This keeps the background entirely inside Compose Canvas.
        // ================================================================

        val brandColor = CyberCyan.copy(alpha = 0.035f)
        val brandSecondary = CyberPurple.copy(alpha = 0.025f)

        val brandTop = height * 0.33f
        val brandHeight = height * 0.12f
        val brandLeft = width * 0.06f
        val brandWidth = width * 0.88f

        val letterWidth = brandWidth * 0.072f
        val letterGap = brandWidth * 0.017f
        val stroke = maxOf(2.dp.toPx(), width * 0.003f)

        fun drawBrandLetter(
            left: Float,
            top: Float,
            letter: Char
        ) {

            val right = left + letterWidth
            val middleX = left + letterWidth / 2f
            val middleY = top + brandHeight / 2f

            when (letter.uppercaseChar()) {

                'S' -> {
                    drawLine(
                        brandColor,
                        Offset(right, top),
                        Offset(left, top),
                        stroke
                    )

                    drawLine(
                        brandColor,
                        Offset(left, top),
                        Offset(left, middleY),
                        stroke
                    )

                    drawLine(
                        brandColor,
                        Offset(left, middleY),
                        Offset(right, middleY),
                        stroke
                    )

                    drawLine(
                        brandColor,
                        Offset(right, middleY),
                        Offset(right, top + brandHeight),
                        stroke
                    )

                    drawLine(
                        brandColor,
                        Offset(right, top + brandHeight),
                        Offset(left, top + brandHeight),
                        stroke
                    )
                }

                'E' -> {
                    drawLine(
                        brandColor,
                        Offset(left, top),
                        Offset(left, top + brandHeight),
                        stroke
                    )

                    drawLine(
                        brandColor,
                        Offset(left, top),
                        Offset(right, top),
                        stroke
                    )

                    drawLine(
                        brandColor,
                        Offset(left, middleY),
                        Offset(right * 0.96f, middleY),
                        stroke
                    )

                    drawLine(
                        brandColor,
                        Offset(left, top + brandHeight),
                        Offset(right, top + brandHeight),
                        stroke
                    )
                }

                'C' -> {
                    drawLine(
                        brandColor,
                        Offset(right, top),
                        Offset(left, top),
                        stroke
                    )

                    drawLine(
                        brandColor,
                        Offset(left, top),
                        Offset(left, top + brandHeight),
                        stroke
                    )

                    drawLine(
                        brandColor,
                        Offset(left, top + brandHeight),
                        Offset(right, top + brandHeight),
                        stroke
                    )
                }

                'U' -> {
                    drawLine(
                        brandColor,
                        Offset(left, top),
                        Offset(left, top + brandHeight),
                        stroke
                    )

                    drawLine(
                        brandColor,
                        Offset(right, top),
                        Offset(right, top + brandHeight),
                        stroke
                    )

                    drawLine(
                        brandColor,
                        Offset(left, top + brandHeight),
                        Offset(right, top + brandHeight),
                        stroke
                    )
                }

                'R' -> {
                    drawLine(
                        brandColor,
                        Offset(left, top),
                        Offset(left, top + brandHeight),
                        stroke
                    )

                    drawLine(
                        brandColor,
                        Offset(left, top),
                        Offset(right * 0.88f, top),
                        stroke
                    )

                    drawLine(
                        brandColor,
                        Offset(right * 0.88f, top),
                        Offset(right * 0.88f, middleY),
                        stroke
                    )

                    drawLine(
                        brandColor,
                        Offset(right * 0.88f, middleY),
                        Offset(left, middleY),
                        stroke
                    )

                    drawLine(
                        brandColor,
                        Offset(left + letterWidth * 0.50f, middleY),
                        Offset(right, top + brandHeight),
                        stroke
                    )
                }

                'Q' -> {
                    drawOval(
                        color = brandColor,
                        topLeft = Offset(left, top),
                        size = androidx.compose.ui.geometry.Size(
                            letterWidth,
                            brandHeight
                        ),
                        style = Stroke(stroke)
                    )

                    drawLine(
                        brandColor,
                        Offset(
                            left + letterWidth * 0.56f,
                            middleY + brandHeight * 0.10f
                        ),
                        Offset(
                            right,
                            top + brandHeight
                        ),
                        stroke
                    )
                }

                'T' -> {
                    drawLine(
                        brandColor,
                        Offset(left, top),
                        Offset(right, top),
                        stroke
                    )

                    drawLine(
                        brandColor,
                        Offset(middleX, top),
                        Offset(middleX, top + brandHeight),
                        stroke
                    )
                }
            }
        }

        val word = "SECUREQUEST"

        word.forEachIndexed { index, letter ->

            val left =
                brandLeft + index * (letterWidth + letterGap)

            drawBrandLetter(
                left = left,
                top = brandTop,
                letter = letter
            )
        }

        // ================================================================
        // SECOND BRAND LINE
        // ================================================================

        val secondBrandY = brandTop + brandHeight + height * 0.025f

        drawLine(
            color = brandSecondary,
            start = Offset(width * 0.18f, secondBrandY),
            end = Offset(width * 0.82f, secondBrandY),
            strokeWidth = 1.dp.toPx()
        )

        drawLine(
            color = CyberCyan.copy(alpha = 0.018f),
            start = Offset(width * 0.28f, secondBrandY + 7.dp.toPx()),
            end = Offset(width * 0.72f, secondBrandY + 7.dp.toPx()),
            strokeWidth = 1.dp.toPx()
        )

        // ================================================================
        // CENTRAL SHIELD
        // ================================================================

        val shieldCenter = Offset(
            width * 0.50f,
            height * 0.48f
        )

        val shieldWidth = width * 0.60f
        val shieldHeight = height * 0.43f

        val shield = Path().apply {

            moveTo(
                shieldCenter.x,
                shieldCenter.y - shieldHeight * 0.50f
            )

            lineTo(
                shieldCenter.x + shieldWidth * 0.38f,
                shieldCenter.y - shieldHeight * 0.32f
            )

            lineTo(
                shieldCenter.x + shieldWidth * 0.31f,
                shieldCenter.y + shieldHeight * 0.20f
            )

            lineTo(
                shieldCenter.x,
                shieldCenter.y + shieldHeight * 0.50f
            )

            lineTo(
                shieldCenter.x - shieldWidth * 0.31f,
                shieldCenter.y + shieldHeight * 0.20f
            )

            lineTo(
                shieldCenter.x - shieldWidth * 0.38f,
                shieldCenter.y - shieldHeight * 0.32f
            )

            close()
        }

        drawPath(
            path = shield,
            color = CyberCyan.copy(alpha = 0.018f)
        )

        drawPath(
            path = shield,
            color = CyberCyan.copy(alpha = 0.065f),
            style = Stroke(
                width = 1.5.dp.toPx()
            )
        )

        // ================================================================
        // INNER SHIELD
        // ================================================================

        val innerShield = Path().apply {

            moveTo(
                shieldCenter.x,
                shieldCenter.y - shieldHeight * 0.36f
            )

            lineTo(
                shieldCenter.x + shieldWidth * 0.27f,
                shieldCenter.y - shieldHeight * 0.23f
            )

            lineTo(
                shieldCenter.x + shieldWidth * 0.21f,
                shieldCenter.y + shieldHeight * 0.15f
            )

            lineTo(
                shieldCenter.x,
                shieldCenter.y + shieldHeight * 0.36f
            )

            lineTo(
                shieldCenter.x - shieldWidth * 0.21f,
                shieldCenter.y + shieldHeight * 0.15f
            )

            lineTo(
                shieldCenter.x - shieldWidth * 0.27f,
                shieldCenter.y - shieldHeight * 0.23f
            )

            close()
        }

        drawPath(
            path = innerShield,
            color = CyberPurple.copy(alpha = 0.035f)
        )

        drawPath(
            path = innerShield,
            color = CyberPurple.copy(alpha = 0.065f),
            style = Stroke(
                width = 1.dp.toPx()
            )
        )

        // ================================================================
        // SECURITY CORE
        // ================================================================

        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(
                    CyberCyan.copy(alpha = 0.18f),
                    CyberCyan.copy(alpha = 0.045f),
                    Color.Transparent
                )
            ),
            radius = width * 0.15f,
            center = shieldCenter
        )

        drawCircle(
            color = CyberCyan.copy(alpha = 0.11f),
            radius = width * 0.075f,
            center = shieldCenter,
            style = Stroke(
                width = 1.dp.toPx()
            )
        )

        drawCircle(
            color = CyberCyan.copy(alpha = 0.16f),
            radius = width * 0.025f,
            center = shieldCenter
        )

        // ================================================================
        // NETWORK NODES
        // ================================================================

        val nodes = listOf(
            Offset(width * 0.07f, height * 0.16f),
            Offset(width * 0.20f, height * 0.28f),
            Offset(width * 0.36f, height * 0.13f),
            Offset(width * 0.63f, height * 0.18f),
            Offset(width * 0.82f, height * 0.12f),
            Offset(width * 0.94f, height * 0.27f),
            Offset(width * 0.10f, height * 0.49f),
            Offset(width * 0.28f, height * 0.57f),
            Offset(width * 0.50f, height * 0.45f),
            Offset(width * 0.73f, height * 0.54f),
            Offset(width * 0.91f, height * 0.48f),
            Offset(width * 0.06f, height * 0.75f),
            Offset(width * 0.24f, height * 0.68f),
            Offset(width * 0.46f, height * 0.80f),
            Offset(width * 0.69f, height * 0.70f),
            Offset(width * 0.90f, height * 0.79f)
        )

        val connections = listOf(
            0 to 1,
            1 to 2,
            2 to 3,
            3 to 4,
            4 to 5,
            1 to 7,
            2 to 8,
            3 to 8,
            4 to 9,
            6 to 7,
            7 to 8,
            8 to 9,
            9 to 10,
            6 to 11,
            7 to 12,
            8 to 13,
            9 to 14,
            10 to 15,
            12 to 13,
            13 to 14,
            14 to 15
        )

        connections.forEach { (from, to) ->

            drawLine(
                color = CyberCyan.copy(alpha = 0.032f),
                start = nodes[from],
                end = nodes[to],
                strokeWidth = 1.dp.toPx()
            )
        }

        nodes.forEachIndexed { index, node ->

            val nodeColor =
                if (index % 5 == 0) {
                    CyberGreen
                } else {
                    CyberCyan
                }

            drawCircle(
                color = nodeColor.copy(alpha = 0.075f),
                radius = 7.dp.toPx(),
                center = node
            )

            drawCircle(
                color = nodeColor.copy(alpha = 0.23f),
                radius = 2.dp.toPx(),
                center = node
            )
        }

        // ================================================================
        // CIRCUIT TRACES
        // ================================================================

        val traceAlpha = 0.055f

        drawLine(
            color = CyberCyan.copy(alpha = traceAlpha),
            start = Offset(
                0f,
                height * 0.30f
            ),
            end = Offset(
                width * 0.13f,
                height * 0.30f
            ),
            strokeWidth = 1.dp.toPx()
        )

        drawLine(
            color = CyberCyan.copy(alpha = traceAlpha),
            start = Offset(
                width * 0.13f,
                height * 0.30f
            ),
            end = Offset(
                width * 0.18f,
                height * 0.25f
            ),
            strokeWidth = 1.dp.toPx()
        )

        drawLine(
            color = CyberPurple.copy(alpha = traceAlpha),
            start = Offset(
                width,
                height * 0.62f
            ),
            end = Offset(
                width * 0.86f,
                height * 0.62f
            ),
            strokeWidth = 1.dp.toPx()
        )

        drawLine(
            color = CyberPurple.copy(alpha = traceAlpha),
            start = Offset(
                width * 0.86f,
                height * 0.62f
            ),
            end = Offset(
                width * 0.80f,
                height * 0.68f
            ),
            strokeWidth = 1.dp.toPx()
        )

        // ================================================================
        // ORBIT SYSTEM
        // ================================================================

        val orbitRadius = width * 0.19f

        drawCircle(
            color = CyberCyan.copy(alpha = 0.032f),
            radius = orbitRadius,
            center = shieldCenter,
            style = Stroke(
                width = 1.dp.toPx()
            )
        )

        drawCircle(
            color = CyberPurple.copy(alpha = 0.023f),
            radius = orbitRadius * 1.25f,
            center = shieldCenter,
            style = Stroke(
                width = 1.dp.toPx()
            )
        )

        val orbitalPoints = 10

        repeat(orbitalPoints) { index ->

            val angle =
                index * (Math.PI * 2.0 / orbitalPoints)

            val point = Offset(
                x = shieldCenter.x +
                    cos(angle).toFloat() * orbitRadius,
                y = shieldCenter.y +
                    sin(angle).toFloat() * orbitRadius
            )

            drawCircle(
                color =
                    if (index % 2 == 0) {
                        CyberCyan.copy(alpha = 0.17f)
                    } else {
                        CyberPurple.copy(alpha = 0.15f)
                    },
                radius = 1.5.dp.toPx(),
                center = point
            )
        }

        // ================================================================
        // SCAN LINES
        // ================================================================

        val scanY = height * 0.86f

        drawLine(
            color = CyberCyan.copy(alpha = 0.032f),
            start = Offset(
                width * 0.10f,
                scanY
            ),
            end = Offset(
                width * 0.90f,
                scanY
            ),
            strokeWidth = 1.dp.toPx()
        )

        drawLine(
            color = CyberCyan.copy(alpha = 0.018f),
            start = Offset(
                width * 0.20f,
                scanY + 7.dp.toPx()
            ),
            end = Offset(
                width * 0.80f,
                scanY + 7.dp.toPx()
            ),
            strokeWidth = 1.dp.toPx()
        )

        // ================================================================
        // CORNER HUD
        // ================================================================

        val cornerLength = 22.dp.toPx()
        val margin = 22.dp.toPx()

        drawLine(
            color = CyberCyan.copy(alpha = 0.09f),
            start = Offset(
                margin,
                margin
            ),
            end = Offset(
                margin + cornerLength,
                margin
            ),
            strokeWidth = 1.dp.toPx()
        )

        drawLine(
            color = CyberCyan.copy(alpha = 0.09f),
            start = Offset(
                margin,
                margin
            ),
            end = Offset(
                margin,
                margin + cornerLength
            ),
            strokeWidth = 1.dp.toPx()
        )

        drawLine(
            color = CyberPurple.copy(alpha = 0.09f),
            start = Offset(
                width - margin,
                height - margin
            ),
            end = Offset(
                width - margin - cornerLength,
                height - margin
            ),
            strokeWidth = 1.dp.toPx()
        )

        drawLine(
            color = CyberPurple.copy(alpha = 0.09f),
            start = Offset(
                width - margin,
                height - margin
            ),
            end = Offset(
                width - margin,
                height - margin - cornerLength
            ),
            strokeWidth = 1.dp.toPx()
        )
    }
}