package com.example.securequest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.securequest.theme.CyberLearnAITheme
import com.revenuecat.purchases.Purchases
import com.revenuecat.purchases.PurchasesConfiguration

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeRevenueCat()

        enableEdgeToEdge()

        setContent {
            CyberLearnAITheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainNavigation()
                }
            }
        }
    }

    private fun initializeRevenueCat() {
        val apiKey = BuildConfig.REVENUECAT_API_KEY

        if (apiKey.isBlank()) {
            return
        }

        if (!Purchases.isConfigured) {
            Purchases.configure(
                PurchasesConfiguration.Builder(
                    this,
                    apiKey
                ).build()
            )
        }
    }
}