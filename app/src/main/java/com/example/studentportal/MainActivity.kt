package com.example.studentportal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private val portals = arrayListOf<Portal>()
    private val portalAdapter = PortalAdapter(portals)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        initViews()

    }

    private fun initViews() {
        rvPortal.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        rvPortal.adapter = portalAdapter

        for (i in Portal.PORTAL_NAMES.indices) {
            portals.add(Portal(Portal.PORTAL_NAMES[i], Portal.PORTAL_URLS[i]))
        }

        val portal = intent.getParcelableExtra<Portal>(PORTAL_EXTRA)

        if (portal != null) {
            portals.add(portal)
        }

        portalAdapter.notifyDataSetChanged()

        btnAddPortal.setOnClickListener { onAddClick() }

    }

    private fun onAddClick() {
        val portalActivityIntent = Intent(this, PortalActivity::class.java)
        startActivity(portalActivityIntent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    companion object {
        const val PORTAL_EXTRA = "PORTAL_EXTRA"
    }
}
