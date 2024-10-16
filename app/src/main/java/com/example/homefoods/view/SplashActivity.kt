package com.example.homefoods.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.homefoods.Connectivity
import com.example.homefoods.R
import com.example.homefoods.model.RestaurantDetails
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity: AppCompatActivity(), Connectivity {
    private lateinit var listOfRestaurantDetails: List<RestaurantDetails>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        fetchData()
        splashing()
    }
    private fun fetchData(){
        listOfRestaurantDetails  = listOf(
            RestaurantDetails(1, "Pasta Place", "123 Noodle St", "123-456-7890", "Italian", "http://example.com/image1.jpg"),
            RestaurantDetails(2, "Sushi World", "456 Fish Ave", "987-654-3210", "Japanese", "http://example.com/image2.jpg"),
            RestaurantDetails(3,"Home Foods", "Bangalore","9492602725","North Indian","www.img.com"),
            RestaurantDetails(4,"Home Foods", "Bangalore","9492602725","North Indian","www.img.com"),
            RestaurantDetails(5,"Home Foods", "Bangalore","9492602725","North Indian","www.img.com"),
            RestaurantDetails(6,"Natural Foods", "Bangalore","9492602725","South Indian","www.img.com")
        )

    }
    private fun splashing(){
        lifecycleScope.launch {
            delay(100) // Delay for 2 seconds
            val intent = Intent(this@SplashActivity, MainActivity::class.java).apply {
                putExtra("restaurant_list",ArrayList(listOfRestaurantDetails))
            }
            startActivity(intent)
            delay(100)
            finish() // Close the splash activity
        }
    }

    override fun display() {
        Log.d("Splash Activity: ","Hello")
    }

    override fun error() {
        TODO("Not yet implemented")
    }

}