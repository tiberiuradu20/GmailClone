package com.example.gmail_clone.model

data class Account(
    val icon:Int?=null,
    val userName:String,
    val email:String,
    val unReadMails:Int
)