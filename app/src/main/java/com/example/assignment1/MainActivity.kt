package com.example.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.assignment1.Fragments.add_Fragment
import com.example.assignment1.Fragments.main_Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.container1,main_Fragment()).commit()

        main.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.container1,main_Fragment()).commit()
        }

        add.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.container1,add_Fragment()).commit()
        }
    }
}