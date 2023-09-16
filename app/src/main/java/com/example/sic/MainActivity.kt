package com.example.sic

import Item
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import au.edu.swin.sdmd.thecontest.R

//Imports: The code begins with several import statements. These statements import classes and resources from various packages that are used in the code. For example, it imports com.example.sic.DetailActivity, Item, and several Android-related classes.
class MainActivity : AppCompatActivity() {
    //
    private lateinit var listView: ListView
    //Class Definition: MainActivity is defined as a subclass of AppCompatActivity, which is a base class for activities in Android apps. This class represents the main activity of the app, which is the entry point for the user.
//
//Properties:
//
    private val items = listOf(
        Item("Item 1", 4.5, "Option A", 10.0, R.drawable.placeholder_imagea, ""),
        Item("Item 2", 3.0, "Option B", 8.0, R.drawable.placeholder_imageb, ""),
        Item("Item 3", 2.5, "Option C", 3.0, R.drawable.placeholder_imagec, ""),
        Item("Item 4", 3.5, "Option D", 4.0, R.drawable.placeholder_imaged, "")
    )
    //listView: This is a property representing a ListView widget, which is used to display a list of items in the app.
//items: This is a list of Item objects, which presumably represent the items to be displayed in the list. Each Item has various properties such as name, rating, options, etc.
//onCreate() Method: This method is called when the activity is created. It performs several tasks:
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//
//It sets the content view of the activity to a layout defined in XML (R.layout.activity_main).
        listView = findViewById(R.id.listView)
//It initializes the listView by finding it in the layout using its ID.
        val adapter = ItemListAdapter(this, items)
        listView.adapter = adapter
//It creates an ItemListAdapter and sets it as the adapter for the listView. The adapter is responsible for populating the list with data.
        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = items[position]
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("item", selectedItem)
            startActivityForResult(intent, REQUEST_EDIT_RESERVATION)
        }
    }
    //It sets an item click listener for the listView, so when an item is clicked, it creates an Intent to start the com.example.sic.DetailActivity and passes data about the selected item as an extra.
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_EDIT_RESERVATION && resultCode == Activity.RESULT_OK) {
            val editedReservationData = data?.getStringExtra("editedReservationData")
            // Handle updated data and UI refresh if needed
        }
    }

    companion object {
        private const val REQUEST_EDIT_RESERVATION = 1001
    }
}
