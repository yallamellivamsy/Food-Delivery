package com.example.homefoods.adapters

// TabPagerAdapter.kt
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.homefoods.model.RestaurantDetails
import com.example.homefoods.view.fragments.HomeFragment
import com.example.homefoods.view.fragments.ProfileFragment

class TabPagerAdapter(fragmentActivity: FragmentActivity, restaurantList: ArrayList<RestaurantDetails>) : FragmentStateAdapter(fragmentActivity) {

    var restaurantLists = restaurantList

    override fun getItemCount(): Int = 5 // Number of tabs

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                val fragment = HomeFragment()
                val args = Bundle().apply {
                    putSerializable("key_data", restaurantLists) // Add your data here
                }
                fragment.arguments = args
                return fragment
            }
            1 -> ProfileFragment()
            2 -> HomeFragment()
            3 -> ProfileFragment()
            4 -> HomeFragment()
            else -> ProfileFragment()
        }
    }
}
