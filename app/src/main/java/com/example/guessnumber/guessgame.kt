package com.example.guessnumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.guess_layotu.*
import kotlin.random.Random

class GuessGame : AppCompatActivity() {
        private lateinit var clRoot: ConstraintLayout
        private lateinit var guessField: EditText
        private lateinit var guessButton: Button
        private lateinit var messages: ArrayList<String>
        private lateinit var tvMessage: TextView
        private var count=3
        private var rand=0

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.guess_layotu)

            rand= Random.nextInt(11)
            clRoot = findViewById(R.id.clMain)
            messages = ArrayList()

            rvRecord.adapter = MessageAdapter(this, messages)
            rvRecord.layoutManager = LinearLayoutManager(this)


            guessField = findViewById(R.id.TextEnter)
            guessButton = findViewById(R.id.button)
            tvMessage=   findViewById(R.id.tvAccount)
            guessButton.setOnClickListener { addMessage() }
        }
        private fun addMessage(){
            val msg = guessField.text!!.toString()
            if(msg.isNotEmpty()){
                if (count>0){
                    when {

                        msg.toInt()==rand -> {
                            disableEntry()
                            messages.add("you guess it right!")}
                        msg.toInt()!=rand -> {

                            messages.add("your guessed Number is:$msg")
                            count--
                            messages.add("your have $count guessed left")
                        }}}
                else if (count==0)   {
                    disableEntry()
                    messages.add("you lose :( the correct answer was $rand")
                    messages.add("Game over")
                }


                guessField.text.clear()
                guessField.clearFocus()
                rvRecord.adapter?.notifyDataSetChanged()
            }
            else{
                Snackbar.make(clRoot, "Please enter Number", Snackbar.LENGTH_LONG).show()
            }
        }
        private fun disableEntry(){
            guessButton.isEnabled = false
            guessButton.isClickable = false
            guessField.isEnabled = false
            guessField.isClickable = false
        }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        val item:MenuItem=menu!!.getItem(0)
        item.title="New Game"
        return super.onPrepareOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.NGame -> {
                val intent= Intent(this, GuessGame::class.java)
                startActivity(intent)
                return true
            }
            R.id.PGame -> {
                val intent= Intent(this, GuessPhrase::class.java)
                startActivity(intent)
                return true
            }
            R.id.Mainn -> {

                val intent= Intent(this, MainActivity::class.java)
                startActivity(intent)
                return true
            }

        }
        return super.onOptionsItemSelected(item)}

}








