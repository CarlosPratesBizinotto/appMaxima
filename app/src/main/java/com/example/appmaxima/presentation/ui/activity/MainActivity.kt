package com.example.appmaxima.presentation.ui.activity

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.appmaxima.R
import com.example.appmaxima.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_card.*

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Lifecycle", "Create")

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setView()

    }
     //Primeiro o OnCreate
    //Apenas exemplos sobre ciclo de vida de uma activity
    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle", "Resume")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Lifecycle", "Start")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Lifecycle", "Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Lifecycle", "Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifecycle", "Destroy")
    }

    @SuppressLint("SetTextI18n")
    private fun setView() {
        binding.apply {
            btnClient.apply {
                imgButton.setImageResource(R.drawable.ic_maxima_pessoas)
                tvButton.text = "Clientes"
                card.setOnClickListener {
                    Intent(this@MainActivity, DetailsActivity::class.java).also {
                        startActivity(it)
                    }
                }
            }
        }
        binding.apply {
            btnSummary.apply {
                imgButton.setImageResource(R.drawable.ic_maxima_resumo_vendas)
                tvButton.text = "Resumo de vendas"
                card.setOnClickListener {
                    message()
                }
            }
        }
        binding.apply {
            btnPedido.apply {
                imgButton.setImageResource(R.drawable.ic_maxima_pedido)
                tvButton.text = "Pedidos"
                card.setOnClickListener {
                    message()
                }
            }
        }
        binding.apply {
            btnSettings.apply {
                imgButton.setImageResource(R.drawable.ic_maxima_ferramentas)
                tvButton.text = "Feramentas"
                card.setOnClickListener {
                    message()
                }
            }
        }
    }

    fun message(){
        Toast.makeText(this@MainActivity, "Você não tem permissão", Toast.LENGTH_LONG).show()
    }

}