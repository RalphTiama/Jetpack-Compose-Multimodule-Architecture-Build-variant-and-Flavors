package com.sneakerups.homecomponent

import androidx.compose.material.icons.Icons
import androidx.compose.material3.NavigationBar
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sneakerups.mainnav.BottomNavSealedClass

@Composable
fun BottomNavigationRail(modifier: Modifier = Modifier) {
    NavigationBar(
        modifier = modifier
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null
                )
            },
            label = {
                Text(
                    text = BottomNavSealedClass.Home.title
                )
            },
            selected = true,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = null
                )
            },
            label = {
                Text(
                    text = BottomNavSealedClass.Calendar.title
                )
            },
            selected = false,
            onClick = {}
        )
    }
}


@Preview(showBackground = true)
@Composable
fun BottomNavPreview() {
    BottomNavigationRail()
}
