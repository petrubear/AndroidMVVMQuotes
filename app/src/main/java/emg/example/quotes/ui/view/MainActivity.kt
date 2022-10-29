package emg.example.quotes.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import emg.example.quotes.databinding.ActivityMainBinding
import emg.example.quotes.ui.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()

        quoteViewModel.quoteModel.observe(this) { quote ->
            binding.tvQuote.text = quote.quote
            binding.tvAuthor.text = quote.author
        }

        quoteViewModel.isLoading.observe(this) {
            binding.pbProgress.isVisible = it
        }

        binding.viewContainer.setOnClickListener { quoteViewModel.randomQuote() }
    }
}