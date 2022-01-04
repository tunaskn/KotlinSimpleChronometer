package com.example.kotlinsimplechronometer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import com.example.kotlinsimplechronometer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var zamaniDurdur:Long = 0
        binding.startButton.setOnClickListener{
            binding.kronometre.base=SystemClock.elapsedRealtime()+zamaniDurdur
            binding.kronometre.start()
            binding.startButton.visibility = View.GONE
            binding.stopButton.visibility = View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.pause))
        }
        binding.stopButton.setOnClickListener{
            zamaniDurdur=binding.kronometre.base-SystemClock.elapsedRealtime()
            binding.kronometre.stop()
            binding.startButton.visibility = View.VISIBLE
            binding.stopButton.visibility = View.GONE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.start))
        }
        binding.resetButton.setOnClickListener{
            zamaniDurdur=0
            binding.kronometre.base = SystemClock.elapsedRealtime()
            binding.kronometre.stop()
            binding.startButton.visibility = View.VISIBLE
            binding.stopButton.visibility = View.GONE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.start))
        }
    }
}