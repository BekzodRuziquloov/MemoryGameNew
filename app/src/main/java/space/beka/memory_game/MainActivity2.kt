package space.beka.memory_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        easy.setOnClickListener{
            val intent_e=Intent(this, MainActivity::class.java)
            startActivity(intent_e)
        }

        normal.setOnClickListener{
            val intent_n=Intent(this, MainActivity5::class.java)
            startActivity(intent_n)
        }

        hard.setOnClickListener{
            val intent_h=Intent(this, MainActivity6::class.java)
            startActivity(intent_h)
        }

        about.setOnClickListener{
            val intent_a=Intent(this, MainActivity4::class.java)
            startActivity(intent_a)
        }

        bas.setOnClickListener{
            finish()
            val intent_b=Intent(this, MainActivity7::class.java)
            startActivity(intent_b)
        }

    }
}