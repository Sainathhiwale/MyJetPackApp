package com.examen.myjetpackapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//https://www.jetpackcompose.net/compose-layout-row-and-column

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            simpleRow()
            simpleColumn()
        }
    }

    @Preview
    @Composable
    private fun simpleColumn() {
       Column(modifier = Modifier.fillMaxHeight().fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment  =  Alignment.CenterHorizontally
        ) {
            Text(text ="Column Text 1", Modifier.background(Color.Red))
            Text(text ="Column Text 2", Modifier.background(Color.Red))
            Text(text ="Column Text 2", Modifier.background(Color.Red))
        }
    }

    @Preview
    @Composable
    fun simpleRow(){
        Row(Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceEvenly) {
            Text(text ="Row Text 1", Modifier.background(Color.Blue))
            Text(text ="Row Text 2", Modifier.background(Color.Blue))
            Text(text ="Row Text 2", Modifier.background(Color.Blue))
        }
    }


}

