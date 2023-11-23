package com.android.testing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.android.testing.feature.Home
import com.android.testing.ui.theme.KrishaTheme
import com.android.testing.ui.theme.MainColor
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KrishaTheme {
                val systemUiController = rememberSystemUiController()

                systemUiController.setStatusBarColor(
                    color = MainColor
                )
                systemUiController.setNavigationBarColor(
                    color = MainColor
                )
                Home()
            }
        }
    }
}