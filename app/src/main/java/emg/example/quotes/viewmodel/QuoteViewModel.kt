package emg.example.quotes.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import emg.example.quotes.model.Quote
import emg.example.quotes.provider.QuoteProvider

class QuoteViewModel : ViewModel() {
    private val quoteProvider = QuoteProvider()
    val quoteModel = MutableLiveData<Quote>()

    fun randomQuote() {
        val quote = quoteProvider.random()
        quoteModel.postValue(quote)
    }
}