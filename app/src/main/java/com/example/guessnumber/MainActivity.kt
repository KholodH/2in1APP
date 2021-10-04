package com.example.guessnumber

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var guessNum:Button
    private lateinit var guessPhrase:Button

    private lateinit var clMain: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clMain= findViewById(R.id.clMain)

         guessNum = findViewById(R.id.button)
         guessPhrase = findViewById(R.id.button1)

        guessNum.setOnClickListener {
            val intent=Intent(this, GuessGame::class.java)
            startActivity(intent)
        }
        guessPhrase.setOnClickListener {
            val intent=Intent(this, GuessPhrase::class.java)
            startActivity(intent)
        }


}


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.NGame -> {
                val intent=Intent(this, GuessGame::class.java)
                startActivity(intent)
                return true
            }
            R.id.PGame -> {

                    val intent=Intent(this, GuessPhrase::class.java)
                    startActivity(intent)
                               return true
            }
            R.id.Mainn -> {
                item.isVisible=false
            }

        }
        return super.onOptionsItemSelected(item)}}






