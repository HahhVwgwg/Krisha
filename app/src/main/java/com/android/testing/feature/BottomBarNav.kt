package com.android.testing.feature

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.android.testing.R
import com.android.testing.domain.models.BottomBarRoute
import com.android.testing.domain.models.BottomNavData
import com.android.testing.ui.theme.MainColor

@Composable
fun BottomBarNav(
    modifier: Modifier = Modifier,
    currentRoute: BottomBarRoute,
    onRouteChange: (bottomRoute: BottomBarRoute) -> Unit
) {
    val items = listOf(
        BottomNavData(R.drawable.ic_home, BottomBarRoute.HOME),
        BottomNavData(R.drawable.ic_users, BottomBarRoute.USERS),
        BottomNavData(R.drawable.ic_message_more, BottomBarRoute.MESSAGES),
        BottomNavData(R.drawable.ic_calendar_week, BottomBarRoute.ANNOUNCEMENT),
        BottomNavData(R.drawable.ic_profile, BottomBarRoute.PROFILE),
    )
    BottomNavigation(
        backgroundColor = MainColor,
        elevation = 10.dp,
        modifier = modifier.padding(top = 1.dp)
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                selected = currentRoute == item.route,
                unselectedContentColor = Color.White,
                selectedContentColor = Color.White,
                icon = {
                    Icon(
                        modifier = Modifier.padding(4.dp),
                        painter = painterResource(id = item.imageResource),
                        contentDescription = null,
                        tint = Color.White
                    )
                },
                label = {

                },
                onClick = {
                    onRouteChange.invoke(item.route)
                })
        }
    }
}
