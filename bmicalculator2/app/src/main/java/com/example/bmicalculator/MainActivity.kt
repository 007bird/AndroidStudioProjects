package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        infoTxt.visibility = View.INVISIBLE  //將infoTxt(顯示訊息的textview)隱藏

        btn.setOnClickListener{     //當btn(button)被按下時...

    //
            // 將weightEditTxt的內容文字(text)傳入weight算式中(以double的型態)
            var weight:Double = weightEditTxt.text.toString().toDouble()
            // 將heightEditTxt的內容文字(text)傳入height算式中(以double的型態)
            var height:Double = heightEditTxt.text.toString().toDouble()

            //將計算後的結果存入bmi中
            var bmi:Double = (weight*703)/(height*height)

            Log.i("msg","+++weight is ${weight}, height is ${height}, BMI is ${bmi}")

            infoTxt.visibility = View.VISIBLE   //將infoTxt顯示
            infoTxt.text="BMI is ${String.format("%.2f",bmi)} you are ${bmiRes(bmi)}"
            //顯示文字 BMI IS 放入 bmi之值  you are  呼叫bmiRes 接收後顯示
        }
    }

    fun bmiRes(bmi:Double):String { //根據數字改變 ans 且將ans回傳
        var ans = ""
        if (bmi < 18.5) {
            ans = "Underweight"
        } else if (bmi > 18.5 && bmi < 24.9) {
            ans = "Normal"
        } else if (bmi > 25 && bmi < 29.9) {
            ans = "Overwight"
        }else{
            ans="Obese"
        }
        return ans
    }
}
//bmi = w*703/hsqr
//
//
//Underweight = <18.5
//Normal weight = 18.5-24.9
//Overweight = 25-29.9
//Obesity = BMI of 30 or greater
