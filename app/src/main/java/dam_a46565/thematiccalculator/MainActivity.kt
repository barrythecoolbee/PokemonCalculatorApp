package dam_a46565.thematiccalculator

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var calculator: Calculator
    private lateinit var mpb : MediaPlayer
    private lateinit var mpc : MediaPlayer
    private lateinit var mps : MediaPlayer
    private lateinit var background : MediaPlayer
    private lateinit var operand1 : TextView
    private lateinit var operand2 : TextView
    private lateinit var operand1Result : TextView
    private lateinit var operand2Result : TextView
    private lateinit var ResultText : TextView
    private lateinit var ResultNumber : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculator = Calculator()

        background = MediaPlayer.create(this, R.raw.pokemon);
        background.isLooping = true; // Set looping
        background.setVolume(0.2f,0.2f);
        background.start();

        val bulbasaur: ImageButton = findViewById(R.id.bulbasaur)
        mpb = MediaPlayer.create(this, R.raw.bulbasound);
        bulbasaur.setOnClickListener{
            setContext(R.id.bulbasaur)
            mpb.setVolume(0.5f, 0.5f);
            mpb.start()
        }

        val charmander: ImageButton = findViewById(R.id.charmander)
        mpc = MediaPlayer.create(this, R.raw.charmasound);
        charmander.setOnClickListener{
            setContext(R.id.charmander)
            mpc.setVolume(1f, 1f);
            mpc.start()
        }

        val squirtle: ImageButton = findViewById(R.id.squirtle)
        mps = MediaPlayer.create(this, R.raw.squirtlesound);
        squirtle.setOnClickListener{
            setContext(R.id.squirtle)
            mps.start()
        }

        val sum: Button = this@MainActivity.findViewById(R.id.button_plus)
        sum.setOnClickListener(this)
        val sub: Button = this@MainActivity.findViewById(R.id.button_minus)
        sub.setOnClickListener(this)
        val div: Button = this@MainActivity.findViewById(R.id.button_divide)
        div.setOnClickListener(this)
        val mul: Button = this@MainActivity.findViewById(R.id.button_multiply)
        mul.setOnClickListener(this)
        val sq: Button = this@MainActivity.findViewById(R.id.button_fatorial)
        sq.setOnClickListener(this)
        val sqxy: Button = this@MainActivity.findViewById(R.id.button_sqrt)
        sqxy.setOnClickListener(this)
        val getmem: Button = this@MainActivity.findViewById(R.id.button_get)
        getmem.setOnClickListener(this)
        val setmem: Button = this@MainActivity.findViewById(R.id.button_set)
        setmem.setOnClickListener(this)

    }

    override fun onStop() {
        super.onStop()
        background.stop()
        background.release()
    }

    private fun setBackground(text: TextView, color: Int){
        text.setBackgroundColor(ContextCompat.getColor(getBaseContext(), color))
    }

    private fun setText(text: TextView, color: Int){
        text.setTextColor(ContextCompat.getColor(getBaseContext(), color))
    }

    private fun setContext(id: Int) {
        val title : TextView = findViewById(R.id.pokemon)
        operand1 = findViewById(R.id.operand1)
        operand2 = findViewById(R.id.operand2)
        operand1Result = findViewById(R.id.operand1Result)
        operand2Result = findViewById(R.id.operand2Result)
        ResultText = findViewById(R.id.finalResultText)
        ResultNumber = findViewById(R.id.finalResultNumber)
        var fc : Int
        var bc : Int
        var black : Int = R.color.black
        var white : Int = R.color.white
        val container: View = findViewById(R.id.container)

        if(id == R.id.bulbasaur){
            container.setBackgroundResource(R.drawable.jungle)
            fc = R.color.light_green
            bc = R.color.dark_green

            setText(title, white)
            setText(operand1, white)
            setText(operand2, white)
            setText(operand1Result, white)
            setText(operand2Result, white)
            setText(ResultText, white)
            setText(ResultNumber, white)
            setBackground(operand1, fc)
            setBackground(operand2, fc)
            setBackground(ResultText, fc)
            setBackground(operand1Result, bc)
            setBackground(operand2Result, bc)
            setBackground(ResultNumber, bc)
        }
        else if(id == R.id.charmander){
            container.setBackgroundResource(R.drawable.volcano)
            fc = R.color.light_orange
            bc = R.color.dark_orange

            setText(title, white)
            setText(operand1, black)
            setText(operand2, black)
            setText(operand1Result, black)
            setText(operand2Result, black)
            setText(ResultText, black)
            setText(ResultNumber, black)
            setBackground(operand1, fc)
            setBackground(operand2, fc)
            setBackground(ResultText, fc)
            setBackground(operand1Result, bc)
            setBackground(operand2Result, bc)
            setBackground(ResultNumber, bc)
        }
        else if(id == R.id.squirtle){
            container.setBackgroundResource(R.drawable.ocean)
            fc = R.color.light_blue
            bc = R.color.dark_blue

            setText(title, black)
            setText(operand1, black)
            setText(operand2, black)
            setText(ResultText, black)
            setText(operand1Result, white)
            setText(operand2Result, white)
            setText(ResultNumber, white)
            setBackground(operand1, fc)
            setBackground(operand2, fc)
            setBackground(ResultText, fc)
            setBackground(operand1Result, bc)
            setBackground(operand2Result, bc)
            setBackground(ResultNumber, bc)
        }
    }

    override fun onClick(v: View?) {
        operand1Result = findViewById(R.id.operand1Result)
        operand2Result = findViewById(R.id.operand2Result)
        ResultNumber = findViewById(R.id.finalResultNumber)
        val sNum1: String = operand1Result.text.toString()
        val sNum2: String = operand2Result.text.toString()
        val num1: Double = sNum1.toDouble()
        val num2: Double = sNum2.toDouble()
        val b: Button? = v as? Button //To avoid exceptions, use the safe cast operator as? that returns null on failure.


        if (b != null) {
            if (b.id == R.id.button_plus) {
                ResultNumber.text = calculator.soma(num1, num2).toString()
            } else if (b.id == R.id.button_minus) {
                ResultNumber.text = calculator.subtracao(num1, num2).toString()
            } else if (b.id == R.id.button_multiply) {
                ResultNumber.text = calculator.multiplicacao(num1, num2).toString()
            } else if (b.id == R.id.button_divide) {
                ResultNumber.text = calculator.divisao(num1, num2).toString()
            } else if (b.id == R.id.button_fatorial) {
                ResultNumber.text = calculator.fatorial(num1, num2).toString()
            } else if (b.id == R.id.button_sqrt) {
                ResultNumber.text = calculator.sqrt(num1, num2).toString()
            }else if (b.id == R.id.button_get) {
                operand1Result.text = calculator.get().toString()
            } else if (b.id == R.id.button_set) {
                calculator.set(num1)
            }

        }
    }
}

