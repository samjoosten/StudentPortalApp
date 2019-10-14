package com.example.studentportal

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_add_portal.*

class PortalActivity : AppCompatActivity() {

    private val portals = arrayListOf<Portal>()
    private val portalAdapter = PortalAdapter(portals)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_portal)
        btnAddPortal.setOnClickListener { initViews() }
    }

    private fun initViews() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Create a portal"

        val portalName = etTitle.text.toString()
        val portalUrl = etUrl.text.toString()

        val portal = Portal(
            portalName,
            portalUrl
        )

        portals.add(portal)

        val portalActivityIntent = Intent(this, MainActivity::class.java)
        portalActivityIntent.putExtra(MainActivity.PORTAL_EXTRA, portal)
        startActivity(portalActivityIntent)

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }



}