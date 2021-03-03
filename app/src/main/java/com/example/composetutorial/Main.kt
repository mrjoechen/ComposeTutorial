package com.example.composetutorial

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun NewStory() {

    val image = ImageBitmap.imageResource(R.drawable.header)

    Column(
        modifier = Modifier.padding(10.dp)
    ) {
        val modifier = Modifier.wrapContentHeight()
            .clip(shape = RoundedCornerShape(5.dp))
        Image(image, "", modifier = modifier, contentScale = ContentScale.FillWidth)

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Android", fontStyle = FontStyle.Italic, fontSize = 30.sp)

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Jetpack", fontSize = 20.sp)

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Compose")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTutorialTheme {
        Column {
            Greeting("Compose")
            NewStory()
        }

    }
}