package ir.all.splashscreen

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import ir.all.myapplication.MainActivity
import ir.all.myapplication.R

class SplashScreen : AppCompatActivity() {

    private lateinit var typeface: Typeface
    private lateinit var txt: TextView
    private lateinit var txt1: TextView
    private lateinit var typefaceTitr: Typeface
    private lateinit var txt2 : TextView
    private lateinit var typefaceCircle: Typeface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        typeface = Typeface.createFromAsset(assets, "fonts/DroidNaskh-Regular.ttf")
        typefaceTitr = Typeface.createFromAsset(assets, "fonts/B06.ttf")
        typefaceCircle = Typeface.createFromAsset(assets , "fonts/B12.ttf")

        txt = findViewById(R.id.txt_splash)
        txt1 = findViewById(R.id.txt_splash_center)
        txt2 = findViewById(R.id.txtCircle)

        txt.setTypeface(typeface)
        txt1.setTypeface(typefaceTitr)
        txt2.typeface = typefaceCircle

        Handler().postDelayed(Runnable {
            run {
                startActivity(Intent(this@SplashScreen, MainActivity::class.java))
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
            }
        }, 5000)

    }


}
