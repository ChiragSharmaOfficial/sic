package com.example.sic

import Item
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import au.edu.swin.sdmd.thecontest.R

//Imports: You're importing various classes and packages that are needed for your ItemListAdapter class to function properly. These include classes like Context, LayoutInflater, View, ViewGroup, ArrayAdapter, ImageView, and TextView. These classes are part of Android's framework and are used to work with UI components and data.
class ItemListAdapter(context: Context, private val items: List<Item>) :
    ArrayAdapter<Item>(context, 0, items) {
    //
//ItemListAdapter Class: This is the main class you're defining in your code. It's responsible for adapting a list of Item objects to be displayed in a ListView or similar widget.
//
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_list_item, parent, false)
        }
//ItemListAdapter(context: Context, private val items: List<Item>): This is the primary constructor for the ItemListAdapter class. It takes two parameters:
//
        val currentItem = items[position]
//context: A reference to the current Android Context, which is necessary for various UI-related operations.
//items: A list of Item objects that you want to display in the list.
//ArrayAdapter<Item>(context, 0, items): The superclass constructor is called here, where you pass the context, a resource ID (0 in this case, since it's not used), and the list of items. This sets up the adapter to work with the provided data.
//
//getView() Method Override: The getView() method is an important method in any ArrayAdapter. It's called for each item in the list and is responsible for creating and returning a View that represents the item at the specified position in the list.
//
        val itemNameTextView: TextView = itemView!!.findViewById(R.id.itemNameTextView)
        val itemImageView: ImageView = itemView.findViewById(R.id.itemImageView)
//override fun getView(position: Int, convertView: View?, parent: ViewGroup): View: This is the overridden getView() method. It takes three parameters:
//
//position: The position of the item in the list that needs to be displayed.
        itemNameTextView.text = currentItem.name
        itemImageView.setImageResource(currentItem.imageResourceId)
//convertView: A recycled view that can be reused to improve performance (it's passed as null when there's no recycled view available).
        return itemView
    }
}
//parent: The parent ViewGroup that the returned View will be attached to.
//Inside the getView() method, you first check if convertView is null. If it's null, you inflate a new View from an XML layout resource using LayoutInflater. This layout resource is named item_list_item.
//
//You then get a reference to the current item at the specified position in the list (currentItem).
//
//Next, you find the TextView and ImageView within the itemView layout using their respective IDs from the XML layout resource.
//
//Finally, you set the text and image for the TextView and ImageView based on the data in the currentItem, and you return the itemView.

