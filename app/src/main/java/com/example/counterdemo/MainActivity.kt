package com.example.counterdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var countDownTimer: CountDownTimer? = null
    var timerDuration:Long = 60000
    var pauseOffset: Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_timerInput.text = "${(timerDuration/1000).toString()}"
        button1.setOnClickListener{
            startTimer(pauseOffset)
        }
        button2.setOnClickListener{
            pauseTimer()


        }
        button3.setOnClickListener{
            if (countDownTimer != null){
                countDownTimer!!.cancel()
                tv_timerInput.text = "${(timerDuration/1000).toString()}"
                countDownTimer =null
                pauseOffset = 0
            }
        }





    }

    private fun pauseTimer() {
        if(countDownTimer !=null)
        {
            countDownTimer!!.cancel()
        }
    }

    private fun startTimer(pauseOffsetl: Long) {
        countDownTimer = object :CountDownTimer(timerDuration - pauseOffsetl, 1000){
            override fun onTick(millisUntilFinished: Long) {
                pauseOffset = timerDuration-millisUntilFinished
                tv_timerInput.text = (millisUntilFinished/1000).toString()
            }

            override fun onFinish() {
                Toast.makeText(this@MainActivity, "timer has finished", Toast.LENGTH_SHORT).show()
            }
        }.start()

    }
}