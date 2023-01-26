package space.beka.memory_game

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main11.*
import kotlin.random.Random

class MainActivity11 : AppCompatActivity() {
    private lateinit var question: TextView
    private lateinit var variant_1: RadioButton
    private lateinit var variant_2: RadioButton
    private lateinit var variant_3: RadioButton
    private lateinit var variant_4: RadioButton
    private lateinit var answer: Button
    private lateinit var radiogroup: RadioGroup
    var shart = -1
    var tJavob = 0
    var btnch=-1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main11)
        asd.setOnClickListener{
            finish()
            val intent_t= Intent(this, MainActivity7::class.java)
            startActivity(intent_t)
        }
        randomMisolYoz()
        answer.setOnClickListener{
            if (variant_1.isChecked) btnch=0
            if (variant_2.isChecked) btnch=1
            if (variant_3.isChecked) btnch=2
            if (variant_4.isChecked) btnch=3

            if(btnch==shart){
                Toast.makeText(this, "Tog`ri Javob", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "No tog`ri javob", Toast.LENGTH_SHORT).show()
            }
            radiogroup.clearCheck()
            btnch=-1
            randomMisolYoz()
        }

    }


    var number1 = 0
    var number2 = 0
    var amal = 0

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
                else {
                    question.text = "$number1-$number2"
                    tJavob = number1 - number2
                }
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
                    }else {
                        question.text = "$number1/$number2"
                        tJavob = number1 / number2
                    }
                } catch (e: Exception) {
                    randomMisolYoz()
                    return
                }
            }
        }
        randomVariant()
    }

    fun randomVariant(){
        val son1 = java.util.Random().nextInt(100)
        val son2 = java.util.Random().nextInt(100)
        val son3 = java.util.Random().nextInt(100)

        shart = java.util.Random().nextInt(4)

        if (son1 != son2 || son2 != son3 || son1 !=tJavob){
            when(shart){
                0-> {
                    variant_1.text=tJavob.toString()
                    variant_2.text=son1.toString()
                    variant_3.text=son2.toString()
                    variant_4.text=son3.toString()

                }
                1-> {
                    variant_2.text=tJavob.toString()
                    variant_1.text=son1.toString()
                    variant_3.text=son2.toString()
                    variant_4.text=son3.toString()

                }
                2-> {
                    variant_3.text=tJavob.toString()
                    variant_2.text=son1.toString()
                    variant_1.text=son2.toString()
                    variant_4.text=son3.toString()

                }
                3-> {
                    variant_4.text=tJavob.toString()
                    variant_2.text=son1.toString()
                    variant_1.text=son2.toString()
                    variant_3.text=son3.toString()

                }
            }
        }else{
            randomVariant()
        }

    }
}