package com.example.gmail_clone

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.gmail_clone.components.HomeAppBar
import com.example.gmail_clone.ui.theme.Gmail_CloneTheme
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.gmail_clone.components.GmailDrawerMenu
import com.example.gmail_clone.components.GmailFab
import com.example.gmail_clone.components.HomeButtonMenu
import com.example.gmail_clone.components.MailList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Gmail_CloneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GmailApp()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GmailApp() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val scrollState= rememberScrollState()
    val openDialog= remember {
        mutableStateOf(false)
    }
    ModalNavigationDrawer(

        drawerState = drawerState,
        drawerContent = {
            GmailDrawerMenu(scrollState)
        }
    ) {
        Scaffold(
            //  scaffoldState = scaffoldState,
            topBar = { HomeAppBar(drawerState, coroutineScope, openDialog) },
            bottomBar = {HomeButtonMenu()},
            floatingActionButton = {GmailFab(scrollState)}

            ) {paddingValues ->///pentru a preveni randarea sub si dupa topBar
          MailList(paddingValues = paddingValues,scrollState )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Gmail_CloneTheme {
        GmailApp()
    }
}