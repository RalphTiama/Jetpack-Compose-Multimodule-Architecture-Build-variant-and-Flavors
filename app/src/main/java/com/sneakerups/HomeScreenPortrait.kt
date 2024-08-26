package com.sneakerups

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.sneakerups.homecomponent.presentation.most_popular_ui.MostPopularSection
import com.sneakerups.homecomponent.presentation.new_post_ui.NewPostSection
import com.sneakerups.homecomponent.presentation.release_today_ui.ReleaseTodaySection
import com.sneakerups.homecomponent.SearchBar

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        SearchBar()
        NewPostSection()
        MostPopularSection()
        ReleaseTodaySection()

    }

}


@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){
    HomeScreen()
}


