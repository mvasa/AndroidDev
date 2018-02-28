package com.vasa.android.helpapp

import android.graphics.Color
import android.opengl.Visibility
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
//import com.vasa.android.helpapp.R.id.fab
import com.vasa.android.helpapp.R.id.helpButton

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)



        visibilityToggle.setOnCheckedChangeListener{_, isChecked ->
                if(isChecked)
                {
                    textView.visibility = View.INVISIBLE
                }
                else
                {
                    textView.visibility = View.VISIBLE
                }

        }



        colorToggle.setOnCheckedChangeListener{_, isChecked ->
            if(isChecked)
            {
                textView.setBackgroundColor(Color.GREEN)
            }
            else
            {
                textView.setBackgroundColor(Color.RED)
            }
        }
        /*fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }*/
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
            helpButton -> {
                textView.text = "The left toggle will affect the visibility of the text. The right toggle will change the background color of the text field."
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
