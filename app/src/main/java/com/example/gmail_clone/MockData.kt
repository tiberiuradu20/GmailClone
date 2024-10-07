package com.example.gmail_clone

import com.example.gmail_clone.model.Account
import com.example.gmail_clone.model.MailData

val mailList= listOf(
    MailData(
        mailId = 0,
        userName="Christy",
        subject="Weekly Android News",
        body="Hello Christy we have got exciting addition to the android api",
        timeStamp = "20:10"
    ),
    MailData(1, "Christy", "Weekly Android News", "Hello Christy we have got exciting addition to the android api", "20:10"),
    MailData(2, "Alex", "Meeting Schedule", "Don't forget our meeting at 3 PM tomorrow.", "08:45"),
    MailData(3, "Sam", "Your Subscription", "Your subscription has been confirmed.", "09:15"),
    MailData(4, "Jordan", "Update", "We have updated our privacy policy.", "10:30"),
    MailData(5, "Casey", "Welcome!", "Welcome to our community!", "11:00"),
    MailData(6, "Pat", "Discounts", "Check out our latest discounts.", "13:20"),
    MailData(7, "Taylor", "Invoice", "Your latest invoice is attached.", "14:05"),
    MailData(8, "Drew", "Delivery", "Your package has been shipped.", "15:45"),
    MailData(9, "Jamie", "Appointment Reminder", "Your next appointment is scheduled for Monday.", "16:30"),
    MailData(10, "Morgan", "Survey", "We'd love your feedback on our services.", "17:25"),
    MailData(11, "Quinn", "Exclusive Offer", "An exclusive offer just for you!", "18:40"),
    MailData(12, "Alexis", "Birthday", "Happy Birthday! We have a gift for you.", "19:00"),
    MailData(13, "Blair", "Photos", "Your photos from the event are ready.", "19:30"),
    MailData(14, "Jesse", "Updates Available", "New updates are available for your software.", "21:15"),
    MailData(15, "Sydney", "Confirmation", "We have received your payment.", "22:00")
)
val accountList= listOf<Account>(
    Account(icon=R.drawable.motivatie, userName = "Tiberiu Baesu",
        email="tibibaesu@gmail.com", unReadMails = 109),
    Account(icon=R.drawable.motivatie, userName = "Tiberiu Baesu",
        email="tiberiubaesu@yahoo.com", unReadMails = 100),
    Account(icon=R.drawable.motivatie, userName = "Baesu Tiberiu-Radu",
        email="tibibaesu@gmail.com", unReadMails = 99)

)