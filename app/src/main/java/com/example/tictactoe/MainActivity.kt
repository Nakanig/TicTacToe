package com.example.tictactoe

import android.content.DialogInterface
import android.graphics.Color
import android.graphics.Color.RED
import android.hardware.camera2.params.RggbChannelVector.RED
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var resButton: Button

    private lateinit var p1text: TextView
    private lateinit var qula1: TextView
    private lateinit var p2text: TextView
    private lateinit var qula2: TextView

    var scorepoint1 = 0
    var scorepoint2 = 0

    private var activePlayer = 1
    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

    }

    private fun init() {

        button1 = findViewById(R.id.Button1)
        button2 = findViewById(R.id.Button2)
        button3 = findViewById(R.id.Button3)
        button4 = findViewById(R.id.Button4)
        button5 = findViewById(R.id.Button5)
        button6 = findViewById(R.id.Button6)
        button7 = findViewById(R.id.Button7)
        button8 = findViewById(R.id.Button8)
        button9 = findViewById(R.id.Button9)
        resButton = findViewById(R.id.resButton)
        p1text = findViewById(R.id.p1text)
        p2text = findViewById(R.id.p2text)
        qula1 = findViewById(R.id.qula1)
        qula2 = findViewById(R.id.qula2)


        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        resButton.setOnClickListener(this)

        resButton.setOnClickListener() {
            resetreset()
        }



    }

    override fun onClick(clickedView: View?) {
        var buttonNumber = 0

        if (clickedView is Button){

            when(clickedView.id){

                R.id.Button1 -> buttonNumber = 1
                R.id.Button2 -> buttonNumber = 2
                R.id.Button3 -> buttonNumber = 3
                R.id.Button4 -> buttonNumber = 4
                R.id.Button5 -> buttonNumber = 5
                R.id.Button6 -> buttonNumber = 6
                R.id.Button7 -> buttonNumber = 7
                R.id.Button8 -> buttonNumber = 8
                R.id.Button9 -> buttonNumber = 9

            }
            if (buttonNumber != 0) {
                playGame(clickedView, buttonNumber)
            }


        }

    }

    private fun stopGame() {
        button1.isEnabled = false
        button2.isEnabled = false
        button3.isEnabled = false
        button4.isEnabled = false
        button5.isEnabled = false
        button6.isEnabled = false
        button7.isEnabled = false
        button8.isEnabled = false
        button9.isEnabled = false
    }


    private fun playGame(clickedView: Button, buttonNumber: Int) {
        if (activePlayer == 1){
            clickedView.text = "X"
            clickedView.setBackgroundColor(Color.RED)
            activePlayer = 2
            firstPlayer.add(buttonNumber)
        }else{
            clickedView.text = "0"
            clickedView.setBackgroundColor(Color.YELLOW)
            activePlayer = 1
            secondPlayer.add(buttonNumber)
        }
        clickedView.isEnabled = false
        check()
    }

    private fun check() {

        var winnerPlayer = 0

        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        }
        if (winnerPlayer == 1) {
            scorepoint1 ++
            qula1.text = scorepoint1.toString()
            Toast.makeText(this, "Gamarjvebulia Player 1", Toast.LENGTH_SHORT).show()
            stopGame()
        } else if (winnerPlayer == 2) {
            scorepoint2 ++
            qula2.text = scorepoint2.toString()
            Toast.makeText(this, "Gamarjvebulia Player 2", Toast.LENGTH_SHORT).show()
            stopGame()
        }else if (winnerPlayer == 3) {
            Toast.makeText(this, "DRAW!", Toast.LENGTH_SHORT).show()
        }

    }

    private fun resetreset() {
        activePlayer = 1
        button1.text = ""
        button2.text = ""
        button3.text = ""
        button4.text = ""
        button5.text = ""
        button6.text = ""
        button7.text = ""
        button8.text = ""
        button9.text = ""

        firstPlayer.clear()
        secondPlayer.clear()
        activePlayer = 1

        button1.isEnabled = true
        button2.isEnabled = true
        button3.isEnabled = true
        button4.isEnabled = true
        button5.isEnabled = true
        button6.isEnabled = true
        button7.isEnabled = true
        button8.isEnabled = true
        button9.isEnabled = true

        button1.setBackgroundColor(Color.BLUE)
        button2.setBackgroundColor(Color.BLUE)
        button3.setBackgroundColor(Color.BLUE)
        button4.setBackgroundColor(Color.BLUE)
        button5.setBackgroundColor(Color.BLUE)
        button6.setBackgroundColor(Color.BLUE)
        button7.setBackgroundColor(Color.BLUE)
        button8.setBackgroundColor(Color.BLUE)
        button9.setBackgroundColor(Color.BLUE)

    }

}


