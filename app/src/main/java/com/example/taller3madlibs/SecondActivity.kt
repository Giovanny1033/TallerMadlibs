package com.example.taller3madlibs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import java.io.PrintStream
import java.util.*

class SecondActivity : AppCompatActivity() {
    val madHistory = arrayListOf<String>("Historia 1 Simple","Historia 2 Tarzan","Historia 3 University","Historia 4 Clothes","Historia 5 Dance",) //creamos el arreglo de datos
    val madIds = arrayListOf<String>("simple","tarzan","university","clothes","dance")
    var adapter: ArrayAdapter<String> ?= null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //val actionBar = supportActionBar
        val txtContent = findViewById<TextView>(R.id.txtContent)
        val btnGuardar = findViewById<Button>(R.id.btnSave)
        val btnRead = findViewById<Button>(R.id.btnRead)
        val btnThird = findViewById<Button>(R.id.btnThirdActivity)


        adapter = ThirdActivity(this, R.layout.activity_third, madHistory)
        val madListView = findViewById<ListView>(R.id.madList)
        madListView.adapter = adapter
        madListView.setOnItemClickListener{ listview, listitem, index, id ->
            println("item: $listitem, index: $index, id: $id")
            Toast.makeText(this, "Seleccionaste la historia ${madHistory[index]}", Toast.LENGTH_SHORT).show()

            val fourthActivityIntent = Intent(this, FourthActivity::class.java)
            fourthActivityIntent.putExtra("story", madIds[index])
            startActivity(fourthActivityIntent)

        }

        val btnAgregar = findViewById<Button>(R.id.btnAgregar)
        btnAgregar.setOnClickListener {
            agregarHistoria()
        }

        val btnQuitar = findViewById<Button>(R.id.btnQuitar)
        btnQuitar.setOnClickListener {
            quitarHistoria()
        }

        btnGuardar.setOnClickListener { writeFile() }

        btnRead.setOnClickListener { txtContent.text = readFile() }

        btnThird.setOnClickListener { goToThirdActivity() }

        //actionBar!!.title = "Second Activity"

        //actionBar.setDisplayHomeAsUpEnabled(true)

    }

    fun goToThirdActivity(){
        val thirdIntent = Intent(this, FourthActivity::class.java)
        thirdIntent.putExtra("CHARACTER", "simple")
        startActivity(thirdIntent)
    }

    fun writeFile(){
        Log.d("MaDLIB", "Escribiendo archivo")
        val output = PrintStream(
            openFileOutput("out.txt", MODE_APPEND))
        output.println("Hola MAD LIB!")
        output.println("Quiero pasar :(")
        output.close()
    }

    fun readFile(): String{
        Log.d("MadLIB", "Leyendo archivo")
        val scan = Scanner(
            openFileInput("out.txt")
        )
        var allText = "" //read entire file
        while (scan.hasNextLine()){
            val line = scan.nextLine()
            allText += line
        }
        Log.d("MadLIB", "Contenido: $allText")
        scan.close()
        return allText
    }

    fun agregarHistoria(){
        madHistory.add("Otra Historia")
        adapter?.notifyDataSetChanged()
    }

    fun quitarHistoria(){
        madHistory.removeAt(madHistory.size-1)
        adapter?.notifyDataSetChanged()
    }
}