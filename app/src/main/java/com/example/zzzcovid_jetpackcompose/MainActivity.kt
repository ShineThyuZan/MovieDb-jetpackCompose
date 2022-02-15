package com.example.zzzcovid_jetpackcompose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.zzzcovid_jetpackcompose.ui.theme.ZzzCovidjetpackComposeTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZzzCovidjetpackComposeTheme() {
                MessageCard( Message("I m from Venus", "Mr Bean"))
            }
        }
    }
}

data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message) {

        // Add padding around our message
        Row(
            modifier = Modifier
                .padding(all = 8.dp)) {
            Image(
                painter = painterResource(R.drawable.ic_upload),
                contentDescription = "Contact profile picture",
                modifier = androidx.compose.ui.Modifier
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
                Text(text = msg.author,
                color = MaterialTheme.colors.error,
                style = MaterialTheme.typography.h5)
                // Add a vertical space between the author and message texts
                Spacer(modifier = Modifier.height(4.dp))

                Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                    Text(
                        text = msg.body,
                        modifier = Modifier.padding(all = 4.dp),
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
        MessageCard( Message("I m from Venus", "Mr Bean"))

    }

}