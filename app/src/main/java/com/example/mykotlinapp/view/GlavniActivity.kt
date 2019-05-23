package com.example.mykotlinapp.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.mykotlinapp.R


import android.support.design.widget.NavigationView
import android.support.v4.app.FragmentActivity
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle

import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.example.mykotlinapp.contract.MainActivityContract
import com.example.mykotlinapp.presenter.GlavniMenu_fragmentPresenter


class GlavniActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener,MainActivityContract.GlavniView{


    private lateinit var mPresenter: MainActivityContract.GlavniPresenter
    //private lateinit var activity: Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.admin_layout)

        mPresenter = GlavniMenu_fragmentPresenter(this)


        val intent = intent

        val username:String=intent.getStringExtra("username")

       // Log.i(ContentValues.TAG, "Log cat from Admina $ime")
       // text.setText(position)
        //text.setText("Welcome my master  "+username)



        mPresenter.glavniFragment(this,username)








    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }
    override fun initView() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)


        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer.setDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
       val id:Int = item.itemId
        if (id == R.id.danas) {
           var rad=AutomobiliFragment()
            val fragment_manager = supportFragmentManager
            val fragmentTransaction = fragment_manager.beginTransaction()
            fragmentTransaction.replace(R.id.glavni_fragment, rad)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()


        } else if (id == R.id.namernice) {

        } else if (id == R.id.aktivnosti) {

        } else if (id == R.id.statistika) {

        }
        else if (id == R.id.log_out) {

        }

        var drawer:DrawerLayout = findViewById(R.id.drawer_layout)
        drawer.closeDrawer(GravityCompat.START)
        return true
    }


}
