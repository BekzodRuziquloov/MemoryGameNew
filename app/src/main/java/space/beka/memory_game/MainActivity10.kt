package space.beka.memory_game

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main10.*
import kotlin.random.Random

class MainActivity10 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main10)

        asas.setOnClickListener{
            finish()
            val intent_j= Intent(this, MainActivity7::class.java)
            startActivity(intent_j)
        }



        randomMisolYoz()

        btn_Javob.setOnClickListener {
            if (answer.text.toString().isBlank()) {
                Toast.makeText(this, "Write Answer", Toast.LENGTH_SHORT).show()
            } else {


                if (tJavob == answer.text.toString().toInt()) {
                    Toast.makeText(this, "Tog`ri Javob", Toast.LENGTH_SHORT).show()
                    randomMisolYoz()
                    answer.text.clear()
                    val mediaPlayer = MediaPlayer.create(this, R.raw.tru)
                    mediaPlayer.start()
                } else {
                    Toast.makeText(this, "No tog`ri javob", Toast.LENGTH_SHORT).show()
                    randomMisolYoz()
                    answer.text.clear()
                    val mediaPlayer = MediaPlayer.create(this, R.raw.fals)
                    mediaPlayer.start()
                }
            }

        }


    }

    var number1 = 0
    var number2 = 0
    var amal = 0
    var tJavob = 0

    @SuppressLint("SetTextI18n")
    fun randomMisolYoz() {
        number1 = Random.nextInt(20)
        number2 = Random.nextInt(20)
        amal = Random.nextInt(4)
        when (amal) {
            0 -> {
                question.text = "$number1+$number2"
                tJavob = number1 + number2
            }
            1 -> {
                if (number1 < number2) {
                    randomMisolYoz()
                    return
                }
                question.text = "$number1-$number2"
                tJavob = number1 - number2
            }
            2 -> {
                question.text = "$number1*$number2"
                tJavob = number1 * number2
            }
            3 -> {
                try {
                    if (number1 % number2 != 0) {
                        randomMisolYoz()
                        return
                    }
                    question.text = "$number1/$number2"
                    tJavob = number1 / number2
                } catch (e: Exception) {
                    randomMisolYoz()
                    return
                }
            }
        }
    }


//    fun myCheecking() {
//        btn_Javob.setOnClickListener {
//            if (tJavob == answer.text.toString().toInt()) {
//                Toast.makeText(this, "Tog`ri Javob", Toast.LENGTH_SHORT).show()
//                randomMisolYoz()
//                answer.text.clear()
//                val mediaPlayer = MediaPlayer.create(this, R.raw.tru)
//                mediaPlayer.start()
//            } else {
//                Toast.makeText(this, "No tog`ri javob", Toast.LENGTH_SHORT).show()
//                randomMisolYoz()
//                answer.text.clear()
//                val mediaPlayer = MediaPlayer.create(this, R.raw.fals)
//                mediaPlayer.start()
//            }
//        }
//    }

}