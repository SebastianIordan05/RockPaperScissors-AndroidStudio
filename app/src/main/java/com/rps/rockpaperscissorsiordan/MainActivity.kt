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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.text.font.FontStyle
import kotlin.random.Random
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width


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
    var selectedImgOpponent by remember { mutableIntStateOf(0) }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text (
            text = stringResource(id = R.string.title),
            fontWeight = FontWeight(800),
            fontStyle = FontStyle.Italic,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            textAlign = TextAlign.Center
        )
        Row (
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 5.dp),
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text = stringResource(id = R.string.YourChoice),
                modifier = Modifier.padding(horizontal = 10.dp)
            )
            Text(
                text = stringResource(id = R.string.opponentsChoice)
            )
        }
        Row {
            Image(
                painter = painterResource(id = getImageResourceId(selectedImg)),
                contentDescription = selectedImg,
                modifier = Modifier.size(100.dp).padding(10.dp)
            )
            Image(
                painter = painterResource(id = getOpponentsResourceId(selectedImgOpponent)),
                contentDescription = null,
                modifier = Modifier.size(100.dp).padding(10.dp)
            )
        }
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Button(onClick = {
                selectedImg = "rock"
                selectedImgOpponent = random()}) {
                Text(text = stringResource(id = R.string.rock))
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = {
                selectedImg = "paper"
                selectedImgOpponent = random()}) {
                Text(text = stringResource(id = R.string.paper))
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = {
                selectedImg = "scissors"
                selectedImgOpponent = random()}) {
                Text(text = stringResource(id = R.string.scissors))
            }
        }
    }
}

fun random(): Int {
    val random = Random.Default
    return random.nextInt(3) + 1
}

fun getOpponentsResourceId(game: Int): Int {
    return when (game) {
        1 -> R.drawable.rock
        2 -> R.drawable.paper
        3-> R.drawable.scissors
        else -> R.drawable.rock
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