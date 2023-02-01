package com.example.simplecounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var counter=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button= findViewById<Button>(R.id.button)
        val textView=findViewById<TextView>(R.id.textView)
        val upgrade = findViewById<Button>(R.id.upgradeBtn)

        button.setOnClickListener {
            // Toast.makeText(it.context, "Clicked Button!", Toast.LENGTH_SHORT).show()
            counter++
            textView.text = counter.toString()

            if (counter >= 100) {

                // The upgrade button is revealed and an OnClickListener is set
                upgrade.visibility = View.VISIBLE
                upgrade.setOnClickListener {
                    button.text = "Add 2"

                    // Original button is updated to add 2 instead of 1
                    button.setOnClickListener {
                        counter += 2
                        textView.text = counter.toString()
                    }

                    // The upgrade button is hidden again
                    upgrade.visibility = View.INVISIBLE
                }
            }
        }

    }
}