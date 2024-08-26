package com.sneakerups.homecomponent.presentation.new_post_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sneakerups.R
import com.sneakerups.ui.theme.commonBoxSurface

@Composable
fun CircleCard(
    painter: Int,
    text: String,
    modifier: Modifier = Modifier){

    Surface(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier.padding(top = 8.dp, end =  8.dp)
    ) {

        Column(
            modifier = modifier
                .background(MaterialTheme.colorScheme.surface)
                .clip(RoundedCornerShape(10.dp))
                .padding(horizontal = 4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Image(
                painter = painterResource(id = R.mipmap.img_card_circle),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(88.dp)
            )
            Text(text,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp))

        }

    }


}

@Composable
@Preview(showBackground = true)
fun CircleCardPreview(){
    CircleCard(
        painter = R.mipmap.img_card_circle,
        text = "Title",
        modifier = Modifier
    )
}
