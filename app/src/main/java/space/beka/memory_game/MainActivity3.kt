package space.beka.memory_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        image_start.setOnClickListener{
            finish()
            val intent=Intent(this, MainActivity7::class.java)
            startActivity(intent)
        }
    }
}