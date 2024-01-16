package com.example.app_design_project_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app_design_project_1.ui.theme.App_Design_Project_1Theme
import com.example.app_design_project_1.ui.theme.lexend

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App_Design_Project_1Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Column {
                        NavBar()
                        Spacer(modifier = Modifier.height(8.dp))
                        Greeting("")
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun NavBar() {

    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically)
    {
        Image(painter = painterResource(id = R.drawable.peperomia_obtusfolia),
            contentDescription = "home-plant",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(43.76699.dp)
                .height(56.dp))
        Row (modifier = Modifier.wrapContentWidth())
        {
            Box {
                Image(painter = painterResource(id = R.drawable._6_notification),
                    contentDescription = "Home plant")
                Icons.Filled.Info
            }

            Spacer(modifier = Modifier.width(15.dp))
            Image(painter = painterResource(id = R.drawable._4_setting),
                contentDescription = "Setting icon",
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp))
        }
    }
}


@Composable
fun Greeting(name: String) {
    Column (horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp)) {
        Text(
            text = "Hey $name",
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = lexend,
                fontWeight = FontWeight(500),
                color = Color(0xFF91A37F),
                textAlign = TextAlign.Start,
            ),
            modifier = Modifier
                .width(84.dp)
                .height(18.dp)
        )
        Text(
            text = "Help Us To Save Our Mother Earth",
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = lexend,
                fontWeight = FontWeight(600),
                color = Color(0xFF394929),
                textAlign = TextAlign.Start
            ),
            modifier = Modifier
                .width(307.dp)
                .height(23.dp)
        )
    }
}

@Preview
@Composable
fun GreetingsPreview(){
    App_Design_Project_1Theme {
        Greeting("Joyce")
    }
}