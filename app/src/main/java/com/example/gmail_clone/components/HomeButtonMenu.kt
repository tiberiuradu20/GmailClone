package com.example.gmail_clone.components

import androidx.compose.foundation.background
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.gmail_clone.model.ButtonMenuData
@Composable
fun HomeButtonMenu(){
    val items=listOf(ButtonMenuData.Mail,ButtonMenuData.Meet)
   NavigationBar(
       modifier=Modifier.background(Color.White), contentColor =Color.Black
   ){
     items.forEach {
         NavigationBarItem(
             label = {Text(text=it.title)},
             alwaysShowLabel = true,
             selected =false , onClick = {  },
             icon = { Icon(imageVector=it.icon,contentDescription = it.title)})



     }
    }
}