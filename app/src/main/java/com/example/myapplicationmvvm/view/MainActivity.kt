package com.example.myapplicationmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.myapplicationmvvm.databinding.ActivityMainBinding
import com.example.myapplicationmvvm.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // Creamos una instancia del QuoteViewModel usando la función de extensión `viewModels()`.
    // Esto nos permite obtener el ViewModel asociado a esta Activity y manejar automáticamente su ciclo de vida.
    // La variable quoteViewModel contendrá el ViewModel para que podamos interactuar con él.
    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Usamos el método inflate para inflar el diseño de la actividad (ActivityMainBinding).
        // Esto nos permite acceder a todas las vistas dentro del diseño mediante la clase ActivityMainBinding.
        binding = ActivityMainBinding.inflate(layoutInflater)

        // Establecemos el diseño de la actividad como la vista raíz.
        setContentView(binding.root)

        // Observamos los cambios en el LiveData `quoteModel` dentro del QuoteViewModel.
        // Cuando cambia el valor, el Observer se activará y actualizaremos los campos de texto en el diseño con los nuevos datos.
        quoteViewModel.quoteModel.observe(this, Observer {
            binding.tvQuote.text = it.quote // Actualizamos el TextView con la cita.
            binding.tvAuthor.text = it.author // Actualizamos el TextView con el autor de la cita.
        })

        // Configuramos un OnClickListener para el viewContainer en el diseño.
        // Cuando se hace clic en el viewContainer, llamamos a la función `randomQuote()` del quoteViewModel.
        binding.viewContainer.setOnClickListener { quoteViewModel.randomQuote() }
    }
}
