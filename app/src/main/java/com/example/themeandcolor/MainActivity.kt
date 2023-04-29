@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.themeandcolor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.themeandcolor.ui.theme.ThemeAndColorTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isDark by remember {
                mutableStateOf(false)
            }
            ThemeAndColorTheme(
                darkTheme = isDark
            ) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen(isDark) {
                        isDark = !isDark
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreen(
    isDark: Boolean = false,
    onChangeTheme: () -> Unit = {},
) {
    Scaffold(topBar = {
        TopAppBar(title = {
            Text(text = "Theme demo")
        })
    }, content = { it ->
        ContentHome(paddingValue = it, isDark = isDark, onChangeTheme = onChangeTheme)
    })

}

@Composable
fun ContentHome(
    isDark: Boolean = false,
    onChangeTheme: () -> Unit = {},
    paddingValue: PaddingValues = PaddingValues(
        0.dp
    ),
) {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Column() {
            Surface(
                color = MaterialTheme.colorScheme.surface,
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(horizontal = 12.dp, vertical = 9.dp)
                        .size(200.dp)
                ) {
                    Text(text = "Demo")
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Text(text = "Change theme ")
                Switch(checked = isDark, onCheckedChange = {
                    onChangeTheme()
                })
            }
        }
    }
}

@Composable
@Preview(
    showSystemUi = true, device = "spec:width=411dp,height=891dp",
)
fun PrevHomeScreen() {
    ThemeAndColorTheme(
    ) {
        HomeScreen()
    }
}

