package com.android.testing.feature.announcements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.android.testing.R
import com.android.testing.ui.theme.MainColor

@Composable
fun AnnouncementScreen(modifier: Modifier = Modifier) {

    Column(modifier = modifier) {
        Row(
            modifier = Modifier
                .height(56.dp)
                .background(MainColor)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_setting),
                tint = Color.White,
                contentDescription = "",
                modifier = Modifier.padding(end = 16.dp)
            )
        }

        LazyColumn {
            items(
                getSampleAnnouncements()
            ) {
                AnnouncementItem(it)
            }
        }
    }
}

@Composable
fun AnnouncementItem(announcement: AnnouncementApiModel) {
    Column {
        Divider()
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(color = Color.Gray, shape = RoundedCornerShape(8.dp))
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            ) {
                Text(announcement.title,
                    fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Text(announcement.address)
                Spacer(modifier = Modifier.height(8.dp))
                Text(announcement.rating)
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_book),
                contentDescription = "",
                modifier = Modifier
                    .padding(start = 16.dp)
                    .wrapContentWidth()
            )
        }
    }
}

data class AnnouncementApiModel(
    val title: String,
    val address: String,
    val rating: String,
    val isFavorite: Boolean,
    val image: String
)

fun getSampleAnnouncements() = listOf(
    AnnouncementApiModel(
        title = "Продам 2-комнатную квартиру, 60 м², 2/5 эт.",
        address = "Алматы, Алатауский р-н",
        rating = "4.5",
        isFavorite = true,
        image = "https://krisha.kz/static/images/placeholder.png"
    ),
    AnnouncementApiModel(
        title = "Продам 2-комнатную квартиру, 60 м², 2/5 эт.",
        address = "Алматы, Алатауский р-н",
        rating = "4.5",
        isFavorite = true,
        image = "https://krisha.kz/static/images/placeholder.png"
    ),
    AnnouncementApiModel(
        title = "Продам 2-комнатную квартиру, 60 м², 2/5 эт.",
        address = "Алматы, Алатауский р-н",
        rating = "4.5",
        isFavorite = true,
        image = "https://krisha.kz/static/images/placeholder.png"
    ),
    AnnouncementApiModel(
        title = "Продам 2-комнатную квартиру, 60 м², 2/5 эт.",
        address = "Алматы, Алатауский р-н",
        rating = "4.5",
        isFavorite = true,
        image = "https://krisha.kz/static/images/placeholder.png"
    ),
    AnnouncementApiModel(
        title = "Продам 2-комнатную квартиру, 60 м², 2/5 эт.",
        address = "Алматы, Алатауский р-н",
        rating = "4.5",
        isFavorite = true,
        image = "https://krisha.kz/static/images/placeholder.png"
    )
)