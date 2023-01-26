package space.beka.memory_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main7.*

class MainActivity7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

       memory_game.setOnClickListener{
           val intent_q=Intent(this, MainActivity2::class.java)
           startActivity(intent_q)
       }

        math_Game.setOnClickListener{
                val intent_w=Intent(this, MainActivity10::class.java)
                startActivity(intent_w)
            }

        test_game.setOnClickListener{
            val intent_p=Intent(this, MainActivity11::class.java)
            startActivity(intent_p)
        }
        }

    }