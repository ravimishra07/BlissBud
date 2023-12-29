package com.ravi.blissbud

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ravi.blissbud.ui.theme.BlissBudTheme
import com.ravi.blissbud.ui.theme.ColorUtil

class OnBoardingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlissBudTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp, 0.dp, 16.dp, 0.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier,
        ) {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                ColorUtil.green400, ColorUtil.green600)
                        ), shape = ButtonDefaults.elevatedShape
                    )
                    .height(ButtonDefaults.MinHeight),
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Text(
                    "Button content", color = if (isSystemInDarkTheme()) {
                       ColorUtil.textColorDarkMode
                    } else {
                        ColorUtil.textColorLightMode
                    }
                )
            }

            val context = LocalContext.current

            Text(
                text = "Sign In",
                color = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier
                    .padding(0.dp, 16.dp, 0.dp, 12.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}


@Composable
fun BlissButton(name: String, modifier: Modifier = Modifier, onClick: () -> Unit) {

    Button(
        onClick = onClick, modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.primary)
            .height(42.dp)

    ) {
        Text(
            text = name,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun GreetingPreview2() {
    BlissBudTheme {
        MyApp()
    }
}