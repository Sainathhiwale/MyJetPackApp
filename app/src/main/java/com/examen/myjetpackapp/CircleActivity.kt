package com.examen.myjetpackapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examen.myjetpackapp.ui.theme.ui.theme.MyJetPackAppTheme

class CircleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyJetPackAppTheme {
             MyApp()
            }
        }
    }
}

@Preview
@Composable
fun CreateCircle(){
    Card (modifier = Modifier
        .padding(10.dp)
        .size(45.dp)
        .clickable {
            Log.d("Tap", "CreateCircle:Tap ")
        }
        ,
        shape = CircleShape
        ) {
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
            Text(
                text = "Tap",
                modifier = Modifier.fillMaxWidth(), // Add this
                textAlign = TextAlign.Center
            // Add this
            )
        }
    }
}

@Composable
fun MyApp(){
    Surface(modifier =
    Modifier.fillMaxHeight()
        .fillMaxWidth(),
        color = MaterialTheme.colorScheme.primary) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "JetPack Compose")
            CreateCircle()
        }

    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyJetPackAppTheme {

            MyApp()


    }
}