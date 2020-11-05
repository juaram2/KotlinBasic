package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
//  2 ways of initialize to null
//  var diceImage: ImageView? = null
  lateinit var diceImage: ImageView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val rollButton : Button = findViewById(R.id.roll_button)
    rollButton.text = "Let's Roll"
    rollButton.setOnClickListener{
      rollDice()
    }

    diceImage = findViewById(R.id.dice_image)
  }

  private fun rollDice() {
    val resultText : TextView = findViewById(R.id.result_text)

    val randomInt = Random.nextInt(6) + 1
    resultText.text = randomInt.toString()

//    val diceImage: ImageView = findViewById(R.id.dice_image)
    val imageResource = when (randomInt) {
      1 -> R.drawable.dice_1
      2 -> R.drawable.dice_2
      3 -> R.drawable.dice_3
      4 -> R.drawable.dice_4
      5 -> R.drawable.dice_5
      else -> R.drawable.dice_6
    }
    diceImage.setImageResource(imageResource)
  }
}