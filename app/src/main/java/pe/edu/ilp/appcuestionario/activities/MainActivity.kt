package pe.edu.ilp.appcuestionario.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import pe.edu.ilp.appcuestionario.R
import pe.edu.ilp.appcuestionario.model.Pregunta

class MainActivity : AppCompatActivity() {

    var preguntas = ArrayList<Pregunta>()
    var posicionActual = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ejm01()
        ejm02()
        ejm03()
        //Este método añade preguntas a la lista
        //cargarPreguntas()

        //Este método muestra las preguntas al usuario
        //mostrarPreguntas()

        val btnVerdad = findViewById<android.view.View>(R.id.btnVerdadero)
        btnVerdad.setOnClickListener{
            Toast.makeText(this,"La respuesta es incorrecta", Toast.LENGTH_SHORT).show()
        }

        val btnIncorrecto = findViewById<android.view.View>(R.id.btnFalso)
        btnIncorrecto.setOnClickListener{
            Toast.makeText(this,"La respuesta es correcta", Toast.LENGTH_SHORT).show()
        }

        val btnNext = findViewById<Button>(R.id.btnSiguiente)

        btnNext.setOnClickListener{
            try {
                posicionActual++
                mostrarPreguntas()
            } catch (e:Exception){
                Toast.makeText(this, "No hay mas preguntas Xd", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun cargarPreguntas() {
        preguntas.add(Pregunta("Caracas es la capital de Venezuela",true))
        preguntas.add(Pregunta("Piura es un departamento que pertenece a Ecuador", false))
        preguntas.add(Pregunta("Uruguay es un país Latinoamericano", true))
        preguntas.add(Pregunta("Lima es la capital de Chile", false))
    }

    private fun mostrarPreguntas() {
        val textoPregunta = findViewById<TextView>(R.id.tvPregunta)
        textoPregunta.text = preguntas[posicionActual].enunciado
    }

    fun ejm01(){
        for(i in 50 downTo 0 step 2){
            println("el valor disminuye en 2: $i")
        }
    }

    fun ejm02(){
        val n1 = 5
        var fact: Long = 1
        for(i in 1..n1){
            fact *= i.toLong()

        }
        println("Factorial de $n1 es: $fact ")
    }

    fun ejm03(){
        val b = 5
        val h = 6
        val  res = (b * h)/2

        println("el área de un triangulo de base: $b y altura: $h es de: $res")
    }
}