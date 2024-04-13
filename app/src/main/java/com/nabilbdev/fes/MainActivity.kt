package com.nabilbdev.fes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.nabilbdev.fes.ui.FesApp
import com.nabilbdev.fes.ui.theme.FesTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FesTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorScheme.background
                ) {
                    val windowSize = calculateWindowSizeClass(activity = this)
                    FesApp(
                        windowSize = windowSize.widthSizeClass
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FesAppCompactPreview() {
    FesTheme {
        FesApp(
            windowSize = WindowWidthSizeClass.Compact
        )
    }
}

@Preview(device = Devices.FOLDABLE, showSystemUi = true)
@Composable
fun FesAppMediumPreview() {
    FesTheme {
        FesApp(
            windowSize = WindowWidthSizeClass.Medium
        )
    }
}

@Preview(device = Devices.DESKTOP, showSystemUi = true)
@Composable
fun FesAppExpandedPreview() {
    FesTheme {
        FesApp(
            windowSize = WindowWidthSizeClass.Expanded
        )
    }
}