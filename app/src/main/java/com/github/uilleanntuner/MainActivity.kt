package com.github.uilleanntuner

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.navigation.NavController
import com.github.uilleanntuner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private var tuningComponent: String = CHANTER
    private lateinit var navController: NavController
    private lateinit var buttonChanter: Button
    private lateinit var buttonDrones: Button
    private lateinit var buttonRegs: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        setNavButtons()
    }

    private fun setNavButtons() {
        findViewById<Button>(R.id.button_chanter).setOnClickListener {
            if (this.tuningComponent == CHANTER) {
                this.tuningComponent = CHANTER
            }

            if (this.tuningComponent == DRONES) {
                navController.navigate(R.id.action_DronesFragment_to_ChanterFragment)
                this.tuningComponent = CHANTER
            }

            if (this.tuningComponent == REGS) {
                navController.navigate(R.id.action_RegsFragment_to_ChanterFragment)
                this.tuningComponent = CHANTER
            }
        }

        findViewById<Button>(R.id.button_drones).setOnClickListener {
            if (this.tuningComponent == CHANTER) {
                navController.navigate(R.id.action_ChanterFragment_to_DronesFragment)
                this.tuningComponent = DRONES
            }

            if (this.tuningComponent == DRONES) {
                this.tuningComponent = DRONES
            }

            if (this.tuningComponent == REGS) {
                navController.navigate(R.id.action_RegsFragment_to_DronesFragment)
                this.tuningComponent = DRONES
            }
        }
        findViewById<Button>(R.id.button_regs).setOnClickListener {
            if (this.tuningComponent == CHANTER) {
                navController.navigate(R.id.action_ChanterFragment_to_RegsFragment)
                this.tuningComponent = REGS
            }

            if (this.tuningComponent == DRONES) {
                navController.navigate(R.id.action_DronesFragment_to_RegsFragment)
                this.tuningComponent = REGS
            }

            if (this.tuningComponent == REGS) {
                this.tuningComponent = REGS
            }
        }
    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.menu_main, menu)
//        return true
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        return when (item.itemId) {
//            R.id.action_settings -> true
//            else -> super.onOptionsItemSelected(item)
//        }
//    }
//
//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        return navController.navigateUp(appBarConfiguration)
//                || super.onSupportNavigateUp()
//    }
}