package com.sneakerups.homecomponent.presentation.release_today_ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ReleaseTodaySection(modifier: Modifier = Modifier.windowInsetsPadding(WindowInsets.navigationBars)){
    Column(modifier) {
        Text(text = "Release Today"
            ,modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp)
        )
        ReleaseTodayColumn()
    }

}


@Composable
@Preview(showBackground = true)
fun ReleaseTodaySectionPreview(){
    ReleaseTodaySection(modifier = Modifier)
}
