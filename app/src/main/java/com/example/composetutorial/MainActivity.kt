package com.example.composetutorial

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.remember
import androidx.compose.runtime.Composable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import com.example.composetutorial.ui.theme.ComposeTutorialTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        var hello by mutableStateOf("aaa")
        var show by mutableStateOf(false)

        var text by mutableStateOf("hello")
        setContent {

            Column {
                if (show){
                    Text(text = "Android Compose")
                }
                Text(text = text)
                Button(onClick = {
                    show = true
                    text = "compose"
                }) {

                }

            }

//            test1()
//            TestComposeScope()

            ComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
//                    NewStory()
                }
            }

        }


    }


    @Composable
    fun test1() {

        var name by remember {
            mutableStateOf("hello")
        }
//        Text(text = name)

        Log.d(TAG, "1111111")
        Column {
            Button(onClick = {}) {
                name = ""
            }
            wrapper {
                Text(text = name, Modifier.padding())
            }

        }

        lifecycleScope.launch {
            delay(2000)
            name = "" + System.currentTimeMillis()
            Log.d(TAG, "2222222")
//            name = "chenqiao"

        }
    }

    @Composable
    fun TestComposeScope(){

        var show by mutableStateOf(false)

        var text by mutableStateOf("hello")
        Column {
            if (show){
                Text(text = "Android Compose")
            }
            Text(text = text)
            Button(onClick = {
                show = true
                text = "compose"
            }) {

            }
            
        }


        lifecycleScope.launch {
            delay(3000)
            show = true
            text = "compose"
        }

    }


    @Preview
    @Composable
    fun TestModifier() {

        Text(text = "hello", modifier = Modifier
            .clickable {
                Toast
                    .makeText(this@MainActivity, "000", Toast.LENGTH_SHORT)
                    .show()
            }
            .padding(15.dp)
            .background(Color.Red)
            .clickable {
                Toast
                    .makeText(this@MainActivity, "111", Toast.LENGTH_SHORT)
                    .show()
            }
            .padding(10.dp)
            .background(Color.Blue)
            .clickable {
                Toast
                    .makeText(this@MainActivity, "222", Toast.LENGTH_SHORT)
                    .show()
            }
        )
    }

    @Composable
    fun wrapper(block: @Composable () -> Unit) {
        block()
    }

}

