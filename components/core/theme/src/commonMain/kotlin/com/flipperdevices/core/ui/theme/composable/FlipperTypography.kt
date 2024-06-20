package com.flipperdevices.core.ui.theme.composable

import androidx.compose.runtime.Stable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Stable
data class FlipperTypography(
    val titleB24: TextStyle = TextStyle(
        fontSize = 24.sp,

        fontWeight = FontWeight.W700
    ),
    val titleB22: TextStyle = TextStyle(
        fontSize = 22.sp,

        fontWeight = FontWeight.W700
    ),
    val titleB20: TextStyle = TextStyle(
        fontSize = 20.sp,

        fontWeight = FontWeight.W700
    ),
    val titleSB18: TextStyle = TextStyle(
        fontSize = 18.sp,

        fontWeight = FontWeight.W600
    ),
    val titleSB16: TextStyle = TextStyle(
        fontSize = 18.sp,

        fontWeight = FontWeight.W600
    ),
    val titleEB20: TextStyle = TextStyle(
        fontSize = 20.sp,

        fontWeight = FontWeight.W800
    ),
    val titleEB18: TextStyle = TextStyle(
        fontSize = 18.sp,

        fontWeight = FontWeight.W800
    ),
    val titleB18: TextStyle = TextStyle(
        fontSize = 18.sp,

        fontWeight = FontWeight.W700
    ),
    val titleR18: TextStyle = TextStyle(
        fontSize = 18.sp,

        fontWeight = FontWeight.W400
    ),
    val titleM18: TextStyle = TextStyle(
        fontSize = 18.sp,

        fontWeight = FontWeight.W500
    ),
    val subtitleB12: TextStyle = TextStyle(
        fontSize = 12.sp,

        fontWeight = FontWeight.W700
    ),
    val subtitleEB12: TextStyle = TextStyle(
        fontSize = 12.sp,

        fontWeight = FontWeight.W800
    ),
    val subtitleM12: TextStyle = TextStyle(
        fontSize = 12.sp,

        fontWeight = FontWeight.W500
    ),
    val subtitleR12: TextStyle = TextStyle(
        fontSize = 12.sp,

        fontWeight = FontWeight.W400
    ),
    val subtitleR10: TextStyle = TextStyle(
        fontSize = 10.sp,

        fontWeight = FontWeight.W400
    ),
    val subtitleB10: TextStyle = TextStyle(
        fontSize = 10.sp,

        fontWeight = FontWeight.W700
    ),
    val subtitleM10: TextStyle = TextStyle(
        fontSize = 10.sp,

        fontWeight = FontWeight.W500
    ),
    val bodySB14: TextStyle = TextStyle(
        fontSize = 14.sp,

        fontWeight = FontWeight.W600
    ),
    val bodySSB14: TextStyle = TextStyle(
        fontSize = 14.sp,

        fontWeight = FontWeight.W700
    ),
    val bodyR14: TextStyle = TextStyle(
        fontSize = 14.sp,

        fontWeight = FontWeight.W400
    ),
    val bodyM14: TextStyle = TextStyle(
        fontSize = 14.sp,

        fontWeight = FontWeight.W500
    ),
    val bodyR16: TextStyle = TextStyle(
        fontSize = 16.sp,

        fontWeight = FontWeight.W400
    ),
    val buttonB16: TextStyle = TextStyle(
        fontSize = 16.sp,

        fontWeight = FontWeight.W700
    ),
    val buttonM16: TextStyle = TextStyle(
        fontSize = 16.sp,

        fontWeight = FontWeight.W500
    ),
    val buttonB14: TextStyle = TextStyle(
        fontSize = 14.sp,

        fontWeight = FontWeight.W700
    ),
    val updateButton40: TextStyle = TextStyle(
        fontSize = 40.sp,

        fontWeight = FontWeight.W500
    ),
    val updateText40: TextStyle = TextStyle(
        fontSize = 40.sp,

        fontWeight = FontWeight.W400
    ),
    val flipperAction: TextStyle = TextStyle(
        fontSize = 24.sp,

        fontWeight = FontWeight.W500
    ),
    val monoSpaceM14: TextStyle = TextStyle(
        fontSize = 14.sp,

        fontWeight = FontWeight.W500
    ),
    val monoSpaceM10: TextStyle = TextStyle(
        fontSize = 10.sp,

        fontWeight = FontWeight.W500
    ),
    val monoSpaceM12: TextStyle = TextStyle(
        fontSize = 12.sp,

        fontWeight = FontWeight.W500
    ),
    val monoSpaceM16: TextStyle = TextStyle(
        fontSize = 16.sp,

        fontWeight = FontWeight.W500
    ),
    val monoSpaceR12: TextStyle = TextStyle(
        fontSize = 12.sp,

        fontWeight = FontWeight.W400
    ),
    val notificationB8: TextStyle = TextStyle(
        fontSize = 8.sp,

        fontWeight = FontWeight.W700
    ),
    val fapHubButtonText: TextStyle = TextStyle(
        fontSize = 18.sp,

        fontWeight = FontWeight.W500
    ),
    val fapHubButtonProgressText: TextStyle = TextStyle(
        fontSize = 18.sp,

        fontWeight = FontWeight.W500
    ),
    val infraredEditButton: TextStyle = TextStyle(
        fontSize = 32.sp,

        fontWeight = FontWeight.W400
    ),
)

fun getTypography(): FlipperTypography {
    return FlipperTypography()
}
