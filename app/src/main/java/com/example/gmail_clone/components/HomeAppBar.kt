package com.example.gmail_clone.components
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap ///important pentru Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gmail_clone.GmailApp
import com.example.gmail_clone.R
import com.example.gmail_clone.ui.theme.Gmail_CloneTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun HomeAppBar(drawerState: DrawerState,coroutineScope: CoroutineScope,
               openDialog:MutableState<Boolean>) {
    //val coroutineScope = rememberCoroutineScope()

    Box(modifier=Modifier.padding(10.dp)){
        Card(shape= RoundedCornerShape(10.dp),
            elevation= CardDefaults.cardElevation(6.dp),
            modifier = Modifier.requiredHeight(50.dp),
            colors=CardDefaults.cardColors(Color.White)
        ){
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)){
                IconButton(onClick = {

                    coroutineScope.launch {
                        if (drawerState.isClosed) {
                            drawerState.open() // Deschide drawer-ul
                        } else {
                            drawerState.close() // Închide drawer-ul
                        }
                    }
                }){
                    Icon(Icons.Default.Menu,"Menu")
                }

                Text(text="Search in emails", modifier=Modifier.weight(2.0f))
                Image(painter= painterResource(id = R.drawable.motivatie),
                    contentDescription = "Motivatie",
                    modifier= Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .background(color = Color.Gray)
                        .clickable {
                            openDialog.value = true
                        },

                    )
                if(openDialog.value){
                    AccountsDialog(openDialog = openDialog)
                }
            }
        }
    }
}
@Preview
@Composable
fun DefaultPreview(){
    Gmail_CloneTheme() {
        GmailApp()
    }
}