package com.ahmed.carefer.ui.screens.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size


@Composable
fun PropertyItem(
    //onItemClicked: (PropertyModel) -> Unit = {}
) {

   /* ConstraintLayout(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            onItemClicked(item)
        }) {
        val (imageCover, title, mergeView) = createRefs()

        Image(
            rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(item.image)
                    .size(Size.ORIGINAL)
                    .build()
            ),
            contentDescription = "Image cover",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .handlePropertyBorder(item.type)
                .clip(RoundedCornerShape(5.dp))
                .constrainAs(imageCover) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            contentScale = ContentScale.Crop
        )

        Text(
            text = item.area,
            modifier = Modifier.constrainAs(title) {
                top.linkTo(imageCover.bottom, 2.dp)
                start.linkTo(imageCover.start)
            },
            style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(mergeView) {
                    top.linkTo(title.bottom)
                    start.linkTo(title.start)
                }
        ) {
            if (item.type != PropertyType.Area.type)
                NoneAreaProperty(item)
            else if (item.type == PropertyType.Area.type)
                AreaProperty(item)
        }
    }*/


}

