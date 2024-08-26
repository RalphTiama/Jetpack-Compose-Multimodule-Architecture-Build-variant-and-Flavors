package com.sneakerups.homecomponent.presentation.most_popular_ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sneakerups.R
import com.sneakerups.homecomponent.model.ModelNewPost

@Composable
fun MostPopularCardGrid(
    modifier: Modifier = Modifier
){
    val lazyListState = rememberLazyListState()

    val newPostList = listOf(
        ModelNewPost(R.mipmap.img_card_circle, "ImageTitle"),
        ModelNewPost(R.mipmap.img_card_circle, "ImageTitle"),
        ModelNewPost(R.mipmap.img_card_circle, "ImageTitle"),
        ModelNewPost(R.mipmap.img_card_circle, "ImageTitle"),
        ModelNewPost(R.mipmap.img_card_circle, "ImageTitle"),
        ModelNewPost(R.mipmap.img_card_circle, "ImageTitle"),
    )

    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.height(168.dp)) {
        itemsIndexed(newPostList){ _, item ->
            MostPopularCard(item.img, item.title, Modifier.height(80.dp))
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MostPopularCardGridPreview(){
    MostPopularCardGrid(modifier = Modifier)
}