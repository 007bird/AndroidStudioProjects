package com.example.myapplication

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_choice.setOnClickListener {
            //切換...
            startActivityForResult(Intent(this,Main2Activity::class.java),1)



        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        data?.extras.let {
            //驗證
            if (requestCode==1 && resultCode== Activity.RESULT_OK)
                //讀取資料
                tv_meal.text = "飲料: ${it.getString("drink") } \n\n "+
                        "甜度: ${it.getString("sugar") }\n\n " +
                        "冰塊: ${it.getString("ice")}"
        }
    }
}
