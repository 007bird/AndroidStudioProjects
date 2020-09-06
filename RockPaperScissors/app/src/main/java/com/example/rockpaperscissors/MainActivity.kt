package com.example.rockpaperscissors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cpu.visibility = View.INVISIBLE

        IMB_hand.setOnClickListener{
            cpu.text = "石頭"
        }
        IMB_scissors.setOnClickListener{
            cpu.text = "布"
        }
        IMB_rock.setOnClickListener{
            cpu.text = "剪刀"
        }
        cpu.visibility = View.VISIBLE
        cpu.text

    }
}


