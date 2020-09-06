package teamtreehouse.com

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView

import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val hamsterButton = findViewById<Button>(R.id.hamsterButton)
        val resultsTextView = findViewById<TextView>(R.id.resultsTextView)
        val seekBar = findViewById<SeekBar>(R.id.seekBar)

        hamsterButton.setOnClickListener{
            val rand = Random().nextInt(seekBar.progress)
            resultsTextView.text =rand.toString()
        }
    }
}