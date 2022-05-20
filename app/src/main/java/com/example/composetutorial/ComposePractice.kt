package com.example.composetutorial

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.chrisbanes.accompanist.coil.CoilImage

@Preview
@Composable
fun prev() {
    test()
}

@Composable
fun test() {

//    CoilImage(data = "https://www.baidu.com/s?wd=%E5%BB%BA%E5%85%9A%E7%99%BE%E5%B9%B4&sa=ire_dl_gh_logo_texing&rsv_dl=igh_logo_pc", contentDescription = "")

//    Column(){
//        Text(text = "aaa")
//        Image(painter = painterResource(id = R.drawable.header), contentDescription = "")
//    }

    Row {
        Text(text = "aaa",
            modifier = Modifier
                .clickable {
                    Log.i("chenqiao", "aaaaa")
                }
                .padding(10.dp)
                .clickable {
                    Log.i("chenqiao", "bbbb")
                }
                .background(Color.Blue)
                .padding(10.dp)
                .clickable {
                    Log.i("chenqiao", "ccc")
                },
            color = Color.White
        )

        Button(onClick = { /*TODO*/ }) {

        }
        Image(
            painter = painterResource(id = R.drawable.header),
            modifier = Modifier
                .width(100.dp)
                .height(120.dp),
            contentDescription = ""
        )
    }

}