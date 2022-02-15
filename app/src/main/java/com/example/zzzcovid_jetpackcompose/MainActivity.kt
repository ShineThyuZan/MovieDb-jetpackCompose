package com.example.zzzcovid_jetpackcompose

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.zzzcovid_jetpackcompose.ui.theme.ZzzCovidjetpackComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZzzCovidjetpackComposeTheme {
                sampleRecyclerView()
            }
        }
    }
}

@Composable
fun sampleRecyclerView() {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
            .clip(shape = RoundedCornerShape(8.dp))
            .background(Color.White),
        contentPadding = PaddingValues(4.dp)
    ) {
        items(111) { it ->
            MessageCard(it.toString())
        }
    }
}

@Composable
fun MessageCard(msg: String) {

    // Add padding around our message
    Row(
        modifier = Modifier
            .border(0.5.dp, Color.White, RectangleShape)
            .padding(all = 8.dp)
            .fillMaxWidth()
            .height(70.dp)
            .clickable {
                Log.d("msg", msg)
            }) {
        Image(
            painter = painterResource(R.drawable.ic_upload),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                // Set image size to 40 dp
                .height(40.dp)
                // Clip image to be shaped as a circle
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )

        // Add a horizontal space between the image and the column
        Spacer(modifier = Modifier.height(16.dp))
        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = "Shine Thyu Zan",
                color = Color.Black,
                style = MaterialTheme.typography.body1
            )
            // Add a vertical space between the author and message texts
            Spacer(modifier = Modifier.height(4.dp))

           Surface(shape  = MaterialTheme.shapes.large, elevation = 1.dp) {
                Text(
                    text = msg,
                    modifier = Modifier.padding(all = 2.dp)
                        .clipToBounds()
                        .height(40.dp)
                        .width(150.dp)
                        .background(color = Color.White, shape = RectangleShape)
                        .fillMaxWidth()
                        .clickable {
                                   Log.d("msgmsg", msg)
                        },
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}


@Preview(name = "Light mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true,
    name = "No more dark mode"
)
@Composable
fun PreviewMessageCard() {

    ZzzCovidjetpackComposeTheme() {
        MessageCard(msg = "message")

    }

}

