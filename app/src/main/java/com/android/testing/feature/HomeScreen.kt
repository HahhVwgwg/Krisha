package com.android.testing.feature

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.android.testing.domain.models.BottomBarRoute.ANNOUNCEMENT
import com.android.testing.domain.models.BottomBarRoute.HOME
import com.android.testing.domain.models.BottomBarRoute.MESSAGES
import com.android.testing.domain.models.BottomBarRoute.PROFILE
import com.android.testing.domain.models.BottomBarRoute.USERS
import com.android.testing.feature.announcements.AnnouncementScreen
import com.android.testing.feature.profile.ProfileScreen

@Composable
fun Home() {
    var bottomBarRoute by rememberSaveable { mutableStateOf(HOME) }

    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier.background(Color.White)
    ) {
        when (bottomBarRoute) {
            HOME -> {
                AnnouncementScreen(modifier = Modifier.weight(1f))
            }
            USERS -> {
                AnnouncementScreen(modifier = Modifier.weight(1f))
            }
            MESSAGES -> {
                AnnouncementScreen(modifier = Modifier.weight(1f))
            }
            ANNOUNCEMENT -> {
                AnnouncementScreen(modifier = Modifier.weight(1f))
            }
            PROFILE -> {
                ProfileScreen(modifier = Modifier.weight(1f))
            }
        }
        BottomBarNav(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            currentRoute = bottomBarRoute
        ) {
            if (it != bottomBarRoute) {
                bottomBarRoute = it
            }
        }
    }
}