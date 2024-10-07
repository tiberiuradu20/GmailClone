package com.example.gmail_clone.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.VideoCall
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ButtonMenuData(
    val icon:ImageVector,
    val title:String
){
    object Mail:ButtonMenuData(icon= Icons.Outlined.Mail, title="Mail")
    object Meet:ButtonMenuData(title="Meet",icon=Icons.Outlined.VideoCall)
}
