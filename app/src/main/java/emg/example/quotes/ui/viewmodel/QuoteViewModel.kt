package emg.example.quotes.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import emg.example.quotes.data.model.Quote
import emg.example.quotes.data.model.provider.QuoteProvider
import emg.example.quotes.domain.GetQuoteUseCase
import emg.example.quotes.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {
    private val quoteProvider = QuoteProvider()
    val quoteModel = MutableLiveData<Quote>()
    val isLoading = MutableLiveData<Boolean>()

    val getQuotesUseCase = GetQuoteUseCase()
    val getRandomQuoteUseCase = GetRandomQuoteUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()
            if (result.isNotEmpty()) {
                quoteModel.postValue(result.random())
                isLoading.postValue(false)
            }
        }
    }

    fun randomQuote() {
        isLoading.postValue(true)
        val quote = getRandomQuoteUseCase.invoke()
        quote?.let {
            quoteModel.postValue(it)
        }
        isLoading.postValue(false)
    }

}