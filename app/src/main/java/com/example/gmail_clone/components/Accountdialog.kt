package com.example.gmail_clone.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.PersonAddAlt
import androidx.compose.material.icons.outlined.ManageAccounts
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.gmail_clone.R
import com.example.gmail_clone.accountList
import com.example.gmail_clone.model.Account

@Composable
fun AccountsDialog(openDialog: MutableState<Boolean>){
    Dialog(onDismissRequest={openDialog.value=false},
        properties= DialogProperties(dismissOnClickOutside = false)
    ){
        accountsDialogUI(openDialog=openDialog)
    }

}
@Composable
fun accountsDialogUI(modifier:Modifier=Modifier,openDialog: MutableState<Boolean>){
    Card {
        Column(modifier= Modifier
            .background(Color.White)
            .padding(bottom = 16.dp)){
            Row(modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically){
                IconButton(onClick = {
                    openDialog.value=false
                }) {
                    Icon(imageVector = Icons.Default.Close,
                        contentDescription = "Descriere")
                }
                Image(painter= painterResource(id = R.drawable.google),contentDescription = null,
                    modifier
                        .size(30.dp)
                        .weight(2.0f))
            }
          accountItem(account = accountList[0])
            Row(modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly){
                Card(modifier.requiredWidth(150.dp), shape= RoundedCornerShape(15.dp),
                    border= BorderStroke(1.dp, Color.DarkGray),
                    colors= CardDefaults.cardColors(Color.White)
                ){
                    Text(text="Google Account",
                        modifier.padding(8.dp),
                        textAlign= TextAlign.Center)
                }
                Spacer(modifier.width(10.dp))
            }
            HorizontalDivider(modifier.padding(top=16.dp))
            Column {
                accountItem(accountList[1])
                accountItem(accountList[2])
            }
            addAcount(icon = Icons.Default.PersonAddAlt, title ="Add another account" )
            addAcount(icon = Icons.Outlined.ManageAccounts, title ="Manange Accounts on this Device" )
            HorizontalDivider(modifier.padding(top=16.dp,bottom=16.dp))
            Row(modifier=Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly){
                Text(text="Privacy Policy")
                Card(modifier=Modifier.padding(top=10.dp)
                    .size(5.01.dp),
                    shape= CircleShape,
                    colors = CardDefaults.cardColors(Color.Black)
                ) {}
                Text(text="Terms of Service")
            }





        }

    }
}
@Composable
fun accountItem(account:Account) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 10.dp)
    ) {
        if (account.icon != null) {
            Image(
                painter = painterResource(id = account.icon), contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
                    .background(color = Color.Gray)
            )
        } else {
            Card(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .clip(CircleShape)
                    .size(40.dp),
                colors = CardDefaults.cardColors(Color.Gray),
            ) {
                Text(
                    text = account.userName[0].toString(),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                )
            }
        }
            Column(
                modifier = Modifier
                    .weight(2.0f)
                    .padding(start = 16.dp, bottom = 10.dp)
            ) {
                Text(text = account.userName, fontWeight = FontWeight.SemiBold)
                Text(text = account.email)
            }
            Text(text = "${account.unReadMails}+", modifier = Modifier.padding(end = 16.dp))

        }
}
@Composable
fun addAcount(icon:ImageVector,title:String){
    Row(modifier= Modifier
        .fillMaxWidth()
        .padding(start = 16.dp)){
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = icon,
                contentDescription = " ",
                modifier=Modifier.padding(bottom = 8.dp)
            )
        }
        Text(text=title, fontWeight = FontWeight.Bold,
            modifier=Modifier.padding(top=8.dp,start=8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun accountDialogUIPreview(){
    accountsDialogUI(openDialog= mutableStateOf(value = false))
}