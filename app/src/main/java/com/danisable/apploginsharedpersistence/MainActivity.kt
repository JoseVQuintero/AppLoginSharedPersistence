package com.danisable.apploginsharedpersistence

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.danisable.apploginsharedpersistence.presentation.fragment.notes.NotesFragment
import com.danisable.apploginsharedpersistence.presentation.fragment.public.PublicFragment
import com.danisable.apploginsharedpersistence.presentation.fragment.work.WorkFragment
import com.danisable.apploginsharedpersistence.presentation.login.LoginActivity
import com.danisable.apploginsharedpersistence.utils.Constants
import com.danisable.apploginsharedpersistence.utils.Utils
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        replaceFragment(NotesFragment(),"",this, null)
        bottomNavigation.setOnNavigationItemSelectedListener(this)

        // Set the toolbar as support action bar
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            // Set toolbar title/app title
            //title = "Toolbar Title"

            // Set action bar/toolbar sub title
            //subtitle = "Toolbar sub title"

            // Display the app icon in action bar/toolbar
            setDisplayShowHomeEnabled(false)
            //setLogo(R.mipmap.ic_launcher)
            //setDisplayUseLogoEnabled(true)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu to use in the action bar
        val inflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle presses on the action bar menu items
        when (item.itemId) {
            /*R.id.action_cut -> {
                //textView.text = "Cut Clicked."
                return true
            }
            R.id.action_copy -> {
                //textView.text = "Copy Clicked."
                return true
            }
            R.id.action_paste -> {
                //textView.text = "Paste Clicked."
                return true
            }
            R.id.action_new -> {
                //textView.text = "New Clicked."
                return true
            }*/
            R.id.action_logout -> {
                //textView.text = "New Clicked."
                Utils.setPreferencesAppData(this, Constants.PREF_IS_SESSION, Constants.PREF_DEFAULT)
                startActivity(Intent(this, LoginActivity::class.java))
                finishAffinity()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_note -> replaceFragment(NotesFragment(),"This value Fragment Home",this, null)
            R.id.menu_public -> replaceFragment(PublicFragment(),"This value Fragment Home",this,null)
            R.id.menu_work -> replaceFragment(WorkFragment(),"This value Fragment News",this,null)
        }
        return false
    }

    fun replaceFragment(fragment: Fragment, message: String, context: Context, bundle: Bundle?){
        val sm = supportFragmentManager.beginTransaction()
        sm.apply {
            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            fragment.arguments = bundle
            replace(R.id.container, fragment)
            addToBackStack(null)
            commit()
        }
    }
}