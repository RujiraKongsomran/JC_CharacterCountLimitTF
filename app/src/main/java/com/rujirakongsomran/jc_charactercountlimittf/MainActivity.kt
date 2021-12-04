package com.rujirakongsomran.jc_charactercountlimittf

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.rujirakongsomran.jc_charactercountlimittf.ui.theme.JC_CharacterCountLimitTFTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JC_CharacterCountLimitTFTheme {
                MyComposable()
            }
        }
    }
}

@Composable
fun MyComposable() {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var name by remember { mutableStateOf("") }
        val maxChar = 10
        OutlinedTextField(
            value = name,
            onValueChange = {
                if (it.length < maxChar) {
                    Toast.makeText(
                        context,
                        "it: $it",
                        Toast.LENGTH_SHORT
                    ).show()
                    name = it
                }
            },
            label = {
                Text(text = "Name")
            },
            placeholder = {
                Text(text = "Enter your name")
            },
            maxLines = 1
        )

    }
}

@Preview
@Composable
fun MyComposablePreview() {
    JC_CharacterCountLimitTFTheme {
        MyComposable()
    }
}
