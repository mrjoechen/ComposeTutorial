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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
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

        setContent {

            var name by remember {
                mutableStateOf("Classin")
            }

//            Column {
//                Log.d(TAG, "111111")
//                Text("hello, $name")
//                Wrapper {
//                    Text("hello, $name")
//                    Log.d(TAG, "22222")
//                }
//                Log.d(TAG, "33333")
//
//                lifecycleScope.launch {
//                    delay(2000)
//                    name = "Android ${System.currentTimeMillis()}"
//                }
//            }

//            Test3()
//            TestComposeScope()
            ChangeRef()

        }

    }



    suspend fun suspengFunction(){
        delay(1000)
    }


    @Composable
    fun Test1(){
        Column {
            var name by remember {
                mutableStateOf("hello")
            }
            Text(text = name)
            Log.d(TAG, "test")
            Button(onClick = { name = "compose" }) {
//                Text(text = name)
            }
        }
    }



    @Composable
    fun Test2() {

        var name by remember {
            mutableStateOf("Classin")
        }

        var show by mutableStateOf(false)

        Column {
            Text("hello, $name")
            Log.d(TAG, "111111")

            if (show){
                Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "")
                Log.d(TAG, "2222")
            }

            Button(onClick = {
                name = "Android"
                show = !show
            }) {
                Text(text = "变")
                Log.d(TAG, "333")

            }
        }

    }


    @Composable
    fun Test3() {

        var name by remember {
            mutableStateOf("hello")
        }
//        Text(text = name)

        Log.d(TAG, "111111")
        Column {

            Log.d(TAG, "222222")

            Button(onClick = {}) {
//                name = ""
//                Text(text = name, Modifier.padding())
                Log.d(TAG, "333333")
            }

            Box {
                Log.d(TAG, "444444")
            }

            Text(text = name, Modifier.padding())

            Wrapper {
                Wrapper {
                    Text(text = name, Modifier.padding())
                    Log.d(TAG, "66666")
                }


            }

        }

        lifecycleScope.launch {
            delay(2000)
            name = "" + System.currentTimeMillis()
            Log.d(TAG, "000000")
//            name = "chenqiao"

        }
    }

    @Composable
    fun TestComposeScope() {

        var show by remember { mutableStateOf(false) }

        var text by mutableStateOf("hello")
        Column {
            if (show) {
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
    fun Wrapper(block: @Composable () -> Unit) {
        block()
    }


    @Composable
    fun TestList(){

        Column {
            var count by remember { mutableStateOf(mutableListOf(1, 2, 3)) }
            Button(onClick = {

                count.add(count.last() + 1)

//                count = count.toMutableList().apply {
//                    add(count.last() + 1)
//                }
                Log.d(TAG, "last value : ${count.last()}")
            }){
                Text("add")
            }

            for (i in count) {
                Text(text = "$i")
            }
        }
    }


    var user = User("haha")

    @Composable
    fun ChangeRef(){

        var text by  remember {
            mutableStateOf("123")
        }

        Column{

            Text(text)
            Button(onClick = {
                // text 改变引发的 recompose 导致 TestUser 重复调用，TestUser 方法是否会重复执行取决于 val/var
                val currentTimeMillis = System.currentTimeMillis()
                text = ""+currentTimeMillis
                user = User("haha")
            }) {
                Text(text = "changeUser")
            }
            TestUser(user)
        }

    }


    @Composable
    fun TestUser(user: User){
        Text(user.name)
        Log.d(TAG, "user.name : ${user.name}")
    }

}

