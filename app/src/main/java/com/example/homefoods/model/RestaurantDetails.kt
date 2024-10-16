package com.example.homefoods.model

import java.io.Serializable

data class RestaurantDetails(
    val id: Int, // Unique identifier for the restaurant
    val name: String, // Name of the restaurant
    val address: String, // Address of the restaurant
    val phoneNumber: String?, // Phone number (nullable)
    val cuisineType: String, // Type of cuisine (e.g., Italian, Chinese)
    val imageUrl: String? // URL to an image of the restaurant (nullable)
): Serializable
