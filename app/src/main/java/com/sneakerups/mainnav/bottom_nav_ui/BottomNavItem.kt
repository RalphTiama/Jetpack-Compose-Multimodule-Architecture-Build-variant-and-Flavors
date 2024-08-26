package com.sneakerups.mainnav.bottom_nav_ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import com.sneakerups.mainnav.BottomNavSealedClass
import com.sneakerups.ui.theme.commonGreyColor

@Composable
fun LazyItemScope.AddItem(
    screen: BottomNavSealedClass,
    currentDestination: NavDestination?,
    navController: NavHostController,
    isDoneAnimation: Boolean = true,
    modifier: Modifier,
    click : () -> Unit
) {
    val isSelected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
    val background = if (isSelected) MaterialTheme.colorScheme.primary.copy(alpha = 0.6f) else Color.Transparent
    val contentColor = if (isSelected && isDoneAnimation) Color.White else commonGreyColor

    Box(
        modifier = modifier
            .height(40.dp)
            .padding(horizontal = 8.dp)
            .clickable(onClick = click),
    )
    {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Icon(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = if (isDoneAnimation) screen.iconFocused else screen.icon),
                contentDescription = "",
                tint = contentColor
            )

            Text(
                text = screen.title,
                color = contentColor
            )
        }
    }

}