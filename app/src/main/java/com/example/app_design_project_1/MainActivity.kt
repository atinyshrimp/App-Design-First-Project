package com.example.app_design_project_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
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
                        Spacer(modifier = Modifier.height(10.dp))
                        NavBar()
                        Spacer(modifier = Modifier.height(8.dp))
                        Greeting("Urvashi")
                        Spacer(modifier = Modifier.height(16.dp))
                        NavPills()
                        Spacer(modifier = Modifier.height(65.dp))
                        PlantGrid(plantList())
                    }
                }
            }
        }
    }
}


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
                Image(
                    painter = painterResource(id = R.drawable.notification_circle),
                    contentDescription = "notification_circle",
                    contentScale = ContentScale.None,
                    modifier = Modifier
                        .padding(1.dp)
                        .width(8.dp)
                        .height(8.dp)
                        .align(Alignment.TopEnd)
                )
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
                .fillMaxWidth()
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
                .fillMaxWidth()
                .height(23.dp)
        )
    }
}

@Composable
fun PlantCard(plant: Plant, imgModifier: Modifier) {
    val gradientBrush = Brush.linearGradient(
        colors = listOf(Color(0xFFD6ECCC), Color(0xFF9CED6B), Color(0xFF579133)),
        start = androidx.compose.ui.geometry.Offset(0f, 0f),
        end = androidx.compose.ui.geometry.Offset(0f, 75f)
    )

    Box (contentAlignment = Alignment.Center,
        modifier = Modifier.wrapContentHeight()) {
        Row (modifier = Modifier
            .shadow(
                elevation = 10.dp,
                spotColor = Color(0x26000000),
                ambientColor = Color(0x26000000)
            )
            .width(160.dp)
            .height(242.dp)
            .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 18.dp))
            .padding(start = 12.dp, top = 192.dp, end = 12.dp, bottom = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = stringResource(id = plant.stringResId),
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = lexend,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF304022)
                ),
                modifier = Modifier
                    .width(71.dp)
                    .height(30.dp)
            )
            //Spacer(modifier = Modifier.width(37.dp))
            Box(
                modifier = Modifier
                    .size(28.dp)
                    .clip(CircleShape)
                    .background(brush = gradientBrush)
            ){
                Icon(
                    imageVector = Icons.Rounded.ArrowForward,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier
                        .size(17.dp)
                        .align(Alignment.Center)
                )
            }

        }
        Image(
            modifier = imgModifier,
            painter = painterResource(id = plant.imageResId),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun NavPills() {
    var selectedTab by remember { mutableIntStateOf(0) }

    Box (modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 13.dp)
        .height(47.dp)
        .background(color = Color(0xFFE6FFD6), shape = RoundedCornerShape(size = 28.dp)),
        contentAlignment = Alignment.Center,
        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            NavItem("Houseplants", selectedTab == 0) { selectedTab = 0 }
            NavItem("Evergreen trees", selectedTab == 1) { selectedTab = 1 }
            NavItem("Palm Tree", selectedTab == 2) { selectedTab = 2 }
        }
    }

}

@Composable
fun NavItem(title: String, selected: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .selectable(
                selected = selected,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        if (selected) {
            Box(modifier = Modifier
                .shadow(
                    elevation = (-50).dp,
                    spotColor = Color(0x40000000),
                    ambientColor = Color(0x40000000)
                )
                .width(112.dp)
                .height(34.dp)
                .background(color = Color(0xFFF2F6EE), shape = RoundedCornerShape(size = 26.dp)))
        }
        Text(
            text = title,
            fontFamily = lexend,
            fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal,
            color = Color(0xFF394929),
        )
    }
}

//@Preview
@Composable
fun PreviewNavPills() {
    NavPills()
}

@Composable
fun PlantGrid(listOfPlants: List<Plant>) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 80.dp) // Adjust the value based on your desired spacing
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(56.dp),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()) {
            items(listOfPlants){ plant ->
                PlantCard(plant, plant.imageModifier)
            }
        }
    }

}

@Preview
@Composable
fun PlantGridPreview() {
    App_Design_Project_1Theme {
        PlantGrid(listOfPlants = plantList())
    }
}

fun plantList(): List<Plant> {
    return listOf(
        Plant(R.drawable.houseplant_peperomia_in_white_flowerpot,
            R.string.plant_1,
            Modifier
                .width(164.99998.dp)
                .height(240.89285.dp)
                .offset(y = (-60).dp)),
        Plant(R.drawable.houseplant_crassula_ovata_jade_plant_money_tree,
            R.string.plant_2,
            Modifier
                .width(181.14783.dp)
                .height(248.dp)
                .offset(y = (-60).dp)),
        Plant(R.drawable.houseplant_asplenium_nidus_in_white_pot,
            R.string.plant_1,
            Modifier
                .width(171.00002.dp)
                .height(234.10715.dp)
                .offset(y = (-55).dp)),
        Plant(R.drawable.houseplant_crassula_grey_pot,
            R.string.plant_2,
            Modifier
                //.shadow(elevation = 45.60000228881836.dp, spotColor = Color(0x40FFB39B), ambientColor = Color(0x40FFB39B))
                .width(228.dp)
                .height(250.dp)
                .offset(y = (-45).dp))
    )
}

/*
@Composable
fun GreetingsPreview(){
    App_Design_Project_1Theme {
        Greeting("Joyce")
    }
}
 */