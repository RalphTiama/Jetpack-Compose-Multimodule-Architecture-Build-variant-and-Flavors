package com.sneakerups.homecomponent.presentation.release_today_ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sneakerups.R
import com.sneakerups.homecomponent.model.ModelNewPost

@Composable
fun ReleaseTodayColumn(
    modifier: Modifier = Modifier
){
    val lazyListState = rememberLazyListState()

    val newPostList = listOf(
        ModelNewPost(R.mipmap.img_card_circle, "ImageTitle"),
        ModelNewPost(R.mipmap.img_card_circle, "ImageTitle"),
    )

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier) {

        itemsIndexed(newPostList) { index, item ->
            ReleaseTodayCard(item.img, item.title, Modifier.height(80.dp))
        }

    }
}

@Composable
@Preview(showBackground = true)
fun ReleaseTodayColumnPreview(){
    ReleaseTodayColumn(modifier = Modifier)
}