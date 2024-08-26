package com.sneakerups.homecomponent.presentation.new_post_ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NewPostSection(modifier: Modifier = Modifier){
    Column(modifier) {
        Text(text = "New Post"
                ,modifier = Modifier
                .paddingFromBaseline(top = 30.dp, bottom = 16.dp)
            .padding(horizontal = 16.dp),
            style = MaterialTheme.typography.bodyLarge)
        NewPostRow()
    }

}


@Composable
@Preview(showBackground = true)
fun NewPostSectionPreview(){
    NewPostSection(modifier = Modifier)
}
