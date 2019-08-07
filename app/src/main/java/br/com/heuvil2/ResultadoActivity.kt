package br.com.heuvil2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    var peso = 0.0
    var altura = 0.0
    var sexo = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        carregaDados()

        calcular()
    }

    private fun calcular() {
        val imc = peso / (altura * altura)
        tvIMC.text = imc.toFixed(1)
//        tvIMC.text = String.format("%.1f", imc)
        when {
            imc < 18.5 -> {
                tvStatusIMC.text = getString(R.string.label_abaixo_peso)
                setaImagem(R.drawable.fem_abaixo)
            }
            imc < 24.9 -> {
                tvStatusIMC.text = getString(R.string.label_peso_ideal)
                setaImagem(R.drawable.fem_ideal)
            }
            imc < 29.9 -> {
                tvStatusIMC.text = getString(R.string.label_acima_peso)
                setaImagem(R.drawable.fem_sobre)
            }
            imc < 34.9 -> {
                tvStatusIMC.text = getString(R.string.label_obeso)
                setaImagem(R.drawable.fem_obeso)
            }
            else -> {
                tvStatusIMC.text = getString(R.string.label_muito_obeso)
                setaImagem(R.drawable.fem_extremo_obeso)
            }
        }
    }

    fun setaImagem(resourceId: Int) {

//        val male = getString(R.string.label_male)
//        val female = getString(R.string.label_female)

        ivIMC.setImageDrawable(
            ContextCompat.getDrawable(this,
                resourceId))
    }

    private fun carregaDados() {
        peso = intent.getStringExtra("PESO").toDouble()
        altura = intent.getStringExtra("ALTURA").toDouble()
        sexo = intent.getStringExtra("SEXO")

        //tvIMC.text = "weight: "+peso+"  height: "+altura+" genre: "+sexo

    }
}
