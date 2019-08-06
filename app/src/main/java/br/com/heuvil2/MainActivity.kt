package br.com.heuvil2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btCalcular.setOnClickListener {
            val proximaTela = Intent ( this, ResultadoActivity::class.java)
            proximaTela.putExtra( "PESO", inputPeso.text.toString())
            proximaTela.putExtra( "ALTURA", inputPeso.text.toString())
            proximaTela.putExtra( "SEXO", spSexo.selectedItem.toString())
            startActivity(proximaTela)
        }

        btLimpar.setOnClickListener {
            inputAltura.setText("")
            inputPeso.setText("")
            spSexo.setSelection(0)
        }
    }
}
