package space.beka.memory_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main4.*

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        bacc.setOnClickListener{
            finish()
            val intent_l=Intent(this, MainActivity2::class.java)
            startActivity(intent_l)

        }
    }
}