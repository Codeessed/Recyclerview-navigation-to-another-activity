package com.example.wk5assignment

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var backArrw: ImageView  = findViewById(R.id.backArrow)

        setSupportActionBar(secondToolbar)

        val _image = findViewById<ImageView>(R.id.prototype_image)
        val _name = findViewById<TextView>(R.id.prototype_name)
        val _gmail = findViewById<TextView>(R.id.prototype_gmail)
        val _number = findViewById<TextView>(R.id.prototype_number)

        val bundle: Bundle? = intent.extras
        val image = bundle!!.getInt("image")
        val name = bundle.getString("name")
        val gmail = bundle.getString("gmail")
        val number = bundle.getString("number")

        _image.setImageResource(image)
        _name.text = name
        _gmail.text = gmail
        _number.text = number


        backArrw.setOnClickListener{
            onBackPressed()
        }
    }
    //puts the menu on the action bar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.second_menu, menu)
        return true
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if ()
//    }
}