package com.example.bottomnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradientShader
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bottomnavigation.ui.theme.BottomNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomNavigationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {



                }
            }
        }
    }
}

data class Items(val icon: ImageVector, val selectedIcon: ImageVector, val route: String)


val navItems = listOf<Items>(
    Items(Icons.Outlined.Home,
        Icons.Filled.Home,
        "home"),
    Items(Icons.Outlined.Search,
        Icons.Filled.Search,
        "search"),
    Items(Icons.Outlined.CameraAlt,
        Icons.Filled.CameraAlt,
        "search"),
    Items(Icons.Outlined.Notifications,
        Icons.Filled.Notifications,
        "search"),
    Items(Icons.Outlined.Person,
        Icons.Filled.Person,
        "search")

)

@Preview(showSystemUi = true)
@Composable
fun CustomBottomNav(modifier: Modifier = Modifier){
    var selected by remember {
        mutableStateOf(0)
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.DarkGray),
        verticalArrangement = Arrangement.Bottom) {

        BottomAppBar(
            modifier = modifier
                .fillMaxWidth()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black,

                            ),
                        startY = 0f,
                        endY = 150f

                    )
                ),
            containerColor = Color.Transparent
        ) {
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround) {


            navItems.forEachIndexed { index, items ->
                val isSelected = index == selected
//                NavigationBarItem(
//                    selected = index == selected,
//                    onClick = { selected = index },
//                    icon = {
//                        if (isSelected) {
//                            Icon(imageVector = items.selectedIcon, contentDescription = null)
//                        } else {
//                            Icon(imageVector = items.icon, contentDescription = null)
//                        }
//                    },
//                    colors = NavigationBarItemDefaults.colors(
//                        selectedIconColor = Color.White,
//                        unselectedIconColor = Color.LightGray,
//                        indicatorColor = Color.Transparent
//                    )
//                )
                CustomNavItem(
                    selected = isSelected,
                    onClick = { selected = index },
                    icon = items.icon,
                    selectedIcon = items.selectedIcon,
                    selectedIconColor = Color.White,
                    unSelectedIconColor = Color.LightGray
                )
            }
            }
        }
    }
}



@Composable
fun CustomNavItem(selected: Boolean,
                  onClick: ()->Unit,
                  icon: ImageVector,
                  selectedIcon: ImageVector,
                  selectedIconColor: Color,
                  unSelectedIconColor: Color,
                  modifier: Modifier = Modifier
                  ){
    IconButton(onClick = onClick, modifier = modifier) {
        if(selected){
            Icon(imageVector = selectedIcon, contentDescription = null,
                tint = selectedIconColor,
                modifier = Modifier.size(28.dp))
        }else{
            Icon(imageVector = icon, contentDescription = null,
                tint = unSelectedIconColor,
                modifier = Modifier.size(28.dp))
        }
    }
}



