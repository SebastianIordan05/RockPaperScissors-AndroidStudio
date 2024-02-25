package com.rps.rockpaperscissorsiordan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rps.rockpaperscissorsiordan.ui.theme.RockPaperScissorsIordanTheme
import androidx.compose.foundation.layout.fillMaxWidth


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RockPaperScissorsIordanTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Layout()
                }
            }
        }
    }
}

@Composable
fun Layout() {
    var selectedImg by remember { mutableStateOf("") }
    var selectedImgOpponent by remember { mutableStateOf("") }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)
    ) {
        Text (
            text = stringResource(id = R.string.title),
            fontWeight = FontWeight(800)
        )

        Row {
            Column {
                Text(
                    text = stringResource(id = R.string.YourChoice)
                )
                Image(
                    painter = painterResource(id = getImageResourceId(selectedImg)),
                    contentDescription = selectedImg,
                    modifier = Modifier.size(100.dp)
                )
            }
            Column {
                Text(
                    text = stringResource(id = R.string.opponentsChoice)
                )
                Image(
                    painter = painterResource(id = getImageResourceId(selectedImgOpponent)),
                    contentDescription = selectedImgOpponent,
                    modifier = Modifier.size(100.dp)
                )
            }
        }

        Text(
            text = stringResource(id = R.string.yourButtons)
        )

        Row (
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { selectedImg = "rock" }) {
                Text(text = stringResource(id = R.string.rock))
            }
            Button(onClick = { selectedImg = "paper" }) {
                Text(text = stringResource(id = R.string.paper))
            }
            Button(onClick = { selectedImg = "scissors" }) {
                Text(text = stringResource(id = R.string.scissors))
            }
        }

        Text(
            text = stringResource(id = R.string.opponentsButtons)
        )

        Row (
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { selectedImgOpponent = "rock" }) {
                Text(text = stringResource(id = R.string.rock))
            }
            Button(onClick = { selectedImgOpponent = "paper" }) {
                Text(text = stringResource(id = R.string.paper))
            }
            Button(onClick = { selectedImgOpponent = "scissors" }) {
                Text(text = stringResource(id = R.string.scissors))
            }
        }
    }
}

fun getImageResourceId(game: String): Int {
    return when (game) {
        "rock" -> R.drawable.rock
        "paper" -> R.drawable.paper
        "scissors" -> R.drawable.scissors
        else -> R.drawable.rock
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RockPaperScissorsIordanTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth(),
            color = MaterialTheme.colorScheme.background
        ) {
            Layout()
        }
    }
}