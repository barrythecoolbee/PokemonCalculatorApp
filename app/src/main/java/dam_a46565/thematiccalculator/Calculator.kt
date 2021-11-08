package dam_a46565.thematiccalculator

import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class Calculator {
    private var memory: Double = 0.0

    fun set(num1: Double){
        memory = num1
    }

    fun get():Double{
        return memory
    }

    fun soma(num1: Double, num2: Double): Double {
        return num1 + num2
    }

    fun subtracao(num1: Double, num2: Double): Double {
        return num1 - num2
    }

    fun multiplicacao(num1: Double, num2: Double): Double {
        return num1 * num2
    }

    fun divisao(num1: Double, num2: Double): Double {
        return num1 / num2
    }

    fun fatorial(num1: Double, num2: Double): Double {
        return num1 % num2
    }

    fun sqrt(num1: Double, num2: Double): Double {
        return num1.pow(num2)
    }
}