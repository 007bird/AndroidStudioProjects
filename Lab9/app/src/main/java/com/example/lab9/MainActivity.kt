package com.example.lab9

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var rabprogress = 0
    private var torprogress = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start.setOnClickListener {
            btn_start.isEnabled= false

            rabprogress = 0

            torprogress = 0

            seekBar.progress = 0
            seekBar2.progress = 0

            runThread()
            runAsyncTask()

        }
    }
}
private fun runThread(){
    object :Thread(){
        override fun run() {
            // val rabprogress
            while (rabprogress <= 100 && torprogress < 100){
                try {
                    Thread.sleep(100)

                }catch (e:InterruptedException){
                    e.printStackTrace()
                }
                rabprogress += (Math.random()*3).toInt()

                val msg = message()

                msg.what = 1

                mHandaler.sendMessage(msg)
            }
        }

    }.start()

}
private val mHandaler = Handler(Handler.Callback { msg ->
    when(msg.what){
        1 -> seeKar.Progress = rabprogress
    }
    if (rabprogress >= 100 && torprogress < 100){
        Toast.makeText(this,"兔子勝利",Toast.LENGTH_SHORT).show()
        btn_start.isEnabled = true
    }
    true

})

private fun runAsyncTask(){
    object :AsyncTask<Void,Int,Boolean>(){
        override fun doInBackground(vararg p0: Void?): Boolean {
            with(torprogress <= 100 && rabprogress < 100){
                try {
                    Thread.sleep(100)
                }catch (e:InterruptedException){
                    e.printStackTrace()
                }
                torprogress += (Math.random()*3).toInt()

                publishProgress(torprogress)
            }
            return true
            TODO("Not yet implemented")
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
            values[0]?.let {
                seekBar2.progress = it
            }
        }

        override fun onPostExecute(result: Boolean?) {
            if(torprogress >= 100 && rabprogress < 100){
                Toast.makeText(this@MainActitvity,"烏龜勝利",
                Toast.LENGTH_SHORT).show()
                btn_start.isEnabled = true

            }
            super.onPostExecute(result)
        }

    }.execute()

}