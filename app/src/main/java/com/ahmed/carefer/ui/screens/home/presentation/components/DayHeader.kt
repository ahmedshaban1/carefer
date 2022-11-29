package com.ahmed.carefer.ui.screens.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ahmed.carefer.R
import com.ahmed.carefer.ui.theme.Purple80

@Composable
fun DayHeader(number: Int, isFavorite: Boolean, onFavoriteClicked: () -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .background(Purple80)
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = stringResource(R.string.day_number, number))

        IconButton(onClick = { onFavoriteClicked() }) {
            if (isFavorite) Icon(
                painterResource(id = R.drawable.ic_favorite_24),
                contentDescription = "",
                tint = Color.Red
            )
            else {
                Icon(
                    painterResource(id = R.drawable.ic_unfavorite),
                    contentDescription = "",
                )
            }
        }
    }
}