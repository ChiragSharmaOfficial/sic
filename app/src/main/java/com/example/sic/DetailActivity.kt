package com.example.sic

import Item
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import au.edu.swin.sdmd.thecontest.R
import au.edu.swin.sdmd.thecontest.R.layout.activity_detail

class DetailActivity : AppCompatActivity() {
//android.app.Activity, android.content.Intent, and android.os.Bundle are core Android classes used for activity management.
    private lateinit var itemImage: ImageView
    private lateinit var itemName: TextView
    private lateinit var ratingBar: RatingBar
    private lateinit var attributeRadioGroup: RadioGroup
    private lateinit var priceEditText: TextView
    private lateinit var reservationEditText: EditText
    //Various UI elements like ImageView, Button, EditText, etc., are imported.
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_detail)

        itemImage = findViewById(R.id.itemImage)
        itemName = findViewById(R.id.itemName)
        ratingBar = findViewById(R.id.ratingBar)
        attributeRadioGroup = findViewById(R.id.attributeRadioGroup)
        priceEditText = findViewById(R.id.priceEditText)
        reservationEditText = findViewById(R.id.reservationEditText)
//androidx.appcompat.app.AppCompatActivity is an Android class for creating activities with AppCompat support.
        val item = intent.getParcelableExtra<Item>("item")

        item?.let { it ->
            itemImage.setImageResource(it.imageResourceId)
            itemName.text = it.name
            ratingBar.rating = it.rating.toFloat()
            reservationEditText.setText(it.reservationData)
        }
//com.example.sic.R is used to reference resources in your app, such as layout files, drawables, and strings.
        val saveButton = findViewById<Button>(R.id.saveButton)
        saveButton.setOnClickListener {
            val editedReservationData = reservationEditText.text.toString()
            val resultIntent = Intent()
            resultIntent.putExtra("editedReservationData", editedReservationData)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
            //Property Declarations: These lines declare private properties for various UI elements within the activity. These properties will hold references to those elements.

        }
    }
}
//Class Declaration: Here, the com.example.sic.DetailActivity class is declared, which extends AppCompatActivity.
