package com.example.taller3madlibs

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class ThirdActivity(val ctx: Context, val layout:Int, val data:ArrayList<String>): ArrayAdapter<String>(ctx, layout, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(layout, null)
        val description = view.findViewById<TextView>(R.id.textMad)
        description.text = data[position]
        val icon = view.findViewById<ImageView>(R.id.listIcon)
        icon.setImageResource(R.drawable.madlibs)
        return view

    }


}