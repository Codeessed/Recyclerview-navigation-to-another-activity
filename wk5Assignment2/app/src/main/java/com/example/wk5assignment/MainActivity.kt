package com.example.wk5assignment

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import com.example.wk5assignment.R.drawable.ic_back_arrow as ic_back_arrow1

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var array: ArrayList<ContactsVariables>
    private lateinit var image: Array<Int>
    private lateinit var name: Array<String>
    private lateinit var gmail: Array<String>
    private lateinit var number: Array<String>





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)





        image = arrayOf(R.drawable.image_1, R.drawable.image_2, R.drawable.image_3, R.drawable.image_4, R.drawable.image_5)
        name = arrayOf("Makinde Gbohunmi", "Oluwaseyi Raymond", "Adegbite Shote", "Alakada Mary", "Indubusi Maria")
        gmail = arrayOf(getString(R.string.firstGmail), getString(R.string.secondGmail), getString(R.string.thirdGmail), getString(R.string.fourthGmail), getString(R.string.fifthGmail))
        number = arrayOf(getString(R.string.firstNumber), getString(R.string.secondNumber), getString(R.string.thirdNumber), getString(R.string.fourthNumber), getString(R.string.fifthNumber), )

        recyclerView = findViewById(R.id.recycleView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        array = arrayListOf()

        userdata()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }




    private fun userdata(){
        for(i in image.indices){
            val contactsVariables = ContactsVariables(image[i], name[i])
            array.add(contactsVariables)
        }

        var adapter = ProtoypesAdapter(array)
        recyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : ProtoypesAdapter.onItemClickListener{
            override fun onItemClick(position: Int) { //gets the position on which the user clicked
                //Toast.makeText(this@MainActivity, "This is item No $position", Toast.LENGTH_LONG).show()

                val intent = Intent(this@MainActivity, SecondActivity::class.java)

                intent.putExtra("image", array[position].image)
                intent.putExtra("name", array[position].name)
                intent.putExtra("gmail", gmail[position])
                intent.putExtra("number", number[position])



                startActivity(intent)
            }

        })
    }
}