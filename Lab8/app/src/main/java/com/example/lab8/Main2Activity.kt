package com.example.lab8

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main2)
        btn_send.setOnClickListener {
            when{
                ed_name.length()<1 -> Toast.makeText(this,
                                                    "請輸入姓名",Toast.LENGTH_SHORT).show()
                ed_phone.length()<1 ->Toast.makeText(this,
                                                    "請輸入電話",Toast.LENGTH_SHORT).show()

                else->{
                    val  b = Bundle()
                    b.putString("name",ed_name.text.toString())
                    b.putString("phone",ed_phone.text.toString())
                    setResult(Activity.RESULT_OK, Intent().putExtra(b))
                    finish()
                }

            }
        }
    }

}