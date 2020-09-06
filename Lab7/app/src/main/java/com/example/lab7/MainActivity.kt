package com.example.lab7

import android.animation.BidirectionalTypeConverter
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.DecorContentParent
import androidx.core.content.res.getStringOrThrow
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.adapter_vertical.view.*
import java.text.ParsePosition

data class Item(
    val photo: Int,
    val name:String
)
val item = ArrayList<Item>()

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // val item = ArrayList<Item>()
        val array = resources.obtainTypedArray(R.array.resourceList)
        val fruitName = resources.obtainTypedArray(R.array.fruitName)

        for(i in 0 until array.length())
            //item.add(Item(array.getResourceId(i,0),"水果${i+1}"))
        item.add(Item(array.getResourceId(i,0),fruitName.getStringOrThrow(i)))
        array.recycle()
        fruitName.recycle()

        spinner.adapter = MyAdapter( R.layout.adapter_horizontal, item)
        gridview.numColumns = 2

        gridview.adapter = MyAdapter(R.layout.adapter_vertical,item)
        listView.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
            arrayListOf("項目1","項目2","項目3","項目4","項目5","項目6","項目7","項目8","項目9"))
    }
}


