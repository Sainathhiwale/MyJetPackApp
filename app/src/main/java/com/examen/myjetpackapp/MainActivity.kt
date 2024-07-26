package com.examen.myjetpackapp

import android.os.Bundle
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examen.myjetpackapp.ui.theme.MyJetPackAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyJetPackAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard(){
    var buttonClickedState = remember {
        mutableStateOf(false)
    }
    Surface( modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()){
       Card(modifier = Modifier
           .width(200.dp)
           .height(390.dp)
           .padding(12.dp),
           shape = RoundedCornerShape(corner = CornerSize(15.dp))) {
           Column (modifier = Modifier.height(300.dp),
               verticalArrangement = Arrangement.Top,
               horizontalAlignment = Alignment.CenterHorizontally){
               CreatedImageProfile()
               Divider()
               CreatedInfo()
               Button(onClick = {
                   buttonClickedState.value = !buttonClickedState.value
                   Log.d("MainActivity", "CreateBizCard: " + buttonClickedState.value)
               }) {
                   Text(text = "Portfolio",
                       style = MaterialTheme.typography.labelSmall)
               }
               if (buttonClickedState.value) {
                   Content(isVisible = buttonClickedState.value)
               } else {
                   Box {} // Empty box for when content is hidden
               }

           }

       }
   }
}


@Composable
fun Content(isVisible: Boolean) {
    Log.d("MainActivity", "Content: "+ isVisible)
   if (isVisible){
       Box(modifier = Modifier
           .fillMaxHeight()
           .fillMaxWidth()
           .padding(5.dp)){
           Surface (modifier = Modifier
               .padding(3.dp)
               .fillMaxWidth()
               .fillMaxHeight(),
               shape = RoundedCornerShape(corner = CornerSize(6.dp)),
               border = BorderStroke(width = 2.dp, color = Color.Red)){
               Portfolio(data = listOf("Project 1",
                   "Project 2",
                   "Project 3",
                   "Project 4",
                   "Project 5"))
           }
       }
   }

}

@Composable
fun Portfolio(data: List<String>) {
   LazyColumn{
       items(data){item ->
         Card(modifier = Modifier
             .padding(13.dp)
             .fillMaxHeight(),
             shape = RectangleShape) {
             Row (modifier = Modifier
                 .padding(8.dp)
                 .background(MaterialTheme.colorScheme.surface)
                 .padding(16.dp)){
                 CreatedImageProfile(modifier = Modifier.size(100.dp))
                 Text(item)
             }
         }
       }
   }
}



@Composable
private fun CreatedInfo() {
    Column(
        modifier = Modifier.padding(5.dp)
    ) {
        Text(
            text = "Sainath Hiwale",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Android Compose Programmer",
            modifier = Modifier.padding(3.dp)
        )
        Text(
            text = "@SainathHiwale",
            modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.displaySmall
        )
    }
}

@Composable
private fun CreatedImageProfile(modifier: Modifier=Modifier) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        shadowElevation = 4.dp,
        color = MaterialTheme.colorScheme.onSecondary.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.baseline_person_24),
            contentDescription = "profile image",
            modifier = Modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyJetPackAppTheme {
        CreateBizCard()
    }
}