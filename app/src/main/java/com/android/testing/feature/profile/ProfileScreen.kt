package com.android.testing.feature.profile

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.testing.R
import com.android.testing.feature.common.RatingBar
import com.android.testing.ui.theme.MainColor

@Composable
fun ProfileScreen(modifier: Modifier) {
    val user = generateUserData()
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(33.dp))
        Box(
            modifier = Modifier
                .size(130.dp)
                .background(color = Color.Gray, shape = RoundedCornerShape(10.dp))
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(text = user.name, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = user.age)

        Spacer(modifier = Modifier.height(8.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_social),
            contentDescription = "",
            Modifier
                .height(40.dp)
                .width(150.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .background(
                    color = MainColor,
                    shape = RoundedCornerShape(10.dp)
                )
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            items(user.comments) {
                CommentItem(it)
            }
        }
    }
}

@Composable
fun CommentItem(it: Comment) {
    Column {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_radio),
                contentDescription = "",
                Modifier.size(12.dp)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            ) {
                Text(text = it.comment, color = Color.White, fontSize = 12.sp)
                Spacer(modifier = Modifier.height(2.dp))
                Text(text = it.date, color = Color.White, fontSize = 12.sp)
            }

            RatingBar(
                modifier = Modifier.wrapContentWidth(),
                rating = it.rating,
                stars = 5,
                starsColor = Color.Yellow
            )
        }
        Divider()
    }
}

fun generateUserData() = User(
    name = "John Doe",
    age = "25",
    address = "123 Main St, San Francisco, CA 94122",
    comments = listOf(
        Comment(
            comment = "This is a comment",
            date = "12/12/2020",
            rating = 4.5
        ),
        Comment(
            comment = "This is a comment",
            date = "12/12/2020",
            rating = 4.5
        ),
        Comment(
            comment = "This is a comment",
            date = "12/12/2020",
            rating = 4.5
        ),
        Comment(
            comment = "This is a comment",
            date = "12/12/2020",
            rating = 4.5
        )
    )
)

data class User(
    val name: String,
    val age: String,
    val address: String,
    val comments: List<Comment>
)

data class Comment(
    val comment: String,
    val date: String,
    val rating: Double
)