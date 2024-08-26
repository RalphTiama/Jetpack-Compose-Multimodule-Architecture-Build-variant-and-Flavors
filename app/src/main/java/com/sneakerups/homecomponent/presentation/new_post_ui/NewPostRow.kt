package com.sneakerups.homecomponent.presentation.new_post_ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sneakerups.R
import com.sneakerups.homecomponent.model.ModelNewPost

@SuppressLint("SuspiciousIndentation")
@Composable
fun NewPostRow(modifier: Modifier = Modifier){

    val lazyListState = rememberLazyListState()


    val newPostList = listOf(
        ModelNewPost(R.mipmap.img_card_circle, "ImageTitle"),
        ModelNewPost(R.mipmap.img_card_circle, "ImageTitle"),
        ModelNewPost(R.mipmap.img_card_circle, "ImageTitle"),
        ModelNewPost(R.mipmap.img_card_circle, "ImageTitle"),
        ModelNewPost(R.mipmap.img_card_circle, "ImageTitle"),
        ModelNewPost(R.mipmap.img_card_circle, "ImageTitle"),
        )


        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier,
            contentPadding = PaddingValues(horizontal = 16.dp),
            state = lazyListState
        ) {
            itemsIndexed(newPostList) { _, item->
                CircleCard(item.img, item.title)
            }
        }

}

@Composable
@Preview(showBackground = true)
fun NewPostRowPreview(){
    NewPostRow(modifier = Modifier)
}