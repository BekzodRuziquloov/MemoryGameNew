package space.beka.memory_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val listImageOpenClose = arrayOf(false, false, false, false, false, false)
    val imageIndex = arrayOfNulls<Int>(2)
    val rasmId = arrayOfNulls<Int>(2)
    var animationDoing=false


    var ochiqRasm = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        abc()

        menuu.setOnClickListener{
            finish()
            val intent_m=Intent(this, MainActivity2::class.java)
            startActivity(intent_m)

        }

        takrorlash.setOnClickListener{
            abc()
        }

    }

    fun abc(){
        img_1.setOnClickListener {
            imageClikc(img_1, R.drawable.img_2, index = 0)
        }
        img_2.setOnClickListener {
            imageClikc(img_2, R.drawable.img_3, index = 1)
        }
        img_3.setOnClickListener {
            imageClikc(img_3, R.drawable.img_4, index = 2)
        }
        img_4.setOnClickListener {
            imageClikc(img_4, R.drawable.img_2, index = 3)
        }
        img_5.setOnClickListener {
            imageClikc(img_5, R.drawable.img_3, index = 4)
        }
        img_6.setOnClickListener {
            imageClikc(img_6, R.drawable.img_4, index = 5)
        }
    }

    fun imageClikc(imageView: ImageView, rasm: Int, index: Int) {
        if (animationDoing == false) {
            if (listImageOpenClose[index] == false) {
                animationOchilish(imageView, rasm, index)
            } else {
                animationYopilishi(imageView, rasm, index)
            }
        }
    }


    fun animationOchilish(imageView: ImageView, rasm: Int, index: Int) {
        val animation_1 = AnimationUtils.loadAnimation(this, R.anim.scole)
        imageView.startAnimation(animation_1)
        animation_1.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {
                animationDoing=true
            }

            override fun onAnimationEnd(p0: Animation?) {
                val animation_2 = AnimationUtils.loadAnimation(this@MainActivity, R.anim.scole_2)
                imageView.startAnimation(animation_2)
                imageView.setImageResource(rasm)
                animation_2.setAnimationListener(object :Animation.AnimationListener{
                    override fun onAnimationStart(p0: Animation?) {

                    }

                    override fun onAnimationEnd(p0: Animation?) {
                        listImageOpenClose[index] = true
                        imageIndex[ochiqRasm] = index
                        rasmId[ochiqRasm] = rasm
                        ochiqRasm++

                        if (ochiqRasm==2){
                            if (rasmId[0]==rasmId[1]){
                                imageViewAniqla(imageIndex[0]).visibility=View.INVISIBLE
                                ochiqRasm--
                                imageViewAniqla(imageIndex[1]).visibility=View.INVISIBLE
                                ochiqRasm--
                            }else{
                                animationYopilishi(imageViewAniqla(imageIndex[0]), -1, imageIndex[0])
                                animationYopilishi(imageViewAniqla(imageIndex[1]), -1, imageIndex[1])
                            }
                        }
                        animationDoing=false
                    }

                    override fun onAnimationRepeat(p0: Animation?) {

                    }

                })
            }

            override fun onAnimationRepeat(p0: Animation?) {

            }

        })

    }





    fun animationYopilishi(imageView: ImageView, rasm: Int, index: Int?){
        val animation_1=AnimationUtils.loadAnimation(this, R.anim.scole)
        imageView.startAnimation(animation_1)
        animation_1.setAnimationListener(object :Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {
                animationDoing=true
            }

            override fun onAnimationEnd(p0: Animation?) {
                val animation_2=AnimationUtils.loadAnimation(this@MainActivity, R.anim.scole_2)
                imageView.startAnimation(animation_2)
                imageView.setImageResource(R.drawable.img_1)
                animation_2.setAnimationListener(object :Animation.AnimationListener{
                    override fun onAnimationStart(p0: Animation?) {

                    }

                    override fun onAnimationEnd(p0: Animation?) {
                        animationDoing=false
                    }

                    override fun onAnimationRepeat(p0: Animation?) {

                    }

                })
            }

            override fun onAnimationRepeat(p0: Animation?) {

            }

        })
        listImageOpenClose[index !!]=false
        ochiqRasm--
    }

    fun imageViewAniqla (index: Int?):ImageView{
        var imageView:ImageView ?=null
        when(index){
            0-> imageView=img_1
            1-> imageView=img_2
            2-> imageView=img_3
            3-> imageView=img_4
            4-> imageView=img_5
            5-> imageView=img_6
        }
        return imageView !!
    }

}