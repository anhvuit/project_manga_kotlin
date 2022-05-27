package com.example.projectmana.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.util.Log
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.projectmana.R
import com.google.firebase.auth.FirebaseAuth
import com.google.android.material.navigation.NavigationView


class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout ;
    private lateinit var nav_view: NavigationView ;

    private fun initParams(){
        drawerLayout = findViewById(R.id.drawer_layout);
        nav_view = findViewById(R.id.nav_view);
    }
    /**
     * This function is auto created by Android when the Activity Class is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        //This call the parent constructor
        super.onCreate(savedInstanceState)

        // This is used to align the xml view to this class
        setContentView(R.layout.activity_main)

        initParams()

        setupActionBar()

//         TODO (Step 8: Assign the NavigationView.OnNavigationItemSelectedListener to navigation view.)
//         START
//         Assign the NavigationView.OnNavigationItemSelectedListener to navigation view.
        nav_view.setNavigationItemSelectedListener(this)
//         END
    }

    // TODO (Step 5: Add a onBackPressed function and check if the navigation drawer is open or closed.)
    // START
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            // A double back press function is added in Base Activity.
            doubleBackToExit()
        }
    }
    // END

    // TODO (Step 7: Implement members of NavigationView.OnNavigationItemSelectedListener.)
    // START
    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        // TODO (Step 9: Add the click events of navigation menu items.)
        // START
        when (menuItem.itemId) {
            R.id.nav_my_profile -> {

                Toast.makeText(this@MainActivity, "My Profile", Toast.LENGTH_SHORT).show()
            }

            R.id.nav_sign_out -> {
                // Here sign outs the user from firebase in this device.
                FirebaseAuth.getInstance().signOut()

                // Send the user to the intro screen of the application.
                val intent = Intent(this, IntroActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                finish()
            }
        }
        this.drawerLayout.closeDrawer(GravityCompat.START)
        // END
        return true
    }
    // END
//
//    // TODO (Step 1: Create a function to setup action bar.)
//    // START
//    /**
//     * A function to setup action bar
//     */
    private fun setupActionBar() {
        val toolbar: Toolbar = findViewById(R.id.toolbar_main_activity);
        setSupportActionBar(toolbar)

        toolbar.setNavigationIcon(R.drawable.ic_action_navigation_menu)

        // TODO (Step 3: Add click event for navigation in the action bar and call the toggleDrawer function.)
        // START
        toolbar.setNavigationOnClickListener {
            toggleDrawer()
        }
        // END
    }
    // END
//
//    // TODO (Step 2: Create a function for opening and closing the Navigation Drawer.)
    // START
    /**
     * A function for opening and closing the Navigation Drawer.
     */
    private fun toggleDrawer() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            drawerLayout.openDrawer(GravityCompat.START)
        }
    }
    // END
}