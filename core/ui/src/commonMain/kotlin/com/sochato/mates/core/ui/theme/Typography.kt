package com.sochato.mates.core.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.Font
import mates.core.ui.generated.resources.Res
import mates.core.ui.generated.resources.montserrat_black
import mates.core.ui.generated.resources.montserrat_bold
import mates.core.ui.generated.resources.montserrat_light
import mates.core.ui.generated.resources.montserrat_medium
import mates.core.ui.generated.resources.montserrat_regular
import mates.core.ui.generated.resources.montserrat_semibold

@Composable
fun WrummyFontFamily() = FontFamily(
    Font(Res.font.montserrat_light, weight = FontWeight.Light),
    Font(Res.font.montserrat_regular, weight = FontWeight.Normal),
    Font(Res.font.montserrat_medium, weight = FontWeight.Medium),
    Font(Res.font.montserrat_semibold, weight = FontWeight.SemiBold),
    Font(Res.font.montserrat_bold, weight = FontWeight.Bold),
    Font(Res.font.montserrat_black, weight = FontWeight.Black)
)

@Composable
internal fun WrummyTypography(): Typography {
    val family = WrummyFontFamily()

    return remember {
        Typography(
            displayLarge = TextStyle(
                fontFamily = family,
                fontWeight = FontWeight.Bold,
                fontSize = 52.sp
            ),
            displayMedium = TextStyle(
                fontFamily = family,
                fontWeight = FontWeight.SemiBold,
                fontSize = 30.sp
            ),
            displaySmall = TextStyle(
                fontFamily = family,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp
            ),
            titleLarge = TextStyle(
                fontFamily = family,
                fontWeight = FontWeight.Medium,
                fontSize = 22.sp
            ),
            titleMedium = TextStyle(
                fontFamily = family,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp
            ),
            titleSmall = TextStyle(
                fontFamily = family,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            ),
            bodyLarge = TextStyle(
                fontFamily = family,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp
            ),
            bodyMedium = TextStyle(
                fontFamily = family,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp
            ),
            bodySmall = TextStyle(
                fontFamily = family,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            ),
            labelLarge = TextStyle(
                fontFamily = family,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp
            ),
            labelMedium = TextStyle(
                fontFamily = family,
                fontWeight = FontWeight.Light,
                fontSize = 16.sp,
                letterSpacing = 0.48.sp
            ),
            labelSmall = TextStyle(
                fontFamily = family,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp
            )
        )
    }
}