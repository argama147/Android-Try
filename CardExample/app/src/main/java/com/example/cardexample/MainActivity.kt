package com.example.cardexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cardexample.ui.theme.CardExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CardExampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FullScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun FullScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        CardMinimalExample()
        Spacer(
            modifier = Modifier
                .height(10.dp)
                .width(30.dp)
        )
        FilledCardExample()
        Spacer(
            modifier = Modifier
                .height(10.dp)
                .width(30.dp)
        )
        ElevatedCardExample()
        Spacer(
            modifier = Modifier
                .height(10.dp)
                .width(30.dp)
        )
        OutlinedCardExample()
    }
}

@Composable
fun CardMinimalExample() {
    Card {
        Text(text = "Hello, world!")
    }
}

@Composable
fun FilledCardExample() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier.size(width = 240.dp, height = 100.dp)
    ) {
        Text(
            text = "Filled",
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun ElevatedCardExample() {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .size(width = 240.dp, height = 100.dp)
    ) {
        Text(
            text = "Elevated",
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun OutlinedCardExample() {
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        border = BorderStroke(1.dp, Color.Black),
        modifier = Modifier
            .size(width = 240.dp, height = 100.dp)
    ) {
        Text(
            text = "Outlined",
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFullScreen() {
    CardExampleTheme {
        FullScreen()
    }
}

@Preview
@Composable
fun PreviewCardExampleTheme() {
    CardExampleTheme {
        CardMinimalExample()
    }
}

@Preview
@Composable
fun PreviewFilledCardExample() {
    CardExampleTheme {
        FilledCardExample()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewElevatedCardExample() {
    CardExampleTheme {
        ElevatedCardExample()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOutlinedCardExample() {
    OutlinedCardExample()
}