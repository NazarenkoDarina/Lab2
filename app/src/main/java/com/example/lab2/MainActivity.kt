package com.example.lab2

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.sqrt
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private fun discriminant(a: Double, b: Double, c: Double) = (Math.sqrt(b) - 4 * a * c).toInt()

    private fun round(a:Double) : Double{
        val roundoff = (a * 100.0).roundToInt() / 100.0
        return roundoff
    }

    private fun Equation(a: Double, b: Double, c: Double): String {
        val discriminant = discriminant(a, b, c)
        if (a!==0.0){
            if (discriminant > 0) {
                val root1 = round((-b + Math.sqrt(discriminant.toDouble())) / (2 * a))
                val root2 = round((-b - Math.sqrt(discriminant.toDouble())) / (2 * a))
                return "x1= $root1 \nx2= $root2"
            }
            else if (discriminant== 0) {
                val root2 = round(-b / (2 * a))
                return "Дискриминант = 0, значит корни уравнения равны: \nx1=x2=$root2"
            }
            else{
                return "Дискриминант меньше нуля, значит уравнение не имеет корней"
            }
        }
        else if(c!=0.0 && b!=0.0)
        {
            val root= round(-c / b)
            return "Данное уравнение является линейным, т.к a=0 \nЗначит оно имеет один корень x=$root"
        }
        else return "Введеные данные некорректны"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun OnResultButtonClick(view: View){
        val aKoeff=findViewById<EditText>(R.id.a).text.toString()
        val bKoeff=findViewById<EditText>(R.id.b).text.toString()
        val cKoeff=findViewById<EditText>(R.id.c).text.toString()
        val resTextView=findViewById<TextView>(R.id.answerText)
        val a=aKoeff.toDouble()
        val b=bKoeff.toDouble()
        val c=cKoeff.toDouble()
        val answer=Equation(a,b,c)
        resTextView.setText(answer)
1    }
}