package colors

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)



//Light Colors
val commonBoxSurface = Color(247, 247, 255)
val commonGreyColor = Color(75, 75, 97)
val primaryColor = Color(239, 145, 50)
val commonBackground = Color(0xFFF2F1F7)
val commonBoxBackground = Color(0xFFFFFFFF)
val commonTextWhite = Color(0xFFFFFFFF)
val commonTextWhiteLight = Color(0x80FFFFFF)
val commonTitleColor = Color(15, 15, 15)
val commonTextBlackLightColor = Color(75, 75, 97)


val commonBoxSurfaceDark = Color(24, 24, 31)
val commonGreyColorDark = Color(75, 75, 97)
val primaryColorDark = Color(239, 145, 50)
val commonBackgroundDark = Color(0xFFF2F1F7)
val commonBoxBackgroundDark = Color(20, 20, 25)
val commonTextWhiteDark = Color(0xFFFFFFFF)
val commonTextWhiteLightDark = Color(0x80FFFFFF)
val commonTitleColorDark = Color(15, 15, 15)
val commonTextBlackLightColorDark = Color(75, 75, 97)


sealed class ThemeColors(
    val bacground: Color,
    val surafce: Color,
    val primary: Color,
    val text: Color
)  {
    data object Night: ThemeColors(
        bacground = commonBoxBackgroundDark,
        surafce = commonBoxSurfaceDark,
        primary = primaryColorDark,
        text = Color.White
    )
    data object Day: ThemeColors(
        bacground = commonBoxBackground,
        surafce = commonBoxSurface,
        primary = primaryColor,
        text = Color.Black
    )
}
