package com.sneakerups.homecomponent.presentation.most_popular_ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MostPopularSection(modifier: Modifier = Modifier){
    Column(modifier) {
        Text(text = "Most Popular"
            ,modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp)
        )
        MostPopularCardGrid()
    }

}


@Composable
@Preview(showBackground = true)
fun MostPopularSectionPreview(){
    MostPopularSection(modifier = Modifier)
}
