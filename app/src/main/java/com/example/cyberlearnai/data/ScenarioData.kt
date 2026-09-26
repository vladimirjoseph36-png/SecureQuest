package com.example.securequest.data

data class CyberScenario(
    val id: String,
    val title: String,
    val description: String,
    val question: String,
    val options: List<String>,
    val correctAnswer: Int,
    val securityTip: String,
    val lesson: String
)

val cyberScenarios = listOf(

    CyberScenario(
        id = "phishing",
        title = "Phishing Attack",
        description = "You receive an unexpected email asking you to verify your account immediately. The message contains a suspicious link.",
        question = "What should you do first?",
        options = listOf(
            "Click the link and verify your account",
            "Reply to the sender and ask for more information",
            "Check the sender and verify the request through an official channel",
            "Forward the email to your friends"
        ),
        correctAnswer = 2,
        securityTip = "Never click suspicious links before verifying the sender and the request.",
        lesson = "Phishing attacks use fake messages to trick users into revealing sensitive information. Always verify unexpected requests through an official channel."
    ),

    CyberScenario(
        id = "password",
        title = "Weak Password",
        description = "You are creating a password for an important online account.",
        question = "Which password strategy is the safest?",
        options = listOf(
            "Use your birthday",
            "Use the same password everywhere",
            "Use a long unique password or passphrase",
            "Use your first name and phone number"
        ),
        correctAnswer = 2,
        securityTip = "Use unique passwords for important accounts and consider using a password manager.",
        lesson = "Strong passwords should be long, unique, and difficult to guess. Reusing passwords increases the impact of a compromised account."
    ),

    CyberScenario(
        id = "public-wifi",
        title = "Public Wi-Fi",
        description = "You are at a coffee shop and need to access an important account using public Wi-Fi.",
        question = "What is the safest approach?",
        options = listOf(
            "Use the public Wi-Fi without checking anything",
            "Disable all security protections",
            "Use a trusted connection such as mobile data or a trusted VPN",
            "Share your password with the Wi-Fi administrator"
        ),
        correctAnswer = 2,
        securityTip = "Avoid sensitive activities on untrusted networks when possible.",
        lesson = "Public networks can expose users to security risks. For sensitive activities, use a trusted network or an appropriate secure connection."
    ),

    CyberScenario(
        id = "malware",
        title = "Suspicious Download",
        description = "A website tells you that your computer is infected and asks you to download a security tool immediately.",
        question = "What should you do?",
        options = listOf(
            "Download the program immediately",
            "Close the website and use trusted security software",
            "Enter your administrator password",
            "Disable your antivirus"
        ),
        correctAnswer = 1,
        securityTip = "Do not trust unexpected security warnings from random websites.",
        lesson = "Fake security alerts can be used to distribute malware. Use trusted security software and obtain applications from legitimate sources."
    )
)