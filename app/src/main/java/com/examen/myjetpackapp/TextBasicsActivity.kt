package com.examen.myjetpackapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.examen.myjetpackapp.ui.theme.MyJetPackAppTheme

//https://www.jetpackcompose.net/text-in-compose
class TextBasicsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
         MyJetPackAppTheme {
             // A surface container using the 'background' color from the theme
            Surface (
                color = MaterialTheme.colorScheme.background){
                TextContainer()
            }
         }
        }
    }

    @Composable
    fun TextContainer(){
        Column {
            TextWithSize(label = "JetPack Compose", size = TextUnit.Unspecified)
            TextSize()
            BoldText()
            ItalicText()
            ItalicText()
            MaxLines()
            OverflowedText()
            SelectableText()
        }

    }
    @Composable
    fun TextWithSize(label:String, size:TextUnit){
        Text(label, fontSize = size, color = Color.Red)
    }
    @Composable
    fun TextSize(){
        Text("Text Color", color = Color.Blue)
    }
    @Composable
    fun BoldText(){
        Text("Bold Text", fontWeight = FontWeight.Bold)
    }
    @Composable
    fun ItalicText(){
        Text("Italic Bold", fontStyle = FontStyle.Italic)
    }
    @Composable
    fun MaxLines(){
        Text("Maximum number of lines,".repeat(6), maxLines = 2)
    }
    @Composable
    fun OverflowedText() {
        Text("Hello Compose ".repeat(50), maxLines = 2, overflow = TextOverflow.Ellipsis)
    }
    @Composable
    fun SelectableText() {
        SelectionContainer {
            Text("This text is selectable")
        }
    }
    val  redTextStyle = TextStyle(color = Color.Red,fontSize = 30.sp)
    @Preview( showBackground = true, showSystemUi = true)
    @Composable
    fun DefaultPreview() {
        Row {
            TextContainer()
        }
    }
}
