package com.example.homefoods.view

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager2.widget.ViewPager2
import com.example.homefoods.Connectivity
import com.example.homefoods.R
import com.example.homefoods.adapters.TabPagerAdapter
import com.example.homefoods.model.RestaurantDetails
import com.example.homefoods.presenter.Presenter
import com.example.homefoods.utils.showToast
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity(), Connectivity {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var restaurantList: ArrayList<RestaurantDetails>

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Retrieve the restaurant list
        restaurantList = intent.getSerializableExtra("restaurant_list") as ArrayList<RestaurantDetails>

//        Log.d("MainActivity",""+restaurantList?.get(0))
//
//        restaurantList?.let {
//            // Now you can use the restaurantList as needed
//            it.forEach { restaurant ->
//                println(restaurant.name) // Example usage
//                Log.d("HHHHHHHH",""+restaurant.name)
//            }
//        }

        val presenter = Presenter(this)
        presenter.loadUser()

        loadTab()
        initNavigationDrawer()
    }
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    private fun initNavigationDrawer(){
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigation_view)

        // Set up the Toolbar
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Set up the ActionBarDrawerToggle
        toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Enable the home button to be clickable
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        // Inflate custom layout for each menu item
        /*for (i in 0..navigationView.menu.size()-1) {
            val menuItem = navigationView.menu.getItem(i)
            val customView = LayoutInflater.from(this).inflate(R.layout.nav_menu_item, navigationView, false)

            val icon = customView.findViewById<ImageView>(R.id.icon)
            val title = customView.findViewById<TextView>(R.id.title)

            // Set the icon and title for each menu item
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    icon.setImageResource(R.drawable.tab_cart) // Replace with your icon
                    title.text = menuItem.title
                }
                R.id.nav_profile -> {
                    icon.setImageResource(R.drawable.tab_home) // Replace with your icon
                    title.text = menuItem.title
                }
                R.id.nav_chat -> {
                    icon.setImageResource(R.drawable.tab_cart) // Replace with your icon
                    title.text = menuItem.title
                }
                R.id.nav_about -> {
                    icon.setImageResource(R.drawable.tab_home) // Replace with your icon
                    title.text = menuItem.title
                }
                R.id.nav_terms -> {
                    icon.setImageResource(R.drawable.tab_cart) // Replace with your icon
                    title.text = menuItem.title
                }
                R.id.nav_contact -> {
                    icon.setImageResource(R.drawable.tab_home) // Replace with your icon
                    title.text = menuItem.title
                }
                R.id.nav_settings -> {
                    icon.setImageResource(R.drawable.tab_cart) // Replace with your icon
                    title.text = menuItem.title
                }
                R.id.nav_share -> {
                    icon.setImageResource(R.drawable.tab_home) // Replace with your icon
                    title.text = menuItem.title
                }
            }

            navigationView.addHeaderView(customView)
        }

         */

        // Handle navigation item clicks
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    // Handle home action
                }
                R.id.nav_settings -> {
                    // Handle settings action
                }
                R.id.nav_about -> {
                    // Handle about action
                }
            }
            drawerLayout.closeDrawers() // Close the drawer
            true
        }

        // Set up the toolbar (if using one)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun loadTab(){
        tabLayout = findViewById(R.id.tab_layout)
        viewPager = findViewById(R.id.view_pager)
        viewPager.isUserInputEnabled = false

        val adapter = TabPagerAdapter(this, restaurantList)
        viewPager.adapter = adapter

        // Link TabLayout and ViewPager2
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            // Inflate custom tab layout
            val tabView = layoutInflater.inflate(R.layout.custom_tab, null)

            // Set the icon and text based on the position
            val tabIcon = tabView.findViewById<ImageView>(R.id.tab_icon)
            val tabText = tabView.findViewById<TextView>(R.id.tab_text)

            when (position) {
                0 -> {
                    tabIcon.setImageResource(R.drawable.tab_home)
                    tabText.text = "Home"
                }
                1 -> {
                    tabIcon.setImageResource(R.drawable.tab_cart)
                    tabText.text = "Dashboard"
                }
                2 -> {
                    tabIcon.setImageResource(R.drawable.tab_home)
                    tabText.text = "Notifications"
                }
                3 -> {
                    tabIcon.setImageResource(R.drawable.tab_cart)
                    tabText.text = "Profile"
                }
                4 -> {
                    tabIcon.setImageResource(R.drawable.tab_home)
                    tabText.text = "Settings"
                }
            }

            tab.customView = tabView
        }.attach()
    }

    override fun display() {
        this.showToast("Main Activity")
    }

    override fun error() {
        Log.d("Splash Activity: ","Error")
    }
}