package com.sneakerups

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.adaptive.currentWindowSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.sneakerups.mainnav.bottom_nav_ui.BottomNav
import com.sneakerups.ui.theme.DebugTheme
import com.sneakerups.ui.theme.SneakerUpsTheme


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalLayoutApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val windowSizeClass = currentWindowSize()


            if(BuildConfig.FEATURE_ENABLED) {
                DebugTheme {
                    BottomNav()
                }
            } else {
                SneakerUpsTheme {
                    BottomNav()
                }
            }



//            if(windowSizeClass.width.pxToDp() >= 200.dp) {
//                BottomNav()
//            }
//
//            if(windowSizeClass.width.pxToDp() > 500.dp) {
//                BottomNavLandscape()
//            }



            }
        }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SneakerUpsTheme {
        BottomNav()
    }
}